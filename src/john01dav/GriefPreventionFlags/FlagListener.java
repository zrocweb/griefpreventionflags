package src.john01dav.GriefPreventionFlags;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FlagListener implements Listener{
    
	@EventHandler
	public void MobSpawnEvent(CreatureSpawnEvent e){
		if(JCore.getClaimAtLocation(e.getLocation()) != null){
			if(!GriefPreventionFlags.instance.claimmanager.flags[0].isAllowedInClaim(JCore.getClaimAtLocation(e.getLocation()))){
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void entityDamagedByEntity(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
			if(JCore.getClaimAtLocation(e.getEntity().getLocation()) != null){
				if(!GriefPreventionFlags.instance.claimmanager.flags[1].isAllowedInClaim(JCore.getClaimAtLocation(e.getEntity().getLocation()))){
					e.setCancelled(true);
				}
			}
		}
	}
	
}
