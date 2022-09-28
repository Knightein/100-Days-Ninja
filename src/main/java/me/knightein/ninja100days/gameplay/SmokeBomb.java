package me.knightein.ninja100days.gameplay;

import com.destroystokyo.paper.ParticleBuilder;
import me.knightein.ninja100days.NinjaMod;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

import java.util.concurrent.atomic.AtomicInteger;

public class SmokeBomb implements Listener {
    @EventHandler
    public void onThrow(PotionSplashEvent event) {
        String name = PlainTextComponentSerializer.plainText().serialize(event.getPotion().getPotionMeta().displayName());
        if (name.equals("Smoke Bomb")) {
            AtomicInteger counter = new AtomicInteger(0);
            Bukkit.getScheduler().runTaskTimer(NinjaMod.getPlugin(NinjaMod.class), (task) -> {
                if (counter.getAndIncrement() > 15) {
                    task.cancel();
                }
                new ParticleBuilder(Particle.EXPLOSION_LARGE)
                        .allPlayers() // Sends particle to all players.
                        // .color(0, 0, 0)
                        .count(150) // Amount of particles.
                        .offset(3, 3, 3) // Offset of the particle.
                        .location(event.getEntity().getLocation().clone().add(0, 1, 0)) // Location of the particle.
                        .spawn();
            }, 0, 2L);
        }
    }
}
