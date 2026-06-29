package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum EffectCategory implements StringRepresentable {
    POSITIVE("positive", "+"),
    NEGATIVE("negative", "-");

    private final String id;
    private final String sign;

    public static final Codec<EffectCategory> CODEC = StringRepresentable.fromEnum(EffectCategory::values);

    EffectCategory(String id, String sign) {
        this.id = id;
        this.sign = sign;
    }

    public @NotNull String getSerializedName() {
        return id;
    }

    public String getId() {
        return id;
    }

    public String getSign() {
        return sign;
    }
}
