
package me.baileypayne.minigamesetup;

import me.baileypayne.minigamesetup.listeners.players.AsyncPlayerPreLogin;
import me.baileypayne.minigamesetup.listeners.players.PlayerDeath;
import me.baileypayne.minigamesetup.listeners.players.PlayerJoin;
import me.baileypayne.minigamesetup.listeners.players.PlayerQuit;
import me.baileypayne.minigamesetup.threads.StartCountdown;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bailey
 */
public class MinigameSetup extends JavaPlugin {
    
    public static int startCountdownId;
     
    @Override
    public void onEnable(){
        GameState.setState(GameState.IN_LOBBY);
        startCountdown();
        
    }        
    public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new AsyncPlayerPreLogin(this), this);
        pm.registerEvents(new PlayerDeath(this), this);
    }
    
    
    public void startCountdown(){
        StartCountdown.timeUntilStart = 60;
        startCountdownId = getServer().getScheduler().scheduleSyncRepeatingTask(this,
                new StartCountdown(this), 20l, 20l);
    }
    public void stopCountdown(){
        getServer().getScheduler().cancelTask(startCountdownId);
    }
    public void restartCountdown(){
        stopCountdown();
        startCountdown();
    }
    
}
