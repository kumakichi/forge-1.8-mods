import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by san on 5/22/15.
 */
public class BlockBreakEvent {
    @SubscribeEvent
    public void sendMessage(BlockEvent.BreakEvent event) {
        event.getPlayer().addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "You break one!!"));
    }
}
