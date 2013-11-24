package com.gmail.bunnehrealm.explosionman;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

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
			if (blockId == MainClass.getConfig().getInt("item")) {
				Action a = e.getAction();
				if (a.equals(Action.RIGHT_CLICK_AIR)) {
					@SuppressWarnings("deprecation")
					Block block = player.getTargetBlock(null, 200);
					Location blocation = block.getLocation();
					if(MainClass.getConfig().getBoolean("boomstickmsg")){
						String explodemsg = MainClass.getConfig().getString("boomsticktext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}
					player.getWorld().createExplosion(blocation, MainClass.getConfig().getInt("boompower"));
					if(player.hasPermission("explosionman.boomlightning")){
						player.getWorld().strikeLightningEffect(blocation);
					}
				}
				else if (a.equals(Action.RIGHT_CLICK_BLOCK)) {
					@SuppressWarnings("deprecation")
					Block block = player.getTargetBlock(null, 200);
					Location blocation = block.getLocation();
					if(MainClass.getConfig().getBoolean("boomstickmsg")){
						String explodemsg = MainClass.getConfig().getString("boomsticktext").replaceAll("(&([a-f0-9]))", "\u00A7$2");
						player.sendMessage(explodemsg);
					}
					player.getWorld().createExplosion(blocation, MainClass.getConfig().getInt("boompower"));
					if(player.hasPermission("explosionman.boomlightning")){
						player.getWorld().strikeLightningEffect(blocation);
					}
				}
			}
		}
	}
}
