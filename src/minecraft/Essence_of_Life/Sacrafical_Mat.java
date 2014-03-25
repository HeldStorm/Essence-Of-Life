package Essence_of_Life;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Sacrafical_Mat extends BlockContainer {
	
	TileEntity_Sacrafical_Mat te = new TileEntity_Sacrafical_Mat();

	protected Sacrafical_Mat(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setBlockBounds(-1.0F, 0.0F, -1.0F, 2.0F, 0.0625F, 2.05F);
		this.setCreativeTab(Essence_of_Life.tabEOL);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return te;
	}

}
