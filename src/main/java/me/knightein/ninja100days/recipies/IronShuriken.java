package me.knightein.ninja100days.recipies;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class IronShuriken {
    public ShapedRecipe ironNinjaStarRecipe() {
        ItemStack ninjaStar = new ItemStack(Material.SNOWBALL, 8);
        ItemMeta ninjaStarMeta = ninjaStar.getItemMeta();

        ninjaStarMeta.displayName(MiniMessage.miniMessage().deserialize("<bold><white>Iron Shuriken"));
        ninjaStar.setItemMeta(ninjaStarMeta);

        // Recipe
        // ninja:star
        ShapedRecipe ninjaStarRecipe = new ShapedRecipe(new NamespacedKey("ninja", "shuriken"), ninjaStar);
        ninjaStarRecipe.shape("*+*", "+++", "*+*");
        ninjaStarRecipe.setIngredient('*', Material.AIR);
        ninjaStarRecipe.setIngredient('+', Material.IRON_INGOT);

        return ninjaStarRecipe;
    }
}
