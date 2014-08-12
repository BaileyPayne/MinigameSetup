
package me.baileypayne.minigamesetup.handlers;

import me.baileypayne.minigamesetup.utils.LocationUtilities;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class Game {
    
    private static boolean canStart = false;
    private static boolean hasStarted = false;
    
    public static boolean canStart() {
        return canStart;
        
    }
    public static void setCanStart(boolean b){
        canStart = b;
    }
    public static void start(){
        hasStarted = true;
        Team red = new Team("Red", new Location(Bukkit.getWorld("world"), 20, 64, 20));
        Team blue = new Team("Blue", new Location(Bukkit.getWorld("world"), 20, 64, 20));
        
        int i = 0;
        for(Player player : Bukkit.getOnlinePlayers()){
            if(i > Team.getAllTeams().size())
                i = 0;
            Team.getTeam(Team.getAllTeams().get(i).getName()).add(player);
            LocationUtilities.teleportToGame(player, Team.getAllTeams().get(i));
            Kit.getKit(player).giveKit(player);
            i ++;
            
        }
    }
    public static void stop(Team team){
        hasStarted = false;
    }
    public static boolean hasStarted(){
        return hasStarted;
    }
}
