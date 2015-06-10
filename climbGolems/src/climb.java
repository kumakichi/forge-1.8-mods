import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by san on 5/29/15.
 */
@Mod(modid = "climbGolems", version = "1.0")
public class climb {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new climb());
    }

    @SubscribeEvent
    public void climbWallGolems(LivingEvent.LivingUpdateEvent event) {
        if (!(event.entity instanceof EntitySnowman || event.entity instanceof EntityIronGolem))
            return; // snowman or ironGolem
        if (!event.entity.isCollidedHorizontally)
            return;
        event.entity.motionY = 0.5; // set motionY to 0.5, every tick, upwards 0.5
    }
}
