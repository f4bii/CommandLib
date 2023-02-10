package de.f4bii.commandlib;

import lombok.extern.slf4j.Slf4j;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@Slf4j
public class BukkitCustomCommand extends CustomCommand<CommandSender, CommandExecutor> implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            this.execute(commandSender, strings);
            return true;
        } catch (IllegalAccessException | InvocationTargetException exception) {
            log.error("We couldn't execute the Command with these arguments: " + Arrays.toString(strings));
        } catch (Throwable throwable) {
            handleException(throwable, commandSender);
        }
        return false;
    }
}
