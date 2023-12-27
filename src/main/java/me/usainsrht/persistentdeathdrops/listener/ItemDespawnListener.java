package me.usainsrht.persistentdeathdrops.listener;

import de.tr7zw.changeme.nbtapi.NBT;
import me.usainsrht.persistentdeathdrops.PersistentDeathDrops;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.util.Vector;

import static org.bukkit.event.entity.EntityDamageEvent.DamageCause.*;

public class ItemDespawnListener implements Listener {

    private PersistentDeathDrops plugin;

    public ItemDespawnListener(PersistentDeathDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDespawn(ItemDespawnEvent e) {
        boolean isPersistent = plugin.isPersistent(e.getEntity().getItemStack());
        if (isPersistent) e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Item) {
            Item item = (Item) e.getEntity();
            boolean isPersistent = plugin.isPersistent(item.getItemStack());
            if (!isPersistent) return;
            e.setCancelled(true);
            if (e.getCause() == FIRE || e.getCause() == FIRE_TICK || e.getCause() == LAVA) {
                e.getEntity().setFireTicks(-99999);
                e.getEntity().setVelocity(new Vector(0,0.05,0));
            }
        }
    }
}
