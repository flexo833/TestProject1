import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


import java.util.logging.Logger;


public class WebDriverLogger extends AbstractWebDriverEventListener {

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigate to:" + url);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Find the element:" + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Click on:" + element);
    }
}