package de.f4bii.commandlib.parser;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BungeeDefaultParser {

    public static void registerAll() {
        DefaultParser.registerAll();
        AdapterWrapper.register(ProxiedPlayer.class, in -> ProxyServer.getInstance().getPlayer(in));
    }
}
