@file:Suppress("SameParameterValue")

package com.username.modid.blocks

import com.username.modid.MainFile
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModIdBlocks {
    private var BlockItemsRegistry = linkedMapOf<String, Item>()
    private var BlockRegistry = linkedMapOf<String, Block>()

    val COOL_BLOCK: Block

    /**
     * Register blocks in here.
     * [net.minecraft.item.BlockItem.BlockItem] gets added automatically.
     * If you wish to change the settings of the BlockItem implement your own methods for it.
     */
    init {
        COOL_BLOCK = addBlock("coolblock", Block(FabricBlockSettings.copy(Blocks.STONE)))
    }

    private fun addBlock(name: String, block: Block): Block {
        val correctedName = name.lowercase().trim()
        BlockRegistry[correctedName] = block
        BlockItemsRegistry[correctedName + "_item"] =
            (BlockItem(block, Item.Settings().maxCount(64).group(ItemGroup.MISC)))
        return block
    }

    public fun registerBlocks() {
        this.BlockRegistry.forEach {
            Registry.register(Registry.BLOCK, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
        registerBlockItems()
    }

    private fun registerBlockItems() {
        this.BlockItemsRegistry.forEach {
            Registry.register(Registry.ITEM, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
    }
}