
package me.baileypayne.minigamesetup.listeners.entity;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.handlers.Team;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author Bailey
 */
public class EntityDamageByEntity extends MGListener {
    
    public EntityDamageByEntity(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        if (!(event.getEntity() instanceof Player && event.getDamager() instanceof Player)){
        event.setCancelled(true);
        return;
    }
        if(!Game.hasStarted()){
            event.setCancelled(true);
            return;
        }
        Player player = (Player) event.getEntity();
        Player damager = (Player) event.getDamager();
        
        if(Team.getTeam(player) == Team.getTeam(damager)) {
            event.setCancelled(true);
        }
                    

    }
}
