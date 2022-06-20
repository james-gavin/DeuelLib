package com.jmsgvn.deuellib.tab;

import com.jmsgvn.deuellib.DeuelLib;
import com.jmsgvn.deuellib.tab.listener.TabListener;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TabManager {
    private static Map<UUID, PlayerTab> playerTabs = new HashMap<>();

    private static TabProvider provider;

    private static boolean initiated = false;

    public static void init() {
        initiated = true;
        (new TabThread()).start();
        DeuelLib.getInstance().getServer().getPluginManager().registerEvents(new TabListener(), DeuelLib.getInstance());
    }
    public static void add(Player player) {
        playerTabs.put(player.getUniqueId(), new PlayerTab(player.getUniqueId()));
    }

    public static PlayerTab getTab(Player player) {
        return playerTabs.get(player.getUniqueId());
    }

    public static TabProvider getProvider() {
        return provider;
    }

    public static void setProvider(TabProvider provider) {
        TabManager.provider = provider;
    }
}
