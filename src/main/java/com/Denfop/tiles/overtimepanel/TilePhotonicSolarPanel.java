
package com.Denfop.tiles.overtimepanel;
import com.Denfop.tiles.base.TileEntitySolarPanel;
import com.Denfop.Config;
import com.Denfop.IUCore;


public class TilePhotonicSolarPanel extends TileEntitySolarPanel
{
    public TilePhotonicSolarPanel() {
        super("blockPhotonicSolarPanel.name",Config.photonicpaneltier, 0, Config.photonicpanelGenDay, Config.photonicpanelGenNight, Config.photonicpanelOutput, Config.photonicpanelStorage);
    }
}
