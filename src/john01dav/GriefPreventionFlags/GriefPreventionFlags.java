package src.john01dav.GriefPreventionFlags;
import me.ryanhamshire.GriefPrevention.Claim;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class GriefPreventionFlags extends JavaPlugin{
	public static GriefPreventionFlags instance;
	public ClaimManager claimmanager;
	public FlagListener flaglistener;
	
	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		forcePlugin(pm, "GriefPrevention");
		claimmanager = new ClaimManager();
		flaglistener = new FlagListener();
		instance = this;
		claimmanager.init();
		pm.registerEvents(flaglistener, instance);
        getLogger().info("GriefPreventionFlags Has Been Enabled!");
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
		
		if(cmd.getName().equalsIgnoreCase("setflag")){
			if(JCore.senderIsConsole(sender)){
				sender.sendMessage(ChatColor.RED + "Only players can do that command!");
				return true;
			}
			Player player = (Player) sender;
			
			if(JCore.isClaimAtLocation(player.getLocation())){
				player.sendMessage(ChatColor.RED + "Stand is the claim that you want to set a flag for.");
				return true;
			}
			
			Claim claim = JCore.getClaimAtLocation(player.getLocation());
            int flag = claimmanager.getFlagId(args[0]);
            
            if(flag < 0){
            	player.sendMessage(ChatColor.RED + "Invalid Flag!");
            	return true;
            }
            
            Boolean isAllowed;
            try{
            	isAllowed = Boolean.parseBoolean(args[1]);
            }catch(Exception e){
            	player.sendMessage(ChatColor.RED + "Value must be a boolean!");
            	return true;
            }
            
            claimmanager.flags[flag].setAllowedInClaim(claim, isAllowed);
            player.sendMessage(ChatColor.GREEN + "Set flag %flag to %value in your claim".replaceAll("%flag", args[0]).replaceAll("%value", args[1]));
			return true;
		}
		
		return false;
	}
	
}
