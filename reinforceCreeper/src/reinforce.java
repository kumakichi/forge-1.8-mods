import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by san on 5/29/15.
 */
@Mod(modid = reinforce.MOD_ID, version = reinforce.MOD_VERSION)
public class reinforce {
    public static final String MOD_ID = "reinforce-creeper";
    public static final String MOD_VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new reinforce());
    }

    @SubscribeEvent
    public void spawnReinforcements(LivingDeathEvent event) {
        if (! (event.entity instanceof EntityCreeper)) // not creeper
            return;

        for(int i = 0; i < 5; i++) {
            EntityCreeper creeper = new EntityCreeper(event.entity.worldObj);
            creeper.setLocationAndAngles(event.entity.posX, event.entity.posY, event.entity.posZ, 0, 0);
            if (!event.entity.worldObj.isRemote) // client -> true, server -> false, If this statement was not here, five regular creepers would spawn, but five creepers without AI would also spawn. If a mob does not have AI, it can’t move and can’t take any damage.
                event.entity.worldObj.spawnEntityInWorld(creeper);
        }
    }
}
