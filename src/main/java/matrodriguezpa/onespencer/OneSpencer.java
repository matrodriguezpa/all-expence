package matrodriguezpa.onespencer;

import java.io.IOException;
import matrodriguezpa.onespencer.controller.ProjectController;
import matrodriguezpa.onespencer.model.ConfigModel;
import matrodriguezpa.onespencer.model.DatabaseModel;
import matrodriguezpa.onespencer.view.ProjectView;

public class OneSpencer {

    public static void main(String[] args) {
        DatabaseModel model = new DatabaseModel();
        ProjectView view = new ProjectView();
        ProjectController controller = new ProjectController(model, view);

        controller.start();
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
