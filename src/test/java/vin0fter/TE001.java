package vin0fter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class TE001 {
    private WebDriver driver;

    public void setUp() {
        // Thiết lập driver cho trình duyệt Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testSearchInputField() {
        // Mở trang web
        driver.get("http://congnongdan.vn/");

        // Kiểm tra sự tồn tại của ô tìm kiếm
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder=\"Nội dung tìm kiếm...\"]"));

        if (searchInput.isDisplayed()) {
            System.out.println("Ô tìm kiếm tồn tại");

            // Nhập dữ liệu vào ô tìm kiếm
            String keyword = "từ khóa mẫu";
            searchInput.sendKeys(keyword);

            // Kiểm tra dữ liệu đã nhập có trùng với dữ liệu hiển thị trong ô tìm kiếm hay không
            if (searchInput.getAttribute("value").equals(keyword)) {
                System.out.println("Dữ liệu nhập vào trùng khớp");
            } else {
                System.out.println("Dữ liệu nhập vào không trùng khớp");
            }
        } else {
            System.out.println("Ô tìm kiếm không tồn tại");
        }
    }

    public void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        TE001 test = new TE001();
        test.setUp();
        test.testSearchInputField();
        test.tearDown();
    }


}
