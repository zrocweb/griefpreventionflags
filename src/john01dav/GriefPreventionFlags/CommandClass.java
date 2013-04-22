package src.john01dav.GriefPreventionFlags;

import me.ryanhamshire.GriefPrevention.Claim;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("setflag") && args.length == 2){
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
            int flag = GriefPreventionFlags.instance.claimmanager.getFlagId(args[0]);
            
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
            
            GriefPreventionFlags.instance.claimmanager.flags[flag].setAllowedInClaim(claim, isAllowed);
            player.sendMessage(ChatColor.GREEN + "Set flag %flag to %value in your claim.".replaceAll("%flag", args[0]).replaceAll("%value", args[1]));
			return true;
		}else if(cmd.getName().equalsIgnoreCase("setFlagGlobal") && args.length == 2){
			int flag = GriefPreventionFlags.instance.claimmanager.getFlagId(args[0]);
            
            if(flag < 0){
            	sender.sendMessage(ChatColor.RED + "Invalid Flag!");
            	return true;
            }
            
            Boolean isAllowed;
            try{
            	isAllowed = Boolean.parseBoolean(args[1]);
            }catch(Exception e){
            	sender.sendMessage(ChatColor.RED + "Value must be a boolean!");
            	return true;
            }
            
            GriefPreventionFlags.instance.claimmanager.flags[flag].setAllowedGlobally(isAllowed);
            sender.sendMessage(ChatColor.GREEN + "Set flag %flag to %value Globally.".replaceAll("%flag", args[0]).replaceAll("%value", args[1]));
			return true;
		}
		
		return false;
	}
	
}
