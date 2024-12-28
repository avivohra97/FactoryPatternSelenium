package DriverFactoryPattern;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    public void quitDriver(){
        driver.quit();
        driver = null;
    }
}
