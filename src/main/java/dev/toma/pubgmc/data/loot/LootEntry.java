package dev.toma.pubgmc.data.loot;

import com.google.gson.*;
import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.util.JsonHelper;
import dev.toma.pubgmc.util.object.LazyLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.util.JsonUtils;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Type;
import java.util.function.Supplier;

public class LootEntry implements Supplier<ItemStack> {

    public static final LazyLoader<LootEntry> EMPTY = new LazyLoader<>(() -> new LootEntry(Items.AIR));
    private final Item item;
    private final CompoundNBT nbt;
    private final int baseCount;
    private final int randomCount;

    public LootEntry(Item item) {
        this(item, 1);
    }

    public LootEntry(Item item, int baseCount) {
        this(item, baseCount, 0, null);
    }

    public LootEntry(Item item, int baseCount, int randomCount, CompoundNBT nbt) {
        this.item = item;
        this.baseCount = baseCount;
        this.randomCount = randomCount;
        this.nbt = nbt;
    }

    @Override
    public ItemStack get() {
        ItemStack stack = new ItemStack(item, baseCount + Pubgmc.rand.nextInt(randomCount + 1));
        if(nbt != null) {
            stack.setTag(nbt);
        }
        return stack;
    }

    public static class Deserializer implements JsonDeserializer<LootEntry> {

        @Override
        public LootEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject object = (JsonObject) json;
            ResourceLocation location = new ResourceLocation(JsonHelper.getString("item", object, () -> new JsonParseException("Entry item is not defined!")));
            Item item = ForgeRegistries.ITEMS.getValue(location);
            if(item == null) throw new JsonParseException("Unknown item: " + location.toString());
            int amount = object.has("count") ? MathHelper.clamp(object.get("count").getAsInt(), 1, 64) : 1;
            int extra = object.has("random") ? MathHelper.clamp(object.get("random").getAsInt(), 0, 64 - amount) : 0;
            CompoundNBT nbt = object.has("nbt") ? JsonUtils.readNBT(object, "nbt") : null;
            return new LootEntry(item, amount, extra, nbt);
        }
    }
}
