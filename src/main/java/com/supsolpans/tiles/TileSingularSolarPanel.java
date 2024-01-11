package com.supsolpans.tiles;

import com.supsolpans.ConfigLoader;

import advsolar.common.tiles.TileEntitySolarPanel;

public class TileSingularSolarPanel extends TileEntitySolarPanel {

    public TileSingularSolarPanel() {
        super(
                "blockSingularSolarPanel.name",
                6,
                ConfigLoader.singularpanelGenDay,
                ConfigLoader.singularpanelGenNight,
                ConfigLoader.singularpanelOutput,
                ConfigLoader.singularpanelStorage);

    }

}
