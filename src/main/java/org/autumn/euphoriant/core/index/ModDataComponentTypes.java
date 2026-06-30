package org.autumn.euphoriant.core.index;

import net.acoyt.acornlib.api.registrants.DataComponentTypeRegistrant;
import net.minecraft.component.ComponentType;
import org.autumn.euphoriant.api.Mixture;

import static org.autumn.euphoriant.core.Euphoriant.PROJECT_ID;

/**
 * @author Chemthunder
 */
public interface ModDataComponentTypes {
    DataComponentTypeRegistrant rant = new DataComponentTypeRegistrant(PROJECT_ID);

    ComponentType<Mixture> MIXTURE = rant.register(
            "mixture",
            Mixture.CODEC,
            Mixture.STREAM_CODEC
    );

    static void init() {}
}
