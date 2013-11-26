
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
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LaunchClass implements CommandExecutor {
	public MainClass MainClass;

	public LaunchClass(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String string,
			String[] args) {
		Player player = (Player) cs;
		Location pLocation = player.getLocation();
		World w = player.getWorld();
		if (string.equalsIgnoreCase("Launch")) {
			if (player.hasPermission("explosionman.launch")) {
				if (args.length == 0) {
					w.createExplosion(pLocation,
							MainClass.getConfig().getInt("launchpower"));

					player.setVelocity(new Vector(0, MainClass.getConfig()
							.getDouble("launchheight"), 0));
					if(MainClass.getConfig().getBoolean("launchmsg")){
						String explodemsg = MainClass.getConfig().getString("launchtxt").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}
				} else if (args.length == 1) {
					try {
						Float.parseFloat(args[0]);
					} catch (NumberFormatException e) {
						player.sendMessage(ChatColor.RED + "Proper use is "
								+ ChatColor.AQUA + "/launch [number]");
						return false;
					}
					if (Float.parseFloat(args[0]) > 10.0) {
						player.sendMessage(ChatColor.RED
								+ "Cannot allow you to use more than 10 in height!");
						return false;
					}
					w.createExplosion(pLocation,
							MainClass.getConfig().getInt("launchpower"));
					player.setVelocity(new Vector(0, Float.parseFloat(args[0]),
							0));
					if(MainClass.getConfig().getBoolean("launchmsg")){
						String explodemsg = MainClass.getConfig().getString("launchtxt").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}

				}
				else if(args.length > 1){
					player.sendMessage(ChatColor.RED + "Proper use is "
							+ ChatColor.AQUA + "/launch [number]");
				}			
			}
		}
		return false;
	}

}
