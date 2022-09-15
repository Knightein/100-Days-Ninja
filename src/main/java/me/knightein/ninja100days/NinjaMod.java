package me.knightein.ninja100days;

import me.knightein.ninja100days.command.CreateNinjaArmour;
import org.bukkit.plugin.java.JavaPlugin;

public final class NinjaMod extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("createninja").setExecutor(new CreateNinjaArmour());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
