package com.supsolpans.tiles;

import com.supsolpans.ConfigLoader;

import advsolar.common.tiles.TileEntitySolarPanel;

public class TileAdminSolarPanel extends TileEntitySolarPanel {

    public TileAdminSolarPanel() {
        super(
                "blockAdminSolarPanel.name",
                7,
                ConfigLoader.adminpanelGenDay,
                ConfigLoader.adminpanelGenNight,
                ConfigLoader.AdminpanelOutput,
                ConfigLoader.AdminpanelStorage);

    }

}
