package de.f4bii.commandlib;

import de.f4bii.commandlib.parser.DefaultParser;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandLib extends JavaPlugin {

    @Override
    public void onEnable() {
        DefaultParser.registerAll();
        BukkitDefaultParser.registerAll();
    }
}
