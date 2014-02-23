package Essence_of_Life;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import Essence_of_Life.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Essence_of_Life_CreativeTab.*;
 
@Mod(modid="Essence of Life", name="Essence of Life", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Essence_of_Life  {
	
	
	
	 // The instance of your mod that Forge uses.
    @Instance("Essence of Life")
    public static Essence_of_Life instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="Essence_of_Life.client.ClientProxy", serverSide="Essence_of_Life.CommonProxy")
    public static CommonProxy proxy;
    
    public static Block TitaniumOre = new TitaniumOre(502, Material.rock).setHardness(3.0f).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitaniumOre").setCreativeTab(Essence_of_Life.tabEOL).setTextureName("essence_of_life:titaniumore");
    
    public static CreativeTabs tabEOL = new tabEOL("Essence of Life");
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            //GameRegistry.addRecipe();
            
            GameRegistry.registerBlock(TitaniumOre, "TitaniumOre");
            LanguageRegistry.addName(TitaniumOre, "Titanium Ore");
            MinecraftForge.setBlockHarvestLevel(TitaniumOre, "pickaxe", 2);
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}

