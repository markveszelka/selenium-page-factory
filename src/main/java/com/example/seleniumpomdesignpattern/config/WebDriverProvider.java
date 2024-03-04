package com.example.seleniumpomdesignpattern.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    public static WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
