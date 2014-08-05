
package me.baileypayne.minigamesetup.utils;

import me.baileypayne.minigamesetup.handlers.Team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class LocationUtilities {
    
    private static Location spawnLocation = new Location(Bukkit.getWorld("Lobby"), 0, 64, 0);
    
    public static void teleportToSpawn(Player player){
        player.teleport(spawnLocation);
    }
    public static void teleportAllToSpawn(){
        for(Player p : Bukkit.getOnlinePlayers()) {
            teleportToSpawn(p);
        }
    }
    public static void teleportToGame(Player player, Team team){
        player.teleport(team.getSpawn());
    }
    
}
