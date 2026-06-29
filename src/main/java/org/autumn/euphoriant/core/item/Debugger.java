package org.autumn.euphoriant.core.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.core.Euphoriant;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;
import org.autumn.euphoriant.core.index.ModSubstanceEffects;

import java.util.Arrays;

public class Debugger extends Item {
    public Debugger(Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack stack = player.getItemInHand(interactionHand);

        if (!player.isCrouching()) {
            stack.set(ModDataComponentTypes.MIXTURE, new Mixture(
                    Arrays.asList(
                            ModSubstanceEffects.SIGHT,
                            ModSubstanceEffects.FLIMSY,
                            ModSubstanceEffects.TEST
                    )
            ));
        } else {
            HighComponent.KEY.get(player).setMixture(stack.get(ModDataComponentTypes.MIXTURE));
            Euphoriant.LOGGER.info("You have these effects! {}", HighComponent.KEY.get(player).getMixture().effects().toString());
        }
        return super.use(level, player, interactionHand);
    }
}
