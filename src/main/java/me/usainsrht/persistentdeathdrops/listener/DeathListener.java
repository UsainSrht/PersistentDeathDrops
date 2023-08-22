package me.usainsrht.persistentdeathdrops.listener;

import de.tr7zw.changeme.nbtapi.NBT;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getDrops().forEach(itemStack -> NBT.modify(itemStack, nbt -> {
            nbt.setBoolean("pdd;persistent", true);
        }));
    }

}
