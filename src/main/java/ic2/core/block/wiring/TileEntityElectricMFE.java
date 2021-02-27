package ic2.core.block.wiring;
import com.Denfop.tiles.base.TileEntityElectricBlock;
public class TileEntityElectricMFE extends TileEntityElectricBlock {
  public TileEntityElectricMFE() {
    super(3, 512, 4000000);
  }
  
  public String getInventoryName() {
    return "MFE";
  }
}
