package org.autumn.euphoriant.core.index;

import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.ext.SubstanceEffectRegistrant;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

/**
 * @author Chemthunder
 */
public interface ModSubstanceEffects {
    SubstanceEffectRegistrant rant = new SubstanceEffectRegistrant(PROJECT_ID);

    /// POSITIVE
    SubstanceEffect SIGHT = rant.register("sight", EffectCategory.POSITIVE);

    /// NEGATIVE
    SubstanceEffect FLIMSY = rant.register("flimsy", EffectCategory.NEGATIVE);

    static void init() {}
}
