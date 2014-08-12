
package me.baileypayne.minigamesetup.threads;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.utils.ChatUtilities;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Bailey
 */
public class StartCountdown extends BukkitRunnable {
    
    MinigameSetup plugin;
    
    public StartCountdown(MinigameSetup pl){
        plugin = pl;
    }    
    public static int timeUntilStart;
        
    @Override
    public void run() {
        if(timeUntilStart == 0) {
              if(!Game.canStart()){
                  plugin.restartCountdown();
                  ChatUtilities.broadcast("Cannot start game, countdown restarting");
                  return;
              }
            Game.start();
            
        }            
           if(timeUntilStart % 10 == 8 || timeUntilStart < 10){
                    ChatUtilities.broadcast(String.valueOf(timeUntilStart) + " seconds until the game starts!");
                    
                }
                timeUntilStart -= 1;
        }
                
    }
    

