package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.autumn.euphoriant.core.index.ModRegistries;

public class SubstanceEffect {
    private final String id;
    private final EffectCategory category;

    public SubstanceEffect(String id, EffectCategory category) {
        this.id = id;
        this.category = category;
    }

    public static final Codec<SubstanceEffect> CODEC = RecordCodecBuilder.create(codec -> codec.group(
            Codec.STRING.optionalFieldOf("id", "").forGetter(SubstanceEffect::getId),
            EffectCategory.CODEC.optionalFieldOf("category", EffectCategory.POSITIVE).forGetter(SubstanceEffect::getCategory)
    ).apply(codec, SubstanceEffect::new));

    public String getId() {
        return id;
    }

    public EffectCategory getCategory() {
        return category;
    }

    public String getTranslationKey() {
        Identifier id = ModRegistries.SUBSTANCE_EFFECT.getKey(this);
        return "substance_effect." + id.getNamespace() + "." + id.getPath();
    }

    public String getDispName() {
        return MiscUtils.formatString(this.getId());
    }


    /// OVERRIDES
    public void tick(Player player) {
    }

    public void onAttack(Player player, Level level, LivingEntity target, ItemStack stack) {
    }

    public void onSneak(Player player, Level level) {
    }

    public void onDamage(Player player, Level level, DamageSource source) {
    }

    public void onHeal(Player player, Level level) {
    }

    public void onDeath(Player player, Level level) {
    }
}
