package org.autumn.euphoriant.core.index;

import net.minecraft.world.food.FoodProperties;

/**
 * @author Chemthunder
 */
public interface ModFoodProperties {
    FoodProperties substance = new FoodProperties.Builder().alwaysEdible().build();

    static void init() {

    }
}
