
package com.Denfop.tiles.overtimepanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.SuperSolarPanels;

public class TileSingularSolarPanel extends TileEntitySolarPanel
{
    public TileSingularSolarPanel() {
        super("blockSingularSolarPanel.name", 7,0, SuperSolarPanels.singularpanelGenDay, SuperSolarPanels.singularpanelGenNight, SuperSolarPanels.singularpanelOutput, SuperSolarPanels.singularpanelstorage);
    }
}
