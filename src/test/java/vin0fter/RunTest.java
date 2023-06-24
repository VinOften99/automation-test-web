package vin0fter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;
import java.time.Duration;


public class RunTest {
    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeTest
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();


        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test (priority = 1)
    public void TE001() {
        homePage.navigateTo();
        Assert.assertTrue(homePage.isSearchInputDisplayed(), "Ô tìm kiếm không tồn tại");

        String keyword = "từ khóa mẫu";
        homePage.enterSearchKeyword(keyword);
        Assert.assertEquals(homePage.getSearchInputValue(), keyword, "Dữ liệu nhập vào không trùng khớp");
    }

    @Test (priority = 2)
    public void TE002() {
        homePage.navigateTo();
        searchResultPage.enterSearchKeyword("nông");
        searchResultPage.clickSearchButton();
        Assert.assertTrue(searchResultPage.getNumberOfResults() > 0);
    }

    @Test (priority = 3)
    public void TE003() {
        homePage.navigateTo();
        searchResultPage.enterSearchKeyword("nông");
        searchResultPage.pressEnterKey();
        Assert.assertTrue(searchResultPage.getNumberOfResults() > 0);
    }

    @Test (priority = 4)
    public void TE004() {
        homePage.navigateTo();
        searchResultPage.enterSearchKeyword("ádasdasdasdas");
        searchResultPage.clickSearchButton();
        Assert.assertEquals(searchResultPage.getNumberOfResults(), 0);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
