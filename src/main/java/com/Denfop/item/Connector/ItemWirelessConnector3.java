package com.Denfop.item.Connector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.input.Keyboard;

import com.Denfop.SuperSolarPanels;
import com.Denfop.block.WirellesStorage.TileWirelessStorageBase;
import com.Denfop.tiles.base.TileEntitySolarPanel;

import ic2.api.item.ElectricItem;
import ic2.core.util.StackUtil;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemWirelessConnector3 extends Item {
	
	public Map<String, TileWirelessStorageBase> tilewsb1 = new HashMap();
	public Map<String, TileEntitySolarPanel> tilewp1 = new HashMap();
	public Map<String, Double> mapcoords = new HashMap<String, Double>();
	
	public Map<Double, Double> mapofcoords = new HashMap<Double, Double>();
	
	protected ArrayList<Double> lista = new ArrayList<Double>();
	protected ArrayList<Double> listb = new ArrayList<Double>();
	protected ArrayList<Double> listc = new ArrayList<Double>();
	
	protected ArrayList<TileWirelessStorageBase> listtiles = new ArrayList<TileWirelessStorageBase>();
	
	protected ArrayList<String> arrayindex = new ArrayList<String>();
	protected ArrayList<Integer> indexint = new ArrayList();
	protected Map<String, ArrayList<Integer>> indexmap = new HashMap();
	
	double a;
	double b;
	double c;
	
	public ItemWirelessConnector3(String name) {
		setUnlocalizedName(name);
		this.maxStackSize = 1;
		this.setTextureName("wirelessvajra:itemConnectorWireless"); setCreativeTab(SuperSolarPanels.tabssp);
		mapcoords.put("xcoord", Double.valueOf(0));
		mapcoords.put("ycoord", Double.valueOf(0));
		mapcoords.put("zcoord", Double.valueOf(0));
		
		mapofcoords.put(0D, 0D);
		a = 1.0D;
		b = 2.0D;
		c = 3.0D;
		
		
		
		
	}
	
	 public boolean onItemUseFirst(ItemStack itemstack, EntityPlayer player, World world, int i, int j, int k, int l, float hitX, float hitY, float hitZ) {
		 if(!world.isRemote) {
		 TileEntity tileEntity = world.getTileEntity(i, j, k);
		 
		
		 if(tileEntity instanceof TileWirelessStorageBase) {
			 if(tilewsb1.get("tilewsb") == null) {
				 if(mapcoords.get("xcoord") != null || mapcoords.get("ycoord") != null || mapcoords.get("zcoord") != null) {
					 
					 
				NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemstack);
			    boolean setTargetWSB = nbtData.getBoolean("SetTargetWSB");
			 
			
			 TileWirelessStorageBase twsb = (TileWirelessStorageBase) tileEntity;
			 tilewsb1.put("tilewsb", twsb);
			 
			 Double xcoord = mapcoords.get("xcoord"); 
			 Double ycoord = mapcoords.get("ycoord");
			 Double zcoord = mapcoords.get("zcoord");
			
			 if(!setTargetWSB) {
				 
				 xcoord = (double) tilewsb1.get("tilewsb").xCoord;
				 ycoord = (double) tilewsb1.get("tilewsb").yCoord;
				 zcoord = (double) tilewsb1.get("tilewsb").zCoord;
				 
				 setTargetWSB = true;
				 if(xcoord != null && ycoord != null && zcoord != null) {
					 
				 mapofcoords.put(a, xcoord);
				 mapofcoords.put(b, ycoord);
				 mapofcoords.put(c, zcoord);
				 lista.add(a);
				 listb.add(b);
				 listc.add(c);
				 
				 }
		    	 
				 tilewsb1.get("tilewsb").targetSet = true;
				
				 
				 mapcoords.put("xcoord", mapofcoords.get(a));
				 mapcoords.put("ycoord", mapofcoords.get(b));
				 mapcoords.put("zcoord", mapofcoords.get(c));
				 
				 
			 
			 player.addChatMessage(new ChatComponentTranslation("debug.connected.storage", new Object[0]));
			
			
			}
				 
			 a++;
			 b++;
			 c++;
			 
		
		nbtData.setBoolean("SetTargetWSB", setTargetWSB);
		
					 
			 return false;
   }	
		 }
		
		
	}
		 else if (tileEntity instanceof TileEntitySolarPanel && 
			        this.tilewp1.get("tilewp") == null) {
			        NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemstack);
			        boolean setTargetWP = nbtData.getBoolean("SetTargetWP");
			        TileEntitySolarPanel tilewp = (TileEntitySolarPanel)tileEntity;
			        this.tilewp1.put("tilewp1", tilewp);
			        if (world.getTileEntity((int)((Double)this.mapcoords.get("xcoord")).doubleValue(), (int)((Double)this.mapcoords.get("ycoord")).doubleValue(), (int)((Double)this.mapcoords.get("zcoord")).doubleValue()) instanceof TileWirelessStorageBase)
			          if (!setTargetWP) {
			            setTargetWP = true;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).mapofcoords = this.mapofcoords;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).lista = this.lista;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).listb = this.listb;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).listc = this.listc;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).targetSet = Boolean.valueOf(true);
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).isconnected = true;
			            ((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).twsb = (TileWirelessStorageBase)world.getTileEntity((int)((Double)this.mapcoords.get("xcoord")).doubleValue(), (int)((Double)this.mapcoords.get("ycoord")).doubleValue(), (int)((Double)this.mapcoords.get("zcoord")).doubleValue());
			            if ((((TileEntitySolarPanel)this.tilewp1.get("tilewp1")).targetSet = Boolean.valueOf(true & (((TileWirelessStorageBase)this.tilewsb1.get("tilewsb")).targetSet = true))).booleanValue())
			              ((TileWirelessStorageBase)this.tilewsb1.get("tilewsb")).isconnected = true; 
			            ((TileWirelessStorageBase)this.tilewsb1.get("tilewsb")).tilewp = this.tilewp1.get("tilewp1");
			            player.addChatMessage((IChatComponent)new ChatComponentTranslation("debug.added.tolist", new Object[0]));
			            player.addChatMessage((IChatComponent)new ChatComponentTranslation("debug.connected.successfully", new Object[0]));
			          }  
			        nbtData.setBoolean("SetTargetWP", setTargetWP);
			      } 
			      return true;
			    } 
			    return false;
			  }
	 
	 
	 
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		
		 if(!world.isRemote) {
			 
			 if(player.isSneaking()) {
			 
			 NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
			 
			
			 
			 
			 if(mapcoords.get("xcoord").intValue() != 0 || mapcoords.get("ycoord").intValue() != 0 || mapcoords.get("zcoord").intValue() != 0)
			 {
				 mapcoords.put("xcoord", Double.valueOf(0));
				 mapcoords.put("ycoord", Double.valueOf(0));
				 mapcoords.put("zcoord", Double.valueOf(0));
				 
			 
			 player.addChatMessage(new ChatComponentTranslation("debug.TargetXYZ.cleared", new Object[0]));
			 }
		 if(nbtData.getBoolean("SetTargetWSB") == true) {
			 
			 nbtData.setBoolean("SetTargetWSB", false);
			 player.addChatMessage(new ChatComponentTranslation("debug.setTargetWSB.cleared", new Object[0]));
			 
		 }
		 
		 if(nbtData.getBoolean("SetTargetWP") == true) {
			 
			 nbtData.setBoolean("SetTargetWP", false);
			 player.addChatMessage(new ChatComponentTranslation("debug.setTargetWP.cleared", new Object[0]));
		 }
		 
		 if(tilewsb1.get("tilewsb") != null || tilewp1.get("tilewp1") != null) {
			 tilewsb1.clear();
			 player.addChatMessage(new ChatComponentTranslation("debug.tileentityWSB.cleared", new Object[0]));
			 tilewp1.clear();
			 player.addChatMessage(new ChatComponentTranslation("debug.tileentityWP.cleared", new Object[0]));
			 
		 }
		 
		 
		 
		 
			 } 
		 return itemStack;
	 }
		return itemStack;
		 
	 }
	
	
	 
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean b) {
		 
		 NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
				info.add(I18n.format("about.connector1"));
				info.add(I18n.format("about.connector2"));
				info.add(I18n.format("about.connector3"));
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
				info.add(I18n.format("connector.storage.connected.coordX") + ": " + mapcoords.get("xcoord").intValue());
				info.add(I18n.format("connector.storage.connected.coordY") + ": " + mapcoords.get("ycoord").intValue());
				info.add(I18n.format("connector.storage.connected.coordZ") + ": " + mapcoords.get("zcoord").intValue());
				info.add(I18n.format("connector.tilewsb.map.instance")  + ": " + (tilewsb1.get("tilewsb") != null));
				info.add(I18n.format("connector.tilewp.map.instance")  + ": " + (tilewp1.get("tilewp1") != null));
				info.add(I18n.format("connector.WSB.connected.boolean")  + ": " + nbtData.getBoolean("SetTargetWSB"));
				info.add(I18n.format("connector.panel.connected.boolean")  + ": " + nbtData.getBoolean("SetTargetWP"));
				
			}
			else {
				info.add(I18n.format("press.lshift.connector"));
				info.add(I18n.format("press.lcontrol.connector"));
			}
		}
	 
}
