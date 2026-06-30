package org.autumn.euphoriant.core.index;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.Euphoriant;

@SuppressWarnings("NullableProblems")
public interface ModRegistries {
    RegistryKey<Registry<SubstanceEffect>> effectKey = RegistryKey.ofRegistry(Euphoriant.id("substance_effect"));
    Registry<SubstanceEffect> SUBSTANCE_EFFECT = FabricRegistryBuilder.createSimple(effectKey)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    static void init() {}
}
