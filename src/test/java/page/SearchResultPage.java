package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
    private final WebDriver driver;
    private final By searchBoxLocator = By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]");
    private final By searchSpanLocator = By.xpath("//span[@class=\"input-group-addon search-span\"]");
    private final By resultsContainerLocator = By.xpath("//div[@class=\"col-md-12 col-sm-12 padding-right0\"]");
    private final By resultItemLocator = By.xpath("//div[@class=\"row padding-topbot5\"]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    // Nhập từ khóa tìm kiếm vào ô tìm kiếm
    public void enterSearchKeyword(String keyword) {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    // Ấn phím Enter
    public void pressEnterKey() {
        WebElement searchBox = driver.findElement(searchBoxLocator);
        searchBox.sendKeys(Keys.RETURN);
    }

    // Nhấp vào nút tìm kiếm
    public void clickSearchButton() {
        WebElement searchSpan = driver.findElement(searchSpanLocator);
        searchSpan.click();
    }

    // Lấy số lượng kết quả tìm kiếm
    public int getNumberOfResults() {
        WebElement resultsContainer = driver.findElement(resultsContainerLocator);
        return resultsContainer.findElements(resultItemLocator).size();
    }
}
