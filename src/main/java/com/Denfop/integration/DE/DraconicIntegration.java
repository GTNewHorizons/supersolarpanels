package com.Denfop.integration.DE;

import com.Denfop.Config;
import com.Denfop.SSPItem;
import com.Denfop.IUCore;
import com.Denfop.item.base.SSPItemBase;
import com.Denfop.tiles.overtimepanel.TileNeutronSolarPanel;
import com.brandon3055.draconicevolution.common.ModItems;
import com.brandon3055.draconicevolution.common.handler.ConfigHandler;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
public class DraconicIntegration {



	  public static Item.ToolMaterial CHAOS= EnumHelper.addToolMaterial("CHAOS", 15, -1, 600.0F, 90.0F, 60);
	public static Item ChaosDestructionStaff;
 public static Item ChaosPickaxe;
 public static Item ChaosAxe;
 public static ItemArmor ChaosHelm;
public static Item ChaosShovel;
 public static Item ChaosSword;
 public static Item ChaosBow;
 public static ItemArmor ChaosChest;
 public static ItemArmor ChaosLeggs;
 public static ItemArmor ChaosBoots;
 public static Item ChaosEnergyCore;
 public static ItemDC ChaosFluxCapacitor;
 public static Item chaosingot;
 public static Block blockDESolarPanel;
private static ArmorMaterial  CHAOS_ARMOR = EnumHelper.addArmorMaterial("CHAOS_ARMOR", -1, new int[] { 5, 10, 8, 6 }, 30);
public static void init() {
	
	   GameRegistry.registerItem(ChaosEnergyCore =   new SSPDEItem().setMaxStackSize(64).setUnlocalizedName("ChaosEnergyCore").setTextureName("supersolarpanel:ChaosEnergyCore"),"ChaosEnergyCore");
		if(Config.registerChaosFluxCapacitor)
		   ChaosFluxCapacitor = (ItemDC)new ChaosFluxCapacitor();
		if(Config.registerChaosDestructionStaff)
			ChaosDestructionStaff = (Item)new ChaosDistructionStaff();
		if(Config.registerChaosPickaxe)
			ChaosPickaxe = (Item)new ChaosPickaxe();
		if(Config.registerChaosAxe)
			ChaosAxe = (Item)new ChaosAxe();
		if(Config.registerChaosShovel)
			ChaosShovel = (Item)new ChaosShovel();
		if(Config.registerChaosSword)
		ChaosSword = (Item)new ChaosSword();
		if(Config.registerChaosBow)
		ChaosBow = (Item)new ChaosBow();
		if(Config.registerChaosArmour) {
		ChaosHelm = (ItemArmor)new ChaosArmor(CHAOS_ARMOR, 0, "ChaosHelm");
		ChaosChest = (ItemArmor)new ChaosArmor(CHAOS_ARMOR, 1, "ChaosChest");
		ChaosLeggs = (ItemArmor)new ChaosArmor(CHAOS_ARMOR, 2, "ChaosLeggs");
		ChaosBoots = (ItemArmor)new ChaosArmor(CHAOS_ARMOR, 3, "ChaosBoots");}
		 GameRegistry.registerItem( chaosingot = new SSPDEItem().setMaxStackSize(64).setUnlocalizedName("chaosingot").setTextureName("supersolarpanel:chaosingot"),"chaosingot");    
	if(Config.registerDraconicPanels)
		 GameRegistry.registerBlock(blockDESolarPanel = (Block)new blockDESolarPanel(), (Class)ItemDESolarPanel.class, "blockDESolarPanel");
    GameRegistry.registerTileEntity((Class)TileEntityDraconSolarPanel.class, "Dracon Solar Panel");
    GameRegistry.registerTileEntity((Class)TileEntityAwakenedSolarPanel.class, "Awakened Solar Panel");
    GameRegistry.registerTileEntity((Class)TileEntityChaosSolarPanel.class, "Chaos Solar Panel");
}


public static void register(ItemDC item) {
    String name = item.getUnwrappedUnlocalizedName(item.getUnlocalizedName());
    if (isEnabled((Item)item))
      GameRegistry.registerItem((Item)item, name.substring(name.indexOf(":") + 1)); 
  }
public static boolean isEnabled(Item item) {
    return !ConfigHandler.disabledNamesList.contains(item.getUnlocalizedName());
  }
public static void Recipes() {
    GameRegistry.addRecipe(new ItemStack(ChaosEnergyCore, 1), new Object[] { " B ","BAB"," B ", 'B', new ItemStack(chaosingot, 1) ,'A', ModItems.draconicEnergyCore});
    Recipes.compressor.addRecipe((IRecipeInput)new RecipeInputItemStack(new ItemStack(ModItems.chaosFragment,1,2), 1), (NBTTagCompound)null, new ItemStack[] { new ItemStack(chaosingot,1) });
    GameRegistry.addRecipe(new ItemStack(ChaosHelm),  "CDC","CAC","CBC", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', new ItemStack(ModItems.draconicHelm),'D',ModItems.chaoticCore,'C',chaosingot);
    GameRegistry.addRecipe(new ItemStack(ChaosChest, 1),  "CDC","CAC","CBC", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', new ItemStack(ModItems.draconicChest),'D',ModItems.chaoticCore,'C',chaosingot);
    GameRegistry.addRecipe(new ItemStack(ChaosLeggs, 1), "CDC","CAC","CBC", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicLeggs,'D',ModItems.chaoticCore,'C',chaosingot);
    GameRegistry.addRecipe(new ItemStack(ChaosBoots, 1),  "CDC","CAC","CBC", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicBoots,'D',ModItems.chaoticCore,'C',chaosingot);
    //
    GameRegistry.addRecipe(new ItemStack(ChaosPickaxe, 1), new Object[] { " D ","CAC"," B ", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicPickaxe,'D',ModItems.chaoticCore,'C',chaosingot});
    GameRegistry.addRecipe(new ItemStack(ChaosAxe, 1), new Object[] { " D ","CAC"," B ", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicAxe,'D',ModItems.chaoticCore,'C',chaosingot});
    GameRegistry.addRecipe(new ItemStack(ChaosShovel, 1), new Object[] { " D ","CAC"," B ", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicShovel,'D',ModItems.chaoticCore,'C',chaosingot});
     GameRegistry.addRecipe(new ItemStack(ChaosSword, 1), new Object[] { " D ","CAC"," B ", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicSword,'D',ModItems.chaoticCore,'C',chaosingot});
    GameRegistry.addRecipe(new ItemStack(ChaosBow, 1), new Object[] { " D ","CAC"," B ", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicBow,'D',ModItems.chaoticCore,'C',chaosingot});
    
    GameRegistry.addRecipe(new ItemStack(ChaosDestructionStaff, 1), new Object[] { "CDC","ACE","CBC", 'B', new ItemStack(ChaosSword, 1) ,'A', ChaosPickaxe,'D',ModItems.chaoticCore,'C',chaosingot,'E', ChaosShovel});
    GameRegistry.addRecipe(new ItemStack(ChaosFluxCapacitor, 1), new Object[] { "CDC","CAC","CBC", 'B', new ItemStack(ChaosEnergyCore, 1) ,'A', ModItems.draconicFluxCapacitor,'D',ModItems.chaoticCore,'C',chaosingot});
    GameRegistry.addRecipe(new ItemStack(blockDESolarPanel, 1,0), new Object[] { " B ","BAB"," B ", 'B', new ItemStack(SSPItem.blockSSPSolarPanel, 1) ,'A',ModItems.wyvernCore});
    GameRegistry.addRecipe(new ItemStack(blockDESolarPanel, 1,1), new Object[] { "AB ","BAB"," BA", 'B', new ItemStack(blockDESolarPanel, 1,0) ,'A',ModItems.awakenedCore});
    GameRegistry.addRecipe(new ItemStack(blockDESolarPanel, 1,2), new Object[] { "ABC","BAB","CBA", 'B', new ItemStack(blockDESolarPanel, 1,1) ,'A',ModItems.chaoticCore , 'C',ChaosEnergyCore});

}
}

