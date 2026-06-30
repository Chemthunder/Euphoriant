package org.autumn.euphoriant.api;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.ColorHelper;
import org.autumn.euphoriant.core.index.ModRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Chemthunder
 */
public class SubstanceUtils {
    public static void renderInventory(DrawContext context, int mouseX, int mouseY) {
        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;

        context.fillGradient(
                0,
                0,
                context.getScaledWindowWidth(),
                context.getScaledWindowHeight(),
                0xF0000000,
                ColorHelper.fromFloats(0, 234, 84, 0.33F)
        );
    }

    public static Mixture generateRandomMixture() {
        Random random = new Random();
        int length = random.nextInt(ModRegistries.SUBSTANCE_EFFECT.size());

        List<SubstanceEffect> effects = new ArrayList<>();

        if (length == 0) {
            generateRandomMixture();
        } else {
            for (SubstanceEffect effect : ModRegistries.SUBSTANCE_EFFECT) {
                if (random.nextInt(4) < 3) {
                    effects.add(effect);
                }
            }
        }

        return new Mixture(effects);
    }
}
