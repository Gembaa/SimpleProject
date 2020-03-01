package me.dionjava.armor.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


import me.dionjava.armor.utils.PRUtils;

public class PRCommands implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("check")) {
				if (player.hasPermission("check.simplepr")) {
					if (args.length == 0) {
						PRUtils.sendPlayerMessage(player, "&eUsage: &d/check <player>");
						return true;
					}
					
					@SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer(args[0]);
					if (target.isOnline()) {
						PRUtils.playerCheckSimplePR(target);
						PRUtils.sendPlayerMessage(player, "&e" + target.getName() + " &cis gecheckt!!");
						return true;
					} else {
						PRUtils.sendPlayerMessage(player,
								"&d" + target.getName() + " is niet online//player niet gevonden!");
						return true;
					}
				} else {
					player.sendMessage(ChatColor.AQUA + "Je hebt hier geen perms voor!");
					return true;
				}
			}
		} else {
			sender.sendMessage(ChatColor.AQUA + "Je moet een speler / staff zijnde zijn met deze perms!");
			return true;
		}
		return true;
	}

}
