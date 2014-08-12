
package me.baileypayne.minigamesetup.utils;

import org.bukkit.entity.Player;

/**
 *
 * @author Bailey
 */
public class InvUtil {
    
    public static void ClearInv(Player player){
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
        player.updateInventory();
    }
    

}
