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

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.bunnehrealm.explosionman.Listeners.Deathclass;
import com.gmail.bunnehrealm.explosionman.Listeners.PreventDamage;
import com.gmail.bunnehrealm.explosionman.Listeners.PreventFlyKick;
import com.gmail.bunnehrealm.explosionman.Listeners.StopDrops;
import com.gmail.bunnehrealm.explosionman.sticks.Boomstick;
import com.gmail.bunnehrealm.explosionman.sticks.LeapStick;
import com.gmail.bunnehrealm.explosionman.sticks.SetBoomstick;
import com.gmail.bunnehrealm.explosionman.sticks.SetLeapStick;

public class MainClass extends JavaPlugin {

	public String fileName;
	public JavaPlugin plugin;
	public File configFile;
	public FileConfiguration fileConfiguration;
	
	public Boomstick boomListen = new Boomstick(this);
	public Deathclass deathListen = new Deathclass(this);
	public Explodecmd explodeCmd = new Explodecmd(this);
	public FexplodeClass fexplodeCmd = new FexplodeClass(this);
	public PreventDamage damageListen = new PreventDamage(this);
	public LaunchClass launchCmd = new LaunchClass(this);
	public LeapClass leapCmd = new LeapClass(this);
	public LeapStick leapStick = new LeapStick(this);
	public ExplodeKit explodeKit = new ExplodeKit(this);
	public PreventDamage MoreListen = new PreventDamage(this);
	public PreventFlyKick flyListen = new PreventFlyKick(this);
	public SetBoomstick setBoomstick = new SetBoomstick(this);
	public SetLeapStick setLeapStick = new SetLeapStick(this);
	public StopDrops dropListen = new StopDrops(this);

	@Override
	public void onDisable() {
		getLogger().info("Explosion Man has been DISABLED!");

	}

	@Override
	public void onEnable() {
		this.getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
		getLogger().info("Explosion Man has been ENABLED!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.boomListen, this);
		pm.registerEvents(this.deathListen, this);
		pm.registerEvents(this.leapStick, this);
		pm.registerEvents(this.flyListen, this);
		pm.registerEvents(this.damageListen, this);
		pm.registerEvents(this.dropListen, this);

		getCommand("explodekit").setExecutor(explodeKit);
		getCommand("leap").setExecutor(leapCmd);
		getCommand("explode").setExecutor(explodeCmd);
		getCommand("setboomstick").setExecutor(setBoomstick);
		getCommand("setleapstick").setExecutor(setLeapStick);
		getCommand("fexplode").setExecutor(fexplodeCmd);
		getCommand("launch").setExecutor(launchCmd);
		if (!this.getConfig().isSet("dropblocks")) {
			this.getConfig().set("dropblocks", true);
		}
		if (!this.getConfig().isSet("explodefire")) {
			this.getConfig().set("explodefire", false);
		}
		if (!this.getConfig().isSet("explodeblocks")) {
			this.getConfig().set("exlodeblocks", true);
		}
		if (!this.getConfig().isSet("explodepower")) {
			this.getConfig().set("explodepower", 4);
		}
		if (!this.getConfig().isSet("explodebigpower")) {
			this.getConfig().set("explodebigpower", 50);
		}
		if (!this.getConfig().isSet("fexplodefire")) {
			this.getConfig().set("fexplodefire", false);
		}
		if (!this.getConfig().isSet("fexplodeblocks")) {
			this.getConfig().set("fexplodeblocks", true);
		}
		if (!this.getConfig().isSet("fexplodepower")) {
			this.getConfig().set("fexplodepower", 4);
		}
		if (!this.getConfig().isSet("fexplodebigpower")) {
			this.getConfig().set("fexplodebigpower", 50);
		}
		if (!this.getConfig().isSet("boomblocks")) {
			this.getConfig().set("boomblocks", true);
		}
		if (!this.getConfig().isSet("boomitem")) {
			this.getConfig().set("boomitem", 280);
		}
		if (!this.getConfig().isSet("boomfire")) {
			this.getConfig().set("boomfire", false);
		}
		if (!this.getConfig().isSet("boompower")) {
			this.getConfig().set("boompower", 4);
		}
		if (!this.getConfig().isSet("deathpower")) {
			this.getConfig().set("deathpower", 4);
		}
		if (!this.getConfig().isSet("deathfire")) {
			this.getConfig().set("deathfire", false);
		}
		if (!this.getConfig().isSet("deathblocks")) {
			this.getConfig().set("deathblocks", true);
		}
		if (!this.getConfig().isSet("explodemsg")) {
			this.getConfig().set("explodemsg", false);
		}
		if (!this.getConfig().isSet("explodetext")) {
			this.getConfig().set("explodetext", "Insert message here");
		}
		if (!this.getConfig().isSet("fexplodemsg")) {
			this.getConfig().set("fexplodemsg", false);
		}
		if (!this.getConfig().isSet("fexplodetext")) {
			this.getConfig().set("fexplodetext", "Insert message here");
		}
		if (!this.getConfig().isSet("boomstickmsg")) {
			this.getConfig().set("boomstickmsg", false);
		}
		if (!this.getConfig().isSet("boomsticktext")) {
			this.getConfig().set("boomsticktext", "Insert message here");
		}
		if (!this.getConfig().isSet("launchfire")) {
			this.getConfig().set("launchfire", false);
		}
		if (!this.getConfig().isSet("launchblocks")) {
			this.getConfig().set("launchblocks", true);
		}
		if (!this.getConfig().isSet("launchpower")) {
			this.getConfig().set("launchpower", 4);
		}
		if (!this.getConfig().isSet("launchheight")) {
			this.getConfig().set("launchheight", 5);
		}
		if (!this.getConfig().isSet("launchmsg")) {
			this.getConfig().set("launchmsg", false);
		}
		if (!this.getConfig().isSet("launchtxt")) {
			this.getConfig().set("launchtxt", "Insert message here");
		}
		if (!this.getConfig().isSet("leapfire")) {
			this.getConfig().set("leapfire", false);
		}
		if (!this.getConfig().isSet("leapblocks")) {
			this.getConfig().set("leapblocks", true);
		}
		if (!this.getConfig().isSet("leapdefault")) {
			this.getConfig().set("leapdefault", 5);
		}
		if (!this.getConfig().isSet("leapexplode")) {
			this.getConfig().set("leapexplode", true);
		}
		if (!this.getConfig().isSet("leapstartpower")) {
			this.getConfig().set("leapstartpower", 4);
		}
		if (!this.getConfig().isSet("leapmsg")) {
			this.getConfig().set("leapmsg", false);
		}
		if (!this.getConfig().isSet("leaptxt")) {
			this.getConfig().set("leaptxt", "Insert message here");
		}
		if (!this.getConfig().isSet("leapstickfire")) {
			this.getConfig().set("leapstickfire", false);
		}
		if (!this.getConfig().isSet("leapstickblocks")) {
			this.getConfig().set("leapstickblocks", true);
		}
		if (!this.getConfig().isSet("leapstickid")) {
			this.getConfig().set("leapstickid", 289);
		}
		if (!this.getConfig().isSet("leapstickexplode")) {
			this.getConfig().set("leapstickexplode", true);
		}
		if (!this.getConfig().isSet("leapmsg")) {
			this.getConfig().set("leapmsg", false);
		}
		if (!this.getConfig().isSet("leapstickstartpower")) {
			this.getConfig().set("leapstickstartpower", 4);
		}
		if (!this.getConfig().isSet("leapstickmsg")) {
			this.getConfig().set("leapstickmsg", false);
		}
		if (!this.getConfig().isSet("leapsticktxt")) {
			this.getConfig().set("testms", "Insert message here");
		}
		if (!this.getConfig().isSet("Version")) {
			this.getConfig().set("Version", "1.7 #(PLEASE DO NOT CHANGE)");
		}
		this.saveConfig();
	}
}
