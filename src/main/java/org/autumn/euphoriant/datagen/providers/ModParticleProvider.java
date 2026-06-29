package org.autumn.euphoriant.datagen.providers;

import net.acoyt.acornlib.data.provider.resources.AcornParticleGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import org.autumn.euphoriant.core.Euphoriant;
import org.autumn.euphoriant.core.index.ModParticleTypes;

/**
 * @author Chemthunder
 */
public class ModParticleProvider extends AcornParticleGen {
    public ModParticleProvider(FabricDataOutput output) {
        super(output);
    }

    public void generate(ParticleDataConsumer consumer) {
        consumer.accept(
                ModParticleTypes.SUBSTANCE_EAT,
                rangeBetween(Euphoriant.id("substance_eat"), 0, 1)
        );
    }
}
// rangeBetween(AcornLib.id("alt_gold/sweep"), 0, 7));
