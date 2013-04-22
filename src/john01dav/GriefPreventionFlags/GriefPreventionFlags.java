package src.john01dav.GriefPreventionFlags;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;

public class GriefPreventionFlags extends JavaPlugin{
	public static GriefPreventionFlags instance;
	public ClaimManager claimmanager;
	public FlagListener flaglistener;
	public CommandClass commandclass;
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		claimmanager = new ClaimManager();
		flaglistener = new FlagListener();
		commandclass = new CommandClass();
		instance = this;
		claimmanager.init();
		pm.registerEvents(flaglistener, instance);
        getLogger().info("GriefPreventionFlags Has Been Enabled!");
        forcePlugin(pm, "GriefPrevention");
	}
	
	public void onDisable(){
		getLogger().info("GriefPreventionFlags Has Been Disabled.");
	}
    
	public void forcePlugin(PluginManager pm, String plugin){
		getLogger().info("Checking for plugin %plugin".replaceAll("%plugin", plugin));
		if(!pm.isPluginEnabled(plugin)){
			getLogger().info("Plugin %plugin not enabled! Shutting down GriefPreventionFlags");
			pm.disablePlugin(this);
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		//Is done this way so that future commands added will not be needed to be manually added to onenable (ex. what would it look like with 500 commands...)
		return commandclass.onCommand(sender, cmd, label, args);
	}
	
}
