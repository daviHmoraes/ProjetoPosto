package util;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {

    private static Properties props = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado no classpath!");
            }

            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Falha ao carregar config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
