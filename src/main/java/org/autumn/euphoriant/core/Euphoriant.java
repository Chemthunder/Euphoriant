package org.autumn.euphoriant.core;

import net.acoyt.acornlib.api.event.BetterItemTooltipEvent;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import org.autumn.euphoriant.core.index.*;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Euphoriant implements ModInitializer {
	public static final String PROJECT_ID = "euphoriant";
	public static final Logger LOGGER = LoggerFactory.getLogger(PROJECT_ID);

	public void onInitialize() {
        ModRegistries.init();
        ModItems.init();
        ModSubstanceEffects.init();
        ModDataComponentTypes.init();
        ModParticleTypes.init();

        this.createTooltips();

		LOGGER.info("Hello Fabric world!");
	}

    private void createTooltips() {
        BetterItemTooltipEvent.EVENT.register(new SubstanceItem.Tooltip());
    }

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(PROJECT_ID, path);
	}
}
