package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By searchInputLocator = By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("http://congnongdan.vn");
    }

    public boolean isSearchInputDisplayed() {
        WebElement searchInput = driver.findElement(searchInputLocator);
        return searchInput.isDisplayed();
    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys(keyword);
    }

    public String getSearchInputValue() {
        WebElement searchInput = driver.findElement(searchInputLocator);
        return searchInput.getAttribute("value");
    }
}

