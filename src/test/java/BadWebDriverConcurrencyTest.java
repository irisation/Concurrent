import helpers.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BadWebDriverConcurrencyTest {

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverSingleton.close();
    }

    @Test
    public void test1() throws InterruptedException, MalformedURLException {
        WebDriverSingleton.initDriver("ie");
        Thread.sleep(6000);
        WebDriverSingleton.getDriver().get("http://www.onliner.by");
    }

    @Test
    public void test2() throws InterruptedException, MalformedURLException {
        Thread.sleep(5000);
        WebDriverSingleton.initDriver("chrome");
        WebDriverSingleton.getDriver().get("http://www.tut.by");
    }
    //mvn -Dtest=BadWebDriverConcurrencyTest test - последовательно
    //mvn -Dtest=BadWebDriverConcurrencyTest -Dparallel=methods -DthreadCount=2 test -методы параллельно, классы послед.

}
