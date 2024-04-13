package me.hans.mailsender;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mailsender extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("mail").setExecutor(new MailCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
