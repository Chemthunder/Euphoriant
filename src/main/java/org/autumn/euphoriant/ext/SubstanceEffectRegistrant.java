package org.autumn.euphoriant.ext;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.index.ModRegistries;

/**
 * @author Chemthunder
 */
public class SubstanceEffectRegistrant extends RegistrantBase<SubstanceEffect> {
    public SubstanceEffectRegistrant(String modId) {
        super(modId, ModRegistries.SUBSTANCE_EFFECT);
    }

    public SubstanceEffect register(String name, EffectCategory category) {
        return register(name, new SubstanceEffect(name, category));
    }

    public void registerLang(RegistryWrapper.WrapperLookup provider, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        this.toRegister.forEach(substanceEffect -> {
            translationBuilder.add(
                    substanceEffect.getTranslationKey(),
                    MiscUtils.formatString(substanceEffect.getId())
            );
        });
    }
}
