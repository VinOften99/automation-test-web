package vin0fter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunTest {
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
        searchBox.clear();
        searchBox.sendKeys("nông");

        searchBox.sendKeys(Keys.RETURN);
        System.out.println("Nhập dữ liệu thành công");
        WebElement resultsContainer = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]"));
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement resultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]")));
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
        RunTest test = new RunTest();
        test.setUp();
        test.SearchTest();
        test.tearDown();
    }
}
