package org.autumn.euphoriant.core.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.client.particle.SpriteSet;

/**
 * @author Chemthunder
 */
public class SubstanceEatParticle extends SimpleAnimatedParticle {
    public SubstanceEatParticle(ClientLevel clientLevel, double d, double e, double f, SpriteSet spriteSet, float g) {
        super(clientLevel, d, e, f, spriteSet, g);
    }

    public void tick() {
        super.tick();

    }
}
