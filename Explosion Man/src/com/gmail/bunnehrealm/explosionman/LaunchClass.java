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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

public class LaunchClass implements CommandExecutor {
	public PreventDamage damageListen = new PreventDamage(this);
	public int id;
	public int id2;
	public int id3;
	public int id4;
	public boolean blockdrop;
	public boolean doDrop;
	public int damagecount;
	public boolean doDamage = false;
	public MainClass MainClass;
	public boolean god;
	public Player theplayer;

	public LaunchClass(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String string,
			String[] args) {
		Player player = (Player) cs;
		theplayer = player;
		Location pLocation = player.getLocation();
		double pX = pLocation.getX();
		double pY = pLocation.getY();
		double pZ = pLocation.getZ();
		World w = player.getWorld();
		if (string.equalsIgnoreCase("Launch")) {
			if (cs instanceof Player) {
				if (player.hasPermission("explosionman.launch")
						|| player.isOp()) {
					blockdrop = MainClass.getConfig().getBoolean("dropblocks");
					if (blockdrop) {
						if (args.length == 0) {

							god = true;
							doDrop = false;
							w.createExplosion(
									pX,
									pY,
									pZ,
									MainClass.getConfig().getInt("launchpower"),
									MainClass.getConfig().getBoolean(
											"launchfire"),
									MainClass.getConfig().getBoolean(
											"launchblocks"));
							player.setVelocity(new Vector(0, MainClass
									.getConfig().getDouble("launchheight"), 0));
							god = false;
							doDrop = true;
							damagecount = 0;
							BukkitScheduler scheduler = Bukkit.getServer()
									.getScheduler();
							id = scheduler.scheduleSyncRepeatingTask(MainClass,
									new Runnable() {
										@Override
										public void run() {
											damagecount++;
											doDamage = true;
											if (damagecount == 10) {
												damagecount = 0;
												doDamage = false;
												Bukkit.getScheduler()
														.cancelTask(id);
											}

										}

									}, 0, 20L);
							theplayer.sendMessage(String.valueOf(doDamage));
							if (MainClass.getConfig().getBoolean("launchmsg")) {
								String explodemsg = MainClass
										.getConfig()
										.getString("launchtxt")
										.replaceAll("(&([a-f0-9]))", "\u00A7$2");
								player.sendMessage(explodemsg);
							}
						} else if (args.length == 1) {
							try {
								Float.parseFloat(args[0]);
							} catch (NumberFormatException e) {
								player.sendMessage(ChatColor.RED
										+ "Proper use is " + ChatColor.AQUA
										+ "/launch [number]");
								return false;
							}
							if (Float.parseFloat(args[0]) > 10.0) {
								player.sendMessage(ChatColor.RED
										+ "Cannot allow you to use more than 10 in height!");
								return false;
							}
							god = true;
							doDrop = false;
							damagecount = 0;
							BukkitScheduler scheduler = Bukkit.getServer()
									.getScheduler();
							id2 = scheduler.scheduleSyncRepeatingTask(
									MainClass, new Runnable() {
										@Override
										public void run() {
											damagecount++;
											doDamage = true;
											if (damagecount == 10) {
												damagecount = 0;
												doDamage = false;
												Bukkit.getScheduler()
														.cancelTask(id2);
											}

										}

									}, 0, 20L);
							w.createExplosion(
									pX,
									pY,
									pZ,
									MainClass.getConfig().getInt("launchpower"),
									MainClass.getConfig().getBoolean(
											"launchfire"),
									MainClass.getConfig().getBoolean(
											"launchblocks"));
							god = false;
							doDrop = true;
							player.setVelocity(new Vector(0, Float
									.parseFloat(args[0]), 0));
							if (MainClass.getConfig().getBoolean("launchmsg")) {
								String explodemsg = MainClass
										.getConfig()
										.getString("launchtxt")
										.replaceAll("(&([a-f0-9]))", "\u00A7$2");
								player.sendMessage(explodemsg);
							}

						} else if (args.length > 1) {
							player.sendMessage(ChatColor.RED + "Proper use is "
									+ ChatColor.AQUA + "/launch [number]");

						}
					} else if (!blockdrop) {
						if (args.length == 0) {

							god = true;
							doDrop = false;
							w.createExplosion(
									pX,
									pY,
									pZ,
									MainClass.getConfig().getInt("launchpower"),
									MainClass.getConfig().getBoolean(
											"launchfire"),
									MainClass.getConfig().getBoolean(
											"launchblocks"));
							player.setVelocity(new Vector(0, MainClass
									.getConfig().getDouble("launchheight"), 0));
							god = false;
							damagecount = 0;
							BukkitScheduler scheduler = Bukkit.getServer()
									.getScheduler();
							id3 = scheduler.scheduleSyncRepeatingTask(
									MainClass, new Runnable() {
										@Override
										public void run() {
											damagecount++;
											doDamage = true;
											if (damagecount == 10) {
												damagecount = 0;
												doDamage = false;
												Bukkit.getScheduler()
														.cancelTask(id3);
											}

										}

									}, 0, 20L);
							if (MainClass.getConfig().getBoolean("launchmsg")) {
								String explodemsg = MainClass
										.getConfig()
										.getString("launchtxt")
										.replaceAll("(&([a-f0-9]))", "\u00A7$2");
								player.sendMessage(explodemsg);
							}
						} else if (args.length == 1) {
							try {
								Float.parseFloat(args[0]);
							} catch (NumberFormatException e) {
								player.sendMessage(ChatColor.RED
										+ "Proper use is " + ChatColor.AQUA
										+ "/launch [number]");
								return false;
							}
							if (Float.parseFloat(args[0]) > 10.0) {
								player.sendMessage(ChatColor.RED
										+ "Cannot allow you to use more than 10 in height!");
								return false;
							}
							god = true;
							w.createExplosion(
									pX,
									pY,
									pZ,
									MainClass.getConfig().getInt("launchpower"),
									MainClass.getConfig().getBoolean(
											"launchfire"),
									MainClass.getConfig().getBoolean(
											"launchblocks"));
							god = false;
							damagecount = 0;
							BukkitScheduler scheduler = Bukkit.getServer()
									.getScheduler();
							id4 = scheduler.scheduleSyncRepeatingTask(
									MainClass, new Runnable() {
										@Override
										public void run() {
											damagecount++;
											doDamage = true;
											if (damagecount == 10) {
												damagecount = 0;
												doDamage = false;
												Bukkit.getScheduler()
														.cancelTask(id4);
											}

										}

									}, 0, 20L);
							doDrop = true;
							player.setVelocity(new Vector(0, Float
									.parseFloat(args[0]), 0));
							if (MainClass.getConfig().getBoolean("launchmsg")) {
								String explodemsg = MainClass
										.getConfig()
										.getString("launchtxt")
										.replaceAll("(&([a-f0-9]))", "\u00A7$2");
								player.sendMessage(explodemsg);
							}

						} else if (args.length > 1) {
							player.sendMessage(ChatColor.RED + "Proper use is "
									+ ChatColor.AQUA + "/launch [number]");
						}
					} else if (!(cs instanceof Player)) {
						MainClass.getLogger().info(
								"That is a player only command!");
						return false;

					}

				}
				return false;
			}
			return false;
		}
		return false;
	}
}
