package org.l2x9.motd.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.l2x9.motd.Motd;

import java.util.List;
import java.util.Objects;

public class PingEvent implements Listener {
    Motd plugin;

    public PingEvent(Motd motd) {
        plugin = motd;
    }

    @EventHandler
    public void onPing(ProxyPingEvent event) {
        ServerPing response = new ServerPing();
        List<String> list = Objects.requireNonNull(plugin.getConfig()).getStringList("Motds");
        response.setDescriptionComponent(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', getRandomMotd(list))).create()[0]);
        response.setPlayers(event.getResponse().getPlayers());
        response.setVersion(event.getResponse().getVersion());
        event.setResponse(response);

    }

    private String getRandomMotd(List<String> list) {
        int random = (int) (Math.random() * (list.size()) + 0);
        return ChatColor.translateAlternateColorCodes('&', list.get(random));
    }
}
