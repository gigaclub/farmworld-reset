package gigaclub.farmworldreset.commands;

import gigaclub.farmworldreset.Main;
import gigaclub.farmworldreset.helper.Helper;
import gigaclub.farmworldreset.server.EndFarmworld;
import gigaclub.farmworldreset.server.Farmworld;
import gigaclub.farmworldreset.server.NetherFarmworld;
import gigaclub.farmworldreset.server.NormalFarmworld;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;

import java.io.IOException;

public class CommandCreateFarmworld extends Command {

    public CommandCreateFarmworld() {
        super("createFarmworld");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 7) {
            String world = args[0].toLowerCase();
            switch (world) {
                case "normal":
                case "nether":
                case "end":
                    if (Helper.isInteger(args[2])) {
                        if (Helper.isDouble(args[3])) {
                            if (Helper.isDouble(args[4])) {
                                if (Helper.isDouble(args[5])) {
                                    if (Helper.isInteger(args[6])) {
                                        try {
                                            Farmworld farmworld;
                                            Configuration config = Main.getPlugin().loadConfig();
                                            if(world.equals("normal")) {
                                                farmworld = new NormalFarmworld(args[1],
                                                                                Integer.parseInt(args[2]),
                                                                                Double.parseDouble(args[3]),
                                                                                Double.parseDouble(args[4]),
                                                                                Double.parseDouble(args[5]),
                                                                                Integer.parseInt(args[6]));
                                            } else if(world.equals("nether")) {
                                                farmworld = new NetherFarmworld(args[1],
                                                                                Integer.parseInt(args[2]),
                                                                                Double.parseDouble(args[3]),
                                                                                Double.parseDouble(args[4]),
                                                                                Double.parseDouble(args[5]),
                                                                                Integer.parseInt(args[6]));
                                            } else {
                                                farmworld = new EndFarmworld(args[1],
                                                                            Integer.parseInt(args[2]),
                                                                            Double.parseDouble(args[3]),
                                                                            Double.parseDouble(args[4]),
                                                                            Double.parseDouble(args[5]),
                                                                            Integer.parseInt(args[6]));
                                            }
                                            config.set("fwp.Farmwelten.subgroups." + world.substring(0, 1).toUpperCase() + world.substring(1) + "." + farmworld.getName() + ".resettimer", farmworld.getResettimer());
                                            config.set("fwp.Farmwelten.subgroups." + world.substring(0, 1).toUpperCase() + world.substring(1) + "." + farmworld.getName() + ".spawn_x", farmworld.getSpawn_x());
                                            config.set("fwp.Farmwelten.subgroups." + world.substring(0, 1).toUpperCase() + world.substring(1) + "." + farmworld.getName() + ".spawn_y", farmworld.getSpawn_y());
                                            config.set("fwp.Farmwelten.subgroups." + world.substring(0, 1).toUpperCase() + world.substring(1) + "." + farmworld.getName() + ".spawn_z", farmworld.getSpawn_z());
                                            config.set("fwp.Farmwelten.subgroups." + world.substring(0, 1).toUpperCase() + world.substring(1) + "." + farmworld.getName() + ".slots", farmworld.getSlots());
                                            Main.getPlugin().saveConfig(config);
                                            sender.sendMessage(new ComponentBuilder("Die Farmwelt wurde erstellt!").color(ChatColor.GREEN).create());
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        sender.sendMessage(new ComponentBuilder("\"" + args[5] + "\" ist keine Slot Zahl").color(ChatColor.RED).create());
                                    }
                                } else {
                                    sender.sendMessage(new ComponentBuilder("\"" + args[4] + "\" ist keine Z Koordinate").color(ChatColor.RED).create());
                                }
                            } else {
                                sender.sendMessage(new ComponentBuilder("\"" + args[3] + "\" ist keine Y Koordinate").color(ChatColor.RED).create());
                            }
                        } else {
                            sender.sendMessage(new ComponentBuilder("\"" + args[2] + "\" ist keine X Koordinate").color(ChatColor.RED).create());
                        }
                    } else {
                        sender.sendMessage(new ComponentBuilder("\"" + args[1] + "\" ist keine ResetTimer Zahl").color(ChatColor.RED).create());
                    }
                    break;
                default:
                    sender.sendMessage(new ComponentBuilder("Diese Welt \"" + world + "\" existiert nicht").color(ChatColor.RED).create());
                    break;
            }
        } else {
            sender.sendMessage(new ComponentBuilder("Der Command heißt: /createfarmworld <normal|nether|end> <name> <spawn_x> <spawn_y> <spawn_z> <slotanzahl>!").color(ChatColor.RED).create());
        }
    }
}
