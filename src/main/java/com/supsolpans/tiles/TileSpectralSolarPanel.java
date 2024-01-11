package com.supsolpans.tiles;

import com.supsolpans.ConfigLoader;

import advsolar.common.tiles.TileEntitySolarPanel;

public class TileSpectralSolarPanel extends TileEntitySolarPanel {

    public TileSpectralSolarPanel() {
        super(
                "blockSpectralSolarPanel.name",
                5,
                ConfigLoader.spectralpanelGenDay,
                ConfigLoader.spectralpanelGenNight,
                ConfigLoader.spectralpanelOutput,
                ConfigLoader.spectralpanelStorage);

    }

}
