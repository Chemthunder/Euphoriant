package org.autumn.euphoriant.core.utilities;

import com.mojang.serialization.MapCodec;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.autumn.euphoriant.core.index.ModDataComponentTypes;

import java.util.List;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.world.World;

public record SubstanceConsumeEffect() implements ConsumeEffect {
    public static final MapCodec<SubstanceConsumeEffect> MAP_CODEC = MapCodec.unit(SubstanceConsumeEffect::new);
    public static final PacketCodec<RegistryByteBuf, SubstanceConsumeEffect> PACKET_CODEC = PacketCodec.unit(new SubstanceConsumeEffect());

    public Type<? extends ConsumeEffect> getType() {
        return new Type<>(MAP_CODEC, PACKET_CODEC);
    }

    public boolean onConsume(World level, ItemStack itemStack, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity player) {
            HighComponent high = HighComponent.KEY.get(player);

            List<SubstanceEffect> effectsToTransmit = itemStack.getOrDefault(ModDataComponentTypes.MIXTURE, Mixture.BLANK).effects();

            Mixture toDeploy = new Mixture(effectsToTransmit);

            high.setMixture(toDeploy);
            high.sync();

            return true;
        }

        return false;
    }
}