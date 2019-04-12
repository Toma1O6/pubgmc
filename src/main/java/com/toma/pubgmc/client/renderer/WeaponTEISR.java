package com.toma.pubgmc.client.renderer;

import com.toma.pubgmc.Pubgmc;
import com.toma.pubgmc.client.models.weapons.ModelAKM;
import com.toma.pubgmc.client.models.weapons.ModelAUG;
import com.toma.pubgmc.client.models.weapons.ModelAWM;
import com.toma.pubgmc.client.models.weapons.ModelBerylM762;
import com.toma.pubgmc.client.models.weapons.ModelDP28;
import com.toma.pubgmc.client.models.weapons.ModelFlareGun;
import com.toma.pubgmc.client.models.weapons.ModelG36C;
import com.toma.pubgmc.client.models.weapons.ModelGroza;
import com.toma.pubgmc.client.models.weapons.ModelKar98K;
import com.toma.pubgmc.client.models.weapons.ModelM16A4;
import com.toma.pubgmc.client.models.weapons.ModelM24;
import com.toma.pubgmc.client.models.weapons.ModelM249;
import com.toma.pubgmc.client.models.weapons.ModelM416;
import com.toma.pubgmc.client.models.weapons.ModelMK14;
import com.toma.pubgmc.client.models.weapons.ModelMK47Mutant;
import com.toma.pubgmc.client.models.weapons.ModelMicroUzi;
import com.toma.pubgmc.client.models.weapons.ModelMini14;
import com.toma.pubgmc.client.models.weapons.ModelP18C;
import com.toma.pubgmc.client.models.weapons.ModelP1911;
import com.toma.pubgmc.client.models.weapons.ModelP92;
import com.toma.pubgmc.client.models.weapons.ModelPP19Bizon;
import com.toma.pubgmc.client.models.weapons.ModelQBU;
import com.toma.pubgmc.client.models.weapons.ModelQBZ;
import com.toma.pubgmc.client.models.weapons.ModelR1895;
import com.toma.pubgmc.client.models.weapons.ModelR45;
import com.toma.pubgmc.client.models.weapons.ModelS12K;
import com.toma.pubgmc.client.models.weapons.ModelS1897;
import com.toma.pubgmc.client.models.weapons.ModelS686;
import com.toma.pubgmc.client.models.weapons.ModelSKS;
import com.toma.pubgmc.client.models.weapons.ModelSLR;
import com.toma.pubgmc.client.models.weapons.ModelSawedOff;
import com.toma.pubgmc.client.models.weapons.ModelScarL;
import com.toma.pubgmc.client.models.weapons.ModelScorpion;
import com.toma.pubgmc.client.models.weapons.ModelTommyGun;
import com.toma.pubgmc.client.models.weapons.ModelUmp45;
import com.toma.pubgmc.client.models.weapons.ModelVSS;
import com.toma.pubgmc.client.models.weapons.ModelVector;
import com.toma.pubgmc.client.models.weapons.ModelWin94;
import com.toma.pubgmc.init.PMCRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class WeaponTEISR extends TileEntityItemStackRenderer
{
	//model
	private final ModelFlareGun flareGun = new ModelFlareGun();
	private final ModelP92 p92 = new ModelP92();
	private final ModelP1911 p1911 = new ModelP1911();
	private final ModelP18C p18c = new ModelP18C();
	private final ModelR45 r45 = new ModelR45();
	private final ModelR1895 r1895 = new ModelR1895();
	private final ModelScorpion scorpion = new ModelScorpion();
	private final ModelWin94 win94 = new ModelWin94();
	private final ModelSawedOff sawedOff = new ModelSawedOff();
	private final ModelS1897 s1897 = new ModelS1897();
	private final ModelS686 s686 = new ModelS686();
	private final ModelS12K s12k = new ModelS12K();
	private final ModelMicroUzi microuzi = new ModelMicroUzi();
	private final ModelUmp45 ump = new ModelUmp45();
	private final ModelTommyGun tommygun = new ModelTommyGun();
	private final ModelPP19Bizon bizon = new ModelPP19Bizon();
	private final ModelVector vector = new ModelVector();
	private final ModelM16A4 m16a4 = new ModelM16A4();
	private final ModelM416 m416 = new ModelM416();
	private final ModelScarL scar = new ModelScarL();
	private final ModelG36C g36c = new ModelG36C();
	private final ModelQBZ qbz = new ModelQBZ();
	private final ModelAUG aug = new ModelAUG();
	private final ModelAKM akm = new ModelAKM();
	private final ModelBerylM762 m762 = new ModelBerylM762();
	private final ModelMK47Mutant mk47 = new ModelMK47Mutant();
	private final ModelGroza groza = new ModelGroza();
	private final ModelDP28 dp28 = new ModelDP28();
	private final ModelM249 m249 = new ModelM249();
	private final ModelVSS vss = new ModelVSS();
	private final ModelMini14 mini14 = new ModelMini14();
	private final ModelQBU qbu = new ModelQBU();
	private final ModelSKS sks = new ModelSKS();
	private final ModelSLR slr = new ModelSLR();
	private final ModelMK14 mk14 = new ModelMK14();
	private final ModelKar98K kar98k = new ModelKar98K();
	private final ModelM24 m24 = new ModelM24();
	private final ModelAWM awm = new ModelAWM();
	
	@Override
	public void renderByItem(ItemStack stack)
	{
		if(stack.getItem() == PMCRegistry.Items.FLARE_GUN)
		{
			bindTexture("flare_gun");
			flareGun.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.P92)
		{
			bindTexture("p92");
			p92.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.P1911)
		{
			bindTexture("p1911");
			p1911.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.P18C)
		{
			bindTexture("p18c");
			p18c.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.R45)
		{
			bindTexture("r45");
			r45.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.R1895)
		{
			bindTexture("r1895");
			r1895.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.SCORPION)
		{
			bindTexture("m762");
			scorpion.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.WIN94)
		{
			bindTexture("win94");
			win94.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.SAWED_OFF)
		{
			bindTexture("sawed_off");
			sawedOff.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.S1897)
		{
			//same texture as for sawed off
			bindTexture("sawed_off");
			s1897.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.S686)
		{
			bindTexture("sawed_off");
			s686.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.S12K)
		{
			bindTexture("s12k");
			s12k.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.MICROUZI)
		{
			bindTexture("microuzi");
			microuzi.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.UMP45)
		{
			bindTexture("microuzi");
			ump.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.VECTOR)
		{
			bindTexture("vector");
			vector.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.TOMMY_GUN)
		{
			bindTexture("tommygun");
			tommygun.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.BIZON)
		{
			bindTexture("m762");
			bizon.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.M16A4)
		{
			bindTexture("microuzi");
			m16a4.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.M416)
		{
			bindTexture("microuzi");
			m416.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.SCAR_L)
		{
			bindTexture("scarl");
			scar.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.G36C)
		{
			bindTexture("m762");
			g36c.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.QBZ)
		{
			bindTexture("microuzi");
			qbz.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.AUG)
		{
			bindTexture("aug");
			aug.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.AKM)
		{
			bindTexture("akm");
			akm.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.BERYL_M762)
		{
			bindTexture("m762");
			m762.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.MK47_MUTANT)
		{
			bindTexture("m762");
			mk47.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.GROZA)
		{
			bindTexture("akm");
			groza.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.DP28)
		{
			bindTexture("akm");
			dp28.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.M249)
		{
			bindTexture("m249");
			m249.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.VSS)
		{
			bindTexture("akm");
			vss.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.MINI14)
		{
			bindTexture("mini14");
			mini14.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.QBU)
		{
			bindTexture("m762");
			qbu.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.SKS)
		{
			bindTexture("sks");
			sks.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.SLR)
		{
			bindTexture("m762");
			slr.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.MK14)
		{
			bindTexture("m762");
			mk14.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.KAR98K)
		{
			bindTexture("kar98k");
			kar98k.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.M24)
		{
			bindTexture("m24");
			m24.render(stack);
		}
		
		else if(stack.getItem() == PMCRegistry.Items.AWM)
		{
			bindTexture("awm");
			awm.render(stack);
		}
	}
	
	private void bindTexture(String name)
	{
		ResourceLocation rl = new ResourceLocation(Pubgmc.MOD_ID + ":textures/weapons/" + name + ".png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(rl);
	}
}
