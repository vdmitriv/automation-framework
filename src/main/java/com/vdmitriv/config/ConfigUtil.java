package com.vdmitriv.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static final Properties props = new Properties();

    static {
        try(InputStream is = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties")){
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config properties file: " + e.getMessage());
        }
    }

    public static String getBrowser(){
        return props.getProperty("browser.name");
    }
}
