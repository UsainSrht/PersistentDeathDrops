package me.usainsrht.persistentdeathdrops.listener;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupListener implements Listener {

    @EventHandler
    public void onPickup(PlayerPickupItemEvent e) {
        boolean isPersistent = NBT.get(e.getItem().getItemStack(), nbt -> nbt.hasTag("persistent"));
        if (isPersistent) {
            NBT.modify(e.getItem().getItemStack(), nbt -> {
                nbt.removeKey("pdd;persistent");
            });
        }
    }
}
