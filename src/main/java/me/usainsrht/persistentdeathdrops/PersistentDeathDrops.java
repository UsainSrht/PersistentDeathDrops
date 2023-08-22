package me.usainsrht.persistentdeathdrops;

import me.usainsrht.persistentdeathdrops.listener.DeathListener;
import me.usainsrht.persistentdeathdrops.listener.ItemDespawnListener;
import me.usainsrht.persistentdeathdrops.listener.PickupListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PersistentDeathDrops extends JavaPlugin {

    private static PersistentDeathDrops instance;

    @Override
    public void onEnable() {

        instance = this;

        registerListeners(getServer().getPluginManager());

    }

    @Override
    public void onDisable() {

    }

    public static PersistentDeathDrops getInstance() {
        return instance;
    }

    public void registerListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new ItemDespawnListener(), this);
        pluginManager.registerEvents(new PickupListener(), this);
    }
}
