package de.f4bii.commandlib;

import de.f4bii.commandlib.parser.AdapterWrapper;
import de.f4bii.commandlib.parser.CommandParser;
import de.f4bii.commandlib.parser.DefaultParser;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.UUID;

public class BungeeDefaultParser {
    private static volatile boolean registered = false;

    public static void registerAll() {
        registered = true;
        DefaultParser.registerAll();
        AdapterWrapper.register(ProxiedPlayer.class, in -> {
            if (in.matches(DefaultParser.UUID_REGEX)) {
                return ProxyServer.getInstance().getPlayer(UUID.fromString(in));
            }
            return ProxyServer.getInstance().getPlayer(in);
        });
    }
}
