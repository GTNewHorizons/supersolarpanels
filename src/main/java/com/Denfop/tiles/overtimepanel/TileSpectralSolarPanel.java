
package com.Denfop.tiles.overtimepanel;

import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.Config;
import com.Denfop.IUCore;


public class TileSpectralSolarPanel extends TileEntitySolarPanel
{
    public TileSpectralSolarPanel() {
        super("blockSpectralSolarPanel.name",5,0, Config.spectralpanelGenDay, Config.spectralpanelGenNight, Config.spectralpanelOutput, Config.spectralpanelstorage);
    }
}
