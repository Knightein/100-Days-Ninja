package me.knightein.ninja100days.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

public class CreateNinjaArmour implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {

        if (label.equalsIgnoreCase("createninja")) {
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
            if (args[0].equalsIgnoreCase("leggings")) {
                return giveNinjaLeggings(sender);
            }
            if (args[0].equalsIgnoreCase("head") || args[0].equalsIgnoreCase("helmet")) {
                return giveNinjaHelmet(sender);
            }
            sender.sendMessage("Argument invalid, use: 'boots', 'chestplate', 'leggings' or 'head'");
        }
        return false;
    }

    /**
     * Creates and Adds the Ninja Boots to the player's inventory.
     * @param sender The player sending the command.
     * @return On success, return true.
     */
    private static boolean createNinjaBoots(@NotNull CommandSender sender) {
        // Logic
        Player player = (Player) sender;

        // Creating Armour and Setting Colour
        ItemStack ninjaBoots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta ninjaBootsMeta = (LeatherArmorMeta) ninjaBoots.getItemMeta();
        ninjaBootsMeta.setColor(Color.BLACK);

        // Display Name
        ninjaBootsMeta.displayName(MiniMessage.miniMessage()
                .deserialize("<bold><grey>Ninja Boots"));

        // Lore
        List<Component> lore = List.of(
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:dark_grey:white:dark_grey><bold>Walk the shadows and never look back."),
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<color:#1be3f5><bold>When equipped, you move twice as fast.")
        );
        ninjaBootsMeta.lore(lore);

        // Modifiers
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.speed", 1,
                AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);
        ninjaBootsMeta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);

        // Enchants & Other
        ninjaBootsMeta.isUnbreakable();

        // Setting Meta and Giving Item
        ninjaBoots.setItemMeta(ninjaBootsMeta);
        player.getInventory().addItem(ninjaBoots);

        // Announcement
        player.sendMessage(ChatColor.DARK_GREEN + "Gave " + player.getPlayer().getName() + " Ninja Boots");

        return true;
    }

    private static boolean giveNinjaChestplate(@NotNull CommandSender sender) {
        // Logic
        Player player = (Player) sender;

        // Creating Armour and Setting Colour
        ItemStack ninjaChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta ninjaChestplateMeta = (LeatherArmorMeta) ninjaChestplate.getItemMeta();
        ninjaChestplateMeta.setColor(Color.BLACK);

        // Display Name
        ninjaChestplateMeta.displayName(MiniMessage.miniMessage()
                .deserialize("<bold><grey>Ninja Chestplate"));

        // Lore
        List<Component> lore = List.of(
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:dark_grey:white:dark_grey><bold>The shadows surround you in dark mist."),
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<color:#31c217><bold>When equipped, enemies become weak."),
                MiniMessage.miniMessage()
                        .deserialize("<color:#ff1900><bold>                   +10 Hearts")
        );
        ninjaChestplateMeta.lore(lore);

        // Modifiers
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.maxhealth", 20,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        ninjaChestplateMeta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);

        // Enchants & Other
        ninjaChestplateMeta.isUnbreakable();

        // Setting Meta and Giving Item
        ninjaChestplate.setItemMeta(ninjaChestplateMeta);
        player.getInventory().addItem(ninjaChestplate);

        // Announcement
        player.sendMessage(ChatColor.DARK_GREEN + "Gave " + player.getPlayer().getName() + " Ninja Chestplate");

        return true;
    }

    private static boolean giveNinjaLeggings(@NotNull CommandSender sender) {
        // Logic
        Player player = (Player) sender;

        // Creating Armour and Setting Colour
        ItemStack ninjaLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ninjaLeggingsMeta = (LeatherArmorMeta) ninjaLeggings.getItemMeta();
        ninjaLeggingsMeta.setColor(Color.BLACK);

        // Display Name
        ninjaLeggingsMeta.displayName(MiniMessage.miniMessage()
                .deserialize("<bold><grey>Ninja Leggings"));

        // Lore
        List<Component> lore = List.of(
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:dark_grey:white:dark_grey><bold>The shadows cast the ability to climb."),
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:#ad130a:red:#ad130a><bold>When equipped, you can climb walls.")
        );
        ninjaLeggingsMeta.lore(lore);

        // Modifiers
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armour", 20,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        ninjaLeggingsMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);

        // Enchants & Other
        ninjaLeggingsMeta.isUnbreakable();

        // Setting Meta and Giving Item
        ninjaLeggings.setItemMeta(ninjaLeggingsMeta);
        player.getInventory().addItem(ninjaLeggings);

        // Announcement
        player.sendMessage(ChatColor.DARK_GREEN + "Gave " + player.getPlayer().getName() + " Ninja Leggings");

        return true;
    }

    private static boolean giveNinjaHelmet(@NotNull CommandSender sender) {
        // Logic
        Player player = (Player) sender;

        // Creating Armour and Setting Colour
        ItemStack ninjaHelmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ninjaHelmetMeta = (LeatherArmorMeta) ninjaHelmet.getItemMeta();
        ninjaHelmetMeta.setColor(Color.BLACK);

        // Display Name
        ninjaHelmetMeta.displayName(MiniMessage.miniMessage()
                .deserialize("<bold><grey>Ninja Helmet"));

        // Lore
        List<Component> lore = List.of(
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:dark_grey:white:dark_grey><bold>The shadows allow you to see the dark."),
                MiniMessage.miniMessage()
                        .deserialize(""),
                MiniMessage.miniMessage()
                        .deserialize("<gradient:#9013c2:#e420fa:#9013c2><bold>When equipped, you have Night Vision.")
        );
        ninjaHelmetMeta.lore(lore);

        // Modifiers
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armour", 10,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        ninjaHelmetMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);

        // Enchants & Other
        ninjaHelmetMeta.isUnbreakable();

        // Setting Meta and Giving Item
        ninjaHelmet.setItemMeta(ninjaHelmetMeta);
        player.getInventory().addItem(ninjaHelmet);

        // Announcement
        player.sendMessage(ChatColor.DARK_GREEN + "Gave " + player.getPlayer().getName() + " Ninja Helmet");

        return true;
    }
}
