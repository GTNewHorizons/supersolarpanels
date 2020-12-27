
package com.Denfop.tiles.overtimepanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import com.Denfop.SuperSolarPanels;


public class TileProtonSolarPanel extends TileEntitySolarPanel
{
    public TileProtonSolarPanel() {
        super("blockProtonSolarPanel.name",6, 0, SuperSolarPanels.protongenDay, SuperSolarPanels.protongennitht, SuperSolarPanels.protonOutput, SuperSolarPanels.protontier);
    }
}
