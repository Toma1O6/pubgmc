package dev.toma.pubgmc.client.renderer.item.gun;

import dev.toma.pubgmc.client.models.weapons.ModelGun;
import dev.toma.pubgmc.client.models.weapons.ModelM416;
import dev.toma.pubgmc.client.renderer.IRenderConfig;
import dev.toma.pubgmc.init.PMCItems;
import dev.toma.pubgmc.util.Pair;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;

public class RenderM416 extends WeaponRenderer {

    final ModelM416 model = new ModelM416();

    @Override
    public Pair<IRenderConfig, IRenderConfig> createHandRenderConfigs() {
        return Pair.of(
                IRenderConfig.rotatedScaled(0.3F, -0.275F, 0.35F, 1F, 1F, 2.4F, 0F, -40F, 0F),
                IRenderConfig.positioned(0.2F, -0.28F, 0.3F)
        );
    }

    @Override
    public void preRender(ItemCameraTransforms.TransformType transformType) {
        GlStateManager.translate(0.0, 0.24, -0.2);
    }

    @Override
    public ModelGun getWeaponModel() {
        return model;
    }

    @Override
    public void registerAttachmentRenders() {
        registerRenderConfig(PMCItems.SCOPE4X, IRenderConfig.positionedScaled(0.0485F, -0.1F, 0.18F, 0.9F, 0.9F, 0.9F));
        registerRenderConfig(PMCItems.SILENCER_AR, IRenderConfig.positioned(0F, -0.15F, 0.48F));
        registerRenderConfig(PMCItems.GRIP_ANGLED, IRenderConfig.positioned(0F, -0.08F, 0.3F));
        registerRenderConfig(PMCItems.GRIP_VERTICAL, IRenderConfig.positioned(0F, -0.09F, 0.3F));
        registerRenderConfig(PMCItems.HOLOGRAPHIC, IRenderConfig.positioned(0F, -0.19F, 0.2F));
        registerRenderConfig(PMCItems.RED_DOT, IRenderConfig.positioned(0F, -0.16F, 0.2F));
        registerRenderConfig(PMCItems.SCOPE2X, IRenderConfig.positionedScaled(0.1F, -0.03F, 0.24F, 0.8F, 0.8F, 0.8F));
    }

    @Override
    public String getResourcePrefix() {
        return "m416";
    }
}
