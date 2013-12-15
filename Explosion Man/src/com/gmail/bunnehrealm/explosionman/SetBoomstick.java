package com.gmail.bunnehrealm.explosionman;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SetBoomstick implements CommandExecutor {
	public MainClass MainClass;

	public SetBoomstick(MainClass MainClass) {
		this.MainClass = MainClass;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String string,
			String[] args) {
		if (string.equalsIgnoreCase("setboomstick")) {
			if (cs.isOp() || cs.hasPermission("explosionman.setboomstick")) {
				if (args.length == 0) {
					cs.sendMessage(ChatColor.RED + "The proper usage is "
							+ ChatColor.AQUA + "/setboomstick [id]");
				} else if (args.length == 1) {

					try {
						Integer.parseInt(args[0]);
					} catch (NumberFormatException c) {
						cs.sendMessage(ChatColor.RED + "The proper usage is "
								+ ChatColor.AQUA + "/setboomstick [id]");
						return false;
					}

					MainClass.getConfig().set("boomitem",
							Integer.parseInt(args[0]));
					cs.sendMessage(ChatColor.GOLD + "SET!");
				} else if (args.length > 1) {
					cs.sendMessage(ChatColor.RED + "The proper usage is "
							+ ChatColor.AQUA + "/setboomstick [id]");
				}
			} else {
				cs.sendMessage(ChatColor.RED
						+ "You do not have permission to use this command!");
			}
		}
		return false;
	}

}
