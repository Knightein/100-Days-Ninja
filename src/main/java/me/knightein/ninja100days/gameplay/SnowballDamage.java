package me.knightein.ninja100days.gameplay;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SnowballDamage implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        Entity possibleTarget = projectile.getNearbyEntities(1, 1, 1).get(0);

        if (possibleTarget instanceof LivingEntity target) {
            Player player = (Player) event.getEntity().getShooter();
            String name = PlainTextComponentSerializer.plainText().serialize(player.getInventory().getItemInMainHand().displayName());
            name = name.substring(1, name.length() - 1);

            if (name.equals("Wooden Ninja Star")) {
                target.damage(2);

            } else if (name.equals("Iron Shuriken")) {
                target.damage(4.5);
            }
        }
    }
}
