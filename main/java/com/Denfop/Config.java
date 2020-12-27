package com.Denfop;

import com.Denfop.utils.MTRecipeConfig;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Config {
public static void config(final FMLPreInitializationEvent event) {
	 final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
     try {
         config.load();
        
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
         SuperSolarPanels.AdminpanelStorage = config.get("Light-Adbord Solar panel", "AdminPanelStorage", 10000000).getInt(10000000);
         SuperSolarPanels.AdminpanelOutput = config.get("Light-Adbord Solar panel", "AdminPanelOutput", 327680).getInt(327680);
         SuperSolarPanels.photonicpanelGenDay = config.get("Photonic Solar panel", "PhotonicPanelGenDay", 655360).getInt(655360);
         SuperSolarPanels.photonicpanelGenNight = config.get("Photonic Solar panel", "PhotonicPanelGenNight", 655360).getInt(655360);
         SuperSolarPanels.photonicpanelOutput = config.get("Photonic Solar panel", "PhotonicPanelOutput", 1310720).getInt(1310720);
         SuperSolarPanels.photonicpanelStorage = config.get("Photonic Solar panel", "PhotonicPanelStorage", 10000000).getInt(10000000);
         SuperSolarPanels.neutronpanelGenDay = config.get("Neutronium Solar panel", "NeutronPanelGenDay", 2621440).getInt(2621440);
         SuperSolarPanels.neutronpanelGenNight = config.get("Neutronium Solar panel", "NeutronPanelGenNight", 2621440).getInt(2621440);
         SuperSolarPanels.neutronpanelOutput = config.get("Neutronium Solar panel", "NeutronPanelOutput", 5242880).getInt(5242880);
         SuperSolarPanels.neutronpanelStorage = config.get("Neutronium Solar panel", "NeutronPanelStorage", 30000000).getInt(30000000);
         SuperSolarPanels.Storagequantumsuit = config.get("Quantum armor", "Storage Enriched Quantum Suit", 100000000).getInt(100000000);
         SuperSolarPanels.spectralsaberactive1 = config.get("Quantum Saber", "SpectralSaber Damage Active", 40).getInt(40);
         SuperSolarPanels.spectralsabernotactive1 = config.get("Quantum Saber", "SpectralSaber Damage Not Active", 8).getInt(8);
         SuperSolarPanels.maxCharge1 = config.get("Quantum Saber", "SpectralSaber max Charge", 300000).getInt(300000);
         SuperSolarPanels.transferLimit1= config.get("Quantum Saber", "SpectralSaber transfer Limit", 20000).getInt(20000);
         SuperSolarPanels.tier1= config.get("Quantum Saber", "SpectralSaber tier", 4).getInt(4);
         SuperSolarPanels.energy= config.get("Neutronium generator", "Consumes energy to make 1 mb neutronim", 15625000.0F).getInt((int) 15625000.0F);
         SuperSolarPanels.spectralpanelstorage= config.get("Spectral Solar panel", "Spectral Solar panel Storage", 500000).getInt(500000);
         
         SuperSolarPanels.maxCharge = config.get("Quantum Saber", "SpectralSaber max Charge", 600000).getInt(300000);
         SuperSolarPanels.transferLimit= config.get("Quantum Saber", "SpectralSaber transfer Limit", 40000).getInt(20000);
         SuperSolarPanels.tier= config.get("Quantum Saber", "SpectralSaber tier", 5).getInt(5);
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
         SuperSolarPanels.MaxChangesaber= config.get("Quantum Saber", "MaxChange", 300000).getInt(300000);
         SuperSolarPanels.transferLimitsaber= config.get("Quantum Saber", "transfer Limit", 1000).getInt(1000);
         SuperSolarPanels. tiersaber= config.get("Quantum Saber", "tier", 3).getInt(3);
         SuperSolarPanels.Quantumsaberactive= config.get("Quantum Saber", "Damage saber active", 40).getInt(40);
         SuperSolarPanels.Quantumsabernotactive= config.get("Quantum Saber", "Damage saber not active", 8).getInt(8);
 	   
 	   
         SuperSolarPanels.tier2= config.get("Advanced MFSU", "tier", 6).getInt(6);
         SuperSolarPanels.singularpaneltier= config.get("Singular Solar panel", "tier", 7).getInt(7);
         SuperSolarPanels.spectralpaneltier= config.get("Spectral Solar panel", "tier", 5).getInt(5);
         SuperSolarPanels.adminpaneltier= config.get("Light-Adbord Solar panel", "tier", 8).getInt(8);
         SuperSolarPanels.photonicpaneltier= config.get("Photonic Solar panel", "tier", 9).getInt(9);
         SuperSolarPanels.neutronpaneltier= config.get("Neutronium Solar panel", "tier", 10).getInt(10);
 	 //
         
         
         SuperSolarPanels.disableeffect = config.get("Disable Effect", "Disable fireResistance", false).getBoolean(false);
         SuperSolarPanels.disableeffect1 = config.get("Disable Effect", "Disable waterBreathing", false).getBoolean(false);
         SuperSolarPanels.disableeffect2 = config.get("Disable Effect", "Disable jump", false).getBoolean(false);
         SuperSolarPanels.disableeffect3 = config.get("Disable Effect", "Disable moveSpeed", false).getBoolean(false);
         SuperSolarPanels.thaumcraft= config.get("Integrestion", "DIntegrestion Thaumcraft", false).getBoolean(false);
         SuperSolarPanels.wireless = config.get("Integrestion", "Integrestion Wireless Solar Panels", false).getBoolean(false);
         SuperSolarPanels.Draconic = config.get("Integrestion", "Integrestion Draconic Evolution", true).getBoolean(true);
         SuperSolarPanels.Botania = config.get("Integrestion", "Integrestion Botania", true).getBoolean(true); 
         SuperSolarPanels.Avaritia = config.get("Integrestion", "Integrestion Avaritia", true).getBoolean(true); 
       
         SuperSolarPanels.advGenDay = config.get("general", "AdvancedSPGenDay", 10).getInt(10);
         SuperSolarPanels.advGenNight = config.get("general", "AdvancedSPGenNight", 5).getInt(5);
         SuperSolarPanels.advStorage = config.get("general", "AdvancedSPStorage", 3200).getInt(3200);
         SuperSolarPanels.advOutput = config.get("general", "AdvancedSPOutput", 20).getInt(20);
         SuperSolarPanels.hGenDay = config.get("general", "HybrydSPGenDay", 40).getInt(40);
         SuperSolarPanels.hGenNight = config.get("general", "HybrydSPGenNight", 15).getInt(15);
         SuperSolarPanels.hStorage = config.get("general", "HybrydSPStorage", 10000).getInt(10000);
         SuperSolarPanels.hOutput = config.get("general", "HybrydSPOutput", 80).getInt(80);
         SuperSolarPanels.uhGenDay = config.get("general", "UltimateHSPGenDay", 160).getInt(160);
         SuperSolarPanels.uhGenNight = config.get("general", "UltimateHSPGenNight", 80).getInt(80);
         SuperSolarPanels.uhStorage = config.get("general", "UltimateHSPStorage", 100000).getInt(100000);
         SuperSolarPanels.uhOutput = config.get("general", "UltimateHSPOutput", 320).getInt(320);
         SuperSolarPanels.qpGenDay = config.get("general", "QuantumSPGenDay", 640).getInt(640);
         SuperSolarPanels.qpGenNight = config.get("general", "QuantumSPGenNight", 160).getInt(160);
         SuperSolarPanels.qpStorage = config.get("general", "QuantumSPStorage", 1000000).getInt(1000000);
         SuperSolarPanels.qpOutput = config.get("general", "QuantumSPOutput", 1280).getInt(1280);
      //
         SuperSolarPanels.TerrasteelRodHeat = config.get("TerrasteelRod", "Heat", 1).getInt(1);
         SuperSolarPanels.TerrasteelRodCells = config.get("TerrasteelRod", "Cells", 20000).getInt(20000);
         SuperSolarPanels.TerrasteelPower = config.get("TerrasteelRod", "Power", 2).getInt(2);
         //
         SuperSolarPanels.ProtonRodHeat = config.get("ProtonRod", "Heat", 2).getInt(2);
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
         
        
     }
     catch (Exception e) {
         throw new RuntimeException(e);
     }
     finally {
         config.save();
     }
}
}
