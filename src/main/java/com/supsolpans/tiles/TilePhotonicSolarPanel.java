package com.supsolpans.tiles;

import com.supsolpans.ConfigLoader;

import advsolar.common.tiles.TileEntitySolarPanel;

public class TilePhotonicSolarPanel extends TileEntitySolarPanel {

    public TilePhotonicSolarPanel() {
        super(
                "blockPhotonicSolarPanel.name",
                8,
                ConfigLoader.photonicpanelGenDay,
                ConfigLoader.photonicpanelGenNight,
                ConfigLoader.photonicpanelOutput,
                ConfigLoader.photonicpanelStorage);

    }

}
