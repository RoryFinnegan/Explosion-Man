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

package com.gmail.bunnehrealm.explosionman.sticks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitScheduler;

import com.gmail.bunnehrealm.explosionman.MainClass;
import com.gmail.bunnehrealm.explosionman.Listeners.PreventDamage;

public class LeapStick implements Listener {
	public MainClass MainClass;
	public PreventDamage damageListen = new PreventDamage(this);
	public boolean god;
	public Player theplayer;
	public boolean doDamage;
	private int damagecount;
	private int id;

	public LeapStick(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeap(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		theplayer = player;
		Action action = event.getAction();
		if (player.hasPermission("explosionman.leapstick")) {
			if (action.equals(Action.RIGHT_CLICK_AIR)) {
				Location pLocation = event.getPlayer().getLocation();
				double pX = pLocation.getX();
				double pY = pLocation.getY();
				double pZ = pLocation.getZ();
				World world = event.getPlayer().getWorld();
				int blockID = player.getItemInHand().getTypeId();
				if (MainClass.players.getString("players." + player.getName()
						+ ".settings.leapstickid") != null) {
					player.sendMessage("id = " + MainClass.players.getString("players." + player.getName()
							+ ".settings.leapstickid"));
					player.sendMessage("not null");
					int tool = MainClass.players.getInt("players." + player.getName() + ".leapstickid");
					player.sendMessage("Tool found");
					player.sendMessage(Integer.toString(blockID));
					if (blockID == tool) {
						{
							player.sendMessage("initiate");
							if (MainClass.getConfig()
									.getBoolean("leapstickmsg")) {
								String fexplodemsg = MainClass.getConfig()
										.getString("leapsticktxt");
								player.sendMessage(fexplodemsg);
							}
							if (MainClass.getConfig().getBoolean(
									"leapstickexlpode")) {
								god = true;
								world.createExplosion(
										pX,
										pY,
										pZ,
										MainClass.getConfig().getInt(
												"leapstartpower"),
										MainClass.getConfig().getBoolean(
												"leapstickfire"),
										MainClass.getConfig().getBoolean(
												"leapstickblocks"));
							}
							player.sendMessage("leap");
							player.setVelocity(player
									.getEyeLocation()
									.getDirection()
									.multiply(
											MainClass.getConfig().getInt(
													"leapdefault")));
							player.sendMessage("done leap");
							god = false;
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
						}
					} else if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
						if (blockID == tool) {
							{
								if (MainClass.getConfig().getBoolean(
										"leapstickexlpode")) {
									world.createExplosion(
											pX,
											pY,
											pZ,
											MainClass.getConfig().getInt(
													"leapstickpower"),
											MainClass.getConfig().getBoolean(
													"leapstickfire"),
											MainClass.getConfig().getBoolean(
													"leapstickblocks"));
								}
								player.setVelocity(player
										.getEyeLocation()
										.getDirection()
										.multiply(
												MainClass.getConfig().getInt(
														"leapdefault")));
							}
						}
					}
				} 
				else if (MainClass.players.getString("players."
						+ player.getName() + ".settings.leapstickid") == null) {
					if (blockID == MainClass.getConfig().getInt("leapstickid")) {
						{
							if (MainClass.getConfig()
									.getBoolean("leapstickmsg")) {
								String fexplodemsg = MainClass.getConfig()
										.getString("leapsticktxt");
								player.sendMessage(fexplodemsg);
							}
							if (MainClass.getConfig().getBoolean(
									"leapstickexlpode")) {
								god = true;
								world.createExplosion(
										pX,
										pY,
										pZ,
										MainClass.getConfig().getInt(
												"leapstartpower"),
										MainClass.getConfig().getBoolean(
												"leapstickfire"),
										MainClass.getConfig().getBoolean(
												"leapstickblocks"));
							}
							player.setVelocity(player
									.getEyeLocation()
									.getDirection()
									.multiply(
											MainClass.getConfig().getInt(
													"leapdefault")));
							god = false;
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
						}
					} else if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
						if (blockID == MainClass.getConfig().getInt(
								"leapstickid")) {
							{
								if (MainClass.getConfig().getBoolean(
										"leapstickexlpode")) {
									world.createExplosion(
											pX,
											pY,
											pZ,
											MainClass.getConfig().getInt(
													"leapstickpower"),
											MainClass.getConfig().getBoolean(
													"leapstickfire"),
											MainClass.getConfig().getBoolean(
													"leapstickblocks"));
								}
								player.setVelocity(player
										.getEyeLocation()
										.getDirection()
										.multiply(
												MainClass.getConfig().getInt(
														"leapdefault")));
							}
						}
					}
				}
			}
		}
	}
}
