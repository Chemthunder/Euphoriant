package org.autumn.euphoriant.core.seffect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.autumn.euphoriant.api.EffectCategory;
import org.autumn.euphoriant.api.SubstanceEffect;

public class Test extends SubstanceEffect {
    public Test(String id, EffectCategory category) {
        super(id, category);
    }

    public void tick(PlayerEntity player) {
        player.sendMessage(
                Text.literal("hola"),
                true
        );
    }

    public void onAttack(PlayerEntity player, World world, LivingEntity target, ItemStack stack) {
        player.sendMessage(
                Text.literal("attack"),
                false
        );
    }
}
