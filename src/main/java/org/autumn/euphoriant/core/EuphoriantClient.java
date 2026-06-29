package org.autumn.euphoriant.core;

import net.fabricmc.api.ClientModInitializer;
import org.autumn.euphoriant.core.index.ModParticleTypes;

/**
 * @author Chemthunder
 */
public class EuphoriantClient implements ClientModInitializer {
    public void onInitializeClient() {
        ModParticleTypes.clientInit();
    }
}
