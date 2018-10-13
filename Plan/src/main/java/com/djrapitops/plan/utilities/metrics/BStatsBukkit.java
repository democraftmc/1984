package com.djrapitops.plan.utilities.metrics;

import com.djrapitops.plan.Plan;
import com.djrapitops.plugin.api.Check;
import org.bstats.bukkit.Metrics;

public class BStatsBukkit {

    private final Plan plugin;
    private Metrics metrics;

    public BStatsBukkit(Plan plugin) {
        this.plugin = plugin;
    }

    public void registerMetrics() {
        if (metrics == null) {
            metrics = new Metrics(plugin);
        }
        registerConfigSettingGraphs();
    }

    private void registerConfigSettingGraphs() {
        String serverType = plugin.getServer().getName();
        if ("CraftBukkit".equals(serverType) && Check.isSpigotAvailable()) {
            serverType = "Spigot";
        }
        String databaseType = plugin.getSystem().getDatabaseSystem().getDatabase().getName();

        addStringSettingPie("server_type", serverType);
        addStringSettingPie("database_type", databaseType);
    }

    protected void addStringSettingPie(String id, String setting) {
        metrics.addCustomChart(new Metrics.SimplePie(id, () -> setting));
    }
}
