package org.autumn.euphoriant.core.cmnd;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.autumn.euphoriant.core.cca.entity.HighComponent;

import static net.minecraft.server.command.CommandManager.literal;

public class ModDebugCommand implements CommandRegistrationCallback {
    public void register(CommandDispatcher<ServerCommandSource> commandDispatcher, CommandRegistryAccess commandBuildContext, CommandManager.RegistrationEnvironment commandSelection) {
        commandDispatcher.register(literal("moddebug")
                .then(literal("querySources").executes(context -> {
                    PlayerEntity player = context.getSource().getPlayer();

                    if (player != null) {
                        HighComponent component = HighComponent.KEY.get(player);

                        player.sendMessage(Text.literal(component.getMixture().join().toString()), false);
                    }
                    return 1;
                }))

                .then(literal("exitSources").executes(context -> {
                    PlayerEntity player = context.getSource().getPlayer();

                    if (player != null) {
                        HighComponent component = HighComponent.KEY.get(player);

                        component.exit();
                    }
                    return 1;
                }))
        );
    }
}
