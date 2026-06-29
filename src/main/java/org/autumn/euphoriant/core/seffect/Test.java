package org.autumn.euphoriant.core.seffect;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.SubstanceEffect;

public class Test extends SubstanceEffect {
    public Test(String id, EffectCategory category) {
        super(id, category);
    }

    public void tick(Player player) {
        player.displayClientMessage(
                Component.literal("hola"),
                true
        );
    }
}
