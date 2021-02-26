package dev.toma.pubgmc;

import dev.toma.pubgmc.client.layers.LayerGhillie;
import dev.toma.pubgmc.common.capability.player.IPlayerData;
import dev.toma.pubgmc.common.capability.player.PlayerData;
import dev.toma.pubgmc.common.items.guns.GunBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ClientHooks {

    public static void model_setupModelAngles(ModelBiped model) {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;
        Entity entity1 = mc.getRenderViewEntity();
        if(player == entity1 && mc.gameSettings.thirdPersonView == 0) {
            return;
        }
        IPlayerData data = PlayerData.get(player);
        if(data == null)
            return;
        boolean isHoldingWeapon = player.getHeldItemMainhand().getItem() instanceof GunBase;
        boolean isProne = data.isProning();
        boolean playerModel = model instanceof ModelPlayer;
        if(isProne) {
            float f0 = (float) Math.toRadians(180.0F);
            float f1 = (float) Math.toRadians(10.0F);
            float f2 = (float) Math.toRadians(-45.0F);
            model.bipedRightArm.rotateAngleX = f0;
            model.bipedLeftArm.rotateAngleX = f0;
            model.bipedRightArm.rotateAngleZ = -f1;
            model.bipedLeftArm.rotateAngleZ = f1;
            model.bipedRightLeg.rotateAngleZ = f1;
            model.bipedLeftLeg.rotateAngleZ = -f1;
            model.bipedHead.rotateAngleX = model.bipedHead.rotateAngleX + f2;
            model.bipedHeadwear.rotateAngleX = model.bipedHead.rotateAngleX;
            if(playerModel) {
                ModelPlayer mp = (ModelPlayer) model;
                ModelBase.copyModelAngles(model.bipedRightArm, mp.bipedRightArmwear);
                ModelBase.copyModelAngles(model.bipedLeftArm, mp.bipedLeftArmwear);
            }
            player.limbSwing = 0.0F;
            player.limbSwingAmount = 0.0F;
        } else if(isHoldingWeapon) {
            boolean aiming = data.isAiming();
            float f0;
            float f1;
            float f2;
            if(aiming) {
                f0 = (float) Math.toRadians(-90.0F);
                f1 = (float) Math.toRadians(-30.0F);
                f2 = (float) Math.toRadians(45.0F);
                model.bipedRightArm.rotateAngleX = f0;
                model.bipedRightArm.rotateAngleY = f1;
                model.bipedLeftArm.rotateAngleX = f0;
            } else {
                f0 = (float) Math.toRadians(-55.0F);
                f1 = (float) Math.toRadians(-40.0F);
                f2 = (float) Math.toRadians(60.0F);
                float f3 = (float) Math.toRadians(-60.0F);
                model.bipedRightArm.rotateAngleX = f0;
                model.bipedLeftArm.rotateAngleX = f3;
                model.bipedRightArm.rotateAngleY = f1;
            }
            model.bipedLeftArm.rotateAngleY = f2;
            if(playerModel) {
                ModelPlayer mp = (ModelPlayer) model;
                ModelBase.copyModelAngles(model.bipedRightArm, mp.bipedRightArmwear);
                ModelBase.copyModelAngles(model.bipedLeftArm, mp.bipedLeftArmwear);
            }
        }
    }

    public static void player_preRenderCallback(RenderPlayer render, AbstractClientPlayer abstractClientPlayer, float partialTicks) {
        IPlayerData data = PlayerData.get(abstractClientPlayer);
        if(data != null && data.isProning()) {
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.translate(0.0F, 0.9F, 0.12F);
        }
    }

    public static void player_constructRender(RenderPlayer renderPlayer, RenderManager manager, boolean useSmallArms) {
        renderPlayer.addLayer(new LayerGhillie(renderPlayer));
    }
}