package org.autumn.euphoriant.core.cca.entity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.autumn.euphoriant.api.Mixture;
import org.autumn.euphoriant.core.Euphoriant;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

/**
 * @author Chemthunder
 */
public class HighComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<HighComponent> KEY = ComponentRegistry.getOrCreate(
            Euphoriant.id("high"),
            HighComponent.class
    );
    private final Player player;

    private Mixture mixture;

    private int duration = 0;

    public HighComponent(Player player) {
        this.player = player;
    }

    public void tick() {
        if (duration > 0) {
            duration--;
            if (duration == 0) {
                mixture = Mixture.BLANK;
                sync();
            }
        }
    }

    public void sync() {
        KEY.sync(player);
    }

    public void readData(ValueInput valueInput) {
        mixture = valueInput.read("Mixture", Mixture.CODEC).orElse(Mixture.BLANK);
    }

    public void writeData(ValueOutput valueOutput) {
        valueOutput.store("Mixture", Mixture.CODEC, mixture);
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
