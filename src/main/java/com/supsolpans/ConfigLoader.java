package com.supsolpans;

import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader implements Runnable {

    public static int spectralpanelGenDay;
    public static int spectralpanelGenNight;
    public static int spectralpanelOutput;
    public static int spectralpanelStorage;

    public static int singularpanelGenDay;
    public static int singularpanelGenNight;
    public static int singularpanelOutput;
    public static int singularpanelStorage;

    public static int adminpanelGenDay;
    public static int adminpanelGenNight;
    public static int AdminpanelStorage;
    public static int AdminpanelOutput;

    public static int photonicpanelGenDay;
    public static int photonicpanelGenNight;
    public static int photonicpanelOutput;
    public static int photonicpanelStorage;

    public static String configFileName;

    public Configuration config;

    public ConfigLoader(FMLPreInitializationEvent event) {
        super();
        config = new Configuration(event.getSuggestedConfigurationFile());
        configFileName = event.getSuggestedConfigurationFile().getAbsolutePath();
    }

    @Override
    public void run() {
        try {
            config.load();
            spectralpanelGenDay = config.get("general", "SpectralSPGenDay", 8192).getInt(8192);
            spectralpanelGenNight = config.get("general", "SpectralSPGenNight", 0).getInt(0);
            spectralpanelOutput = config.get("general", "SpectralSPOutput", 8192).getInt(8192);
            spectralpanelStorage = config.get("general", "SpectralSPStorage", 81920000).getInt(81920000);

            singularpanelGenDay = config.get("general", "SingularSPGenDay", 32768).getInt(32768);
            singularpanelGenNight = config.get("general", "SingularSPGenNight", 0).getInt(0);
            singularpanelOutput = config.get("general", "SingularSPOutput", 32768).getInt(32768);
            singularpanelStorage = config.get("general", "SingularSPStorage", 327680000).getInt(327680000);

            adminpanelGenDay = config.get("general", "AdminPanelGenDay", 131072).getInt(131072);
            adminpanelGenNight = config.get("general", "AdminPanelGenNight", 0).getInt(0);
            AdminpanelStorage = config.get("general", "AdminPanelStorage", 1310720000).getInt(1310720000);
            AdminpanelOutput = config.get("general", "AdminPanelOutput", 131072).getInt(131072);

            photonicpanelGenDay = config.get("general", "PhotonicPanelGenDay", 524288).getInt(524288);
            photonicpanelGenNight = config.get("general", "PhotonicPanelGenNight", 0).getInt(0);
            photonicpanelOutput = config.get("general", "PhotonicPanelOutput", 524288).getInt(524288);
            photonicpanelStorage = config.get("general", "PhotonicPanelStorage", 2000000000).getInt(2000000000);
        } catch (Exception e) {

            throw new RuntimeException(e);
        } finally {
            config.save();
        }

    }

}
