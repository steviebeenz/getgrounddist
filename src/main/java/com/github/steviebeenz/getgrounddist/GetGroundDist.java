package com.github.steviebeenz.reacher;

import java.util.List;
import java.util.ArrayList;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.entity.EntityType; 
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.Location;
import com.github.steviebeenz.importablegba.ImportableGBA;
import io.papermc.lib.PaperLib;

public class GetGroundDist {
    public static int getDistance(Player e){
        Location loc = e.getLocation().clone();
        double y = loc.getBlockY();
        int distance = 0;
        for (double i = y; i >= 0; i--){
            loc.setY(i);
            if(ImportableGBA.getBlockAsync(loc.clone()).getType().isSolid())break;
            distance++;
        }
        return distance;
    }
    public void goToGround(Player p) {
        Location tp = p.getLocation();
        
        tp.setY(tp.getY()-getDistance(p) + 2);

        PaperLib.teleportAsync(p, tp);
    }
}