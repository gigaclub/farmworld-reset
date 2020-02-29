package gigaclub.farmworldreset.commands;

import gigaclub.farmworldreset.Main;
import gigaclub.farmworldreset.server.Farmworld;
import gigaclub.farmworldreset.server.NormalFarmworld;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import systems.reformcloud.reformcloud2.executor.api.common.ExecutorAPI;
import systems.reformcloud.reformcloud2.executor.api.common.api.group.GroupSyncAPI;
import systems.reformcloud.reformcloud2.executor.api.common.groups.MainGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandInitPlugin extends Command {

    public CommandInitPlugin() {
        super("initPlugin");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        initStuff();
    }

    public void initStuff() {

        System.out.println("create list for subgroups");

        List<String> subGroups = new ArrayList<>();

        subGroups.add("Normal");
        subGroups.add("Nether");
        subGroups.add("End");

        System.out.println("list created");

        System.out.println("create maingroup and add subgroups");
        GroupSyncAPI gaPI = ExecutorAPI.getInstance().getSyncAPI().getGroupSyncAPI();
        MainGroup mg = gaPI.createMainGroup("Farmwelten", subGroups);
        System.out.println("maingroup created and subgroups added");

        try {
            Configuration config = Main.getPlugin().loadConfig();

            if(config.get("fwp.init") != null) {
                config.set("fwp.init", true);
            }

            for(String s : mg.getSubGroups()) {
                config.set("fwp." + mg.getName() + ".subgroups." + s , new ArrayList<Farmworld>());
            }

            Main.getPlugin().createServer();
            Main.getPlugin().saveConfig(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.getPlugin().getProxy().getPluginManager().unregisterCommand(this);

    }
}
