package DriverFactoryPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FactoryDesignTest {

    DriverManager driverManager;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver=driverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
    }


    @Test
    public void verifyBStackDemoAddToCart() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.shelf-item__buy-btn")));
        List<WebElement> addToCartBtns = driver.findElements(By.cssSelector("div.shelf-item__buy-btn"));
        addToCartBtns.get(0).click();
        WebElement chkoutbtn = driver.findElement(By.cssSelector("div.buy-btn"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(chkoutbtn.isDisplayed());
    }

    @Test
    public void verifyBStackDemoTitle() {

        Assert.assertEquals(driver.getTitle(), "StackDemo");
    }

    @Test
    public void verifyBStackDemoLogo() {

        WebElement logo = driver.findElement(By.cssSelector(" a.Navbar_logo__26S5Y"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(logo.isDisplayed());
    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}
