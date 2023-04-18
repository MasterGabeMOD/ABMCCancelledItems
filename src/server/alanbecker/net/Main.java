package server.alanbecker.net;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    static World plotworld = Bukkit.getWorld("plotworld");

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("ABMC Cancelled Items successfully enabled!");
    }


    public void onDisable() {
        getLogger().info("ABMC Cancelled Items successfully disabled!");
    }

    @EventHandler
    public void onBlockDispense(BlockDispenseEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPistonExtend(BlockPistonExtendEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPistonRetract(BlockPistonRetractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockRedstone(BlockRedstoneEvent e) {
        e.setNewCurrent(0);
    }

    @EventHandler
    public void onHopperItemPickup(InventoryPickupItemEvent e) {
        if (e.getInventory().getType().equals(InventoryType.HOPPER)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE &&
            (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SURVIVAL)) {
            e.setCancelled(true);
        }
    }
}

//testing for discord bot