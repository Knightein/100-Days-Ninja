package me.knightein.ninja100days;

import me.knightein.ninja100days.command.CreateNinja;
import me.knightein.ninja100days.gameplay.*;
import me.knightein.ninja100days.recipies.IronShuriken;
import me.knightein.ninja100days.recipies.NinjaStars;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class NinjaMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("createninja").setExecutor(new CreateNinja());
        getServer().getPluginManager().registerEvents(new NinjaHelmet(), this);
        getServer().getPluginManager().registerEvents(new NinjaChestplate(), this);
        getServer().getPluginManager().registerEvents(new NinjaLeggings(), this);
        getServer().getPluginManager().registerEvents(new SmokeBomb(), this);
        getServer().getPluginManager().registerEvents(new NinjaSword(), this);
        getServer().getPluginManager().registerEvents(new SnowballDamage(), this);
        if (getServer().getRecipe(new NamespacedKey("ninja", "star")) == null) {
            getServer().addRecipe(new NinjaStars().woodNinjaStarRecipe());
        }
        if (getServer().getRecipe(new NamespacedKey("ninja", "shuriken")) == null) {
            getServer().addRecipe(new IronShuriken().ironNinjaStarRecipe());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
