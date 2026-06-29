package org.autumn.euphoriant.core.item;

import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import net.acoyt.acornlib.api.event.BetterItemTooltipEvent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
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

        stack.set(ModDataComponentTypes.MIXTURE, new Mixture(
                Arrays.asList(
                        ModSubstanceEffects.SIGHT,
                        ModSubstanceEffects.FLIMSY
                )
        ));
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

    public record ItemConsumeEffect() implements ConsumeEffect {
        public static final MapCodec<ItemConsumeEffect> MAP_CODEC = MapCodec.unit(ItemConsumeEffect::new);
        public static final StreamCodec<RegistryFriendlyByteBuf, ItemConsumeEffect> STREAM_CODEC = StreamCodec.unit(new ItemConsumeEffect());

        public static final Type<ItemConsumeEffect> TYPE = new Type<>(
                MAP_CODEC,
                STREAM_CODEC
        );

        public Type<? extends ConsumeEffect> getType() {
            return TYPE;
        }

        public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {
            if (livingEntity instanceof Player player) {
                HighComponent high = new HighComponent(player);

                List<SubstanceEffect> effectsToTransmit = itemStack.get(ModDataComponentTypes.MIXTURE).effects();

                Mixture toDeploy = new Mixture(effectsToTransmit);

                high.setMixture(toDeploy);
            }

            return true;
        }
    }
}
