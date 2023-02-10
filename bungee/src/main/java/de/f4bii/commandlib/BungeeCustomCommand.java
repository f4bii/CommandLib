package de.f4bii.commandlib;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.lang.reflect.InvocationTargetException;

public class BungeeCustomCommand extends CustomCommand<CommandSender, Command> {
    private final Command executor;

    public BungeeCustomCommand() {
        de.f4bii.commandlib.annotation.Command cmd = getClass().getAnnotation(de.f4bii.commandlib.annotation.Command.class);
        this.executor = new Command(cmd.value()) {
            @Override
            public void execute(CommandSender commandSender, String[] strings) {
                try {
                    BungeeCustomCommand.this.execute(commandSender, strings);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Throwable throwable) {
                    handleException(throwable, commandSender);
                }
            }
        };
    }

    public final Command getExecutor() {
        return executor;
    }
}
