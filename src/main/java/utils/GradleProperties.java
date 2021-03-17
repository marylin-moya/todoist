package utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static utils.Constants.*;

public class GradleProperties {
    private static GradleProperties instance;
    public Logger log = Logger.getLogger(getClass());
    private String browser;
    private String site;
    private String email;
    private String password;
    private Properties properties;

    private GradleProperties() {
        initialize();
    }

    public static GradleProperties getInstance() {
        if (instance == null) {
            instance = new GradleProperties();
        }
        return instance;
    }

//    private void initialize() {
//        log.info("Initialize Gradle Properties");
//        browser = System.getProperty(BROWSER);
//        site = System.getProperty(SITE);
//        email = System.getProperty(EMAIL);
//        password = System.getProperty(PASSWORD);
//    }

    private void initialize() {
        log.info("Initialize Gradle Properties");
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(GRADLE_PROPERTIES);
            properties.load(inputStream);
            browser = System.getProperty(BROWSER) == null ? properties.getProperty(BROWSER) : System.getProperty(BROWSER);
            site = System.getProperty(SITE) == null ? properties.getProperty(SITE) : System.getProperty(SITE);
            email = System.getProperty(EMAIL) == null ? properties.getProperty(EMAIL) : System.getProperty(EMAIL);
            password = System.getProperty(PASSWORD) == null ? properties.getProperty(PASSWORD) : System.getProperty(PASSWORD);
        } catch (IOException e) {
            log.error("Error getting info of file: " + CONFIG_PROPERTIES);
            log.error(e.getStackTrace());
        }
    }

    public String getBrowser() {
        return browser;
    }

    public String getSite() {
        return site;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
