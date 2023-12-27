package me.usainsrht.persistentdeathdrops;

import de.tr7zw.changeme.nbtapi.NBT;
import me.usainsrht.persistentdeathdrops.listener.DeathListener;
import me.usainsrht.persistentdeathdrops.listener.ItemDespawnListener;
import me.usainsrht.persistentdeathdrops.listener.PickupListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PersistentDeathDrops extends JavaPlugin {

    private static PersistentDeathDrops instance;
    public static final String PERSISTENT_KEY = "pdd;persistent";
    private static final int pluginID = 20560;
    private Metrics metrics;

    @Override
    public void onEnable() {

        instance = this;

        this.metrics = new Metrics(this, pluginID);

        registerListeners(getServer().getPluginManager());

    }

    @Override
    public void onDisable() {

    }

    public boolean isPersistent(ItemStack itemStack) {
        return itemStack != null && itemStack.getType() != Material.AIR && NBT.get(itemStack, nbt -> { return nbt.hasTag(PERSISTENT_KEY); });
    }

    public static PersistentDeathDrops getInstance() {
        return instance;
    }

    public void registerListeners(PluginManager pluginManager) {
        pluginManager.registerEvents(new DeathListener(this), this);
        pluginManager.registerEvents(new ItemDespawnListener(this), this);
        pluginManager.registerEvents(new PickupListener(this), this);
    }
}
