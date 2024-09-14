package matrodriguezpa.onespencer.model;
import java.io.*;
import java.util.Properties;

public class ConfigModel {
    private final Properties properties;
    private final String configFilePath;

    // Constructor that loads the configuration file
    public ConfigModel(String configFilePath) throws IOException {
        this.configFilePath = configFilePath;
        properties = new Properties();
        loadProperties();
    }

    // Load properties from the configuration file
    private void loadProperties() throws IOException {
        try (InputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
        }
    }

    // Get a property value by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Set a property value and save to file
    public void setProperty(String key, String value) throws IOException {
        properties.setProperty(key, value);
        saveProperties();
    }

    // Save properties back to the configuration file
    private void saveProperties() throws IOException {
        try (OutputStream output = new FileOutputStream(configFilePath)) {
            properties.store(output, null);
        }
    }

    
}
