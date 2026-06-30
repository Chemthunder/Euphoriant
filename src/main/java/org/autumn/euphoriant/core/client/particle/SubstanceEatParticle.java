package org.autumn.euphoriant.core.client.particle;

import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;

/**
 * @author Chemthunder
 */
public class SubstanceEatParticle extends AnimatedParticle {
    public SubstanceEatParticle(ClientWorld clientLevel, double d, double e, double f, SpriteProvider spriteSet, float g) {
        super(clientLevel, d, e, f, spriteSet, g);
    }

    public void tick() {
        super.tick();
    }
}
