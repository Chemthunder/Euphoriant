package org.autumn.euphoriant.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "attack", at = @At(value = "HEAD"))
    private void euphoriant$attack(Entity entity, CallbackInfo ci) {
        PlayerEntity self = (PlayerEntity) (Object) this;

        HighComponent component = HighComponent.KEY.get(self);

        if (entity instanceof LivingEntity target) {

            component.getMixture().effects().forEach(substanceEffect -> substanceEffect.onAttack(
                    self,
                    self.getEntityWorld(),
                    target,
                    self.getActiveOrMainHandStack()
            ));
        }
    }
}
