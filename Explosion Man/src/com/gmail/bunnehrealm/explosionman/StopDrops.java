package com.gmail.bunnehrealm.explosionman;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

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
