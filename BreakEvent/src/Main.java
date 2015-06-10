import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by san on 5/22/15.
 */
@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
    public static final String MODID = "myMods";
    public static final String VERSION = "1.0";
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new BlockBreakEvent());
    }
}
