package org.autumn.euphoriant.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.component.Consumable;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * @author Chemthunder
 */
@Mixin(value = Consumable.class)
public abstract class ConsumableMixin {

    @WrapOperation(
            method = "emitParticlesAndSounds",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;playSound(Lnet/minecraft/sounds/SoundEvent;FF)V"
            )
    )
    private void euphoriant$customEatSound(LivingEntity instance, SoundEvent soundEvent, float v, float v2, Operation<Void> original) {
        if (instance.getActiveItem().getItem() instanceof SubstanceItem) {
            original.call(
                    instance,
                    SoundEvents.BRUSH_SAND,
                    v, v2
            );
        } else {
            original.call(
                    instance,
                    soundEvent,
                    v, v2
            );
        }
    }
}
