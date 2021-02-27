package ic2.core.block.wiring;
import com.Denfop.tiles.base.TileEntityElectricBlock;
public class TileEntityElectricMFSU extends TileEntityElectricBlock {
  public TileEntityElectricMFSU() {
    super(4, 2048, 40000000);
  }
  
  public String getInventoryName() {
    return "MFSU";
  }
}
