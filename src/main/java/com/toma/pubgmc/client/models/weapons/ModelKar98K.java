package com.toma.pubgmc.client.models.weapons;

import com.toma.pubgmc.client.models.ModelGun;
import com.toma.pubgmc.common.capability.IPlayerData.PlayerDataProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;

public class ModelKar98K extends ModelGun
{
	private final ModelRenderer bone;
	private final ModelRenderer stock;
	private final ModelRenderer stock2;
	private final ModelRenderer ir;
	private final ModelRenderer trigger;

	public ModelKar98K()
	{
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, -23.0F, -41.0F, 6, 6, 42, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -23.3F, -50.5F, 5, 1, 51, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -23.3F, -51.0F, 5, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -0.5F, -24.0F, -67.0F, 1, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -0.5F, -19.0F, -61.0F, 1, 1, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -0.5F, -20.0F, -54.0F, 1, 1, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -1.0F, -22.0F, -72.0F, 2, 2, 21, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -0.5F, -26.0F, -67.0F, 1, 3, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.3F, -49.5F, 5, 1, 35, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -21.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -23.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -25.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -27.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -29.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -31.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -33.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -35.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -37.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -39.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -41.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -43.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -45.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -47.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -49.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -23.9F, -20.5F, 4, 1, 21, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, 1.0F, -24.5F, -15.5F, 1, 1, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -24.5F, -15.5F, 1, 1, 16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -22.0F, 1.0F, 4, 5, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -17.0F, 43.0F, 4, 14, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -14.5F, 34.0F, 5, 3, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -17.5F, -3.5F, 4, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -14.5F, -6.5F, 4, 1, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -15.5F, -7.5F, 4, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.0F, -17.5F, -8.5F, 4, 2, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -3.0F, -23.0F, -42.0F, 6, 6, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.5F, -22.3F, -50.0F, 5, 5, 8, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -19.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -17.5F, 5, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 64, -2.5F, -24.7F, -15.5F, 5, 1, 1, 0.0F, false));

		stock = new ModelRenderer(this);
		stock.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(stock, -0.0873F, 0.0F, 0.0F);
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -21.0F, 5.0F, 4, 3, 38, 0.0F, false));
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -18.0F, 14.0F, 4, 3, 28, 0.0F, false));
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -15.0F, 24.0F, 4, 2, 19, 0.0F, false));
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -13.0F, 29.0F, 4, 2, 14, 0.0F, false));
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -12.0F, 33.0F, 4, 2, 10, 0.0F, false));

		stock2 = new ModelRenderer(this);
		stock2.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(stock2, -0.3491F, 0.0F, 0.0F);
		stock2.cubeList.add(new ModelBox(stock2, 0, 0, -2.0F, -21.0F, -1.0F, 4, 3, 41, 0.0F, false));

		ir = new ModelRenderer(this);
		ir.setRotationPoint(0.0F, 24.0F, 0.0F);
		ir.cubeList.add(new ModelBox(ir, 0, 65, -2.0F, -25.0F, -3.0F, 4, 2, 2, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 65, -1.5F, -26.0F, -3.0F, 1, 1, 2, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 65, 0.5F, -26.0F, -3.0F, 1, 1, 2, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 65, -1.0F, -27.0F, -3.0F, 2, 1, 2, 0.0F, false));

		trigger = new ModelRenderer(this);
		trigger.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(trigger, -0.1745F, 0.0F, 0.0F);
		trigger.cubeList.add(new ModelBox(trigger, 0, 64, -1.0F, -16.5F, -8.5F, 2, 2, 1, 0.0F, false));
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void render(ItemStack stack)
	{
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		
		if(player != null && player.hasCapability(PlayerDataProvider.PLAYER_DATA, null))
		{
			boolean aim = player.getCapability(PlayerDataProvider.PLAYER_DATA, null).isAiming();
			
			renderKar98K(aim, stack);
		}
	}
	
	private void renderKar98K(boolean aim, ItemStack stack)
	{
		GlStateManager.pushMatrix();
		transform.defaultSRTransform();
		GlStateManager.translate(0.0, 2.0, 7.0);
		
		if(aim && enableADS(stack))
		{
			rotateModelForADSRendering();
			GlStateManager.translate(26.6, -12.3, 15.0);
			
			if(hasRedDot(stack)) GlStateManager.translate(0, 3.4, 0);
			else if(hasHoloSight(stack)) GlStateManager.translate(0, 5.4, 0);
		}
		
		renderParts(hasScopeAtachment(stack));
		GlStateManager.popMatrix();
		
		if(hasSilencer(stack)) renderSilencer(aim, stack);
		if(hasRedDot(stack)) renderRedDot(aim, stack);
		else if(hasHoloSight(stack)) renderHolo(aim, stack);
		else if(has2X(stack)) render2x(stack);
		else if(has4X(stack)) render4x(stack);
		else if(has8X(stack)) render8x(stack);
		else if(has15X(stack)) render15x(stack);
	}
	
	private void renderRedDot(boolean aim, ItemStack stack)
	{
		if(aim) {
			renderRedDot(28.25, -17, 7, 1.3f, stack);
		}
		
		else renderRedDot(-0.5, -7.2, -9, 1.3f, stack);
	}
	
	private void renderHolo(boolean aim, ItemStack stack)
	{
		if(aim) {
			renderHolo(22.35, -13.8, 1, 1.3f, stack);
		}
		else renderHolo(-1.5, -7.7, -11, 1.3f, stack);
	}
	
	private void render2x(ItemStack stack)
	{
		renderScope2X(7.8, 10, -19, 1f, stack);
	}
	
	private void render4x(ItemStack stack)
	{
		renderScope4X(7.8, 10, -19, 1f, stack);
	}
	
	private void render8x(ItemStack stack)
	{
		renderScope8X(0, -1.5, -11, 1f, stack);
	}
	
	private void render15x(ItemStack stack)
	{
		renderScope15X(0, -1, -11, 1f, stack);
	}
	
	private void renderSilencer(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack)) {
			if(hasRedDot(stack)) {
				renderSniperSilencer(-16, 6, 3, 1f, stack);
			} else if(hasHoloSight(stack)) {
				renderSniperSilencer(-16, 4.4, 3, 1f, stack);
			} else renderSniperSilencer(-16, 7.8, 3, 1f, stack);
		}
		
		else renderSniperSilencer(0, 0.4, -5, 1f, stack);
	}
	
	private void renderParts(boolean hasScope)
	{
		bone.render(1f);
		stock.render(1f);
		stock2.render(1f);
		trigger.render(1f);
		if(!hasScope) ir.render(1f);
	}
}
