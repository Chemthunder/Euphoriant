package org.autumn.euphoriant.api;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
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
        Identifier id = ModRegistries.SUBSTANCE_EFFECT.getId(this);
        return "substance_effect." + id.getNamespace() + "." + id.getPath();
    }

    public String getDispName() {
        return MiscUtils.formatString(this.getId());
    }


    /// OVERRIDES
    public void tick(PlayerEntity player) {
    }

    public void onAttack(PlayerEntity player, World world, LivingEntity target, ItemStack stack) {
    }

    public void onSneak(PlayerEntity player, World world) {
    }

    public void onDamage(PlayerEntity player, World world, DamageSource source) {
    }

    public void onHeal(PlayerEntity player, World world) {
    }

    public void onDeath(PlayerEntity player, World world) {
    }
}
