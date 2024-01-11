package com.supsolpans;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.supsolpans.blocks.BlockAdminSP;
import com.supsolpans.blocks.BlockPhotonSP;
import com.supsolpans.blocks.BlockSpectralSP;
import com.supsolpans.blocks.BlockSuperSP;
import com.supsolpans.itemblock.ItemBlockAdmSP;
import com.supsolpans.itemblock.ItemBlockPhotonSP;
import com.supsolpans.itemblock.ItemBlockSSP;
import com.supsolpans.itemblock.ItemBlockSpSP;
import com.supsolpans.items.ItemBlueSpectralComponent;
import com.supsolpans.items.ItemEnderQuantumComponent;
import com.supsolpans.items.ItemGreenSpectralComponent;
import com.supsolpans.items.ItemRedSpectralComponent;
import com.supsolpans.items.ItemSpectralLightSplitter;
import com.supsolpans.reference.Reference;
import com.supsolpans.tiles.TileAdminSolarPanel;
import com.supsolpans.tiles.TilePhotonicSolarPanel;
import com.supsolpans.tiles.TileSingularSolarPanel;
import com.supsolpans.tiles.TileSpectralSolarPanel;

import advsolar.common.AdvancedSolarPanel;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.MOD_VERSION,
        dependencies = "required-after:AdvancedSolarPanel; required-after:IC2; before:dreamcraft")

public class MainSSP {

    public static final CreativeTabSSP tabssp = new CreativeTabSSP();

    public static final Item enderquantumcomponent = new ItemEnderQuantumComponent();
    public static final Item solarsplitter = new ItemSpectralLightSplitter();
    public static final Item bluecomponent = new ItemBlueSpectralComponent();
    public static final Item greencomponent = new ItemGreenSpectralComponent();
    public static final Item redcomponent = new ItemRedSpectralComponent();

    public static final Block BlockSingularSP = new BlockSuperSP();
    public static final Block BlockSpectralSP = new BlockSpectralSP();
    public static final Block BlockAdminSP = new BlockAdminSP();
    public static final Block BlockPhotonSP = new BlockPhotonSP();

    public static ConfigLoader cfg;

    @Instance("supersolarpanel")
    public static MainSSP instance = new MainSSP();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        cfg = new ConfigLoader(event);
        cfg.run();

        GameRegistry.registerBlock(BlockSingularSP, ItemBlockSSP.class, "SingularSolarPanel");
        GameRegistry.registerBlock(BlockSpectralSP, ItemBlockSpSP.class, "SpectralSolarPanel");
        GameRegistry.registerBlock(BlockAdminSP, ItemBlockAdmSP.class, "AdminSolarPanel");
        GameRegistry.registerBlock(BlockPhotonSP, ItemBlockPhotonSP.class, "PhotonicSolarPanel");

        GameRegistry.registerItem(solarsplitter, "solarsplitter");
        GameRegistry.registerItem(enderquantumcomponent, "enderquantumcomponent");
        GameRegistry.registerItem(bluecomponent, "bluecomponent");
        GameRegistry.registerItem(greencomponent, "greencomponent");
        GameRegistry.registerItem(redcomponent, "redcomponent");
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        GameRegistry.registerTileEntity(TileSingularSolarPanel.class, "SingularSolarPanel");
        GameRegistry.registerTileEntity(TileSpectralSolarPanel.class, "SpectralSolarPanel");
        GameRegistry.registerTileEntity(TileAdminSolarPanel.class, "AdminSolarPanel");
        GameRegistry.registerTileEntity(TilePhotonicSolarPanel.class, "PhotonicSolarPanel");
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        if (!Loader.isModLoaded("dreamcraft")) {
            GameRegistry.addRecipe(
                    new ItemStack(BlockSpectralSP, 1),
                    new Object[] { "BBB", "BAB", "BBB", Character.valueOf('A'), new ItemStack(solarsplitter, 1),
                            Character.valueOf('B'), new ItemStack(AdvancedSolarPanel.blockAdvSolarPanel, 1, 3) });
            GameRegistry.addRecipe(
                    new ItemStack(BlockSingularSP, 1),
                    new Object[] { "AAA", "ACA", "AAA", Character.valueOf('A'), new ItemStack(BlockSpectralSP, 1),
                            Character.valueOf('C'), new ItemStack(enderquantumcomponent, 1) });
            GameRegistry.addRecipe(
                    new ItemStack(enderquantumcomponent, 1),
                    new Object[] { "ABA", "BCB", "ABA", Character.valueOf('A'), IC2Items.getItem("iridiumPlate"),
                            Character.valueOf('B'), Items.ender_eye, Character.valueOf('C'), Items.nether_star });
            GameRegistry.addShapelessRecipe(
                    new ItemStack(greencomponent, 1),
                    new Object[] { AdvancedSolarPanel.itemIrradiantGlassPane });
            GameRegistry.addRecipe(
                    new ItemStack(bluecomponent, 1),
                    new Object[] { "AAA", "BBB", "AAA", Character.valueOf('A'), IC2Items.getItem("reinforcedGlass"),
                            Character.valueOf('B'), new ItemStack(Items.dye, 1, 4) });
            GameRegistry.addRecipe(
                    new ItemStack(redcomponent, 1),
                    new Object[] { "AAA", "BBB", "AAA", Character.valueOf('A'), IC2Items.getItem("reinforcedGlass"),
                            Character.valueOf('B'), Items.redstone });
            GameRegistry.addRecipe(
                    new ItemStack(solarsplitter, 1),
                    new Object[] { "ABC", "ABC", "ABC", Character.valueOf('A'), new ItemStack(redcomponent, 1),
                            Character.valueOf('B'), new ItemStack(greencomponent), Character.valueOf('C'),
                            new ItemStack(bluecomponent) });
            GameRegistry.addRecipe(
                    new ItemStack(BlockAdminSP, 1),
                    new Object[] { "AAA", "AAA", "AAA", Character.valueOf('A'), new ItemStack(BlockSingularSP, 1) });
            GameRegistry.addRecipe(
                    new ItemStack(BlockPhotonSP, 1),
                    new Object[] { "AAA", "AAA", "AAA", Character.valueOf('A'), new ItemStack(BlockAdminSP, 1) });
        }
    }

}
