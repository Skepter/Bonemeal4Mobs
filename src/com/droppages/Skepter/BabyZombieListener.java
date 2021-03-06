package com.droppages.Skepter;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class BabyZombieListener
	implements Listener
{
		
    public BabyZombieListener(BoneMeal4Mobs plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        }


@EventHandler
	public void PlayerInteract(PlayerInteractEntityEvent event)
	{
		Player player = event.getPlayer();
		Entity entity = event.getRightClicked();
		if(entity instanceof Zombie)
		{
			if(!(entity instanceof PigZombie))
			{
			if(((Zombie) entity).isBaby())
			{
				if(player.getItemInHand().getType() == Material.INK_SACK && player.getItemInHand().getDurability() == 15)
					if(player.hasPermission("BoneMeal4Mobs.babyzombie") || player.isOp()){
				{
					player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
					if(player.getItemInHand().getAmount() == 1)
					{
						player.setItemInHand(null);
					}
					Location entityloc = entity.getLocation();
					entity.getWorld().spawnEntity(entityloc, EntityType.ZOMBIE);
					entity.remove();
					player.sendMessage(ChatColor.GOLD + "[BoneMeal4Mobs] " + ChatColor.AQUA + "You bonemealed yourself a Zombie!");
				}}
			}
		}
	}}
}