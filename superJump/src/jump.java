import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by san on 5/29/15.
 */
@Mod(modid = "superJump", version = "1.0")
public class jump {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new jump());
    }

    @SubscribeEvent
    public void jumpFiveTimesHigher(LivingEvent.LivingJumpEvent event) {
        if (!(event.entity instanceof EntityPlayer)) // only player jump 5 times higher
            return;

        BlockPos cur = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 2, (int) Math.floor(event.entity.posZ));
        if (event.entity.worldObj.getBlockState(cur).getBlock() != Blocks.sponge)
            return;

        event.entity.motionY *= 5;
    }
}
