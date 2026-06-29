package org.autumn.euphoriant.core.index;

import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.seffect.Test;
import org.autumn.euphoriant.ext.SubstanceEffectRegistrant;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

/**
 * @author Chemthunder
 */
public interface ModSubstanceEffects {
    SubstanceEffectRegistrant rant = new SubstanceEffectRegistrant(PROJECT_ID);

    /// POSITIVE
    SubstanceEffect SIGHT = rant.register("sight", EffectCategory.POSITIVE);
    SubstanceEffect TEST = rant.register("test", new Test("test", EffectCategory.POSITIVE));

    /// NEGATIVE
    SubstanceEffect FLIMSY = rant.register("flimsy", EffectCategory.NEGATIVE);
    SubstanceEffect HIDEOUS = rant.register("hideous", EffectCategory.NEGATIVE);
    SubstanceEffect SINKING = rant.register("sinking", EffectCategory.NEGATIVE);

    static void init() {}
}
