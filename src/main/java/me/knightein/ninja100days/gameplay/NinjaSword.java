package me.knightein.ninja100days.gameplay;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class NinjaSword implements Listener {
    @EventHandler
    public void lifeSteal(EntityDamageByEntityEvent event) {
        // Basically says if it is a Player, do this.
        if (event.getDamager().getType().equals(EntityType.PLAYER)) {
            Player player = (Player) event.getDamager();
            String name = PlainTextComponentSerializer.plainText().serialize(player.getInventory().getItemInMainHand().displayName());
            name = name.substring(1, name.length() - 1);
            if (name.equals("Grandmaster Sword") || name.equals("Lifesteal Katana")) {
                double healingDamage = (event.getDamage() / 4);
                player.setHealth(player.getHealth() + healingDamage);
            }
        }
    }
}
