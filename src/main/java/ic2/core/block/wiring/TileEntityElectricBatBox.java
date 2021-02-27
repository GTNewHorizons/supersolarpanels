package ic2.core.block.wiring;
import com.Denfop.tiles.base.TileEntityElectricBlock;
public class TileEntityElectricBatBox extends TileEntityElectricBlock {
  public TileEntityElectricBatBox() {
    super(1, 32, 40000);
  }
  
  public String getInventoryName() {
    return "BatBox";
  }
}
