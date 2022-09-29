package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NinjaLeggings implements Listener {
    private static boolean armourEquipped = false;

    @EventHandler
    public void onEquip(PlayerArmorChangeEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getLeggings() != null) {
            String name = PlainTextComponentSerializer.plainText().serialize(event.getPlayer().getInventory().getLeggings().displayName());
            name = name.substring(1, name.length() - 1);
            if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.LEGS) {
                if (name.equals("Ninja Leggings")) {
                    armourEquipped = true;
                } else {
                    armourEquipped = false;
                }
            }
        } else {
            armourEquipped = false;
        }
    }

    @EventHandler
    public void goInvis(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        if (!player.isSneaking() && armourEquipped) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000000, 1));
        } else {
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
    }
}
