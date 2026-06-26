package org.autumn.euphoriant.core.index;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.Euphoriant;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NullableProblems")
public interface ModRegistries {
    ResourceKey<Registry<SubstanceEffect>> effectKey = ResourceKey.createRegistryKey(Euphoriant.id("substance_effect"));
    Registry<SubstanceEffect> SUBSTANCE_EFFECT = FabricRegistryBuilder.createSimple(effectKey)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    static void init() {}
}
