package me.usainsrht.persistentdeathdrops.listener;

import de.tr7zw.changeme.nbtapi.NBT;
import me.usainsrht.persistentdeathdrops.PersistentDeathDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupListener implements Listener {

    private PersistentDeathDrops plugin;

    public PickupListener(PersistentDeathDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        boolean isPersistent = plugin.isPersistent(e.getItem().getItemStack());
        if (isPersistent) {
            NBT.modify(e.getItem().getItemStack(), nbt -> {
                nbt.removeKey(PersistentDeathDrops.PERSISTENT_KEY);
            });
        }
    }
}
