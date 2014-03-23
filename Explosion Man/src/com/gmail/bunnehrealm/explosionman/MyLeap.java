package com.gmail.bunnehrealm.explosionman;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyLeap implements CommandExecutor {
	public MainClass MainClass;

	public MyLeap(MainClass MainClass) {
		this.MainClass = MainClass;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String string,
			String[] args) {
		if (string.equalsIgnoreCase("myleap")) {
			if (!(cs instanceof Player)) {
				cs.sendMessage("This is a player only command!");
			} else {
				Player player = (Player) cs;
				if (player.hasPermission("explosionman.myleap")|| player.isOp()) {
					if (args.length == 0) {
						MainClass.players.set("players." + player.getName()
								+ ".settings.leapstickid", player.getItemInHand().getTypeId());
						MainClass.savePlayers();
						player.sendMessage(ChatColor.GOLD + "Set!");
					} else if (args.length == 1) {

						try {
							Integer.parseInt(args[0]);
						} catch (NumberFormatException c) {
							cs.sendMessage(ChatColor.RED
									+ "The proper usage is " + ChatColor.AQUA
									+ "/myleap [id]");
							return false;
						}
						if(args[0].equals("0")){
							MainClass.players.set("players." + player.getName()
									+ ".settings.leapstickid", null);
							return false;
						}
						else
						MainClass.players.set("players." + player.getName()
								+ ".settings.leapstickid", args[0]);
						MainClass.savePlayers();
						player.sendMessage(ChatColor.GOLD + "Set!");
					}
					else{
						cs.sendMessage(ChatColor.RED
								+ "The proper usage is " + ChatColor.AQUA
								+ "/myleap [id]");
						return false;
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "You Do not have permission to use this command!");
				}
			}
			return false;
		}
		return false;

	}
}