package src.john01dav.GriefPreventionFlags;
import java.io.*;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.ryanhamshire.GriefPrevention.*;

public class JCore {
    
	public static Boolean fileExists(String file){
		File fileObject = new File(file);
		return fileObject.exists();
	}
	
	public static String getFileContents(String file){
		if(!fileExists(file)){
			return null;
		}
		try{
			FileReader fileReader =  new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			String newLine = reader.readLine(), finalLine = "";
			
			while(newLine != null){
				finalLine += ("/n" + newLine);
				newLine = reader.readLine();
			}
			
			reader.close();
			fileReader.close();
			
			return finalLine;
			
		}catch(Exception e){
	    	e.printStackTrace();
	    	return null;
	    }
		
	}
	
	public static Boolean senderIsConsole(CommandSender sender){
		return !(sender instanceof Player);
	}
	
	public static Claim getClaimAtLocation(Location loc){
		return GriefPrevention.instance.dataStore.getClaimAt(loc, true, null);
	}
	
	public static Boolean isClaimAtLocation(Location loc){
		return getClaimAtLocation(loc) == null;
	}
	
	public static void setFileContents(String file, String contents){
		try{
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			
			writer.write(contents);
			
			writer.close();
			fileWriter.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
