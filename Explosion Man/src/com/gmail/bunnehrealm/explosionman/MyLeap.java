/*Explosion Man for general explosions on Bukkit
 Copyright (C) 2013  Rory Finnegan
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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