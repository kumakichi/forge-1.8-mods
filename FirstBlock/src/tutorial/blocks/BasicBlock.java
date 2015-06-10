package tutorial.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import tutorial.items.ModItems;

import java.util.Random;

public class BasicBlock extends Block {

	public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	public BasicBlock(String unlocalizedName, float hardness, float resistance) {
		this(unlocalizedName, Material.rock, hardness, resistance);
	}

	public BasicBlock(String unlocalizedName) {
		this(unlocalizedName, 2.0f, 10.0f);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.tutorialItem;
	}

	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune) {
		return 20 + fortune * 10;
	}
}
