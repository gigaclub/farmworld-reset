package gigaclub.farmworldreset.commands;

import gigaclub.farmworldreset.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class CommandCreateFarmworld extends Command {

    public CommandCreateFarmworld() {
        super("createFarmworld");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(new ComponentBuilder("Hello world!").color(ChatColor.GREEN).create());
    }
}
