package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum EffectCategory implements StringRepresentable {
    POSITIVE("positive", "+", 0xFF00ff0a),
    NEGATIVE("negative", "-", 0xFFff0000);

    private final String id;
    private final String sign;
    private final int color;

    public static final Codec<EffectCategory> CODEC = StringRepresentable.fromEnum(EffectCategory::values);

    EffectCategory(String id, String sign, int color) {
        this.id = id;
        this.sign = sign;
        this.color = color;
    }

    public @NotNull String getSerializedName() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public String getSign() {
        return sign;
    }
}
