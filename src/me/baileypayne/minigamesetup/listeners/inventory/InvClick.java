
package me.baileypayne.minigamesetup.listeners.inventory;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Kit;
import me.baileypayne.minigamesetup.listeners.MGListener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bailey
 */
public class InvClick extends MGListener {
    
    public InvClick(MinigameSetup pl){
        super(pl);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        if(!event.getInventory().getName().equalsIgnoreCase("Kit Selector")) {
            return;
        }
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();
        ItemStack i = event.getCurrentItem();
        
        if(i == null){
            return;
        }
        if(i.getType() == null || i.getType() == Material.AIR){
            return;
        }
        Kit k = Kit.getKit(i.getItemMeta().getDisplayName());
        Kit.setKit(player, k);
        player.sendMessage(ChatColor.GREEN + "Kits " + k.getName() + " Is Selected!");
        
    }

}
