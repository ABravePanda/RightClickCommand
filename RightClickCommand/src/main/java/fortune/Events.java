package fortune;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener
{
    private Main plugin;
    
    public Events(Main plugin)
    {
    	this.plugin = plugin;
    }
    
    
    @EventHandler
    public void onRightClick(PlayerInteractEvent e)
    {
	Player p = e.getPlayer();
	ItemStack itemInMainHand = p.getInventory().getItemInMainHand();
	
	//if player right clicked w/main hand
	if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getHand() == EquipmentSlot.HAND)
	{
	    //if item is diamond pickaxe
	    if(itemInMainHand.getType() == Material.DIAMOND_PICKAXE)
	    {
		//if there are enchants
		if(itemInMainHand.getEnchantments().size() != 0)
		{
		    //grab commands
		    List<String> commands = (List<String>) plugin.getConfig().get("commands");
		    
		    //loop thru em
		    for(String cmd : commands)
		    {
			//dispatch command as player, dont forget placeholder
			Bukkit.dispatchCommand(p, cmd.replace("%player%", p.getName()));
		    }
		}
	    }
	}
    }

}
