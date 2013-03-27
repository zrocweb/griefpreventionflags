package src.john01dav.GriefPreventionFlags;

public class ClaimManager {
    public Flag[] flags;
	
	public void init(){
		flags = new Flag[2];
		flags[0] = new Flag("Mob-Spawning");
		flags[1] = new Flag("PVP");
	}
	
	public int getFlagId(String flagName){
		for(int x=0;x<flags.length;x++){
			if(flags[x].name.equalsIgnoreCase(flagName)){
				return x;
			}
		}
		
		return -1;
		
	}
	
}
