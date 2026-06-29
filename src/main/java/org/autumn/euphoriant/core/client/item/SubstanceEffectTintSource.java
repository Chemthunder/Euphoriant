package org.autumn.euphoriant.core.client.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;
import org.jspecify.annotations.Nullable;

/**
 * @author Chemthunder
 */
public record SubstanceEffectTintSource() implements ItemTintSource {
    public static final MapCodec<SubstanceEffectTintSource> MAP_CODEC = MapCodec.unit(SubstanceEffectTintSource::new);

    public int calculate(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity) {
        return itemStack.getOrDefault(ModDataComponentTypes.MIXTURE, Mixture.BLANK).effects().getFirst().getColor();
    }

    public MapCodec<? extends ItemTintSource> type() {
        return MAP_CODEC;
    }
}
