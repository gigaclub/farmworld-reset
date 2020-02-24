package gigaclub.farmworldreset;

import net.md_5.bungee.api.plugin.Plugin;

public final class Main extends Plugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        setPlugin(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }

    private static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }
}
