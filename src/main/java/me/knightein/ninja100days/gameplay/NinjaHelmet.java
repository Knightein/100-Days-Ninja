package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;

public class NinjaHelmet implements Listener {
    @EventHandler
    public void onEquip(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() != null) {
            String name = PlainTextComponentSerializer.plainText().serialize(event.getPlayer().getInventory().getHelmet().displayName());
            name = name.substring(1, name.length() - 1);
            if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.HEAD) {
                if (name.equals("Ninja Mask")) {
                    player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(1000000, 2));
                }
            }
        }
    }
}
