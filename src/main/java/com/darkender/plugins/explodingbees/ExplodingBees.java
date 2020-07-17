package com.darkender.plugins.explodingbees;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplodingBees extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
    {
        if(event.getDamager().getType() == EntityType.BEE && event.getEntityType() == EntityType.PLAYER &&
                event.getEntity().hasPermission("explodingbees.explode"))
        {
            event.getDamager().getWorld().createExplosion(event.getDamager().getLocation(), 4.0F);
            event.getDamager().remove();
        }
    }
}
