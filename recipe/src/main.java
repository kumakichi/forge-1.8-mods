package demoxx;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by san on 6/9/15.
 */
@Mod(modid = main.MODID, name = main.NAME, version = main.VERSION)
public class main {
    public static final String MODID = "demoRecipe";
    public static final String NAME = "demoRecipe";
    public static final String VERSION = "v1.10";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // shaped crafting recipe
        GameRegistry.addRecipe(new ItemStack(Items.lava_bucket, 64),
                "d w",
                'd', Blocks.dirt,
                'w', Items.stick);

        // shapeless crafting recipe
        GameRegistry.addShapelessRecipe(new ItemStack(Items.apple, 9),
                new ItemStack(Items.stick),
                new ItemStack(Blocks.wooden_button));

        // smelting recipe
        GameRegistry.addSmelting(Items.apple, // input
                new ItemStack(Items.golden_apple, 64),//output and	has	to	be	an	 *ItemStack*
                5.0F); //exp

        // brewing recipe
        Items.apple.setPotionEffect(PotionHelper.blazePowderEffect
        +
        "+6"
        +
        "+14");
    }
}
