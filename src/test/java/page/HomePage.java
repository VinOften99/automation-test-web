package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder=\"Nội dung tìm kiếm...\"]")
    WebElement searchInput;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Kiểm tra xem ô tìm kiếm có hiển thị trên trang web hay không
    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }

    // Nhập từ khóa tìm kiếm vào ô tìm kiếm
    public void enterSearchKeyword(String keyword) {
        searchInput.sendKeys(keyword);
    }

    // Lấy giá trị hiện tại của ô tìm kiếm
    public String getSearchInputValue() {
        return searchInput.getAttribute("value");
    }
}
