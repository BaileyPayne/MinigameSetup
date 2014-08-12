
package me.baileypayne.minigamesetup.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.baileypayne.minigamesetup.utils.ChatUtilities;
import me.baileypayne.minigamesetup.utils.InvUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;

/**
 *
 * @author Bailey
 */
public class Kit {
    
    private static List<Kit> allKits = new ArrayList<>();
    
    private static HashMap<String, Kit> playerKits = new HashMap<>();
    
    private String name, permission;
    
    private List<ItemStack> items = new ArrayList<>();
    
    private int displayItem;
    
    public Kit(String name, List<String> items, int displayItem){
        this.name = name;
        this.permission = "minigame.kit." + name;
        this.displayItem = displayItem;
        
        for(String s : items){
            int id = 0, amount = 1;
            if(s.contains(":")){
                String[] splitItem = s.split(":");
                id = Integer.valueOf(splitItem[0].trim());
                amount = Integer.valueOf(splitItem[1].trim());
            }
            else{
                id = Integer.valueOf(s.trim());
                this.items.add(new ItemStack(id, amount));
            }
            allKits.add(this);
        }
    }
    public static boolean isKit(String name){
        for(Kit k : allKits){
            if(name.equalsIgnoreCase(k.getName())){
                return true;
            }
            
        }
        return false;
        
    }
    public static Kit getKit(String name){
        for(Kit k : allKits){
            if(name.equalsIgnoreCase(name)){
                return k;
            }
        }
        return null;
    }
    public static void setKit(Player player, Kit kit){
        if(player.hasPermission(kit.getPermissionNode())) {
            ChatUtilities.sendMessage(player, "Insufficient Permission");
            return;
        }
            playerKits.put(player.getName(), kit);
    }
    public static Kit getKit(Player player){
        return playerKits.get(player.getName() ==  null ? allKits.get(0)
                : playerKits.get(player.getName()));
    }
    
    public void setKit(Player player){
        setKit(player, this);
    }
    public void giveKit(Player player){
        InvUtil.ClearInv(player);
        for(ItemStack is: items){
            player.getInventory().addItem(is);
        }
    }
    
    public String getName(){
        return name;
    }
    public static List<Kit> getAllKits(){
        return allKits;
    }
    
    public ItemStack getDisplayItem(){
        ItemStack is = new ItemStack(displayItem);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return is;
    }
    public Permission getPermissionNode(){
        return new Permission(permission);
    }
    

}
