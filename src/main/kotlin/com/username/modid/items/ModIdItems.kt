@file:Suppress("SameParameterValue")

package com.username.modid.items

import com.username.modid.MainFile
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModIdItems {
    private var ItemRegistry = linkedMapOf<String, Item>()

    /**
     * Register [net.minecraft.item.Item.Item]s in here.
     */
    init {
        addItem("coolitem", Item(FabricItemSettings().maxCount(64).group(ItemGroup.MISC)))
    }

    private fun addItem(name: String, item: Item) {
        val correctedName = name.lowercase().trim()
        ItemRegistry[correctedName] = item
    }

    public fun registerItems() {
        this.ItemRegistry.forEach {
            Registry.register(Registry.ITEM, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
    }
}