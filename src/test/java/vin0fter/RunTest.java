package vin0fter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class RunTest {
    WebDriver driver;
    @BeforeTest
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TE001() {

        driver.get("http://congnongdan.vn");
        // Kiểm tra sự tồn tại của ô tìm kiếm
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));
        Assert.assertTrue(searchInput.isDisplayed(), "Ô tìm kiếm không tồn tại");

        // Nhập dữ liệu vào ô tìm kiếm
        String keyword = "từ khóa mẫu";
        searchInput.sendKeys(keyword);

        // Kiểm tra dữ liệu đã nhập có trùng với dữ liệu hiển thị trong ô tìm kiếm hay không
        Assert.assertEquals(searchInput.getAttribute("value"), keyword, "Dữ liệu nhập vào không trùng khớp");
    }
    @Test
    public void TE002() throws InterruptedException {

        driver.get("http://congnongdan.vn/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));
        WebElement searchSpan = driver.findElement(By.xpath("//span[@class=\"input-group-addon search-span\"]"));

        searchBox.clear();
        searchBox.sendKeys("nông");

        searchSpan.click();

        WebElement resultsContainer = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]"));
        int numberOfResults = resultsContainer.findElements(By.xpath("//div[@class=\"row padding-topbot5\"]")).size();

        Assert.assertTrue(numberOfResults > 0);

    }

    @Test
    public void TE003() throws InterruptedException {

        driver.get("http://congnongdan.vn/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));
        WebElement searchSpan = driver.findElement(By.xpath("//span[@class=\"input-group-addon search-span\"]"));

        searchBox.clear();
        searchBox.sendKeys("nông");

        searchBox.sendKeys(Keys.RETURN);

        WebElement resultsContainer = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]"));
        int numberOfResults = resultsContainer.findElements(By.xpath("//div[@class=\"row padding-topbot5\"]")).size();

        Assert.assertTrue(numberOfResults > 0);

    }

    @Test
    public void TE004() throws InterruptedException {

        driver.get("http://congnongdan.vn/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));
        WebElement searchSpan = driver.findElement(By.xpath("//span[@class=\"input-group-addon search-span\"]"));

        searchBox.clear();
        searchBox.sendKeys("ádasdasdasdas");

        searchSpan.click();
        WebElement resultsContainer = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]"));
        int numberOfResults = resultsContainer.findElements(By.xpath("//div[@class=\"row padding-topbot5\"]")).size();

        Assert.assertTrue(numberOfResults == 0);

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

