package org.autumn.euphoriant.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;
import org.autumn.euphoriant.core.index.ModParticleTypes;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * @author Chemthunder
 */
@Mixin(value = LivingEntity.class)
public abstract class LivingEntityMixin {

    @WrapOperation(
            method = "spawnItemParticles",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;addParticleClient(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V"
            )
    )
    private void euphoriant$customEatParticle(World instance, ParticleEffect particleOptions, double d, double e, double f, double g, double h, double i, Operation<Void> original) {
        LivingEntity living = (LivingEntity) (Object)this;

        if (living.getMainHandStack().getItem() instanceof SubstanceItem) {
            original.call(
                    instance,
                    ModParticleTypes.SUBSTANCE_EAT,
                    d, e, f, g, h, i
            );
        } else {
            original.call(
                    instance,
                    particleOptions,
                    d, e, f, g, h, i
            );
        }
    }
}
