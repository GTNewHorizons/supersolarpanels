
package com.Denfop.tiles.overtimepanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import com.Denfop.SuperSolarPanels;


public class TilePhotonicSolarPanel extends TileEntitySolarPanel
{
    public TilePhotonicSolarPanel() {
        super("blockPhotonicSolarPanel.name",6, 0, SuperSolarPanels.photonicpanelGenDay, SuperSolarPanels.photonicpanelGenNight, SuperSolarPanels.photonicpanelOutput, SuperSolarPanels.photonicpanelStorage);
    }
}
