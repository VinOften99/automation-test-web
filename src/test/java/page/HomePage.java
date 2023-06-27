package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    private final By searchInputLocator = By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Kiểm tra xem ô tìm kiếm có hiển thị trên trang web hay không
    public boolean isSearchInputDisplayed() {
        WebElement searchInput = driver.findElement(searchInputLocator);
        return searchInput.isDisplayed();
    }

    // Nhập từ khóa tìm kiếm vào ô tìm kiếm
    public void enterSearchKeyword(String keyword) {
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.sendKeys(keyword);
    }

    // Lấy giá trị hiện tại của ô tìm kiếm
    public String getSearchInputValue() {
        WebElement searchInput = driver.findElement(searchInputLocator);
        return searchInput.getAttribute("value");
    }
}

