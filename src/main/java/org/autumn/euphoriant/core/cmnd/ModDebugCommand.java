package org.autumn.euphoriant.core.cmnd;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.autumn.euphoriant.core.cca.entity.HighComponent;

import static net.minecraft.commands.Commands.literal;

public class ModDebugCommand implements CommandRegistrationCallback {
    public void register(CommandDispatcher<CommandSourceStack> commandDispatcher, CommandBuildContext commandBuildContext, Commands.CommandSelection commandSelection) {
        commandDispatcher.register(literal("moddebug")
                .then(literal("querySources").executes(context -> {
                    Player player = context.getSource().getPlayer();

                    if (player != null) {
                        HighComponent component = HighComponent.KEY.get(player);

                        player.displayClientMessage(Component.literal(component.getMixture().join().toString()), false);
                    }
                    return 1;
                }))

                .then(literal("exitSources").executes(context -> {
                    Player player = context.getSource().getPlayer();

                    if (player != null) {
                        HighComponent component = HighComponent.KEY.get(player);

                        component.exit();
                    }
                    return 1;
                }))
        );
    }
}
