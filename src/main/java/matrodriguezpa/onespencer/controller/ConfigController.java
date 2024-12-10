
package matrodriguezpa.onespencer.controller;

import java.io.IOException;
import matrodriguezpa.onespencer.model.ConfigModel;

public class ConfigController {

    public ConfigController() {

    }

    private void getSettings() {

        try {
            // Initialize ConfigManager with the path to your config file
            ConfigModel configManager = new ConfigModel("C:\\Users\\Usuario\\Documents\\GitHub\\one-spencer\\src\\main\\resources\\config.properties");

            // Retrieve properties
            String theme = configManager.getProperty("view.theme");
            String textSize = configManager.getProperty("view.textsize");
            String language = configManager.getProperty("view.language");

            // Print current settings
            System.out.println("Current theme: " + theme);
            System.out.println("Text size: " + textSize);
            System.out.println("Language: " + language);

            // Update a property
            configManager.setProperty("view.theme", "lightmode");

            // Confirm update
            System.out.println("Updated theme: " + configManager.getProperty("view.theme"));

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
