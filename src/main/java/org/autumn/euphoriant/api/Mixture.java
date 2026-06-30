package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

/**
 * @author Chemthunder
 */
public record Mixture(List<SubstanceEffect> effects) {
    public static final Mixture BLANK = new Mixture(List.of());

    public static final Codec<Mixture> CODEC = RecordCodecBuilder.create(codec -> codec.group(
            Codec.list(SubstanceEffect.CODEC).optionalFieldOf("effects", List.of()).forGetter(Mixture::effects)
    ).apply(codec, Mixture::new));

    public static final PacketCodec<ByteBuf, Mixture> STREAM_CODEC = PacketCodecs.codec(CODEC);

    public List<String> join() {
        List<String> strings = new ArrayList<>();
        for (SubstanceEffect effect : effects) {
            strings.add(effect.getDispName());
        }
        return strings;
    }
}
