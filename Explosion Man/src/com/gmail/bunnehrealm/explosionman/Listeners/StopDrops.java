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

package com.gmail.bunnehrealm.explosionman.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.gmail.bunnehrealm.explosionman.Explodecmd;
import com.gmail.bunnehrealm.explosionman.MainClass;

public class StopDrops implements Listener {
	public static MainClass MainClass;

	@SuppressWarnings("static-access")
	public StopDrops(MainClass MainClass) {
		this.MainClass = MainClass;
	}
	public static Explodecmd Explodecmd;

	@SuppressWarnings("static-access")
	public StopDrops(Explodecmd Explodecmd) {
		this.Explodecmd = Explodecmd;
	}
	
@EventHandler
public void onDrop(PlayerDropItemEvent e){
	
}
}
