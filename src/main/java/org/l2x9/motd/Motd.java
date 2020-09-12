package org.l2x9.motd;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import org.l2x9.motd.events.PingEvent;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public final class Motd extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new PingEvent(this));
        getProxy().getPluginManager().registerCommand(this, new ReloadConfig("motd", this));
        makeConfig();
    }

    public Configuration getConfig() {
        try {
            File config = new File("plugins/L2X9BungeeMotd/config.yml");
            return ConfigurationProvider.getProvider(YamlConfiguration.class).load(config);
        } catch (IOException ignored) {
            return null;
        }
    }

    private void makeConfig() {
        try {
            File config = new File("plugins/L2X9BungeeMotd/config.yml");
            File configFolder = new File("plugins/L2X9BungeeMotd");
            if (!configFolder.exists()) {
                configFolder.mkdir();
            }
            if (!config.exists()) {
                InputStream in = getResourceAsStream("config.yml");
                Files.copy(in, config.toPath());
            }
        } catch (IOException ignored) {
        }
    }

    public void reloadConfig() {
        try {
            File config = new File("plugins/L2X9BungeeMotd/config.yml");
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(getConfig(), config);
        } catch (IOException ignored) {
        }
    }
}

