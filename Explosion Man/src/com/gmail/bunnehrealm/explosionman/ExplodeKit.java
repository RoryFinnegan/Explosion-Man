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
		ItemStack boom = new ItemStack(MainClass.getConfig().getInt("item"), 1);
		if (string.equalsIgnoreCase("explodekit")) {
			if (player.hasPermission("explosionman.kit") || player.isOp()) {
				ItemMeta loreleap = leap.getItemMeta();
				ItemMeta loreboom = boom.getItemMeta();
				loreleap.setDisplayName(ChatColor.RED + "Leap Tool");
				ArrayList<String> leaplore = new ArrayList<String>();
				leaplore.add(ChatColor.DARK_PURPLE
						+ "RightClick to launch that way!");
				loreleap.setLore(leaplore);
				loreboom.setDisplayName(ChatColor.RED + "Leap Tool");
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

