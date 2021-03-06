package dev.toma.pubgmc.init;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.client.models.BakedModelGun;
import dev.toma.pubgmc.common.items.guns.GunBase;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void bakeModels(ModelBakeEvent e) {
        BakedModelGun instance = new BakedModelGun();
        ForgeRegistries.ITEMS.getValuesCollection().stream()
                .filter(it -> it instanceof GunBase)
                .forEach(it -> {
                    ModelResourceLocation mrl = new ModelResourceLocation(it.getRegistryName(), "inventory");
                    e.getModelRegistry().putObject(mrl, instance);
                });
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent e) {
        for (ResourceLocation rl : ForgeRegistries.ITEMS.getKeys()) {
            if (rl.getResourceDomain().equals(Pubgmc.MOD_ID))
                registerModel(ForgeRegistries.ITEMS.getValue(rl));
        }

        for (ResourceLocation rl : ForgeRegistries.BLOCKS.getKeys()) {
            if (rl.getResourceDomain().equals(Pubgmc.MOD_ID))
                registerModel(ForgeRegistries.BLOCKS.getValue(rl));
        }
    }

    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    private static void registerModel(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
}
