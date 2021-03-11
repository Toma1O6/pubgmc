package dev.toma.pubgmc.client.renderer.item.gun;

import dev.toma.pubgmc.client.models.weapons.ModelGun;
import dev.toma.pubgmc.client.models.weapons.ModelMK14;
import dev.toma.pubgmc.client.models.weapons.ModelWin94;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;

public class RenderWincherster94 extends WeaponRenderer {

    final ModelWin94 model = new ModelWin94();

    @Override
    public void preRender(ItemCameraTransforms.TransformType transformType) {
        GlStateManager.translate(0.001, -0.01, 0.0);
    }

    @Override
    public ModelGun getWeaponModel() {
        return model;
    }

    @Override
    public void registerAttachmentRenders() {

    }
}
