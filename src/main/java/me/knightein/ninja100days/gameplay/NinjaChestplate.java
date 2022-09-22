package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class NinjaChestplate implements Listener {
    @EventHandler
    public void onEquip(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getChestplate() != null) {
            String name = PlainTextComponentSerializer.plainText().serialize(event.getPlayer().getInventory().getChestplate().displayName());
            name = name.substring(1, name.length() - 1);
            if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.CHEST) {
                if (name.equals("Ninja Chestplate")) {
                    if (player.getLastDamageCause().getEntity() instanceof Player) {

                    }
                }
            }
        }
    }

    @EventHandler
    public void onEquipTemp(EntityDamageByEntityEvent event) {

    }
}
