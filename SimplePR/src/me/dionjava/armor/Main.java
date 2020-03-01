package me.dionjava.armor;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.dionjava.armor.commands.PRCommands;
import me.dionjava.armor.utils.PRUtils;

public class Main extends JavaPlugin {

	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;

		registerListeners();
		registerStatic();
		registerCommand();
		PRUtils.sendConsoleMessage("Enabled!");
	}

	@Override
	public void onDisable() {
		PRUtils.sendConsoleMessage("Disabled!");
	}

	private void registerListeners() {
		PluginManager spr = Bukkit.getServer().getPluginManager();
		spr.registerEvents(new PRCommands(), this);
		spr.registerEvents(new PRUtils(), this);
	}

	private void registerStatic() {
		PRUtils.checkedPlayers = new ArrayList<Player>();
		PRUtils.time = new HashMap<Player, Integer>();
		PRUtils.task = new HashMap<Player, BukkitRunnable>();
	}

	private void registerCommand() {
		getCommand("check").setExecutor(new PRCommands());
	}
}