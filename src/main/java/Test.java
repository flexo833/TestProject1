import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = GetWebDriver();
        WebDriverLogger logger = new WebDriverLogger();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);
        autorize(driver, logger);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#header_logo"))).isDisplayed();

        Actions hover = new Actions(driver);
        WebElement catalogLink = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        hover.moveToElement(catalogLink).build().perform();
        logger.afterClickOn(catalogLink, driver);

        WebElement categories = driver.findElement(By.cssSelector("#subtab-AdminCategories > a"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#subtab-AdminCategories > a"))).click();
        logger.afterClickOn(categories, driver);

        WebElement newCategorylink = driver.findElement(By.cssSelector("#page-header-desc-category-new_category"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#page-header-desc-category-new_category"))).click();
        logger.afterClickOn(newCategorylink, driver);

        WebElement nameInputField = driver.findElement(By.cssSelector("#name_1"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#name_1"))).sendKeys("TestCategoryPoliannik");
        logger.afterClickOn(nameInputField, driver);

        WebElement submitButton = driver.findElement(By.cssSelector("#category_form_submit_btn"));
        submitButton.click();
        logger.afterClickOn(submitButton, driver);

        WebElement successAlert = driver.findElement(By.cssSelector("#content > div:nth-child(4) > div"));
        if (!successAlert.isDisplayed()){
            System.out.println("Category is not created!");

        }

        WebElement filter = driver.findElement(By.xpath("//span[@class='title_box active']//i[@class='icon-caret-up']"));
        filter.click();
        logger.afterClickOn(filter,driver);

        WebElement categoryName = driver.findElement(By.xpath("//*[contains(text(),'TestCategoryPoliannik')]"));
        if (!categoryName.isDisplayed()){
            System.out.println("Category is not presented!");

        }
        else System.out.println("Category is presented");




        logOut(driver,wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#login_form"))).isDisplayed();
       driver.quit();
        }





    public static void autorize(WebDriver driver, WebDriverLogger logger) {
        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        driver.navigate().to(url);
        logger.afterNavigateTo(url,driver);
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();


    }

    private static WebDriver GetWebDriver() {
        System.setProperty("webdriver.chrome.driver", Test.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
    private static void logOut (WebDriver driver, WebDriverWait wait) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='employee_infos']/a/span")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header_logout']"))).click();


    }

}
