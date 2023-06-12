package Testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TE002 {
    private WebDriver driver;

    public void setUp() {
        // Thiết lập driver cho trình duyệt Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void SearchTest() {
        // Mở trang web
        driver.get("http://congnongdan.vn/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));
        WebElement searchSpan = driver.findElement(By.xpath("//span[@class=\"input-group-addon search-span\"]"));

        searchBox.clear();
        searchBox.sendKeys("nông");

        searchSpan.click();
        WebElement resultsContainer = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]"));
        if (resultsContainer.findElements(By.xpath("//div[@class=\"row padding-topbot5\"]")).size() > 0) {
            System.out.println("Tìm kiếm thành công");
        } else {
            System.out.println("Tìm kiếm không thành công");
        }
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        TE002 test = new TE002();
        test.setUp();
        test.SearchTest();
        test.tearDown();
    }
}