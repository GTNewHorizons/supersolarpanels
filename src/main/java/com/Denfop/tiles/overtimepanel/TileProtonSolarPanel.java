
package com.Denfop.tiles.overtimepanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;


public class TileProtonSolarPanel extends TileEntitySolarPanel
{
    public TileProtonSolarPanel() {
        super("blockProtonSolarPanel.name",6, 0, Config.protongenDay, Config.protongennitht, Config.protonOutput, Config.protontier);
    }
}
