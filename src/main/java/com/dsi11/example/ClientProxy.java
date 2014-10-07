package com.dsi11.example;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Malte on 05.10.2014.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderInformation() {
        Item item = GameRegistry.findItem("examplemod", ExampleMod.exampleBlock.getUnlocalizedName());
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        String name = "examplemod:" + ExampleMod.exampleBlock.getUnlocalizedName();

        mesher.register(item, 0, new ModelResourceLocation(name,
                "inventory"));
    }
}
