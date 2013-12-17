package com.gmail.bunnehrealm.explosionman.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import com.gmail.bunnehrealm.explosionman.LaunchClass;
import com.gmail.bunnehrealm.explosionman.LeapClass;
import com.gmail.bunnehrealm.explosionman.MainClass;
import com.gmail.bunnehrealm.explosionman.sticks.LeapStick;

public class PreventFlyKick implements Listener{
	public static MainClass MainClass;

	@SuppressWarnings("static-access")
	public PreventFlyKick(MainClass MainClass) {
		this.MainClass = MainClass;
	}
	public static LeapStick LeapStick;
	@SuppressWarnings("static-access")
	public PreventFlyKick(LeapStick LeapStick) {
		this.LeapStick = LeapStick;
	}
	
	public static LeapClass LeapClass;
	@SuppressWarnings("static-access")
	public PreventFlyKick(LeapClass LeapClass) {
		this.LeapClass = LeapClass;
	}
	
	public static LaunchClass LaunchClass;
	@SuppressWarnings("static-access")
	public PreventFlyKick(LaunchClass LaunchClass) {
		this.LaunchClass = LaunchClass;
	}
	public void onKick(PlayerKickEvent e){
		e.setCancelled(true);
		if(LaunchClass.doDamage || LeapClass.doDamage || LeapStick.doDamage){
		if(e.getReason().contains("Flying")){
			e.setCancelled(true);
		}
		else 
			e.setCancelled(false);
	}
		else
			e.setCancelled(false);
	}
}
