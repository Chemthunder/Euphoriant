package org.autumn.euphoriant.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.autumn.euphoriant.core.item.SubstanceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/**
 * @author Chemthunder
 */
@Mixin(value = ConsumableComponent.class)
public abstract class ConsumableComponentMixin {

    @WrapOperation(
            method = "spawnParticlesAndPlaySound",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"
            )
    )
    private void euphoriant$customEatSound(LivingEntity instance, SoundEvent soundEvent, float v, float v2, Operation<Void> original) {
        if (instance.getActiveOrMainHandStack().getItem() instanceof SubstanceItem) {
            original.call(
                    instance,
                    SoundEvents.ITEM_BRUSH_BRUSHING_SAND,
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
