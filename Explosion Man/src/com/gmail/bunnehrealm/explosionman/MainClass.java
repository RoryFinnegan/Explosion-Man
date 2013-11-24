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
