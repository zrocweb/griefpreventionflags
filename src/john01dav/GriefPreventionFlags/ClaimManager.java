package src.john01dav.GriefPreventionFlags;

public class ClaimManager {
    public Flag[] flags;
	public static final int MobSpawning = 0;
	public static final int pvp =         1;
	public static final int LeafDecay =   2;
    
	public void init(){
		flags = new Flag[3];
		flags[MobSpawning] = new Flag("Mob-Spawning");
		flags[pvp] = new Flag("PVP");
		flags[LeafDecay] = new Flag("Leaf-Decay");
	}
	
	public void addFlag(Flag flag){
		Flag[] newFlags = new Flag[flags.length + 1];
		
		for(int x=0;x<flags.length;x++){
			newFlags[x] = flags[x];
		}
		
		newFlags[newFlags.length - 1] = flag;
		
		flags = newFlags;
		
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
