
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

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
	public Boomstick boomListen = new Boomstick(this);
	public Deathclass deathListen = new Deathclass(this);
	public Explodecmd explodeCmd = new Explodecmd(this);
	public FexplodeClass fexplodeCmd = new FexplodeClass(this);
 @Override
 public void onDisable(){
	 getLogger().info("Explosion Man has been DISABLED!");
	 
 }
 @Override
 public void onEnable(){
	 this.getConfig().options().copyDefaults(true);
	 this.saveDefaultConfig();
	 getLogger().info("Explosion Man has been ENABLED!");
	 PluginManager pm = getServer().getPluginManager();
	 pm.registerEvents(this.boomListen, this);
	 pm.registerEvents(this.deathListen, this);
	 
	 
	 getCommand("explode").setExecutor(explodeCmd);
	 getCommand("fexplode").setExecutor(fexplodeCmd);
 }
}
