package me.knightein.ninja100days;

import me.knightein.ninja100days.command.CreateNinja;
import me.knightein.ninja100days.gameplay.NinjaChestplate;
import me.knightein.ninja100days.gameplay.NinjaHelmet;
import me.knightein.ninja100days.gameplay.SmokeBomb;
import org.bukkit.plugin.java.JavaPlugin;

public final class NinjaMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("createninja").setExecutor(new CreateNinja());
        getServer().getPluginManager().registerEvents(new NinjaHelmet(), this);
        getServer().getPluginManager().registerEvents(new NinjaChestplate(), this);
        getServer().getPluginManager().registerEvents(new SmokeBomb(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
