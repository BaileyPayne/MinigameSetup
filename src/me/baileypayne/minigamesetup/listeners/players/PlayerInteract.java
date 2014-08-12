
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.handlers.Kit;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Bailey
 */
public class PlayerInteract extends MGListener {
    
    public PlayerInteract(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getItem() == null){
            return;
        }
        if(event.getItem().getType() == Material.DIAMOND_SWORD && !Game.hasStarted()){
            Inventory inv = Bukkit.createInventory(null, 27, "Kit Selector");
            for(Kit k : Kit.getAllKits()){
                inv.addItem(k.getDisplayItem());
                event.getPlayer().openInventory(inv);
            }
        }
    }

}
