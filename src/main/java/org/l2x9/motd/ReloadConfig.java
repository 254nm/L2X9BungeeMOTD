package org.l2x9.motd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class ReloadConfig extends Command {
    Motd plugin;

    public ReloadConfig(String name, Motd motd) {
        super(name);
        plugin = motd;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("l2x9motd.commands")) {
            if (args.length > 0) {
                switch (args[0]) {
                    case "reload":
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&b&lL2X9&r&3&lMotd&r]&a Reloaded configuration file"));
                        break;
                    case "help":
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&1 ---&r [&b&lL2X9&r&3&lMotd&r]&a Help&1 ---&r"));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&b&lL2X9&r&3&lMotd&r]&6 /motd reload&r&e| Reloads the config"));
                        break;
                    default:
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&b&lL2X9&r&3&lMotd&r]&c Please do /motd help for help"));
                        break;
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&b&lL2X9&r&3&lMotd&r]&c Please do /motd help for help"));
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&b&lL2X9&r&3&lMotd&r]&c No permission"));
        }
    }
}
