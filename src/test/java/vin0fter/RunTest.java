package vin0fter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTest {

    public static void main(String[] args) {
        System.out.println("hello");

        WebDriver driver;
//        System.setProperty("webdriver.chrome.driver", "")
        WebDriverManager.chromedriver().setup(); //gọi phiên bản browser
        driver = new ChromeDriver(); //khởi tạo giá trị cho browser

        driver.get("http://congnongdan.vn/");



    }
}
