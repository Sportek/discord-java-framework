package com.sportek.discordframework;

import com.sportek.discordframework.managers.ConfigManager;

import javax.security.auth.login.LoginException;

public class Ignitor {

    public static void main(String[] args) throws LoginException {
//        DiscordJDA discordJDA = new DiscordJDA();
//        discordJDA.connect();
        System.out.println(ConfigManager.getInstance().getConfig());
    }

}
