import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class BadWebDriverConcurrencyTest {
    private WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver = new InternetExplorerDriver();
        Thread.sleep(6000);
        driver.get("http://www.onliner.by");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        driver = new ChromeDriver();
        driver.get("http://www.tut.by");
    }
    //mvn -Dtest=BadWebDriverConcurrencyTest test - последовательно
    //mvn -Dtest=BadWebDriverConcurrencyTest -Dparallel=methods -DthreadCount=2 test -методы параллельно, классы послед.

}
