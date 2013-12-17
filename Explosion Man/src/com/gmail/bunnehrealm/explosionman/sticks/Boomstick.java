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

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.bunnehrealm.explosionman.MainClass;

public class Boomstick implements Listener {
	public MainClass MainClass;

	public Boomstick(MainClass mainClass) {
        this.MainClass = mainClass;
    }

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		if (player.hasPermission("explosionman.boomstick")) {
			@SuppressWarnings("deprecation")
			int blockId = player.getItemInHand().getTypeId();
			if (blockId == MainClass.getConfig().getInt("boomitem")) {
				Action a = e.getAction();
				if (a.equals(Action.RIGHT_CLICK_AIR)) {
					@SuppressWarnings("deprecation")
					Block block = player.getTargetBlock(null, 200);
					Location blocation = block.getLocation();
					double pX = blocation.getX();
					double pY = blocation.getY();
					double pZ = blocation.getZ();
					if(MainClass.getConfig().getBoolean("boomstickmsg")){
						String explodemsg = MainClass.getConfig().getString("boomsticktext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}
					player.getWorld().createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("boompower"),MainClass.getConfig().getBoolean("boomfire"), MainClass.getConfig().getBoolean("boomblocks") );
					if(player.hasPermission("explosionman.boomlightning")){
						player.getWorld().strikeLightningEffect(blocation);
					}
				}
				else if (a.equals(Action.RIGHT_CLICK_BLOCK)) {
					@SuppressWarnings("deprecation")
					Block block = player.getTargetBlock(null, 200);
					Location blocation = block.getLocation();
					double pX = blocation.getX();
					double pY = blocation.getY();
					double pZ = blocation.getZ();
					if(MainClass.getConfig().getBoolean("boomstickmsg")){
						String explodemsg = MainClass.getConfig().getString("boomsticktext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}
					player.getWorld().createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("boompower"),MainClass.getConfig().getBoolean("boomfire"), MainClass.getConfig().getBoolean("boomblocks") );
					if(player.hasPermission("explosionman.boomlightning")){
						player.getWorld().strikeLightningEffect(blocation);
					}
				}
			}
		}
	}
}
