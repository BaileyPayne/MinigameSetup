
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
     
    public void onEnable(){
        GameState.setState(GameState.IN_LOBBY);
        new Thread(new StartCountdown()).start();
    }        
    public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new PlayerQuit(this), this);
        pm.registerEvents(new AsyncPlayerPreLogin(this), this);
        pm.registerEvents(new PlayerDeath(this), this);
    }
    
}
