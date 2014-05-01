package Essence_of_Life;

import net.minecraft.block.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Wrench extends Item {
	
	boolean result;

	public Wrench(int par1) {
		super(par1);{
			
		}
	}

		
			@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int BlockId = par3World.getBlockId(par4, par5, par6);
		Block Wblock = Block.blocksList[BlockId];
		
		if(Wblock instanceof IEOLWrenchable)
		{
			
			((IEOLWrenchable) Wblock).DoWrench();
			result = true;
			return true;
			
		}
		return true;
	}
			
}