package Essence_of_Life;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import Essence_of_Life_CreativeTab.tabEOL;
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
 
@Mod(modid="Essence of Life", name="Essence of Life", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Essence_of_Life  {
	
	
	
	 // The instance of your mod that Forge uses.
    @Instance("Essence of Life")
    public static Essence_of_Life instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="Essence_of_Life.client.ClientProxy", serverSide="Essence_of_Life.CommonProxy")
    public static CommonProxy proxy;
    public CreativeTabs tabEOL = new tabEOL("Essence of Life");
    
    public static Block TitaniumOre;
    public static Block SteelOre;
    public static Item Titanium_Ingot;
    public static Item Obsidian_Ingot;
    public static Item Steel_Ingot;
    public static Item Black_Hardened_Steel;
    public static Item Life_Core;
    
    EventManager oreManager = new EventManager();
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	TitaniumOre = new TitaniumOre(502, Material.rock).setHardness(3.0f).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitaniumOre").setCreativeTab(this.tabEOL).setTextureName("eol:titaniumore");
    	SteelOre = new SteelOre(505, Material.rock).setHardness(3.0f).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SteelOre").setCreativeTab(this.tabEOL).setTextureName("eol:steelore");
    	Titanium_Ingot = new Titanium_Ingot(501).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Titanium_Ingot").setTextureName("eol:titanium_ingot");
    	Obsidian_Ingot = new Obsidian_Ingot(503).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Obsidian_Ingot").setTextureName("eol:obsidian_ingot");
    	Steel_Ingot = new Steel_Ingot(504).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("steel_Ingot").setTextureName("eol:steel_ingot");
    	Black_Hardened_Steel = new Black_Hardened_Steel(506).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Black_Hardened_Steel").setTextureName("eol:bhs");
    	Life_Core = new Life_Core(507).setMaxStackSize(1).setCreativeTab(this.tabEOL).setUnlocalizedName("LifeCore").setTextureName("eol:life_core");
    }
   
    private Object setMaxStackSize(int i) {

		return null;
	}

	@EventHandler
    public void load(FMLInitializationEvent event) {
            proxy.registerRenderers();
            //GameRegistry.addRecipe();
            
            GameRegistry.registerBlock(TitaniumOre, "TitaniumOre");
            LanguageRegistry.addName(TitaniumOre, "Titanium Ore");
            MinecraftForge.setBlockHarvestLevel(TitaniumOre, "pickaxe", 2);
            
            
            GameRegistry.registerItem(Titanium_Ingot,"Titanium_Ingot");
            LanguageRegistry.addName(Titanium_Ingot, "Titanium Ingot");

            
            GameRegistry.registerItem(Obsidian_Ingot,"Obsidian Ingot");
            LanguageRegistry.addName(Obsidian_Ingot, "Obsidian Ingot");
            
            GameRegistry.registerItem(Steel_Ingot, "Steel Ingot");
            LanguageRegistry.addName(Steel_Ingot, "Steel Ingot");
            
            GameRegistry.registerBlock(SteelOre, "SteelOre");
            LanguageRegistry.addName(SteelOre, "Steel Ore");
            MinecraftForge.setBlockHarvestLevel(SteelOre, "pickaxe", 2);
            
            GameRegistry.registerItem(Black_Hardened_Steel, "Black_Hardened_Steel");
            LanguageRegistry.addName(Black_Hardened_Steel, "Black Hardened Steel");
            
            GameRegistry.registerItem(Life_Core, "LifeCore");
            LanguageRegistry.addName(Life_Core, "Life Core");
            
            //this is an itemstack!
            ItemStack Ti_Ingot = new ItemStack(Titanium_Ingot);
            ItemStack Ob_Ingot = new ItemStack(Obsidian_Ingot);
            ItemStack St_Ingot = new ItemStack(Steel_Ingot);
            ItemStack BHS = new ItemStack(Black_Hardened_Steel);
            ItemStack LC = new ItemStack(Life_Core);
            
            //you need to give it the block id and then the itemstack!!
            GameRegistry.addSmelting(TitaniumOre.blockID, Ti_Ingot, 0.7f);
            GameRegistry.addSmelting(Block.obsidian.blockID, Ob_Ingot, 0.7f);
            GameRegistry.addSmelting(SteelOre.blockID, St_Ingot, 0.7f);
            GameRegistry.addRecipe(BHS, "xxx", "yyy", "zzz", 'x', Ti_Ingot, 'y', Ob_Ingot, 'z', St_Ingot);
            GameRegistry.addRecipe(LC, "yyy", "yxy", "yyy", 'x', Block.blockDiamond.blockID, 'y', Block.blockRedstone.blockID);
            
            GameRegistry.registerWorldGenerator(oreManager);
    }

	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}

