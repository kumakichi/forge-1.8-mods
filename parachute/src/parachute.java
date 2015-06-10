import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by san on 5/29/15.
 */
@Mod(modid = "parachute", version = "1.0")
public class parachute {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // PlayerTickEvent is part of FMLCommonHandler.instance().bus()
        FMLCommonHandler.instance().bus().register(new parachute());
        // LivingFallEvent is part of MinecraftForge.EVENT_BUS
        MinecraftForge.EVENT_BUS.register(new parachute());
    }

    @SubscribeEvent
    public void deployParachute(TickEvent.PlayerTickEvent event) { // which	happens	for	every player on	every tick
        EntityPlayer player = event.player;
        if (!player.isAirBorne || !player.isSneaking())
            return;
        player.motionY = -0.1; // each tick, fall down 0.1, if you like more slower, try -0.01
    }

    @SubscribeEvent
    public void negateFallDamage(LivingFallEvent event) {
        if (!(event.entity instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer) event.entity;
        if (!player.isSneaking()) // how to sneak? Press 'Shift'
            return;
        event.setCanceled(true); // The event is canceled, so the player doesn’t take fall damage
    }
}
