// 
// Decompiled by Procyon v0.5.36
// 

package aroma1997.uncomplication.enet;

import ic2.core.util.ConfigUtil;
import ic2.core.init.MainConfig;
import java.util.HashMap;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySourceInfo;
import ic2.api.energy.tile.IEnergySource;
import java.util.Map;

public class EnergyTransferList
{
    public static Map<String, Integer> values;
    public static Map<String, Integer> acceptingOverride;
    
    public EnergyTransferList() {
        init();
    }
    
    public static int getMaxEnergy(final IEnergySource par1, int currentMax) {
        if (par1 instanceof IEnergySourceInfo) {
            final IEnergySourceInfo info = (IEnergySourceInfo)par1;
            return info.getMaxEnergyAmount();
        }
        if (!EnergyTransferList.values.containsKey(par1.getClass().getSimpleName())) {
            EnergyTransferList.values.put(par1.getClass().getSimpleName(), currentMax);
        }
        if (EnergyTransferList.values.containsKey(par1.getClass().getSimpleName())) {
            final int newValue = EnergyTransferList.values.get(par1.getClass().getSimpleName());
            if (newValue < currentMax) {
                EnergyTransferList.values.put(par1.getClass().getSimpleName(), currentMax);
            }
            currentMax = EnergyTransferList.values.get(par1.getClass().getSimpleName());
        }
        return currentMax;
    }
    
    public static void initIEnergySource(final IEnergySource par1) {
        if (!EnergyTransferList.values.containsKey(par1.getClass().getSimpleName())) {
            EnergyTransferList.values.put(par1.getClass().getSimpleName(), 10);
        }
    }
    
    public static boolean hasOverrideInput(final IEnergySink par1) {
        if (par1 == null) {
            return false;
        }
        final Class clz = par1.getClass();
        return EnergyTransferList.acceptingOverride.containsKey(clz.getSimpleName());
    }
    
    public static int getOverrideInput(final IEnergySink par1) {
        if (par1 == null || !hasOverrideInput(par1)) {
            return 0;
        }
        final Class clz = par1.getClass();
        return EnergyTransferList.acceptingOverride.get(clz.getSimpleName());
    }
    
    public static void init() {
        final Map<String, Integer> list = new HashMap<String, Integer>();
        list.put("TileEntityEnergyOMat", 32);
        list.put("TileEntityNuclearReactorElectric", Math.round(1512.0f * ConfigUtil.getFloat(MainConfig.get(), "balance/energy/generator/nuclear")));
        list.put("TileEntityReactorChamberElectric", Math.round(240.0f * ConfigUtil.getFloat(MainConfig.get(), "balance/energy/generator/nuclear")));
        list.put("TileEntityWindGenerator", 10);
        list.put("TileEntityGenerator", Math.round(10.0f * ConfigUtil.getFloat(MainConfig.get(), "balance/energy/generator/generator")));
        list.put("TileEntityGeoGenerator", Math.round(20.0f * ConfigUtil.getFloat(MainConfig.get(), "balance/energy/generator/geothermal")));
        list.put("TileEntitySolarGenerator", 1);
        list.put("TileEntityWaterGenerator", 2);
        list.put("TileEntityElectricBatBox", 32);
        list.put("TileEntityStirlingGenerator", 128);
        list.put("TileEntityKineticGenerator", 512);
        list.put("TileEntityRTGenerator", 32);
        list.put("TileEntitySemifluidGenerator", 32);
        list.put("TileEntityChargepadBatBox", 32);
        list.put("TileEntityChargepadCESU", 128);
        list.put("TileEntityChargepadMFE", 512);
        list.put("TileEntityChargepadMFSU", 2048);
        list.put("TileEntityTransformerMV", 512);
        list.put("TileEntityTransformerLV", 128);
        list.put("TileEntityTransformerHV", 2048);
        list.put("TileEntityTransformerEV", 8192);
        list.put("TileEntityElectricMFSU", 2048);
        list.put("TileEntityElectricMFE", 512);
        list.put("TileEntityElectricCESU", 128);
        EnergyTransferList.values.putAll(list);
        EnergyTransferList.acceptingOverride.put("TileEntityMolecularTransformer", 4096);
    }
    
    static {
        EnergyTransferList.values = new HashMap<String, Integer>();
        EnergyTransferList.acceptingOverride = new HashMap<String, Integer>();
    }
}
