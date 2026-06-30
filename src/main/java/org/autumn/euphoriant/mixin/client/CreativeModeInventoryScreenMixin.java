package org.autumn.euphoriant.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import org.autumn.euphoriant.api.SubstanceUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = CreativeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {
    @Inject(method = "render", at = @At(value = "HEAD"))
    private void euphoriant$draw(DrawContext guiGraphics, int i, int j, float f, CallbackInfo ci) {
        SubstanceUtils.renderInventory(
                guiGraphics,
                i,
                j
        );
    }
}
