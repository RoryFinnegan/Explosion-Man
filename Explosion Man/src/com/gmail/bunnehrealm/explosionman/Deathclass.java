
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
import org.bukkit.event.entity.PlayerDeathEvent;

public class Deathclass implements Listener {
	public static MainClass MainClass;
	@SuppressWarnings("static-access")
	public Deathclass(MainClass MainClass){
		this.MainClass = MainClass;
	}
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player player = e.getEntity();
		if(player.hasPermission("explosionman.deathexplode")){
			@SuppressWarnings("unused")
			boolean willdie = MainClass.getConfig().getBoolean("death");
			if(willdie = true){
				Location pLocation = player.getLocation();
				World world = player.getWorld();
				world.createExplosion(pLocation, MainClass.getConfig().getInt("deathpower"));
				if(player.hasPermission("explosionman.deathlightning")){
					world.strikeLightningEffect(pLocation);
				}
			}
		}
	}

}
