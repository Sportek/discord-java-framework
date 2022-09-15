package com.sportek.discordframework;

import com.sportek.discordframework.managers.ConfigManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordJDA {

    public void connect() throws LoginException {
        JDA jda = JDABuilder.createDefault(ConfigManager.getInstance().getConfig().getToken()).build();
    }
}
