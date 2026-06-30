package org.autumn.euphoriant.core.index;

import net.acoyt.acornlib.api.registrants.ParticleTypeRegistrant;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.particle.SimpleParticleType;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

/**
 * @author Chemthunder
 */
public interface ModParticleTypes {
    ParticleTypeRegistrant rant = new ParticleTypeRegistrant(PROJECT_ID);

    SimpleParticleType SUBSTANCE_EAT = rant.register("substance_eat", FabricParticleTypes.simple());

    static void init() {}

    static void clientInit() {
        ParticleFactoryRegistry.getInstance().register(SUBSTANCE_EAT, EndRodParticle.Factory::new);
    }
}
