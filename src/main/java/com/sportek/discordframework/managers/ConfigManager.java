package com.sportek.discordframework.managers;

import com.sportek.discordframework.Config;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ConfigManager {

    private static ConfigManager configManager;
    private File fileConfiguration;
    Config config;

    public static ConfigManager getInstance() {
        if (configManager == null) {
            try {
                configManager = new ConfigManager();
            } catch (Exception e) {
                LogManager.LOGGER.severe(e.toString());
            }
        }
        return configManager;
    }

    public Config getConfig() {
        return this.config;
    }

    private ConfigManager() {
        try {
            this.config = loadConfiguration();
        } catch (Exception e) {
            LogManager.LOGGER.severe(e.toString());
        }
    }

    public Config loadConfiguration() throws IOException {
        Constructor constructor = new Constructor(Config.class);
        Yaml yaml = new Yaml(constructor);
        return yaml.load(new FileInputStream(getConfigurationFile()));
    }

    public void dumpConfig() throws IllegalArgumentException, IOException {
        dumpConfig(this.config);
    }

    public void dumpConfig(Config config) throws IllegalArgumentException, IOException {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        Yaml yml = new Yaml(options);
        yml.dump(config, new FileWriter(fileConfiguration));
    }

    private File getConfigurationFile() {
        if (fileConfiguration == null) {
            File file = new File("discord-bot\\config.yml");
            if (!file.exists()) {
                try {
                    if (file.getParentFile().mkdir() || file.getParentFile().exists()) {
                        try {
                            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("./config.yml")) {
                                FileManager fileManager = new FileManager();
                                fileManager.copyFileFromRessource(inputStream, file);
                            }
                            LogManager.LOGGER.info("Created configuration file: " + file.getPath());
                            fileConfiguration = file;
                            return fileConfiguration;
                        } catch (IOException e) {
                            throw new IOException("Failed to copy file " + file.getPath());
                        }
                    }
                    throw new IOException("Failed to create directory " + file.getParent());
                } catch (Exception e) {
                    LogManager.LOGGER.severe(e.toString());
                }
            }
            fileConfiguration = file;
        }
        return fileConfiguration;
    }
}
