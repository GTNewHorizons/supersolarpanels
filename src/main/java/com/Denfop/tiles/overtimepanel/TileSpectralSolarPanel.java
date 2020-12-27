
package com.Denfop.tiles.overtimepanel;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.SuperSolarPanels;


public class TileSpectralSolarPanel extends TileEntitySolarPanel
{
    public TileSpectralSolarPanel() {
        super("blockSpectralSolarPanel.name",5,0, SuperSolarPanels.spectralpanelGenDay, SuperSolarPanels.spectralpanelGenNight, SuperSolarPanels.spectralpanelOutput, SuperSolarPanels.spectralpanelstorage);
    }
}
