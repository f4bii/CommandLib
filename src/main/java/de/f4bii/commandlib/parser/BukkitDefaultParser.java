package de.f4bii.commandlib.parser;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BukkitDefaultParser {

    public static void registerAll() {
        DefaultParser.registerAll();
        AdapterWrapper.register(Player.class, Bukkit::getPlayer);
        AdapterWrapper.register(OfflinePlayer.class, Bukkit::getOfflinePlayer);
        AdapterWrapper.register(World.class, Bukkit::getWorld);
    }
}
