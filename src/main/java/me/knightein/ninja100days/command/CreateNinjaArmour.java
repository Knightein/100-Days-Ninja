package me.knightein.ninja100days.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CreateNinjaArmour implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {

        // Checks if the command is "restrictInventory" otherwise returns false.
        if (label.equalsIgnoreCase("createninja")) {
            // Only Players are allowed to run this command.
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only a Player can run this command!");
                return true;
            }

            if (args[0].equalsIgnoreCase("boots")) {
                return createNinjaBoots(sender);
            }
            if (args[0].equalsIgnoreCase("chestplate")) {
                return giveNinjaChestplate(sender);
            }
            sender.sendMessage("Argument invalid, try 'Boots' or 'Chestplate'");
        }

        return false;
    }

    private static boolean createNinjaBoots(@NotNull CommandSender sender) {

        // Logic
        Player player = (Player) sender;
        ItemStack ninjaBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta ninjaBootsMeta = (LeatherArmorMeta) ninjaBoots.getItemMeta();
        ninjaBootsMeta.setColor(Color.BLACK);
        ninjaBootsMeta.displayName(Component.text("Ninja Boots").color(NamedTextColor.DARK_GRAY));
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.speed", 1,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
        ninjaBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
        ninjaBoots.setItemMeta(ninjaBootsMeta);
        player.getInventory().addItem(ninjaBoots);

        // Announcement
        player.sendMessage(ChatColor.DARK_GREEN + "Gave " + player.getPlayer() + " Ninja Boots");

        return true;
    }

    private static boolean giveNinjaChestplate(@NotNull CommandSender sender) {

        // Fills the player's inventory full of barriers.
        Player player = (Player) sender;
        ItemStack barrier = new ItemStack(Material.BARRIER, 1);
        for (int i = 9; i < 36; i++) {
            player.getInventory().setItem(i, barrier);
        }

        // Announcement
        player.sendMessage(ChatColor.RED + "Hotbar Mode Only Activated!");
        player.sendMessage(ChatColor.DARK_GREEN + "Ultimate Hardcore Mode Enabled! Good Luck!");

        return true;
    }
}
