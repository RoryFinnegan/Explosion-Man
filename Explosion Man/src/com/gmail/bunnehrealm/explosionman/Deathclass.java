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
