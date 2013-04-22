package src.john01dav.GriefPreventionFlags;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.*;

public class FlagListener implements Listener{
    
	@EventHandler
	public void MobSpawnEvent(CreatureSpawnEvent e){
		if(JCore.getClaimAtLocation(e.getLocation()) != null){
			if(GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.MobSpawning].isDataSet(JCore.getClaimAtLocation(e.getLocation()))){
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.MobSpawning].isAllowedInClaim(JCore.getClaimAtLocation(e.getLocation()))){
					e.setCancelled(true);
				}
			}else{
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.MobSpawning].isAllowedGlobally()){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void entityDamagedByEntity(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			if(JCore.getClaimAtLocation(e.getEntity().getLocation()) != null){
				if(GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.pvp].isDataSet(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
					if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.pvp].isAllowedInClaim(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
						e.setCancelled(true);
					}	
				}else{
					if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.pvp].isAllowedInClaim(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
						e.setCancelled(true);
					}
				}
				
			}
		}
	}
	
	@EventHandler
	public void leafDecayEvent(LeavesDecayEvent e){
		if(JCore.getClaimAtLocation(e.getBlock().getLocation()) != null){
			if(GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.LeafDecay].isDataSet(JCore.getClaimAtLocation(e.getBlock().getLocation()))){
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.LeafDecay].isAllowedInClaim(JCore.getClaimAtLocation(e.getBlock().getLocation()))){
					e.setCancelled(true);
				}
			}else{
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.LeafDecay].isAllowedGlobally()){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void playerDamageEvent(EntityDamageEvent e){
		if(JCore.getClaimAtLocation(e.getEntity().getLocation()) != null && e.getEntity() instanceof Player){
			if(GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.Damage].isDataSet(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.Damage].isAllowedInClaim(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
					e.setCancelled(true);
				}
			}else{
				if(!GriefPreventionFlags.instance.claimmanager.flags[ClaimManager.Damage].isAllowedGlobally()){
					e.setCancelled(true);
				}
			}
		}
	}
	
}
