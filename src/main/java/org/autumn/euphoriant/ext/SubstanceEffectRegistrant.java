package org.autumn.euphoriant.ext;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
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

    public SubstanceEffect register(String name, EffectCategory category, int color) {
        return register(name, new SubstanceEffect(name, category, color));
    }

    public void registerLang(HolderLookup.Provider provider, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        this.toRegister.forEach(substanceEffect -> {
            translationBuilder.add(
                    substanceEffect.getTranslationKey(),
                    MiscUtils.formatString(substanceEffect.getId())
            );
        });
    }
}
