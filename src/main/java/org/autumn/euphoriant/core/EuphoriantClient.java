package org.autumn.euphoriant.core;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.color.item.ItemTintSources;
import org.autumn.euphoriant.core.client.item.SubstanceEffectTintSource;
import org.autumn.euphoriant.core.index.ModParticleTypes;

/**
 * @author Chemthunder
 */
public class EuphoriantClient implements ClientModInitializer {
    public void onInitializeClient() {
        ModParticleTypes.clientInit();

        ItemTintSources.ID_MAPPER.put(
                Euphoriant.id("substance_tint"),
                SubstanceEffectTintSource.MAP_CODEC
        );
    }
}
