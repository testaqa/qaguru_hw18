package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    private static ApiConfig getApiConfig() {
        return ConfigFactory.create(ApiConfig.class);
    }

    public static String getBaseURL() {
        return getApiConfig().baseURL();
    }

}