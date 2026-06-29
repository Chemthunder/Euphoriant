package org.autumn.euphoriant.core.utilities;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;

import java.util.List;

public record SubstanceConsumeEffect() implements ConsumeEffect {
    public static final MapCodec<SubstanceConsumeEffect> MAP_CODEC = MapCodec.unit(SubstanceConsumeEffect::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, SubstanceConsumeEffect> STREAM_CODEC = StreamCodec.unit(new SubstanceConsumeEffect());

    public static final Type<SubstanceConsumeEffect> TYPE = new Type<>(
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
            return true;
        }

        return false;
    }
}