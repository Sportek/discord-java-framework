package com.sportek.discordframework;

import javax.security.auth.login.LoginException;

public class Ignitor {

    public static void main(String[] args) throws LoginException {
        DiscordJDA discordJDA = new DiscordJDA();
        discordJDA.connect();
    }

}
