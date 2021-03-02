package dev.toma.pubgmc.common.items.guns;

import dev.toma.pubgmc.DevUtil;
import dev.toma.pubgmc.PMCTabs;
import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.client.models.ModelGun;
import dev.toma.pubgmc.common.capability.player.AimInfo;
import dev.toma.pubgmc.common.capability.player.IPlayerData;
import dev.toma.pubgmc.common.capability.player.PlayerData;
import dev.toma.pubgmc.common.entity.EntityBullet;
import dev.toma.pubgmc.common.items.ItemAmmo;
import dev.toma.pubgmc.common.items.PMCItem;
import dev.toma.pubgmc.common.items.attachment.*;
import dev.toma.pubgmc.config.common.CFGWeapon;
import dev.toma.pubgmc.network.PacketHandler;
import dev.toma.pubgmc.network.sp.PacketDelayedSound;
import dev.toma.pubgmc.network.sp.PacketReloadingSP;
import dev.toma.pubgmc.util.game.loot.LootManager;
import dev.toma.pubgmc.util.game.loot.LootType;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This is the core class for all guns
 * @author Toma
 */
public class GunBase extends PMCItem {

    public static final List<GunBase> GUNS = new ArrayList<>();
    protected final Supplier<SoundEvent> action;
    private final CFGWeapon wepStats;
    private final float horizontalRecoil;
    private final float verticalRecoil;
    private final int reloadTime;
    private final int firerate;
    private final int maxAmmo, exMaxAmmo;
    private final int burstAmount;
    private final AmmoType ammoType;
    private final Firemode firemode;
    private final Function<Firemode, Firemode> firemodeSwitch;
    private final ReloadType reloadType;
    private final GunType gunType;
    private final SoundEvent shootSound, silentShootSound, reloadSound;
    private final float gunVolume, silentGunVolume;
    private final GunAttachments attachments;
    private final ScopeData customScope;

    // TODO delete all below
    @SideOnly(Side.CLIENT)
    private ModelGun gunModel;
    private ItemAmmo ammoItem;
    private int ammoCount = 0;

    protected GunBase(GunBuilder builder) {
        super(builder.name);
        setCreativeTab(PMCTabs.TAB_GUNS);
        setMaxStackSize(1);
        GUNS.add(this);
        this.action = builder.action;
        this.gunType = builder.weaponType;
        this.wepStats = builder.cfgStats;
        this.verticalRecoil = builder.vertical;
        this.horizontalRecoil = builder.horizontal;
        this.reloadType = builder.reloadType;
        this.reloadTime = builder.reloadTime;
        this.firerate = builder.firerate;
        this.ammoType = builder.ammoType;
        this.maxAmmo = builder.maxAmmo;
        this.exMaxAmmo = builder.exMaxAmmo;
        this.firemode = builder.defFiremode;
        this.firemodeSwitch = builder.firemodeSwitchFunc;
        this.burstAmount = builder.burstAmount;
        this.shootSound = builder.shootNormal;
        this.silentShootSound = builder.shootSilenced;
        this.reloadSound = builder.reloadSound;
        this.gunVolume = builder.volumeNormal;
        this.silentGunVolume = builder.volumeSilenced;
        this.attachments = builder.attachments;
        this.customScope = builder.customScope;
    }

    public SoundEvent getWeaponReloadSound() {
        return this.reloadSound;
    }

    public int getWeaponAmmoLimit(ItemStack stack) {
        ItemMagazine mag = getAttachment(AttachmentType.MAGAZINE, stack);
        return mag != null && mag.isExtended() ? exMaxAmmo : maxAmmo;
    }

    public void shoot(World world, EntityPlayer player, ItemStack stack) {
        IPlayerData data = PlayerData.get(player);
        CooldownTracker tracker = player.getCooldownTracker();
        if ((this.hasAmmo(stack) || player.capabilities.isCreativeMode) && !data.isReloading() && !tracker.hasCooldown(stack.getItem())) {
            if (!world.isRemote) {
                if (!gunType.equals(GunType.SHOTGUN)) {
                    EntityBullet bullet = new EntityBullet(world, player, this);
                    world.spawnEntity(bullet);
                } else {
                    for (int i = 0; i < 8; i++) {
                        EntityBullet bullet = new EntityBullet(world, player, this);
                        world.spawnEntity(bullet);
                    }
                }

                if (!player.capabilities.isCreativeMode) {
                    this.consumeAmmo(stack);
                }
                tracker.setCooldown(stack.getItem(), getFireRate());
                PacketHandler.sendToClientsAround(new PacketDelayedSound(playWeaponSound(stack), playWeaponSoundVolume(stack), player.posX, player.posY, player.posZ), new TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 256));
            }
        }
    }

    public float playWeaponSoundVolume(ItemStack stack) {
        ItemMuzzle muzzle = this.getAttachment(AttachmentType.MUZZLE, stack);
        return muzzle != null && muzzle.isSilenced() ? this.getGunSilencedVolume() : this.getGunVolume();
    }

    public SoundEvent playWeaponSound(ItemStack stack) {
        ItemMuzzle muzzle = this.getAttachment(AttachmentType.MUZZLE, stack);
        return muzzle != null && muzzle.isSilenced() ? this.getGunSilencedSound() : this.getGunSound();
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    public boolean hasAmmo(ItemStack itemStack) {
        return getAmmo(itemStack) > 0;
    }

    public boolean hasPlayerAmmoForGun(EntityPlayer player, GunBase gun) {
        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack stack = player.inventory.getStackInSlot(i);

            if (stack.getItem() instanceof ItemAmmo) {
                if (((ItemAmmo) stack.getItem()).type == gun.getAmmoType()) {
                    ammoCount = stack.getCount();
                    ammoItem = (ItemAmmo) stack.getItem();
                    return true;
                }
            }
        }

        return player.capabilities.isCreativeMode;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(I18n.format("gun.desc.ammo") + ": " + TextFormatting.RED + getAmmo(stack));
        tooltip.add(I18n.format("gun.desc.firemode") + ": " + getFiremode(stack).translatedName());
        if(GuiScreen.isShiftKeyDown()) {
            if(wepStats.damage == null)
                return;
            tooltip.add(I18n.format("gun.desc.damage") + ": " + TextFormatting.RED + DevUtil.formatToTwoDecimals(wepStats.damage.getAsFloat()));
            tooltip.add(I18n.format("gun.desc.velocity") + ": " + TextFormatting.AQUA + DevUtil.formatToTwoDecimals(wepStats.velocity.getAsFloat() * 20) + " m/s");
            tooltip.add(I18n.format("gun.desc.ammotype") + ": " + TextFormatting.GREEN + ammoType.translatedName());
            tooltip.add(I18n.format("gun.desc.firerate") + ": " + TextFormatting.GOLD + DevUtil.formatToTwoDecimals(20.0D / firerate) + " shots per second");
        } else if(GuiScreen.isCtrlKeyDown()) {
            tooltip.add("Attachments");
            for (AttachmentType<?> type : AttachmentType.allTypes) {
                ItemAttachment attachment = getAttachment(type, stack);
                if(attachment != null) {
                    tooltip.add(type.getName() + ": " + I18n.format(attachment.getUnlocalizedName() + ".name"));
                }
            }
        } else {
            tooltip.add(TextFormatting.YELLOW + I18n.format("gun.desc.moreinfo"));
            tooltip.add(TextFormatting.YELLOW + I18n.format("gun.desc.moreinfo2"));
        }
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        return true;
    }

    public int getBurstAmount() {
        return burstAmount;
    }

    @SuppressWarnings("unchecked")
    public <I extends ItemAttachment> I getAttachment(AttachmentType<I> type, ItemStack stack) {
        NBTTagCompound nbt = getOrCreateGunData(stack);
        if(nbt.hasKey("attachments", Constants.NBT.TAG_COMPOUND)) {
            NBTTagCompound attachmentData = nbt.getCompoundTag("attachments");
            String key = type.getName();
            if(attachmentData.hasKey(key, Constants.NBT.TAG_STRING)) {
                ResourceLocation loc = new ResourceLocation(attachmentData.getString(key));
                Item item = ForgeRegistries.ITEMS.getValue(loc);
                try {
                    return (I) item;
                } catch (ClassCastException ex) {
                    Pubgmc.logger.fatal("Exception occurred while trying to get {} attachment for item {}: {}", key, stack, ex);
                    return null;
                }
            }
        }
        return null;
    }

    public Firemode getFiremode(ItemStack stack) {
        NBTTagCompound nbt = getOrCreateGunData(stack);
        if(nbt.hasKey("firemode", Constants.NBT.TAG_INT)) {
            return Firemode.fromID(nbt.getInteger("firemode"));
        }
        return firemode;
    }

    public void setFiremode(ItemStack stack, Firemode firemode) {
        NBTTagCompound nbt = getOrCreateGunData(stack);
        nbt.setInteger("firemode", firemode.ordinal());
    }

    public Firemode switchFiremode(ItemStack stack) {
        Firemode current = getFiremode(stack);
        return firemodeSwitch.apply(current);
    }

    public ScopeData getScopeData(ItemStack stack) {
        if(customScope != null) {
            return customScope;
        }
        ItemScope scope = getAttachment(AttachmentType.SCOPE, stack);
        return scope != null ? scope.getData() : null;
    }

    public NBTTagCompound getOrCreateGunData(ItemStack stack) {
        if(!stack.hasTagCompound()) {
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("ammo", 0);
            stack.setTagCompound(nbt);
        }
        return stack.getTagCompound();
    }

    public Supplier<SoundEvent> getAction() {
        return action;
    }

    public GunAttachments getAttachments() {
        return attachments;
    }

    @SideOnly(Side.CLIENT)
    @Deprecated
    public void setGunModel(ModelGun model) {
        this.gunModel = model;
    }

    @SideOnly(Side.CLIENT)
    @Deprecated
    public ModelGun getWeaponModel() {
        return gunModel;
    }

    public CFGWeapon getConfigurableStats() {
        return wepStats;
    }

    public double getReloadTime(ItemStack stack) {
        ItemMagazine mag = this.getAttachment(AttachmentType.MAGAZINE, stack);
        ItemStock stock = this.getAttachment(AttachmentType.STOCK, stack);
        return (mag != null && mag.isQuickdraw()) || (stock != null && stock.isFasterReload()) ? reloadTime * 0.7 : reloadTime;
    }

    @Deprecated
    public void registerToGlobalLootPool(boolean airdropOnly) {
        LootManager.register(LootType.GUN, new LootManager.LootEntry(this, gunType.getWeight(), airdropOnly));
    }

    public AmmoType getAmmoType() {
        return ammoType;
    }

    public SoundEvent getGunSound() {
        return shootSound;
    }

    public SoundEvent getGunSilencedSound() {
        return silentShootSound;
    }

    public float getGunVolume() {
        return gunVolume;
    }

    public float getGunSilencedVolume() {
        return silentGunVolume;
    }

    public ReloadType getReloadType() {
        return reloadType;
    }

    public int getFireRate() {
        return firerate;
    }

    public GunType getGunType() {
        return gunType;
    }

    public float getHorizontalRecoil() {
        return horizontalRecoil * wepStats.horizontalRecoilMultiplier.getAsFloat();
    }

    public float getVerticalRecoil() {
        return verticalRecoil * wepStats.verticalRecoilMultiplier.getAsFloat();
    }

    public int getAmmo(ItemStack stack) {
        NBTTagCompound nbt = getOrCreateGunData(stack);
        return DevUtil.wrap(nbt.getInteger("ammo"), 0, getWeaponAmmoLimit(stack));
    }

    public void setAmmo(ItemStack stack, int ammo) {
        NBTTagCompound nbt = getOrCreateGunData(stack);
        nbt.setInteger("ammo", DevUtil.wrap(ammo, 0, getWeaponAmmoLimit(stack)));
    }

    public void consumeAmmo(ItemStack stack) {
        int ammo = getAmmo(stack);
        setAmmo(stack, ammo - 1);
    }

    public enum Firemode {
        SINGLE("gun.firemode.single"),
        BURST("gun.firemode.burst"),
        AUTO("gun.firemode.auto");

        final String name;

        Firemode(String name) {
            this.name = name;
        }

        public static Firemode fromID(int id) {
            return values()[DevUtil.wrap(id, 0, 2)];
        }

        public static Firemode ignoreAuto(Firemode current) {
            return current == SINGLE ? BURST : SINGLE;
        }

        public static Firemode ignoreBurst(Firemode current) {
            return current == SINGLE ? AUTO : SINGLE;
        }

        public static Firemode cycleAll(Firemode current) {
            int i = current.ordinal();
            int j = i + 1;
            if(j > 2)
                j = 0;
            return values()[j];
        }

        @SideOnly(Side.CLIENT)
        public String translatedName() {
            return I18n.format(name);
        }
    }

    public enum ReloadType {
        MAGAZINE,
        SINGLE,
        KAR98K;

        // TODO: clean
        public void handleReload(EntityPlayer player) {
            IPlayerData data = PlayerData.get(player);
            ItemStack heldItem = player.getHeldItemMainhand();

            if (heldItem.getItem() instanceof GunBase) {
                data.getAimInfo().setAiming(false, AimInfo.STOP_AIMING_SPEED);
                GunBase gun = (GunBase) heldItem.getItem();

                if ((heldItem.getTagCompound().getInteger("ammo") == gun.getWeaponAmmoLimit(heldItem) || !gun.hasPlayerAmmoForGun(player, gun)) && data.isReloading()) {
                    data.setReloading(false);
                    PacketHandler.INSTANCE.sendTo(new PacketReloadingSP(false), (EntityPlayerMP) player);
                }

                if (heldItem.getTagCompound().getInteger("ammo") < gun.getWeaponAmmoLimit(heldItem)) {
                    if (gun.getReloadType() == ReloadType.MAGAZINE) {
                        while ((gun.hasPlayerAmmoForGun(player, gun) || player.capabilities.isCreativeMode) && heldItem.getTagCompound().getInteger("ammo") < gun.getWeaponAmmoLimit(heldItem)) {
                            int ammoInGun = heldItem.getTagCompound().getInteger("ammo");
                            int ammoToFill = gun.getWeaponAmmoLimit(heldItem) - ammoInGun;
                            int ammoInInventory = gun.ammoCount;

                            if (ammoToFill > ammoInInventory) ammoToFill = ammoInInventory;

                            if (!player.capabilities.isCreativeMode) {
                                ItemAmmo ammo = (ItemAmmo) gun.ammoItem.getAmmoItem();
                                player.inventory.clearMatchingItems(ammo.getAmmoItem(), 0, ammoToFill, null);
                            }

                            heldItem.getTagCompound().setInteger("ammo", ammoInGun + ammoToFill);
                        }

                        data.setReloading(false);
                        PacketHandler.INSTANCE.sendTo(new PacketReloadingSP(false), (EntityPlayerMP) player);
                    } else if (gun.getReloadType() == ReloadType.SINGLE) {
                        if (gun.hasPlayerAmmoForGun(player, gun) || player.capabilities.isCreativeMode) {
                            //If the gun is already full and player still atempts to reload, cancel it
                            if (heldItem.getTagCompound().getInteger("ammo") == gun.getWeaponAmmoLimit(heldItem)) {
                                data.setReloading(false);
                                PacketHandler.INSTANCE.sendTo(new PacketReloadingSP(false), (EntityPlayerMP) player);
                            }

                            if (heldItem.getTagCompound().getInteger("ammo") < gun.getWeaponAmmoLimit(heldItem)) {
                                ItemAmmo ammo = (ItemAmmo) gun.ammoItem.getAmmoItem();

                                if (!player.capabilities.isCreativeMode) {
                                    player.inventory.clearMatchingItems(ammo.getAmmoItem(), 0, 1, null);
                                }

                                //Increase ammo count by 1
                                heldItem.getTagCompound().setInteger("ammo", heldItem.getTagCompound().getInteger("ammo") + 1);
                            }
                        }
                    } else if (gun.getReloadType() == ReloadType.KAR98K) {
                        if (!gun.hasAmmo(heldItem)) {
                            while ((gun.hasPlayerAmmoForGun(player, gun) || player.capabilities.isCreativeMode) && heldItem.getTagCompound().getInteger("ammo") < gun.getWeaponAmmoLimit(heldItem)) {
                                ItemAmmo ammo = (ItemAmmo) gun.ammoItem.getAmmoItem();

                                if (!player.capabilities.isCreativeMode) {
                                    player.inventory.clearMatchingItems(ammo.getAmmoItem(), 0, 1, null);
                                }

                                heldItem.getTagCompound().setInteger("ammo", heldItem.getTagCompound().getInteger("ammo") + 1);
                            }

                            data.setReloading(false);
                            PacketHandler.INSTANCE.sendTo(new PacketReloadingSP(false), (EntityPlayerMP) player);
                        } else if (heldItem.getTagCompound().getInteger("ammo") > 0 && heldItem.getTagCompound().getInteger("ammo") < gun.getWeaponAmmoLimit(heldItem)) {
                            ItemAmmo ammo = (ItemAmmo) gun.ammoItem.getAmmoItem();

                            if (!player.capabilities.isCreativeMode) {
                                player.inventory.clearMatchingItems(ammo.getAmmoItem(), 0, 1, null);
                            }

                            heldItem.getTagCompound().setInteger("ammo", heldItem.getTagCompound().getInteger("ammo") + 1);
                        }
                    } else {
                        throw new IllegalArgumentException("Unknown reload type. Report this to mod author!");
                    }
                }
            }
        }
    }

    public enum GunType {
        LMG(40),
        PISTOL(100),
        SHOTGUN(80),
        SMG(70),
        AR(50),
        DMR(30),
        SR(10);

        final int weight;

        GunType(int weight) {
            this.weight = weight;
        }

        public static GunType getTypeFromName(String name) {
            for (GunType type : values()) {
                if (type.name().equalsIgnoreCase(name)) {
                    return type;
                }
            }
            return null;
        }

        public static List<GunType> toCollection() {
            List<GunType> list = new ArrayList<>(values().length);
            for (int i = 0; i < values().length; i++) {
                list.add(values()[i]);
            }
            list = list.stream().filter(type -> type != LMG).collect(Collectors.toList());
            return list;
        }

        public int getWeight() {
            return weight;
        }
    }
}
