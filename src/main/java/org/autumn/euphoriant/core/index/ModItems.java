package org.autumn.euphoriant.core.index;

import net.acoyt.acornlib.api.registrants.ItemRegistrant;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.autumn.euphoriant.core.utilities.SubstanceConsumeEffect;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

public interface ModItems {
    ItemRegistrant rant = new ItemRegistrant(PROJECT_ID);

    Item SUBSTANCE = rant.register("substance", SubstanceItem::new, new Item.Settings()
            .maxCount(1)
            .component(ModDataComponentTypes.MIXTURE, Mixture.BLANK)
            .food(
                    new FoodComponent(
                            0,
                            0,
                            true
                    ),
                    ConsumableComponent.builder()
                            .useAction(UseAction.EAT)
                            .finishSound(RegistryEntry.of(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK))
                            .consumeParticles(true)
                            .consumeEffect(new SubstanceConsumeEffect())
                            .build()
            )
    );

    static void init() {}
}
