package org.autumn.euphoriant.core.cca;

import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

/**
 * @author Chemthunder
 */
public class ModCCA implements EntityComponentInitializer {
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry module) {
        module.registerForPlayers(
                HighComponent.KEY,
                HighComponent::new,
                RespawnCopyStrategy.NEVER_COPY
        );
    }
}
