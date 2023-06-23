package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private WebDriver driver;
    private By searchBoxLocator = By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]");
    private By searchSpanLocator = By.xpath("//span[@class=\"input-group-addon search-span\"]");
    private By resultsContainerLocator = By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]");
    private By resultItemLocator = By.xpath("//div[@class=\"row padding-topbot5\"]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

    }

//    public void enterSearchKeyword(String keyword) {
//        WebElement searchBox = driver.findElement(searchBoxLocator);
//        searchBox.clear();
//        searchBox.sendKeys(keyword);
//    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void pressEnterKey() {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(Keys.RETURN);
    }

    public void clickSearchButton() {
        WebElement searchSpan = driver.findElement(searchSpanLocator);
        searchSpan.click();
    }

    public int getNumberOfResults() {
        WebElement resultsContainer = driver.findElement(resultsContainerLocator);
        return resultsContainer.findElements(resultItemLocator).size();
    }
}

