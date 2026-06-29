package org.autumn.euphoriant.api;

import net.fabricmc.fabric.impl.client.indigo.renderer.helper.ColorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.ARGB;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.level.ColorResolver;

import java.awt.*;

/**
 * @author Chemthunder
 */
public class SubstanceUtils {
    public static void extractInventorySprite(GuiGraphics context, int mouseX, int mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;

        context.fillGradient(
                0,
                0,
                context.guiWidth(),
                context.guiHeight(),
                0xF0000000,
                ARGB.colorFromFloat(0, 234, 84, 0.33F)
        );
    }
}
