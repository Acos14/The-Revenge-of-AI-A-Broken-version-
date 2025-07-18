package com.yourname.revengeofai;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Random;

public class TheRevengeOfAIMod implements ModInitializer {

    // Tároljuk a játékosokhoz rendelt horror "élményt"
    private final Map<UUID, String> playerExperiences = new HashMap<>();
    private final Random random = new Random();

    // Példa horror élmény nevek
    private final String[] horrorExperiences = {
            "The Broken Script",
            "Whispering Shadows",
            "Silent Screams",
            "The Forgotten Entity",
            "Nightmare Echoes"
    };

    @Override
    public void onInitialize() {
        System.out.println("[TheRevengeOfAI] Mod started!");

        // Itt be lehetne eseményfigyelőket regisztrálni, pl. játékos csatlakozáskor
        // Ez most egyszerű példa: csak kiírjuk a konzolra
    }

    // Egyszerű példa metódus játékos csatlakozáskor, hogy kapjon egyedi élményt
    public void assignUniqueExperience(ServerPlayerEntity player) {
        UUID playerId = player.getUuid();

        if (!playerExperiences.containsKey(playerId)) {
            // Véletlenszerűen hozzárendelünk egy élményt a listából, de a célodnak megfelelően itt bővítheted
            String experience = horrorExperiences[random.nextInt(horrorExperiences.length)];
            playerExperiences.put(playerId, experience);
            player.sendMessage(Text.literal("Your unique horror experience: " + experience), false);
            System.out.println("[TheRevengeOfAI] Assigned experience '" + experience + "' to player " + player.getName().getString());
        }
    }
}
