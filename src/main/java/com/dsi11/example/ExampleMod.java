package com.dsi11.example;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.Map;

@Mod(modid = "examplemod", name = "ExampleMod", version = "0.1")
public class ExampleMod {

    @SidedProxy(clientSide = "com.dsi11.example.ClientProxy", serverSide = "com.dsi11.example.CommonProxy")
    public static CommonProxy proxy;

    public static ExampleBlock exampleBlock;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        exampleBlock = new ExampleBlock(Material.rock);
        registerBlock(exampleBlock, ExampleItemBlock.class,
                exampleBlock.getUnlocalizedName());
        exampleBlock.setCreativeTab(CreativeTabs.tabTransport);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt) {
        proxy.registerRenderInformation();
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> itemclass, String name,
                                      Object... itemCtorArgs) {
        block = GameRegistry.registerBlock(block, itemclass, name, itemCtorArgs);
        Item associatedItem = GameRegistry.findItem("examplemod", name);

        Map itemBlockMap = (Map) ObfuscationReflectionHelper.getPrivateValue(Item.class, null, "BLOCK_TO_ITEM");

        if (!itemBlockMap.containsKey(block)) {
            itemBlockMap.put(block, associatedItem);
        }

        Iterator iterator = block.getBlockState().getValidStates().iterator();

        while (iterator.hasNext()) {
            IBlockState iblockstate = (IBlockState) iterator.next();
            int id = Block.blockRegistry.getIDForObject(block) << 4 | block.getMetaFromState(iblockstate);
            Block.BLOCK_STATE_IDS.put(iblockstate, id);
        }

        return block;
    }
}
