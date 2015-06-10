import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by san on 5/22/15.
 */
@Mod(modid = BiggerTNT.MODID, version = BiggerTNT.VERSION)
public class BiggerTNT {
    int fuse = 1;
    float power = 1.0F;
    public static final String MODID = "biggerTNT";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new BiggerTNT());
    }

    @SubscribeEvent
    public void spawnTNTItem(EntityJoinWorldEvent event) { // when an entity is created
        if (!(event.entity instanceof EntityTNTPrimed)) {
            return;
        }

        Entity entity = event.entity;
        EntityItem explosion = new EntityItem(event.world, entity.posX, entity.posY, entity.posZ, new ItemStack(Blocks.tnt));
        explosion.setInfinitePickupDelay(); // disable pick up,so a player can’t disable the TNT by picking up the item
        explosion.motionX = 0;
        explosion.motionY = 0;
        explosion.motionZ = 0;
        explosion.lifespan = fuse * 20; //there are 20 ticks in a second
        if (!event.world.isRemote) {
            event.world.spawnEntityInWorld(explosion); //checks if the world isRemote , meaning is it a client world or a server world. In Forge, sometimes events run twice, once on the client side and once on the server side. This if statement contains a line of code that spawns in the explosion item, and it makes sure that only one item is spawned.
        }
    }

    @SubscribeEvent
    public void explode(ItemExpireEvent event) {
        if (event.entityItem.getEntityItem().getItem() != Item.getItemFromBlock(Blocks.tnt)) {
            return;
        }

        EntityItem explosion = event.entityItem;
        event.entity.worldObj.createExplosion(explosion, explosion.posX, explosion.posY, explosion.posZ, power, true); //using explosion as the source and location, and with a power of power . The explosion also breaks blocks
    }
}
