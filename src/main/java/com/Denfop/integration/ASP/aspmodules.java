package com.Denfop.integration.ASP;

import com.Denfop.Config;
import com.Denfop.SuperSolarPanels;

import advsolar.common.AdvancedSolarPanel;

public class aspmodules {
	   public static int GenDay(int meta) {
	    	
	    	if(meta == 0) {
			return AdvancedSolarPanel.advGenDay;
			}
	    	else if(meta ==1) {
	    		return AdvancedSolarPanel.hGenDay;
	    	}
	    	else if(meta ==2) {
	    		return AdvancedSolarPanel.uhGenDay;
	    	}
	    	else if(meta ==3) {
	    		return AdvancedSolarPanel.qpGenDay;
	    	}
	    	
	    	return 0;
	    	
	    }
	public static int GenNight(int meta) {
	    	
	    	if(meta == 0) {
			return AdvancedSolarPanel.advGenNight;
			}
	    	else if(meta ==1) {
	    		return AdvancedSolarPanel.hGenNight;
	    	}
	    	else if(meta ==2) {
	    		return AdvancedSolarPanel.uhGenNight;
	    	}
	    	else if(meta ==3) {
	    		return AdvancedSolarPanel.qpGenNight;
	    	}
	    	return 0;
	    	
	    }
	public static int Output(int meta) {
		
		if(meta == 0) {
		return AdvancedSolarPanel.advOutput;
		}
		else if(meta ==1) {
			return AdvancedSolarPanel.hOutput;
		}
		else if(meta ==2) {
    		return AdvancedSolarPanel.uhOutput;
    	}
		else if(meta ==3) {
    		return AdvancedSolarPanel.qpOutput;
    	}
		
		return 0;
		
	}
	public static int storage(int meta) {
		
		if(meta == 0) {
		return AdvancedSolarPanel.advStorage;
		}
		else if(meta ==1) {
			return AdvancedSolarPanel.hStorage;
		}
		else if(meta ==2) {
			return AdvancedSolarPanel.uhStorage;
		}
		else if(meta ==3) {
			return AdvancedSolarPanel.qpStorage;
		}
		return 0;
		
	}
}
