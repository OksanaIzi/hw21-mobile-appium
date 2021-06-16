package helpers;

import config.Project;

import java.net.MalformedURLException;
import java.net.URL;

import static config.Project.appiumConfig;

public class Appium {
    public static URL getAppiumServerUrl() {
        try {
            return new URL(isCredentials() ? String.format(appiumConfig.appiumServerUrl(),
                    appiumConfig.appiumServerUser(),
                    appiumConfig.appiumServerPassword()) :
                    appiumConfig.appiumServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Credentials are not used for local launch
     */
    public static boolean isCredentials() {
        return appiumConfig.appiumServerPassword() != null && appiumConfig.appiumServerUser() != null &&
                !appiumConfig.appiumServerPassword().equals("") && !appiumConfig.appiumServerUser().equals("");
    }

    public static String getSelenoidVideoUrl(String sessionId) {
        return Project.appiumConfig.videoStorage() + sessionId + ".mp4";
    }
}
