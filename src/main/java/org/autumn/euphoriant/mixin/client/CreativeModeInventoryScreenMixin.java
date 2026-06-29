package org.autumn.euphoriant.mixin.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import org.autumn.euphoriant.api.SubstanceUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {
    @Inject(method = "render", at = @At(value = "HEAD"))
    private void euphoriant$draw(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        SubstanceUtils.extractInventorySprite(
                guiGraphics,
                i,
                j
        );
    }
}
