package me.usainsrht.persistentdeathdrops.listener;

import de.tr7zw.changeme.nbtapi.NBT;
import me.usainsrht.persistentdeathdrops.PersistentDeathDrops;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    private PersistentDeathDrops plugin;

    public DeathListener(PersistentDeathDrops plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getDrops().forEach(itemStack -> NBT.modify(itemStack, nbt -> {
            nbt.setBoolean(PersistentDeathDrops.PERSISTENT_KEY, true);
        }));
    }

}
