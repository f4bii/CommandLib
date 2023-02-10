package de.f4bii.commandlib;

import de.f4bii.commandlib.parser.AdapterWrapper;
import de.f4bii.commandlib.parser.DefaultParser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BukkitDefaultParser {

    public static void registerAll() {
        DefaultParser.registerAll();
        AdapterWrapper.register(Player.class, in -> {
            if (in.matches(DefaultParser.UUID_REGEX)) {
                return Bukkit.getPlayer(UUID.fromString(in));
            }
            return Bukkit.getPlayer(in);
        });
        AdapterWrapper.register(OfflinePlayer.class, in -> {
            if (in.matches(DefaultParser.UUID_REGEX)) {
                return Bukkit.getOfflinePlayer(UUID.fromString(in));
            }
            return Bukkit.getOfflinePlayer(in);
        });
        AdapterWrapper.register(World.class, in -> {
            if (in.matches(DefaultParser.UUID_REGEX)) {
                return Bukkit.getWorld(UUID.fromString(in));
            }
            return Bukkit.getWorld(in);
        });
    }
}