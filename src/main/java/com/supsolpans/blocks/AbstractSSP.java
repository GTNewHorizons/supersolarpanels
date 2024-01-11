package com.supsolpans.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

abstract public class AbstractSSP extends BlockContainer {

    public AbstractSSP(Material mat) {
        super(mat);

    }

    public AbstractSSP() {
        this(Material.rock);
    }

}
