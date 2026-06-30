package org.autumn.euphoriant.core.cca.entity;

import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.api.SubstanceEffect;
import org.autumn.euphoriant.core.Euphoriant;
import org.jetbrains.annotations.Nullable;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

import java.util.List;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;

/**
 * @author Chemthunder
 */
public class HighComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<HighComponent> KEY = ComponentRegistry.getOrCreate(
            Euphoriant.id("high"),
            HighComponent.class
    );
    private final PlayerEntity player;

    private @Nullable Mixture mixture;

    private int duration = 0;

    private static final int BASE_DURATION = 500;

    public HighComponent(PlayerEntity player) {
        this.player = player;
    }

    public void tick() {
        if (mixture != null) {
            for (SubstanceEffect effect : mixture.effects()) {
                effect.tick(player);
            }
        }
    }

    public void sync() {
        KEY.sync(player);
    }

    public void readData(ReadView valueInput) {
        mixture = valueInput.read("Mixture", Mixture.CODEC).orElse(null);
    }

    public void writeData(WriteView valueOutput) {
        if (mixture != null) {
            valueOutput.put("Mixture", Mixture.CODEC, mixture);
        }
    }

    public void submitNewMixture(List<SubstanceEffect> effects, int ticks) {
        Mixture mixture1 = new Mixture(
                effects
        );

        mixture = mixture1;
        duration = ticks;
        sync();
    }

    public void submitNewMixture(List<SubstanceEffect> effects) {
        Mixture mixture1 = new Mixture(
                effects
        );

        mixture = mixture1;
        duration = BASE_DURATION;
        sync();
    }

    public void submitNewMixture(Mixture newMixture) {
        mixture = newMixture;
        duration = BASE_DURATION;
        sync();
    }

    public void exit() {
        mixture = Mixture.BLANK;
        duration = 0;
        sync();
    }

    public Mixture getMixture() {
        return mixture;
    }

    public void setMixture(Mixture mixture) {
        this.mixture = mixture;
        sync();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        sync();
    }
}
