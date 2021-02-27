package com.Denfop;

import java.io.File;

import com.google.common.collect.Sets;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;

public class Config {
public static final boolean EnglishFix = false;
public static boolean EnableNetherOres;
public static int limit;
public static int tier;
public static int neutrongenday;
public static int neutronGenNight;
public static int neutronStorage;
public static int neutronOutput;
public static int InfinityGenNight;
public static int InfinityGenDay;
public static int InfinityOutput;
public static int InfinityStorage;
public static int manasteeltier;
public static int manasteeloutput;
public static int manasteelstorage;
public static int manasteelgennight;
public static int manasteelgenday;
public static int elementiumstorage;
public static int elementiumgenday;
public static int elementiumgennight;
public static int elementiumoutput;
public static int elementiumtier;
public static int terasteelgenday;
public static int terasteelgennight;
public static int terasteelstorage;
public static int terasteeloutput;
public static int terasteeltier;
public static int chaosgenday;
public static int chaosgennight;
public static int chaosstorage;
public static int chaosoutput;
public static int chaostier;
public static int awakenedtier;
public static int awakenedoutput;
public static int awakenedstorage;
public static int awakenedgennight;
public static int awakenedgenday;
public static int draconictier;
public static int draconicoutput;
public static int draconicstorage;
public static int draconicgennight;
public static int draconicgenday;
public static boolean ASP;
public static int toriyRodCells;
public static int toriyRodHeat;
public static float toriyPower;
public static File configFile;
public static boolean registerDraconicPanels;
public static boolean registerChaosArmour;
public static boolean registerChaosFluxCapacitor;
public static boolean registerChaosAxe;
public static boolean registerChaosBow;
public static boolean registerChaosSword;
public static boolean registerChaosShovel;
public static boolean registerChaosPickaxe;
public static boolean registerChaosDestructionStaff;
public static boolean nightvision;
public static float effPower;
public static float bigHolePower;
public static float lowPower;
public static float ultraLowPower;
public static int ultdrillmaxCharge;
public static int ultdrilltier;
public static int energyPerOperation;
public static int energyPerLowOperation;
public static int energyPerultraLowPowerOperation;
public static int energyPerbigHolePowerOperation;
public static int ultdrilltransferLimit;
public static boolean enableefficiency;
public static int efficiencylevel;
public static boolean enableefficiency1;
public static int efficiencylevel1;
public static boolean enablesilkTouch;
public static boolean enablefortune;
public static int fortunelevel;
public static boolean enableexlposion;
public static boolean enableIC2EasyMode;
public static boolean EnableEndOres;
public static boolean EnableMickailOre;
public static boolean EnableSpinelOre;
public static boolean EnablePlatiumOre;
public static boolean EnableWolframOre;
public static boolean EnableChromiumOre;
public static boolean EnableIridiumOre;
public static boolean EnableMagnesiumOre;
public static boolean EnableNickelOre;
public static boolean EnableToriyOre;
public static boolean EnableMagnetitOre;
public static boolean damagecable;
public static boolean newsystem;
public static int armor_maxcharge;
public static int armor_transferlimit;
public static int armor_tier;
public static int armor_maxcharge_body;
public static int percent_output;
public static int percent_storage;
public static int percent_day;
public static int percent_night;
public static void config(final FMLPreInitializationEvent event) {
	final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
     try {
         config.load();
         configFile = event.getSuggestedConfigurationFile();
        //
         
         damagecable=config.get("Events", "Damage", true).getBoolean(true);
         newsystem=config.get("Events", "New system transfer energy", true).getBoolean(true);
         EnableMagnetitOre=config.get("Generation", "Spawn Magnetit Ore", true).getBoolean(true);
         EnableToriyOre=config.get("Generation", "Spawn Toriy Ore", true).getBoolean(true);
         EnableNickelOre=config.get("Generation", "Spawn Nickel Ore", true).getBoolean(true);
         EnableMagnesiumOre=config.get("Generation", "Spawn Magnesium Ore", true).getBoolean(true);
         EnableIridiumOre=config.get("Generation", "Spawn Iridium Ore", true).getBoolean(true);
         EnableChromiumOre=config.get("Generation", "Spawn Chromium Ore", true).getBoolean(true);
         EnableWolframOre=config.get("Generation", "Spawn Wolfram Ore", true).getBoolean(true);
         EnablePlatiumOre=config.get("Generation", "Spawn Platium Ore", true).getBoolean(true);
         EnableSpinelOre=config.get("Generation", "Spawn Spinel Ore", true).getBoolean(true);
         EnableMickailOre=config.get("Generation", "Spawn Mickail Ore", true).getBoolean(true);
         effPower= config.get("UltimateDrill", "Mode 0 efficiency", 35).getInt(35); 
         lowPower=config.get("UltimateDrill", "Mode 1 efficiency", 20).getInt(20); 
         bigHolePower =config.get("UltimateDrill", "Mode 2 efficiency", 16).getInt(16); 
         ultraLowPower=config.get("UltimateDrill", "Mode 3 efficiency", 10).getInt(10); 
         ultdrillmaxCharge=config.get("UltimateDrill", "maxCharge", 750000).getInt(750000); 
         ultdrilltier=config.get("UltimateDrill", "tier", 2).getInt(2); 
         ultdrilltransferLimit=config.get("UltimateDrill", "transfer Limit", 500).getInt(500); 
         energyPerOperation=config.get("UltimateDrill", "energyPerOperation", 160).getInt(160); 
         energyPerLowOperation=config.get("UltimateDrill", "energyPerLowOperation", 80).getInt(80); 
         energyPerbigHolePowerOperation=config.get("UltimateDrill", "energyPerBigHolesOperation",300).getInt(300); 
         energyPerultraLowPowerOperation=config.get("UltimateDrill", "energyPerUltraBigHolesOperation", 500).getInt(500); 
         enableefficiency=config.get("UltimateDrill", "Enable Efficiency tool mode 0", true).getBoolean(true); 
         if(efficiencylevel > 1 && efficiencylevel <15) {
         efficiencylevel=config.get("UltimateDrill", "Level efficiency(tool mode 0)", 10).getInt(10); }else {
        	 efficiencylevel =10;
         }
         EnableNetherOres=config.get("Generation", "Spawn ores in Nether", true).getBoolean(true);
         EnableEndOres=config.get("Generation", "Spawn ores in End", true).getBoolean(true);
         enableIC2EasyMode=config.get("general", "Easy Mode", false).getBoolean(false);
         
         enableexlposion=config.get("Events", "Enable exlposion", true).getBoolean(true);
         if(damagecable == false) {
        	 newsystem = true;
         }
         enableefficiency=config.get("UltimateDrill", "Enable Efficiency tool mode 1", true).getBoolean(true); 
         if(efficiencylevel1 > 1 && efficiencylevel1 <15) {
         efficiencylevel1=config.get("UltimateDrill", "Level efficiency(tool mode 1)", 10).getInt(10); }else {
        	 efficiencylevel1 =10;
         }
         enablesilkTouch=config.get("UltimateDrill", "Enable silk Touch tool mode 2", true).getBoolean(true); 
         enablefortune=config.get("UltimateDrill", "Enable fortune tool mode 3", true).getBoolean(true); 
         if(fortunelevel > 1 && fortunelevel < 10) {
         fortunelevel=config.get("UltimateDrill", "Level fortune(tool mode 3)", 5).getInt(5); }else {
        	 fortunelevel = 5;
         }
         //
         SuperSolarPanels.singularpanelstorage = config.get("Singular Solar panel", "SingularSPStorage", 10000000).getInt(10000000); 
         SuperSolarPanels.configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
         SuperSolarPanels.spectralpanelGenDay = config.get("Spectral Solar panel", "SpectralSPGenDay", 2560).getInt(2560);
         SuperSolarPanels.protongenDay = config.get("Proton Solar panel", "ProtonGenDay", 10240).getInt(10240);
         SuperSolarPanels.protongennitht = config.get("Proton Solar panel", "ProtonGenNight", 5120).getInt(5120);
         SuperSolarPanels.protonOutput = config.get("Proton Solar panel", "ProtonOutput", 20480).getInt(20480);
         SuperSolarPanels.protontier = config.get("Proton Solar panel", "Protonstorage", 5000000).getInt(5000000);
         SuperSolarPanels.spectralpanelGenNight = config.get("Spectral Solar panel", "SpectralSPGenNight", 1280).getInt(1280);
         SuperSolarPanels.singularpanelGenDay = config.get("Singular Solar panel", "SingularSPGenDay", 40960).getInt(40960);
         SuperSolarPanels.singularpanelGenNight = config.get("Singular Solar panel", "SingularSPGenNight", 40960).getInt(40960);
         SuperSolarPanels.singularpanelOutput = config.get("Singular Solar panel", "SingularSPOutput", 81920).getInt(81920);
         SuperSolarPanels.spectralpanelOutput = config.get("Spectral Solar panel", "SpectralSPOutput", 5120).getInt(5120);
         SuperSolarPanels.adminpanelGenDay = config.get("Light-Adbord Solar panel", "AdminPanelGenDay", 163840).getInt(163840);
         SuperSolarPanels.adminpanelGenNight = config.get("Light-Adbord Solar panel", "AdminPanelGenNight", 163840).getInt(163840);
         SuperSolarPanels.AdminpanelStorage = config.get("Light-Adbord Solar panel", "AdminPanelStorage", 20000000).getInt(20000000);
         SuperSolarPanels.AdminpanelOutput = config.get("Light-Adbord Solar panel", "AdminPanelOutput", 327680).getInt(327680);
         SuperSolarPanels.photonicpanelGenDay = config.get("Photonic Solar panel", "PhotonicPanelGenDay", 655360).getInt(655360);
         SuperSolarPanels.photonicpanelGenNight = config.get("Photonic Solar panel", "PhotonicPanelGenNight", 655360).getInt(655360);
         SuperSolarPanels.photonicpanelOutput = config.get("Photonic Solar panel", "PhotonicPanelOutput", 1310720).getInt(1310720);
         SuperSolarPanels.photonicpanelStorage = config.get("Photonic Solar panel", "PhotonicPanelStorage", 40000000).getInt(40000000);
         SuperSolarPanels.neutronpanelGenDay = config.get("Neutronium Solar panel", "NeutronPanelGenDay", 2621440).getInt(2621440);
         SuperSolarPanels.neutronpanelGenNight = config.get("Neutronium Solar panel", "NeutronPanelGenNight", 2621440).getInt(2621440);
         SuperSolarPanels.neutronpanelOutput = config.get("Neutronium Solar panel", "NeutronPanelOutput", 5242880).getInt(5242880);
         SuperSolarPanels.neutronpanelStorage = config.get("Neutronium Solar panel", "NeutronPanelStorage", 60000000).getInt(60000000);
        
         SuperSolarPanels.spectralsaberactive1 = config.get("Quantum Saber", "QuantumSaber Damage Active", 40).getInt(40);
         SuperSolarPanels.spectralsabernotactive1 = config.get("Quantum Saber", "QuantumSaber Damage Not Active", 8).getInt(8);
         SuperSolarPanels.maxCharge1 = config.get("Quantum Saber", "SpectralSaber max Charge", 200000).getInt(200000);
         SuperSolarPanels.transferLimit1= config.get("Quantum Saber", "SpectralSaber transfer Limit", 15000).getInt(20000);
         SuperSolarPanels.tier1= config.get("Quantum Saber", "SpectralSaber tier", 4).getInt(4);
         SuperSolarPanels.energy= config.get("Neutronium generator", "Consumes energy to make 1 mb neutronim", 15625000.0F).getInt((int) 15625000.0F);
         SuperSolarPanels.spectralpanelstorage= config.get("Spectral Solar panel", "Spectral Solar panel Storage", 500000).getInt(500000);
         
         SuperSolarPanels.maxCharge = config.get("Spectral Saber", "SpectralSaber max Charge", 600000).getInt(300000);
         SuperSolarPanels.transferLimit= config.get("Spectral Saber", "SpectralSaber transfer Limit", 40000).getInt(20000);
         SuperSolarPanels.tier= config.get("Spectral Saber", "SpectralSaber tier", 5).getInt(5);
         SuperSolarPanels.spectralsaberactive = config.get("Spectral Saber", "SpectralSaber Damage Active", 60).getInt(60);
         SuperSolarPanels.spectralsabernotactive = config.get("Spectral Saber", "SpectralSaber Damage Not Active", 12).getInt(12);
       
        
         SuperSolarPanels.enegry1= config.get("Imroved MFSU", "energy transfer Et/t", 32768).getInt(32768);
         SuperSolarPanels.storage1= config.get("Imroved MFSU", "energy storage", 100000000).getInt(100000000);
         SuperSolarPanels.tier1= config.get("Imroved MFSU", "tier", 5).getInt(5);
         SuperSolarPanels.enegry2= config.get("Advanced MFSU", "energy transfer Et/t", 242144).getInt(242144);
         SuperSolarPanels.storage2= config.get("Advanced MFSU", "energy storage", 400000000).getInt(400000000);
         SuperSolarPanels.tier2= config.get("Advanced MFSU", "tier", 6).getInt(6);
         SuperSolarPanels.singularpaneltier= config.get("Singular Solar panel", "tier", 7).getInt(7);
         SuperSolarPanels.spectralpaneltier= config.get("Spectral Solar panel", "tier", 5).getInt(5);
         SuperSolarPanels.adminpaneltier= config.get("Light-Adbord Solar panel", "tier", 8).getInt(8);
         SuperSolarPanels.photonicpaneltier= config.get("Photonic Solar panel", "tier", 9).getInt(9);
         SuperSolarPanels.neutronpaneltier= config.get("Neutronium Solar panel", "tier", 10).getInt(10);
         
         //
         InfinityGenDay = config.get("Infinity Solar panel", "GenDay", 1048576).getInt(1048576);
         InfinityGenNight = config.get("Infinity Solar panel", "GenNight", 1048576).getInt(1048576);
         InfinityOutput = config.get("Infinity Solar panel", "Output", 2097152).getInt(2097152);
         InfinityStorage= config.get("Infinity Solar panel", "Storage", 30000000).getInt(30000000);
         
         tier = config.get("Neutron Solar panel(Avaritia)", "tier", 8).getInt(8);
         neutrongenday = config.get("Neutron Solar panel(Avaritia)", "GenDay", 1310720).getInt(1310720);
         neutronGenNight = config.get("Neutron Solar panel(Avaritia)", "GenNight", 1310720).getInt(1310720);
         neutronOutput = config.get("Neutron Solar panel(Avaritia)", "Output", 2621440).getInt(2621440);
         neutronStorage = config.get("Neutron Solar panel(Avaritia)", "Storage", 40000000).getInt(40000000);
         percent_output= config.get("Modules", "percent_output", 20).getInt(20);
         percent_storage= config.get("Modules", "percent_output", 20).getInt(20);
         percent_day= config.get("Modules", "percent_output", 20).getInt(20);
         percent_night= config.get("Modules", "percent_output", 20).getInt(20);
//
         
         //
         SuperSolarPanels.tier2= config.get("Advanced MFSU", "tier", 6).getInt(6);
         SuperSolarPanels.singularpaneltier= config.get("Singular Solar panel", "tier", 7).getInt(7);
         SuperSolarPanels.spectralpaneltier= config.get("Spectral Solar panel", "tier", 5).getInt(5);
         SuperSolarPanels.adminpaneltier= config.get("Light-Adbord Solar panel", "tier", 8).getInt(8);
         SuperSolarPanels.photonicpaneltier= config.get("Photonic Solar panel", "tier", 9).getInt(9);
         SuperSolarPanels.neutronpaneltier= config.get("Neutronium Solar panel", "tier", 10).getInt(10);
 	 //
          registerDraconicPanels= config.get("Draconic Integration", "Register Draconic Panels", true).getBoolean(true);
         registerChaosArmour = config.get("Draconic Integration", "Register Chaos Armour", true).getBoolean(true);
         registerChaosFluxCapacitor = config.get("Draconic Integration", "Register Chaos Flux Capacitor", true).getBoolean(true);
         registerChaosDestructionStaff = config.get("Draconic Integration", "Register Chaos Destruction Staff", true).getBoolean(true);
         registerChaosPickaxe = config.get("Draconic Integration", "Register Chaos Pickaxe", true).getBoolean(true);
         registerChaosShovel = config.get("Draconic Integration", "Register Chaos Shovel", true).getBoolean(true);
         registerChaosSword = config.get("Draconic Integration", "Register Chaos Sword", true).getBoolean(true);
         registerChaosBow = config.get("Draconic Integration", "Register Chaos Bow", true).getBoolean(true);
         registerChaosAxe = config.get("Draconic Integration", "Register Chaos Axe", true).getBoolean(true);
         nightvision= config.get("Events", "If player have quantum or nano or improvemed helmet and it was dressed and if player has coord y < 60 and skylight < 8,nightvision allow", true).getBoolean(true);
         SuperSolarPanels.disableeffect = config.get("Disable Effect", "Disable fireResistance", false).getBoolean(false);
         SuperSolarPanels.disableeffect1 = config.get("Disable Effect", "Disable waterBreathing", false).getBoolean(false);
         SuperSolarPanels.disableeffect2 = config.get("Disable Effect", "Disable jump", false).getBoolean(false);
         SuperSolarPanels.disableeffect3 = config.get("Disable Effect", "Disable moveSpeed", false).getBoolean(false);
         SuperSolarPanels.thaumcraft= config.get("Integrestion", "Integrestion Thaumcraft", false).getBoolean(false);
         SuperSolarPanels.wireless = config.get("Integrestion", "Integrestion Wireless Solar Panels", false).getBoolean(false);
         SuperSolarPanels.Draconic = config.get("Integrestion", "Integrestion Draconic Evolution", true).getBoolean(true);
         SuperSolarPanels.Botania = config.get("Integrestion", "Integrestion Botania", true).getBoolean(true); 
         SuperSolarPanels.Avaritia = config.get("Integrestion", "Integrestion Avaritia", true).getBoolean(true); 
       
         SuperSolarPanels.advGenDay = config.get("general", "AdvancedSPGenDay", 10).getInt(10);
         SuperSolarPanels.advGenNight = config.get("general", "AdvancedSPGenNight", 5).getInt(5);
         SuperSolarPanels.advStorage = config.get("general", "AdvancedSPStorage", 3200).getInt(3200);
         SuperSolarPanels.advOutput = config.get("general", "AdvancedSPOutput", 20).getInt(20);
         SuperSolarPanels.hGenDay = config.get("general", "HybrydSPGenDay", 40).getInt(40);
         SuperSolarPanels.hGenNight = config.get("general", "HybrydSPGenNight", 20).getInt(20);
         SuperSolarPanels.hStorage = config.get("general", "HybrydSPStorage", 10000).getInt(10000);
         SuperSolarPanels.hOutput = config.get("general", "HybrydSPOutput", 80).getInt(80);
         SuperSolarPanels.uhGenDay = config.get("general", "UltimateHSPGenDay", 160).getInt(160);
         SuperSolarPanels.uhGenNight = config.get("general", "UltimateHSPGenNight", 80).getInt(80);
         SuperSolarPanels.uhStorage = config.get("general", "UltimateHSPStorage", 100000).getInt(100000);
         SuperSolarPanels.uhOutput = config.get("general", "UltimateHSPOutput", 320).getInt(320);
         SuperSolarPanels.qpGenDay = config.get("general", "QuantumSPGenDay", 640).getInt(640);
         SuperSolarPanels.qpGenNight = config.get("general", "QuantumSPGenNight", 320).getInt(320);
         SuperSolarPanels.qpStorage = config.get("general", "QuantumSPStorage", 200000).getInt(200000);
         SuperSolarPanels.qpOutput = config.get("general", "QuantumSPOutput", 1280).getInt(1280);
      //
         SuperSolarPanels.TerrasteelRodHeat = config.get("TerrasteelRod", "Heat", 1).getInt(1);
         SuperSolarPanels.TerrasteelRodCells = config.get("TerrasteelRod", "Cells", 20000).getInt(20000);
         SuperSolarPanels.TerrasteelPower = config.get("TerrasteelRod", "Power", 2).getInt(2);
         //
         toriyRodHeat = config.get("ToriyRod", "Heat", 1).getInt(1);
         toriyRodCells = config.get("ToriyRod", "Cells", 10000).getInt(10000);
         toriyPower = config.get("ToriyRod", "Power", 1).getInt(1);
         //
         SuperSolarPanels.ProtonRodHeat = config.get("ProtonRod", "Heat", 1).getInt(1);
         SuperSolarPanels.ProtonRodCells = config.get("ProtonRod", "Cells", 30000).getInt(30000);
         SuperSolarPanels.ProtonPower = config.get("ProtonRod", "Power", 4).getInt(4);
         //
         SuperSolarPanels.Radius = config.get("Iridium rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability = config.get("Iridium rotor", "durability", 648000).getInt(648000);
         SuperSolarPanels.efficiency = config.get("Iridium rotor", "efficiency", 2.0F).getInt((int) 2.0F);
         SuperSolarPanels.minWindStrength = config.get("Iridium rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength = config.get("Iridium rotor", "maxWindStrength", 110).getInt(110);
         //
         SuperSolarPanels.Radius1 = config.get("Compress Iridium rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability1 = config.get("Compress Iridium rotor", "durability", 720000).getInt(720000);
         SuperSolarPanels.efficiency1 = config.get("Compress Iridium rotor", "efficiency", 3.0F).getInt((int) 3.0F);
         SuperSolarPanels.minWindStrength1 = config.get("Compress Iridium rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength1 = config.get("Compress Iridium rotor", "maxWindStrength", 110).getInt(110);
         //
         SuperSolarPanels.Radius2 = config.get("Spectral rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability2 = config.get("Spectral rotor", "durability", 172800).getInt(172800);
         SuperSolarPanels.efficiency2 = config.get("Spectral rotor", "efficiency", 4.0F).getInt((int) 4.0F);
         SuperSolarPanels.minWindStrength2 = config.get("Spectral rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength2 = config.get("Spectral rotor", "maxWindStrength", 110).getInt(110);
         SuperSolarPanels.Streak = config.get("Quantum Armor", "Allow Streak", true).getBoolean(true); 
         //
         SuperSolarPanels.Radius5 = config.get("Myphical rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability5 = config.get("Myphical rotor", "durability", 345600).getInt(345600);
         SuperSolarPanels.efficiency5 = config.get("Myphical rotor", "efficiency", 5.0F).getInt((int) 5.0F);
         SuperSolarPanels.minWindStrength5 = config.get("Myphical rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength5 = config.get("Myphical rotor", "maxWindStrength", 110).getInt(110);
        
         //
         SuperSolarPanels.Radius4 = config.get("Neutron rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability4 = config.get("Neutron rotor", "durability", 2764800).getInt(2764800);
         SuperSolarPanels.efficiency4 = config.get("Neutron rotor", "efficiency", 7.0F).getInt((int) 7.0F);
         SuperSolarPanels.minWindStrength4 = config.get("Neutron rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength4 = config.get("Neutron rotor", "maxWindStrength", 110).getInt(110);
         //
         SuperSolarPanels.Radius3 = config.get("Photon rotor", "Radius", 11).getInt(11);
         SuperSolarPanels.durability3 = config.get("Photon rotor", "durability", 691200).getInt(691200);
         SuperSolarPanels.efficiency3 = config.get("Photon rotor", "efficiency", 6.0F).getInt((int) 6.0F);
         SuperSolarPanels.minWindStrength3 = config.get("Photon rotor", "minWindStrength", 25).getInt(25);
         SuperSolarPanels.maxWindStrength3 = config.get("Photon rotor", "maxWindStrength", 110).getInt(110);
         limit = config.get("Unifier panels", "Limit", 2).getInt(2); 
        //
         manasteelgenday= config.get("Manasteel Solar Panel", "genday", 160).getInt(160);
         manasteelgennight= config.get("Manasteel Solar Panel", "gennight", 80).getInt(80);
         manasteelstorage= config.get("Manasteel Solar Panel", "storage", 100000).getInt(100000);
         manasteeloutput= config.get("Manasteel Solar Panel", "output", 320).getInt(320);
         manasteeltier= config.get("Manasteel Solar Panel", "tier", 3).getInt(3);
         //
         elementiumgenday= config.get("Elementium Solar Panel", "genday", 1280).getInt(1280);
         elementiumgennight= config.get("Elementium Solar Panel", "gennight", 320).getInt(320);
         elementiumstorage= config.get("Elementium Solar Panel", "storage", 100000).getInt(100000);
         elementiumoutput= config.get("Elementium Solar Panel", "output", 2560).getInt(2560);
         elementiumtier= config.get("Elementium Solar Panel", "tier", 4).getInt(4);
         //
         terasteelgenday= config.get("Terasteel Solar Panel", "genday", 10240).getInt(10240);
         terasteelgennight= config.get("Terasteel Solar Panel", "gennight", 2560).getInt(2560);
         terasteelstorage= config.get("Terasteel Solar Panel", "storage", 200000).getInt(200000);
         terasteeloutput= config.get("Terasteel Solar Panel", "output", 20480).getInt(20480);
         terasteeltier= config.get("Terasteel Solar Panel", "tier", 5).getInt(5);
         //
        draconicgenday= config.get("Draconic Solar Panel", "genday", 40).getInt(40);
        draconicgennight= config.get("Draconic Solar Panel", "gennight", 10).getInt(10);
        draconicstorage= config.get("Draconic Solar Panel", "storage", 10000).getInt(10000);
        draconicoutput= config.get("Draconic Solar Panel", "output", 80).getInt(80);
        draconictier= config.get("Draconic Solar Panel", "tier", 2).getInt(2);
    //
         awakenedgenday= config.get("Awakaned Solar Panel", "genday", 163840).getInt(163840);
         awakenedgennight= config.get("Awakaned Solar Panel", "gennight", 81920).getInt(81920);
         awakenedstorage= config.get("Awakaned Solar Panel", "storage", 10000000).getInt(10000000);
         awakenedoutput= config.get("Awakaned Solar Panel", "output", 327680).getInt(327680);
         awakenedtier= config.get("Awakaned Solar Panel", "tier", 7).getInt(7);
         //
         chaosgenday= config.get("Chaos Solar Panel", "genday", 1310720).getInt(1310720);
         chaosgennight= config.get("Chaos Solar Panel", "gennight", 1310720).getInt(1310720);
         chaosstorage= config.get("Chaos Solar Panel", "storage", 50000000).getInt(50000000);
         chaosoutput= config.get("Chaos Solar Panel", "output", 2621440).getInt(2621440);
         chaostier= config.get("Chaos Solar Panel", "tier", 10).getInt(10);
         ASP = config.get("Integrestion", "Integrestion Advanced Solar Panels", true).getBoolean(true);
         
         armor_maxcharge= config.get("Improvemed Quantum Armor", "maxcharge exept Improvemed Quantum Body", 100000000).getInt(100000000);
         armor_transferlimit= config.get("Improvemed Quantum Armor", "transferlimit", 10000).getInt(10000);
         armor_tier = config.get("Improvemed Quantum Armor", "tier", 4).getInt(4);
         armor_maxcharge_body= config.get("Improvemed Quantum Armor", "maxcharge Improvemed Quantum Body", 300000000).getInt(300000000);
         //
     }
     catch (Exception e) {
         throw new RuntimeException(e);
     }
     finally {
         config.save();
     }
}

}
