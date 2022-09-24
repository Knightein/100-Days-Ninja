package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NinjaChestplate implements Listener {
    private static boolean armourEquipped = false;
    @EventHandler
    public void onEquip(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getChestplate() != null) {
            String name = PlainTextComponentSerializer.plainText().serialize(event.getPlayer().getInventory().getChestplate().displayName());
            name = name.substring(1, name.length() - 1);
            if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.CHEST) {
                if (name.equals("Ninja Chestplate")) {
                    armourEquipped = true;
                } else {
                    armourEquipped = false;
                }
            }
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof LivingEntity && armourEquipped) {
            ((LivingEntity)event.getDamager()).addPotionEffect
                    (new PotionEffect(PotionEffectType.SLOW, 120, 2));
            ((LivingEntity)event.getDamager()).addPotionEffect
                    (new PotionEffect(PotionEffectType.WEAKNESS, 120, 1));
        }
    }
}
