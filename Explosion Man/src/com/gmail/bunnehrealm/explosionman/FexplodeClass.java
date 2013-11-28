
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
			if(!(cs instanceof Player)){
				MainClass.getLogger().info("That is a player only command!");
			}
		else if(cs instanceof Player){
			if (player.hasPermission("explosionman.fexplode") || player.isOp()) {
				@SuppressWarnings("unused")
				boolean canexplode = true;
				@SuppressWarnings("deprecation")
				Block lookBlock = player.getTargetBlock(null, 200);
				Location plocation = lookBlock.getLocation();
				double pX = plocation.getX();
				double pY = plocation.getY();
				double pZ = plocation.getZ();
				if (args.length == 0) {
					if(MainClass.getConfig().getBoolean("fexplodemsg")){
						String fexplodemsg = MainClass.getConfig().getString("fexplodetext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(fexplodemsg);
					}
					w.createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("fexplodepower"),MainClass.getConfig().getBoolean("fexplodefire"), MainClass.getConfig().getBoolean("fexplodeblocks") );
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
						if (player.hasPermission("explosionman.fexplodebig") || player.isOp()) {
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
						w.createExplosion(pX, pY, pZ, explosionPower ,MainClass.getConfig().getBoolean("fexplodefire"), MainClass.getConfig().getBoolean("fexplodeblocks") );
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
			}
		return false;
	}

}
