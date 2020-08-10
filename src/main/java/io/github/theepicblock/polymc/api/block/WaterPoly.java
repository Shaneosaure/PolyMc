/*
 * PolyMc
 * Copyright (C) 2020-2020 TheEpicBlock_TEB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; If not, see <https://www.gnu.org/licenses>.
 */
package io.github.theepicblock.polymc.api.block;

import io.github.theepicblock.polymc.resource.ResourcePackMaker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Property;

public class WaterPoly implements BlockPoly{
    @Override
    public BlockState getClientBlock(BlockState input) {
        BlockState output = Blocks.WATER.getDefaultState();
        for (Property<?> p : input.getProperties()) {
            output = copyProperty(output, input, p);
        }
        System.out.println(input + " -> " + output);
        return output;
    }

    /**
     * Copies Property p from BlockState b into BlockState a
     * @return
     */
    private <T extends Comparable<T>> BlockState copyProperty(BlockState a, BlockState b, Property<T> p) {
        return a.with(p,b.get(p));
    }

    @Override
    public void AddToResourcePack(Block block, ResourcePackMaker pack) {

    }
}
