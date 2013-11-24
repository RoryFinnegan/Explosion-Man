package com.gmail.bunnehrealm.explosionman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FexplodeClass implements CommandExecutor {
	public static MainClass MainClass;

	@SuppressWarnings("static-access")
	public FexplodeClass(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command command, String string,
			String[] args) {
		Player player = (Player) cs;
		World w = Bukkit.getServer().getWorld("World");
		if (string.equalsIgnoreCase("fexplode")) {
			if (player.hasPermission("explosionman.fexplode")) {
				@SuppressWarnings("unused")
				boolean canexplode = true;
				@SuppressWarnings("deprecation")
				Block lookBlock = player.getTargetBlock(null, 200);
				Location plocation = lookBlock.getLocation();
				if (args.length == 0) {
					if(MainClass.getConfig().getBoolean("fexplodemsg")){
						String fexplodemsg = MainClass.getConfig().getString("fexplodetext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(fexplodemsg);
					}
					w.createExplosion(plocation,
							MainClass.getConfig().getInt("fexplodepower"));
					if (player.hasPermission("explosionman.fexplodelightning")) {
						w.strikeLightningEffect(plocation);
					}
				} else if (args.length == 1) {
					try {
						@SuppressWarnings("unused")
						float explosionPower = Float.parseFloat(args[0]);
					} catch (NumberFormatException e) {
						player.sendMessage(ChatColor.RED
								+ "That is not a number!");
						return false;
					}
					float explosionPower = Float.parseFloat(args[0]);
					if (explosionPower > MainClass.getConfig().getInt(
							"fexplodebigpower")) {
						if (player.hasPermission("explosionman.fexplodebig")) {
							canexplode = true;
						} else {
							player.sendMessage(ChatColor.RED
									+ "You do not have permission to create such a large explosion!");
							canexplode = false;
							return false;
						}
					}
					if (canexplode = true) {
						if(MainClass.getConfig().getBoolean("fexplodemsg")){
							String fexplodemsg = MainClass.getConfig().getString("fexplodetext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
							player.sendMessage(fexplodemsg);
						}
						w.createExplosion(plocation, explosionPower);
						if (player
								.hasPermission("explosionman.fexplodelightning")) {
							w.strikeLightningEffect(plocation);
						}
					}
				} else if (args.length > 1) {
					player.sendMessage(ChatColor.RED + "The proper use is "
							+ ChatColor.AQUA + "/fexplode [number]");
				}

			} else {
				player.sendMessage(ChatColor.RED
						+ "You cannot make an explosion over there!");
			}
		}
		return false;
	}

}
