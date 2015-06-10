import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by san on 5/29/15.
 */
@Mod(modid = "blockFiller", version = "1.0")
public class BlockFillerPositionSelector {
    static List<Integer> pos1 = new ArrayList();
    static List<Integer> pos2 = new ArrayList();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());
    }

    @SubscribeEvent
    public void choosePositions(PlayerInteractEvent event) { // use woodden axe to mark position, and just only in creativeMode
        if (event.entityPlayer.getHeldItem() == null ||
                event.entityPlayer.getHeldItem().getItem()
                        != Items.wooden_axe ||
                !event.entityPlayer.capabilities.isCreativeMode) {
            return;
        }
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            pos1.clear();
            pos1.add(event.pos.getX());
            pos1.add(event.pos.getY());
            pos1.add(event.pos.getZ());
            event.entityPlayer.addChatMessage(new ChatComponentText(
                    EnumChatFormatting.GREEN
                            + "Position 1 set to "
                            + event.pos.getX()
                            + ", " + event.pos.getY()
                            + ", " + event.pos.getZ() + "."));
            event.setCanceled(true);
        } else if (event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            pos2.clear();
            pos2.add(event.pos.getX());
            pos2.add(event.pos.getY());
            pos2.add(event.pos.getZ());
            event.entityPlayer.addChatMessage(new ChatComponentText(
                    EnumChatFormatting.GREEN
                            + "Position 2 set to "
                            + event.pos.getX()
                            + ", " + event.pos.getY()
                            + ", " + event.pos.getZ() + "."));
            event.setCanceled(true);
        }
    }

}
