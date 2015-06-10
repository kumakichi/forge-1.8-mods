import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * Created by san on 5/25/15.
 */
@Mod(modid = PigDrop.MODID, version = PigDrop.MODVER)
public class PigDrop {
    public static final String MODID = "PigDiamond";
    public static final String MODVER = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new PigDrop());
    }

    @SubscribeEvent
    public void dropDiamonds(LivingDeathEvent event) { //which happens when	an entity dies
        if (!(event.entity instanceof EntityPig))
            return;

        Random random = new Random();
        if(!event.entity.worldObj.isRemote) // not a client world
            event.entity.dropItem(Items.diamond, random.nextInt(3));
    }
}
