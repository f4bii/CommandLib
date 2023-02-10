package de.f4bii.commandlib;

import de.f4bii.commandlib.parser.DefaultParser;
import net.md_5.bungee.api.plugin.Plugin;

public class CommandLib extends Plugin {

    @Override
    public void onEnable() {
        DefaultParser.registerAll();
        BungeeDefaultParser.registerAll();
    }
}
