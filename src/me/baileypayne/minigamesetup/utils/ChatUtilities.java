
package me.baileypayne.minigamesetup.utils;

import org.bukkit.Bukkit;
import static org.bukkit.ChatColor.*;
import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class ChatUtilities {
    
    public static void broadcast(String msg){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(starter() + msg);
        }
    }
    private static String starter(){
        return DARK_GRAY + "[" + RED + "Minigame" + DARK_GRAY + "]" + WHITE;
    }
}
