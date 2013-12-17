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

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.gmail.bunnehrealm.explosionman.sticks.LeapStick;

public class PreventDamage implements Listener {
	public static MainClass MainClass;

	@SuppressWarnings("static-access")
	public PreventDamage(MainClass MainClass) {
		this.MainClass = MainClass;
	}
	public static LeapStick LeapStick;
	@SuppressWarnings("static-access")
	public PreventDamage(LeapStick LeapStick) {
		this.LeapStick = LeapStick;
	}
	
	public static LeapClass LeapClass;
	@SuppressWarnings("static-access")
	public PreventDamage(LeapClass LeapClass) {
		this.LeapClass = LeapClass;
	}

	public static Explodecmd Explodecmd;


	@SuppressWarnings("static-access")
	public PreventDamage(Explodecmd Explodecmd) {
		this.Explodecmd = Explodecmd;
	}
	
	public static LaunchClass LaunchClass;
	@SuppressWarnings("static-access")
	public PreventDamage(LaunchClass LaunchClass) {
		this.LaunchClass = LaunchClass;
	}
	

	@EventHandler
	public void onPain(EntityDamageEvent e) {
		if (e.getEntity() == (Entity) Explodecmd.theplayer || e.getEntity() == (Entity) LeapStick.theplayer || e.getEntity() == (Entity) LaunchClass.theplayer || e.getEntity() == (Entity) LeapClass.theplayer ) {
			if(Explodecmd.god || LeapStick.god || LaunchClass.god || LeapClass.god ){
				e.setCancelled(true);
			}
			else if(LaunchClass.doDamage || LeapClass.doDamage || LeapStick.doDamage){
				
				if(e.getCause() == EntityDamageEvent.DamageCause.FALL){
				e.setCancelled(true);
				}
			}
			else{
				e.setCancelled(false);
			}
		}
		else{
			e.setCancelled(false);
		}
	}
}
