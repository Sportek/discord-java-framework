package com.sportek.discordframework;

import com.sportek.discordframework.managers.ConfigManager;

public class Ignitor {

    public static void main(String[] args) {
        System.out.println(ConfigManager.getInstance().getConfig().getToken());
    }

}
