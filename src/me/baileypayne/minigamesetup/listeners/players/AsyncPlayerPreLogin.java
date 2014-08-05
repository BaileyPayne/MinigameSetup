
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

/**
 *
 * @author Bailey
 */
public class AsyncPlayerPreLogin extends MGListener {
    
    public AsyncPlayerPreLogin(MinigameSetup pl){
        super(pl);
    }
    
    @EventHandler
    public void playerPreLogin(AsyncPlayerPreLoginEvent event){
        if(Game.hasStarted()){
            event.disallow(Result.KICK_OTHER, ChatColor.RED + "The game has already started!");
            
        }
    }
}
