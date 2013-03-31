package src.john01dav.GriefPreventionFlags;
import java.io.File;
import java.io.IOException;

import me.ryanhamshire.GriefPrevention.Claim;

public class Flag {
    String name = "flag"; 
    
    public Flag(String name){
    	this.name = name;
    }
    
    public Boolean isDataSet(Claim claim){
    	String dataLocation = "./plugins/GriefPreventionFlags/data/" + claim.getID() + "/" + name;
    	
    	return JCore.fileExists(dataLocation);
    	
    }
    
    public Boolean isAllowedGlobally(){
    	String dataLocation = "./plugins/GriefPreventionFlags/data/global/" + name;
    	
    	if(!JCore.fileExists(dataLocation)){
    		return true;
    	}
    	
    	if(JCore.getFileContents(dataLocation).toLowerCase().contains("true")){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void setAllowedGlobally(Boolean value){
    	String dataLocation = "./plugins/GriefPreventionFlags/data/global/" + name;
    	
    	File data = new File(dataLocation);
    	if(data.exists() == false){
    		try {
				data.getParentFile().mkdirs();
    			data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	JCore.setFileContents(dataLocation, value + "");
    	
    }
    
    public Boolean isAllowedInClaim(Claim claim){
    	if(claim == null){
    		return true;
    	}
    	String dataLocation = "./plugins/GriefPreventionFlags/data/" + claim.getID() + "/" + name;
    	
    	if(!JCore.fileExists(dataLocation)){
    		return true;
    	}
    	
    	if(JCore.getFileContents(dataLocation).toLowerCase().contains("true")){
    		return true;
    	}else{
    		return false;
    	}
    }
	
    public void setAllowedInClaim(Claim claim, Boolean value){
    	String dataLocation = "./plugins/GriefPreventionFlags/data/" + claim.getID() + "/" + name;
    	
    	File data = new File(dataLocation);
    	if(data.exists() == false){
    		try {
				data.getParentFile().mkdirs();
    			data.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	JCore.setFileContents(dataLocation, value + "");
    	
    }
    
}
