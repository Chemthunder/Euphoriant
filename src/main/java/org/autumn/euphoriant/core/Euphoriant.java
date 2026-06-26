package org.autumn.euphoriant.core;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.autumn.euphoriant.core.index.ModItems;
import org.autumn.euphoriant.core.index.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Euphoriant implements ModInitializer {
	public static final String MOD_ID = "euphoriant";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        ModRegistries.init();
        ModItems.init();

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
