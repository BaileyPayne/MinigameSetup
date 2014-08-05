
package me.baileypayne.minigamesetup.threads;

import me.baileypayne.minigamesetup.GameState;
import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.utils.ChatUtilities;
import org.bukkit.Bukkit;

/**
 *
 * @author Bailey
 */
public class StartCountdown implements Runnable {
    
    private static int timeUntilStart;

    @Override
    public void run() {
        timeUntilStart = 60;
                while(true){
                    if(GameState.isState(GameState.IN_LOBBY)){
                        if(Game.canStart()){
                    timeUntilStart = 60;
                    ChatUtilities.broadcast("Minimum Players Reached, Countdown starting!");
            for(;timeUntilStart >= 0; timeUntilStart--){
                if(!Game.canStart()){
                    ChatUtilities.broadcast("Not enough players. Countdown stopped");
                }
                if(timeUntilStart == 0){
                    Game.start();
                    break;
                }
                
                if(timeUntilStart % 10==0 || timeUntilStart < 10){
                    ChatUtilities.broadcast(timeUntilStart + "seconds until game starts!");
                }
                
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                    Bukkit.shutdown();
                }
            }
                        }
                    }
            try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                    Bukkit.shutdown();
                }
        }
                
    }
    
}
