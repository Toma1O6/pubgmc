package com.toma.pubgmc.client.models.weapons;

import com.toma.pubgmc.client.models.ModelGun;
import com.toma.pubgmc.common.capability.IPlayerData;
import com.toma.pubgmc.common.capability.IPlayerData.PlayerDataProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;

public class ModelMicroUzi extends ModelGun
{
	private final ModelRenderer uzi;

	public ModelMicroUzi()
	{
		textureWidth = 128;
		textureHeight = 128;

		uzi = new ModelRenderer(this);
		uzi.setRotationPoint(0.0F, 24.0F, 0.0F);
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -3.0F, -21.0F, -11.0F, 6, 6, 18, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -1.5F, -19.5F, -12.0F, 3, 3, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -1.0F, -19.0F, -14.0F, 2, 2, 2, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -0.5F, -23.0F, -9.9F, 1, 2, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, 1.5F, -22.5F, 3.0F, 1, 2, 3, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -2.5F, -22.5F, 3.0F, 1, 2, 3, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -2.5F, -21.5F, -10.5F, 5, 1, 17, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -0.5F, -22.0F, 5.0F, 1, 1, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -1.0F, -24.5F, 5.0F, 2, 1, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -1.5F, -24.0F, 5.0F, 1, 2, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, 0.5F, -24.0F, 5.0F, 1, 2, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -3.5F, -20.0F, -9.0F, 7, 1, 13, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -3.5F, -18.0F, -9.0F, 7, 1, 13, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -2.0F, -15.0F, -3.0F, 4, 2, 4, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, 1.5F, -22.0F, -6.0F, 1, 2, 5, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -2.0F, -20.0F, 6.5F, 1, 3, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, 1.0F, -20.0F, 6.5F, 1, 3, 1, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -2.5F, -22.0F, -6.0F, 1, 2, 5, 0.0F, false));
		uzi.cubeList.add(new ModelBox(uzi, 0, 0, -1.5F, -13.0F, -2.5F, 3, 12, 3, 0.0F, false));
	}
	
	@Override
	public void render(ItemStack stack)
	{
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		
		if(player != null && player.hasCapability(PlayerDataProvider.PLAYER_DATA, null))
		{
			IPlayerData data = player.getCapability(PlayerDataProvider.PLAYER_DATA, null);
			
			if(data.isAiming())
			{
				renderUzi(true, stack);
				
				if(hasSilencer(stack))
				{
					renderSilencer(true, stack);
				}
			}
			
			else
			{
				renderUzi(false, stack);
				
				if(hasSilencer(stack))
				{
					renderSilencer(false, stack);
				}
			}
		}
	}
	
	private void renderUzi(boolean aim, ItemStack stack)
	{
		GlStateManager.pushMatrix();
		transform.defaultSMGTransform();
		
		if(aim)
		{
			GlStateManager.translate(18.699999999999996, -6.600000000000001, 5.0);
		}
		
		uzi.render(1f);
		GlStateManager.popMatrix();
	}
	
	private void renderSilencer(boolean aim, ItemStack stack)
	{
		GlStateManager.pushMatrix();
		if(aim)
		{
			renderSMGSilencer(-18.7, 7, 4.8, 1f, stack);
		}
		
		else renderSMGSilencer(0.1, 0, 0, 1f, stack);
		GlStateManager.popMatrix();
	}
}
