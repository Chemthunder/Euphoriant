package org.autumn.euphoriant.core.item;

import net.acoyt.acornlib.api.event.BetterItemTooltipEvent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.api.SubstanceUtils;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;
import org.autumn.euphoriant.core.index.ModSubstanceEffects;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SubstanceItem extends Item {
    public SubstanceItem(net.minecraft.item.Item.Settings properties) {
        super(properties);
    }

    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (player.isInSneakingPose()) {
            stack.set(ModDataComponentTypes.MIXTURE, SubstanceUtils.generateRandomMixture());
        }
        return super.use(world, player, hand);
    }

    public static final class Tooltip implements BetterItemTooltipEvent {
        public void getTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent component, @Nullable PlayerEntity player, TooltipType type, Consumer<Text> consumer) {
            if (stack.getItem() instanceof SubstanceItem) {
                List<SubstanceEffect> effects = stack.get(ModDataComponentTypes.MIXTURE).effects();

                if (!effects.isEmpty()) {
                    for (SubstanceEffect effect : effects) {
                        EffectCategory category = effect.getCategory();

                        consumer.accept(
                                Text.literal(
                                        category.getSign() + " " + effect.getDispName()
                                ).formatted(category == EffectCategory.POSITIVE ? Formatting.GREEN : Formatting.RED)
                        );
                    }
                }
            }
        }
    }

}
