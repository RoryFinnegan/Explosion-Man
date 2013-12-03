
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

public class LeapClass implements CommandExecutor {
	public PreventDamage damageListen = new PreventDamage(this);
	public MainClass MainClass;
	public boolean god;
	public Player theplayer;
	public LeapClass(MainClass mainClass) {
        this.MainClass = mainClass;
    }


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string,
			String[] args) {
		if (string.equalsIgnoreCase("leap")) {
			if(!(sender instanceof Player)){
				MainClass.getLogger().info("That is a player only command!");
				return false;
			}
		else if(sender instanceof Player){
			Player player = (Player) sender;
			theplayer = player;
			Location pLocation = player.getLocation();
			double pX = pLocation.getX();
			double pY = pLocation.getY();
			double pZ = pLocation.getZ();
			World world = player.getWorld();
			if(player.hasPermission("explosionman.leap")){
			if (args.length == 0) {
				god = true;
				if(MainClass.getConfig().getBoolean("leapmsg")){
					String explodemsg = MainClass.getConfig().getString("leaptxt").replaceAll("(&([a-f0-9]))", "\u00A7$2");
					player.sendMessage(explodemsg);
				}
				if (MainClass.getConfig().getBoolean("leapexlpode")) {
					world.createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("fexplodepower"),MainClass.getConfig().getBoolean("fexplodefire"), MainClass.getConfig().getBoolean("fexplodeblocks") );
				}
				player.setVelocity(player.getEyeLocation().getDirection()
						.multiply(MainClass.getConfig().getInt("leapdefault")));
				god = false;

			} else if (args.length == 1) {
				try {
					Integer.parseInt(args[0]);
				} catch (NumberFormatException c) {
					player.sendMessage(ChatColor.RED + "The proper use is "
							+ ChatColor.AQUA + "/leap [number]");
					return false;
				}
				
				if(Integer.parseInt(args[0]) > 10){
					player.sendMessage(ChatColor.RED + "Maximum number is 10");
					return false;
				}
				if(MainClass.getConfig().getBoolean("leapmsg")){
					String explodemsg = MainClass.getConfig().getString("leaptxt").replaceAll("(&([a-f0-9]))", "\u00A7$2");
					player.sendMessage(explodemsg);
				}
				if (MainClass.getConfig().getBoolean("leapexlpode")) {
					god = true;
					world.createExplosion(pX, pY, pZ, MainClass.getConfig().getInt("leapstartpower"),MainClass.getConfig().getBoolean("leapfire"), MainClass.getConfig().getBoolean("leapblocks") );
					god = false;
				}
				player.setVelocity(player.getEyeLocation().getDirection()
						.multiply(Integer.parseInt(args[0])));
				
			}
		}
			else{
				player.sendMessage(ChatColor.RED + "You cannot leap!");}
		}
			}
return false;
}
	}
