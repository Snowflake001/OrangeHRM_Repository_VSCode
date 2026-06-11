package com.saucelabs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Sauce Labs testing.
 * Manages WebDriver capabilities and Sauce Labs connection settings.
 */
public class SauceLabsConfig {

    private String sauceUsername;
    private String sauceAccessKey;
    private String saucePlatform;
    private String sauceBrowser;
    private String sauceBrowserVersion;
    private Map<String, Object> capabilities;

    public SauceLabsConfig() {
        // Load from environment variables
        this.sauceUsername = System.getenv("SAUCE_USERNAME");
        this.sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
        this.saucePlatform = System.getenv("SAUCE_PLATFORM") != null ? 
            System.getenv("SAUCE_PLATFORM") : "Windows 10";
        this.sauceBrowser = System.getenv("SAUCE_BROWSER") != null ? 
            System.getenv("SAUCE_BROWSER") : "Chrome";
        this.sauceBrowserVersion = System.getenv("SAUCE_BROWSER_VERSION") != null ? 
            System.getenv("SAUCE_BROWSER_VERSION") : "latest";
        
        // Use defaults if not set (for local testing)
        if (this.sauceUsername == null) {
            this.sauceUsername = "your_username";
        }
        if (this.sauceAccessKey == null) {
            this.sauceAccessKey = "your_access_key";
        }
        
        initializeCapabilities();
    }

    private void initializeCapabilities() {
        this.capabilities = new HashMap<>();
        capabilities.put("platformName", this.saucePlatform);
        capabilities.put("browserName", this.sauceBrowser);
        capabilities.put("browserVersion", this.sauceBrowserVersion);
    }

    public URL getSauceLabsURL() throws MalformedURLException {
        return new URL("https://" + this.sauceUsername + ":" + this.sauceAccessKey 
            + "@ondemand.saucelabs.com:443/wd/hub");
    }

    public String getSauceUsername() {
        return sauceUsername;
    }

    public String getSauceAccessKey() {
        return sauceAccessKey;
    }

    public String getSaucePlatform() {
        return saucePlatform;
    }

    public String getSauceBrowser() {
        return sauceBrowser;
    }

    public String getSauceBrowserVersion() {
        return sauceBrowserVersion;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }

    public void setCapability(String key, Object value) {
        this.capabilities.put(key, value);
    }
}
