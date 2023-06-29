package vin0fter.testcase;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;


public class SearchTest extends BaseSetup {
    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }


    @Test (priority = 1)
    public void TE001() {
        Assert.assertTrue(homePage.isSearchInputDisplayed(), "Ô tìm kiếm không tồn tại");
        String keyword = "từ khóa mẫu";
        homePage.enterSearchKeyword(keyword);
        Assert.assertEquals(homePage.getSearchInputValue(), keyword, "Dữ liệu nhập vào không trùng khớp");
    }

    @Test (priority = 2)
    public void TE002() {
        String keyword = "nông";
        searchResultPage.enterSearchKeyword(keyword);
        searchResultPage.clickSearchButton();
        Assert.assertTrue(searchResultPage.getNumberOfResults() > 0);
    }

    @Test (priority = 3)
    public void TE003() {
        String keyword = "nông";
        searchResultPage.enterSearchKeyword(keyword);
        searchResultPage.pressEnterKey();
        Assert.assertTrue(searchResultPage.getNumberOfResults() > 0);
    }

    @Test (priority = 4)
    public void TE004() {
//        driver.navigate().refresh();
        String keyword = "ádasdasdasdas";
        searchResultPage.enterSearchKeyword(keyword);
        searchResultPage.clickSearchButton();
        Assert.assertFalse(searchResultPage.getNumberOfResults() > 0);

    }

}
