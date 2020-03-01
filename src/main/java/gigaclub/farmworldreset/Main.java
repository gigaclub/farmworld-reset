package gigaclub.farmworldreset;

import com.google.common.io.ByteStreams;
import gigaclub.farmworldreset.commands.CommandCreateFarmworld;
import gigaclub.farmworldreset.commands.CommandInitPlugin;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.*;

public final class Main extends Plugin {

    public static Main plugin;

    @Override
    public void onEnable() {
        setPlugin(this);

        createConfig();
        initConfig();

        try {
            Configuration config = loadConfig();
            if(config.getBoolean("fwp.init")) {
                registerCommands();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {

    }

    public static Main getPlugin() {
        return plugin;
    }

    private static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    public void registerCommands() {
        getProxy().getPluginManager().registerCommand(this, new CommandCreateFarmworld());
    }

    public Configuration loadConfig() throws IOException {
        return ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
    }

    public void saveConfig(Configuration configuration) {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                try (InputStream is = getResourceAsStream("config.yml");
                     OutputStream os = new FileOutputStream(configFile)) {
                    ByteStreams.copy(is, os);
                }
            } catch (IOException e) {
                throw new RuntimeException("Unable to create configuration file", e);
            }
        }
    }

    public void initConfig() {
        try {
            Configuration config = loadConfig();

            if(config.get("fwp.init") == null) {
                config.set("fwp.init", false);
            }

            if(!config.getBoolean("fwp.init")) {
                getProxy().getPluginManager().registerCommand(this, new CommandInitPlugin());
            }

            saveConfig(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createServer() {

    }

}
