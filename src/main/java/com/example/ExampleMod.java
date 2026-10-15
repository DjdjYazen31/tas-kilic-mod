package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Kılıcı kaydetme
    public static final Item PETRIFY_SWORD = Registry.register(
        Registries.ITEM,
        new Identifier(MOD_ID, "petrify_sword"),
        new PetrifySwordItem(ToolMaterials.DIAMOND, 4, -2.4F, new Item.Settings())
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Taslastirici Kilic Modu Basariyla Yuklendi!");
    }
}
