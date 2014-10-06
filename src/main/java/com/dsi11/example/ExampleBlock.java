package com.dsi11.example;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Malte on 04.10.2014.
 */
public class ExampleBlock extends Block {
    protected ExampleBlock(Material materialIn) {
        super(materialIn);
        setUnlocalizedName("exampleblock");
        this.setBlockBounds(0, 0, 0, 1, 0.5f, 1);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos);
    }
}
