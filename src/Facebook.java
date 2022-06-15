
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Facebook {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sayalimammadova/Desktop/BrowserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");

        driver.findElement(By.name("email")).sendKeys("sss.mmm@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("12345");
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
        String name=driver.findElement(By.className("_9ay7")).getText();
        driver.quit();
        if (name.equalsIgnoreCase("The password you've entered is incorrect. Forgot Password?")){
//
            System.out.printf("passed");
        }
        else{
            System.out.printf("failed");
            throw new RuntimeException();
        }



    }
}
