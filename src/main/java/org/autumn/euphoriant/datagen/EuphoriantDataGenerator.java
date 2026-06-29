package org.autumn.euphoriant.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.autumn.euphoriant.datagen.providers.ModModelProvider;
import org.autumn.euphoriant.datagen.providers.ModParticleProvider;

public class EuphoriantDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModParticleProvider::new);
	}
}
