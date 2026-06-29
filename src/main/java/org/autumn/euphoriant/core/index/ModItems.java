package org.autumn.euphoriant.core.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.autumn.euphoriant.core.utilities.SubstanceConsumeEffect;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

public interface ModItems {
    ItemRegistrant rant = new ItemRegistrant(PROJECT_ID);

    Item SUBSTANCE = rant.register("substance", SubstanceItem::new, new Item.Properties()
            .stacksTo(1)
            .component(ModDataComponentTypes.MIXTURE, Mixture.BLANK)
            .food(
                    new FoodProperties(
                            0,
                            0,
                            true
                    ),
                    Consumable.builder()
                            .animation(ItemUseAnimation.EAT)
                            .hasConsumeParticles(true)
                            .onConsume(new SubstanceConsumeEffect())
                            .build()
            )
    );

    static void init() {}
}
