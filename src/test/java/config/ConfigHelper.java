package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }
}