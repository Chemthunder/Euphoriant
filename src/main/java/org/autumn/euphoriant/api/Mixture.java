package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.List;

/**
 * @author Chemthunder
 */
public record Mixture(List<SubstanceEffect> effects) {
    public static final Mixture BLANK = new Mixture(List.of());

    public static final Codec<Mixture> CODEC = RecordCodecBuilder.create(codec -> codec.group(
            Codec.list(SubstanceEffect.CODEC).optionalFieldOf("effects", List.of()).forGetter(Mixture::effects)
    ).apply(codec, Mixture::new));

    public static final StreamCodec<ByteBuf, Mixture> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);
}
