package com.devops.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    WebDriver driver;

@BeforeClass
public void setup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new"); // modern headless mode
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    driver = new ChromeDriver(options);
}


    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        assert driver.getTitle().contains("Google");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
