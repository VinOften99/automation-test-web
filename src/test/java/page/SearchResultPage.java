package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@placeholder=\"Nội dung tìm kiếm...\"]")
    WebElement searchBox;

    @FindBy(xpath = "//span[@class=\"input-group-addon search-span\"]")
    WebElement searchSpan;

    @FindBy(xpath = "//div[@class=\"col-md-12 col-sm-12 padding-right0\"]")
    WebElement resultsContainer;

    @FindBy(xpath = "//div[@class=\"row padding-topbot5\"]")
    List<WebElement> resultItems;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKeyword(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public void pressEnterKey() {
        searchBox.sendKeys(Keys.RETURN);
    }

    public void clickSearchButton() {
        searchSpan.click();
    }

    public int getNumberOfResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(resultsContainer));
        return resultItems.size();
    }
}
