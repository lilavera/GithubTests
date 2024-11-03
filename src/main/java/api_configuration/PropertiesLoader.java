package api_configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesLoader {
    private final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    public PropertiesLoader(String propertiesFilePath) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFilePath)) {
            if (input == null) {
                logger.warn("Sorry, unable to find {}", propertiesFilePath);
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Error occurred {}", Arrays.toString(ex.getStackTrace()));
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}