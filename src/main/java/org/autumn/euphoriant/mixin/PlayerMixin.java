package org.autumn.euphoriant.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.autumn.euphoriant.core.cca.entity.HighComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = Player.class)
public abstract class PlayerMixin {

    @Inject(method = "attack", at = @At(value = "HEAD"))
    private void euphoriant$attack(Entity entity, CallbackInfo ci) {
        Player self = (Player) (Object) this;

        HighComponent component = HighComponent.KEY.get(self);

        if (entity instanceof LivingEntity target) {

            component.getMixture().effects().forEach(substanceEffect -> substanceEffect.onAttack(
                    self,
                    self.level(),
                    target,
                    self.getActiveItem()
            ));
        }
    }
}
