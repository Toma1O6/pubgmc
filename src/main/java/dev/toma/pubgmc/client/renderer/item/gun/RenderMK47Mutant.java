package dev.toma.pubgmc.client.renderer.item.gun;

import dev.toma.pubgmc.client.models.weapons.ModelGun;
import dev.toma.pubgmc.client.models.weapons.ModelMK47Mutant;
import dev.toma.pubgmc.client.renderer.IRenderConfig;
import dev.toma.pubgmc.init.PMCItems;
import dev.toma.pubgmc.util.Pair;

public class RenderMK47Mutant extends WeaponRenderer {

    final ModelMK47Mutant model = new ModelMK47Mutant();

    @Override
    public Pair<IRenderConfig, IRenderConfig> createHandRenderConfigs() {
        return Pair.of(
                IRenderConfig.rotatedScaled(0.445F, -0.265F, -0.05F, 1F, 1F, 1.7F, 0F, -30F, 0F),
                IRenderConfig.positioned(0.1F, -0.23F, 0.3F)
        );
    }

    @Override
    public ModelGun getWeaponModel() {
        return model;
    }

    @Override
    public void registerAttachmentRenders() {
        registerRenderConfig(PMCItems.SCOPE4X, IRenderConfig.positionedScaled(0.05F, 0.17F, 0.1F, 0.9F, 0.9F, 0.9F));
        registerRenderConfig(PMCItems.SILENCER_AR, IRenderConfig.positioned(0F, 0.08F, 0.02F));
        registerRenderConfig(PMCItems.GRIP_ANGLED, IRenderConfig.positioned(0F, 0.14F, 0.1F));
        registerRenderConfig(PMCItems.GRIP_VERTICAL, IRenderConfig.positioned(0F, 0.13F, 0.1F));
        registerRenderConfig(PMCItems.HOLOGRAPHIC, IRenderConfig.positioned(0F, 0.08F, 0.2F));
        registerRenderConfig(PMCItems.RED_DOT, IRenderConfig.positioned(0F, 0.1F, 0.1F));
        registerRenderConfig(PMCItems.SCOPE2X, IRenderConfig.positioned(0F, 0.11F, 0.1F));
    }

    @Override
    public String getResourcePrefix() {
        return "mk47mutant";
    }
}
