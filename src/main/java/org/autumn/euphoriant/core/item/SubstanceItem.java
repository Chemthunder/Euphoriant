package org.autumn.euphoriant.core.item;

import net.acoyt.acornlib.api.event.BetterItemTooltipEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;
import org.autumn.euphoriant.core.index.ModSubstanceEffects;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SubstanceItem extends Item {
    public SubstanceItem(Properties properties) {
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
        }
        return super.use(level, player, interactionHand);
    }

    public static final class Tooltip implements BetterItemTooltipEvent {
        public void getTooltip(ItemStack stack, TooltipContext context, TooltipDisplay component, @Nullable Player player, TooltipFlag type, Consumer<Component> consumer) {
            if (stack.getItem() instanceof SubstanceItem) {
                List<SubstanceEffect> effects = stack.get(ModDataComponentTypes.MIXTURE).effects();

                if (!effects.isEmpty()) {
                    for (SubstanceEffect effect : effects) {
                        EffectCategory category = effect.getCategory();

                        consumer.accept(
                                Component.literal(
                                        category.getSign() + " " + effect.getDispName()
                                ).withStyle(category == EffectCategory.POSITIVE ? ChatFormatting.GREEN : ChatFormatting.RED)
                        );
                    }
                }
            }
        }
    }

}
