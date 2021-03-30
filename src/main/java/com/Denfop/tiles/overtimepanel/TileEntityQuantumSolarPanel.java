
package com.Denfop.tiles.overtimepanel;

import com.Denfop.Config;
import com.Denfop.IUCore;
import com.Denfop.tiles.base.TileEntitySolarPanel;

public class TileEntityQuantumSolarPanel extends TileEntitySolarPanel {
	public TileEntityQuantumSolarPanel() {
		super("blockQuantumSolarPanel.name", 4, 0, Config.qpGenDay, Config.qpGenNight, Config.qpOutput,
				Config.qpStorage);
	}

}
