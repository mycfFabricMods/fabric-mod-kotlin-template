package com.username.modid

import com.username.modid.blocks.ModIdBlocks
import com.username.modid.items.ModIdItems
import net.fabricmc.api.ModInitializer


@Suppress("UNUSED")
object MainFile : ModInitializer {
    const val MOD_ID = "mod_id"


    override fun onInitialize() {
        ModIdBlocks.registerBlocks()
        ModIdItems.registerItems()
    }
}
