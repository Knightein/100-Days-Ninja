package me.knightein.ninja100days.recipies;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class NinjaStars {
    public ShapedRecipe woodNinjaStarRecipe() {
        ItemStack ninjaStar = new ItemStack(Material.SNOWBALL, 8);
        ItemMeta ninjaStarMeta = ninjaStar.getItemMeta();

        ninjaStarMeta.displayName(MiniMessage.miniMessage().deserialize("<white>Wooden Ninja Star"));
        ninjaStar.setItemMeta(ninjaStarMeta);

        // Recipe
        // ninja:star
        ShapedRecipe ninjaStarRecipe = new ShapedRecipe(new NamespacedKey("ninja", "star"), ninjaStar);
        ninjaStarRecipe.shape("*+*", "+++", "*+*");
        ninjaStarRecipe.setIngredient('*', Material.AIR);
        ninjaStarRecipe.setIngredient('+', Material.STICK);

        return ninjaStarRecipe;
    }
}
