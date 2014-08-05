
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.GameState;
import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.handlers.Team;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Bailey
 */
public class PlayerQuit extends MGListener {
    
    public PlayerQuit(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        if(GameState.isState(GameState.IN_LOBBY)){
            Game.setCanStart(Bukkit.getOnlinePlayers().length - 1 >= 8);
            Player player = event.getPlayer();
            
            if(Game.hasStarted()){
                Team.getTeam(player).remove(player);
            }
        }
    }
}
