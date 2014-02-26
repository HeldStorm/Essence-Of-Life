package Essence_of_Life_CreativeTab;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class tabEOL extends CreativeTabs {
	
	public tabEOL(String name) {
		super(name);
	}

	
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Essence of Life";
	}
	
}
