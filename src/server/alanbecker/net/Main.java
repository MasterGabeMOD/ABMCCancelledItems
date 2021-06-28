package server.alanbecker.net;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.material.Redstone;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_16_R3.BlockRedstoneWire;


public class Main extends JavaPlugin implements Listener {
    static World plotworld = Bukkit.getWorld("plotworld");

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("ABMC Cancelled Items successfully enabled!");
    }

    public void onDisable() {
        getLogger().info("ABMC Cancelled Items successfully disabled!");
    }



    @EventHandler
    public void onPistonEvent(BlockPistonExtendEvent e){
            e.setCancelled(true);
        }
   
    
    @EventHandler
    public void onPistonEvent(BlockPistonRetractEvent e){
            e.setCancelled(true);
        }
    

	@EventHandler
	public void onBlockRedstone(BlockRedstoneEvent e){
		e.setNewCurrent(0);
    }


	@EventHandler
	public void onBlockDispenseEvent(BlockDispenseEvent e) {
		e.setCancelled(true);
}


	@EventHandler
	public void onHopperItemPickup(InventoryPickupItemEvent e) {
		if (e.getInventory().getType().equals(InventoryType.HOPPER))
			e.setCancelled(true); 
}
}



