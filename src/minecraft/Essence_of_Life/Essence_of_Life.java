package Essence_of_Life;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
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
    public static CreativeTabs tabEOL = new tabEOL("Essence of Life");
    
    public static Block TitaniumOre;
    public static Block SteelOre;
    public static Item Titanium_Ingot;
    public static Item Obsidian_Ingot;
    public static Item Steel_Ingot;
    public static Item Black_Hardened_Steel;
    public static Item Life_Core;
    public static Item Ender_Dust;
    public static Item Sacrfical_Gem;
    public static Item Necro_Gem;
    public static Block Sacrafical_Mat;
    public static TileEntity TileEntity_Sacrafical_Mat;
    
    EventManager oreManager = new EventManager();

	private ItemStack itemtack;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	TitaniumOre = new TitaniumOre(502, Material.rock).setHardness(3.0f).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("TitaniumOre").setCreativeTab(this.tabEOL).setTextureName("eol:titaniumore");
    	SteelOre = new SteelOre(505, Material.rock).setHardness(3.0f).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SteelOre").setCreativeTab(this.tabEOL).setTextureName("eol:steelore");
    	Titanium_Ingot = new Titanium_Ingot(501).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Titanium_Ingot").setTextureName("eol:titanium_ingot");
    	Obsidian_Ingot = new Obsidian_Ingot(503).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Obsidian_Ingot").setTextureName("eol:obsidian_ingot");
    	Steel_Ingot = new Steel_Ingot(504).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("steel_Ingot").setTextureName("eol:steel_ingot");
    	Black_Hardened_Steel = new Black_Hardened_Steel(506).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("Black_Hardened_Steel").setTextureName("eol:bhs");
    	Life_Core = new Life_Core(507).setMaxStackSize(1).setCreativeTab(this.tabEOL).setUnlocalizedName("LifeCore").setTextureName("eol:life_core");
    	Ender_Dust = new Ender_dust(508).setMaxStackSize(64).setCreativeTab(this.tabEOL).setUnlocalizedName("EnderDust").setTextureName("eol:ender_dust");
    	Sacrfical_Gem = new Sacrfical_Gem(509).setMaxStackSize(1).setCreativeTab(this.tabEOL).setUnlocalizedName("SacraficalGem").setTextureName("eol:scarafical_gem");
    	Necro_Gem = new Necro_Gem(510).setMaxStackSize(1).setCreativeTab(this.tabEOL).setUnlocalizedName("NecroGem").setTextureName("eol:necro_gem");
    	Sacrafical_Mat = new Sacrafical_Mat(511, Material.cloth).setCreativeTab(this.tabEOL).setUnlocalizedName("Mat");
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
            
            GameRegistry.registerItem(Ender_Dust, "EnderDust");
            LanguageRegistry.addName(Ender_Dust, "Ender Dust");
            
            GameRegistry.registerItem(Sacrfical_Gem, "SacrficalGem");
            LanguageRegistry.addName(Sacrfical_Gem, "Sacrfical Gem");
            
            GameRegistry.registerItem(Necro_Gem, "NecroGem");
            LanguageRegistry.addName(Necro_Gem, "Necro Gem");
            
            //GameRegistry.registerTileEntity(TileEntity_Sacrafical_Mat.class, "SacraficalMat");
            GameRegistry.registerBlock(Sacrafical_Mat, "Sacrafical_Mat");
            LanguageRegistry.addName(Sacrafical_Mat, "Sacrafical Mat");
            
            //this is an itemstack!
            ItemStack Ti_Ingot = new ItemStack(Titanium_Ingot);
            ItemStack Ob_Ingot = new ItemStack(Obsidian_Ingot);
            ItemStack St_Ingot = new ItemStack(Steel_Ingot);
            ItemStack BHS = new ItemStack(Black_Hardened_Steel);
            ItemStack LC = new ItemStack(Life_Core);
            ItemStack BOD = new ItemStack(Block.blockDiamond);
            ItemStack BOR = new ItemStack(Block.blockRedstone);
            ItemStack ED = new ItemStack(Ender_Dust);
            ItemStack Pist = new ItemStack(Block.pistonBase);
            ItemStack EB = new ItemStack(Block.whiteStone);
            ItemStack SG = new ItemStack(Sacrfical_Gem);
            ItemStack NG = new ItemStack(Necro_Gem);
            
            //you need to give it the block id and then the itemstack!!
            GameRegistry.addSmelting(TitaniumOre.blockID, Ti_Ingot, 0.7f);
            GameRegistry.addSmelting(Block.obsidian.blockID, Ob_Ingot, 0.7f);
            GameRegistry.addSmelting(SteelOre.blockID, St_Ingot, 0.7f);
            GameRegistry.addRecipe(BHS, "xxx", "yyy", "zzz", 'x', Ti_Ingot, 'y', Ob_Ingot, 'z', St_Ingot);
            GameRegistry.addRecipe(LC, "yyy", "yxy", "yyy", 'x', BOD, 'y', BOR);
            GameRegistry.addRecipe(ED, "yxy", "yxy", "yxy", 'y', Pist, 'x', EB);
            GameRegistry.addRecipe(SG, "yyy", "yxy", "yyy", 'y', BOD, 'x', LC);
            GameRegistry.addRecipe(NG, "xxx", "xyx", "xxx", 'x', ED, 'y', SG);
            
            
            GameRegistry.registerWorldGenerator(oreManager);
    }

	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}

