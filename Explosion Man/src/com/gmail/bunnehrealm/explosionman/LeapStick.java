
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

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeapStick implements Listener {
	public MainClass MainClass;

	public LeapStick(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLeap(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
		if (player.hasPermission("explosionman.leapstick")) {
			if (action.equals(Action.RIGHT_CLICK_AIR)) {
				Location pLocation = event.getPlayer().getLocation();
				double pX = pLocation.getX();
				double pY = pLocation.getY();
				double pZ = pLocation.getZ();
				World world = event.getPlayer().getWorld();
				int blockID = player.getItemInHand().getTypeId();
				if (blockID == MainClass.getConfig().getInt("leapstickid")) {
					{
						if(MainClass.getConfig().getBoolean("leapstickmsg")){
							String fexplodemsg = MainClass.getConfig().getString("leapsticktxt").replaceAll("(&([a-f0-9]))", "\u00A7$2");
							player.sendMessage(fexplodemsg);
						}
						if (MainClass.getConfig()
								.getBoolean("leapstickexlpode")) {
							world.createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("leapstartpower"),MainClass.getConfig().getBoolean("leapstickfire"), MainClass.getConfig().getBoolean("leapstickblocks") );}
							player.setVelocity(player
									.getEyeLocation()
									.getDirection()
									.multiply(
											MainClass.getConfig().getInt(
													"leapdefault")));
						}
					}
				else if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
					if (blockID == MainClass.getConfig().getInt("leapstickid")) {
						{
							if (MainClass.getConfig()
									.getBoolean("leapstickexlpode")) {
								world.createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("leapstickpower"),MainClass.getConfig().getBoolean("leapstickfire"), MainClass.getConfig().getBoolean("leapstickblocks") ); }
								player.setVelocity(player
										.getEyeLocation()
										.getDirection()
										.multiply(
												MainClass.getConfig().getInt(
														"leapdefault")));
							}
						}}

			} 
				}
			}
		}
