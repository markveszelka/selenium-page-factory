package com.example.seleniumpomdesignpattern.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    public static final String BROWSER_VERSION = "122";

    public static WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
