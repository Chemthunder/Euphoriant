package org.autumn.euphoriant.mixin.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import org.autumn.euphoriant.api.SubstanceUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Chemthunder
 */
@Mixin(value = InventoryScreen.class)
public abstract class InventoryScreenMixin {
    @Inject(method = "render", at = @At(value = "HEAD"))
    private void euphoriant$draw(GuiGraphics guiGraphics, int i, int j, float f, CallbackInfo ci) {
        SubstanceUtils.extractInventorySprite(
                guiGraphics,
                i,
                j
        );
    }
}
