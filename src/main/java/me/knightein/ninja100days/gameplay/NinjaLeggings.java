package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NinjaLeggings implements Listener {
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
    public void wallClimb(PlayerMoveEvent event) {
        Player player = event.getPlayer();

    }
}
