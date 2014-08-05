
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.listeners.MGListener;
import me.baileypayne.minigamesetup.utils.LocationUtilities;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 *
 * @author Bailey
 */
public class PlayerJoin extends MGListener {
    
    public PlayerJoin(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e){
        Game.setCanStart(Bukkit.getOnlinePlayers().length >= 8);
        LocationUtilities.teleportToSpawn(e.getPlayer());
    }
    
}
