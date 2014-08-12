
package me.baileypayne.minigamesetup.listeners.players;

import me.baileypayne.minigamesetup.MinigameSetup;
import me.baileypayne.minigamesetup.handlers.Game;
import me.baileypayne.minigamesetup.listeners.MGListener;
import me.baileypayne.minigamesetup.utils.InvUtil;
import me.baileypayne.minigamesetup.utils.LocationUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        InvUtil.ClearInv(e.getPlayer());
        ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(ChatColor.GREEN + "Kits");
        is.setItemMeta(im);
        e.getPlayer().updateInventory();
    }
    
}
