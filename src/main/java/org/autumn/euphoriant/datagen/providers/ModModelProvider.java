package org.autumn.euphoriant.datagen.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import org.autumn.euphoriant.core.index.ModItems;

/**
 * @author Chemthunder
 */
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockModelGenerators) {}

    public void generateItemModels(ItemModelGenerator itemModelGenerators) {
        itemModelGenerators.register(
                ModItems.SUBSTANCE,
                Models.GENERATED
        );
    }
}
