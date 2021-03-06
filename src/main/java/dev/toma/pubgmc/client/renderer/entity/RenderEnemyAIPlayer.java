package dev.toma.pubgmc.client.renderer.entity;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.client.models.ModelAIPlayer;
import dev.toma.pubgmc.common.entity.bot.EntityAIPlayer;
import dev.toma.pubgmc.common.items.armor.ItemGhillie;
import dev.toma.pubgmc.init.PMCItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderEnemyAIPlayer extends RenderBiped<EntityAIPlayer> {

    private static final ResourceLocation[] BOT_TEXTURES = {
            new ResourceLocation(Pubgmc.MOD_ID, "textures/entity/bot_0.png"),
            new ResourceLocation(Pubgmc.MOD_ID, "textures/entity/bot_1.png"),
            new ResourceLocation(Pubgmc.MOD_ID, "textures/entity/bot_2.png"),
            new ResourceLocation(Pubgmc.MOD_ID, "textures/entity/bot_3.png")
    };

    public RenderEnemyAIPlayer(RenderManager manager) {
        super(manager, new ModelAIPlayer(), 0.5F);
        this.addLayer(new LayerGhillieSpecial(this));
        this.addLayer(new LayerBipedArmor(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAIPlayer entity) {
        return BOT_TEXTURES[entity.getVariant()];
    }

    private static class LayerGhillieSpecial implements LayerRenderer<EntityAIPlayer> {

        public static final ResourceLocation TEXTURE_MAIN = new ResourceLocation(Pubgmc.MOD_ID + ":textures/models/ghillie_main.png");
        public static final ResourceLocation TEXTURE_OVERLAY = new ResourceLocation(Pubgmc.MOD_ID + ":textures/models/ghillie_overlay.png");

        protected final RenderLivingBase<?> renderLivingBase;
        protected final ModelBiped baseLayer;
        protected final ModelBiped overlay;

        public LayerGhillieSpecial(RenderLivingBase<?> renderLivingBase) {
            this.renderLivingBase = renderLivingBase;
            this.baseLayer = new ModelBiped(1.2F);
            this.overlay = new ModelBiped(1.4F);
        }

        @Override
        public boolean shouldCombineTextures() {
            return false;
        }

        @Override
        public void doRenderLayer(EntityAIPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
            ItemStack stack = entitylivingbaseIn.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
            if(!stack.isEmpty() && stack.getItem() == PMCItems.GHILLIE_SUIT) {
                this.baseLayer.setModelAttributes(this.renderLivingBase.getMainModel());
                this.overlay.setModelAttributes(this.renderLivingBase.getMainModel());
                this.baseLayer.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
                this.overlay.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
                int color = stack.hasTagCompound() && stack.getTagCompound().hasKey("ghillieColor") ? stack.getTagCompound().getInteger("ghillieColor") : ItemGhillie.DEFAULT_COLOR;
                float red = (color >> 16 & 255) / 255.0F;
                float green = (color >> 8 & 255) / 255.0F;
                float blue = (color & 255) / 255.0F;
                this.renderLivingBase.bindTexture(TEXTURE_MAIN);
                GlStateManager.color(red, green, blue);
                this.baseLayer.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                this.renderLivingBase.bindTexture(TEXTURE_OVERLAY);
                this.overlay.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.color(1f, 1f, 1f);
            }
        }
    }
}
