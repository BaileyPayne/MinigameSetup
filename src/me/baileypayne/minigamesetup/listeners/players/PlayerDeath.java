
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Team;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author Bailey
 */
public class PlayerDeath extends MGListener {
    
    public PlayerDeath(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Team.getTeam(player).remove(player);
        
        player.kickPlayer(ChatColor.RED + "You Died!!");
    }
}
