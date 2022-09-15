package com.sportek.discordframework;

import com.sportek.discordframework.managers.ConfigManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordJDA {

    private JDA jda;

    public void connect() throws LoginException {
        jda = JDABuilder.createDefault(ConfigManager.getInstance().getConfig().getToken()).build();
    }

    public JDA getJda() {
        return jda;
    }
}
