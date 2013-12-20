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

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplodeKit implements CommandExecutor {
	public MainClass MainClass;

	public ExplodeKit(MainClass mainClass) {
		this.MainClass = mainClass;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string,
			String[] args) {
		Player player = (Player) sender;
		PlayerInventory inventory = player.getInventory();
		@SuppressWarnings("deprecation")
		ItemStack leap = new ItemStack(MainClass.getConfig().getInt(
				"leapstickid"), 1);
		@SuppressWarnings("deprecation")
		ItemStack boom = new ItemStack(MainClass.getConfig().getInt("boomitem"), 1);
		if (string.equalsIgnoreCase("explodekit")) {
			if (player.hasPermission("explosionman.kit") || player.isOp()) {
				ItemMeta loreleap = leap.getItemMeta();
				ItemMeta loreboom = boom.getItemMeta();

				ArrayList<String> leaplore = new ArrayList<String>();
				leaplore.add(ChatColor.DARK_PURPLE
						+ "RightClick to launch that way!");
				loreleap.setLore(leaplore);
				loreleap.setDisplayName(ChatColor.RED + "Leap Tool");
				ArrayList<String> boomlore = new ArrayList<String>();
				boomlore.add(ChatColor.DARK_PURPLE
						+ "RightClick to blow that up!");
				loreboom.setDisplayName(ChatColor.RED + "Boom Tool");
				loreboom.setLore(boomlore);
				leap.setItemMeta(loreleap);
				boom.setItemMeta(loreboom);
				ItemStack helm = new ItemStack(Material.TNT, 1);
				inventory.setHelmet(helm);
				inventory.addItem(leap);
				inventory.addItem(boom);
			}
			else{
				player.sendMessage(ChatColor.RED + "You do not have access to that command!");
				return false;
		}
			}
		return false;
	}

}

