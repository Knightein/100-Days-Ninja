package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NinjaClothing implements Listener {
    @EventHandler
    public void onEquip (PlayerArmorChangeEvent event) {
        if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.FEET) {
            ItemStack ninjaBoots = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta ninjaBootsMeta = ninjaBoots.getItemMeta();
            ninjaBootsMeta.displayName(Component.text("Ninja Boots").color(NamedTextColor.GRAY));
            ninjaBoots.setItemMeta(ninjaBootsMeta);
            if (ninjaBootsMeta.displayName().contains(Component.text("Ninja Boots"))
                    && ninjaBoots.hasItemMeta()) {
            }
        } else if (event.getSlotType() == PlayerArmorChangeEvent.SlotType.CHEST) {

        }
    }
    @EventHandler
    public void checkBoots () {

    }
}
