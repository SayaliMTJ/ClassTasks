import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.testng.Assert;


import java.time.Duration;

public class Dice {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sayalimammadova/Desktop/BrowserDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //1. Navigate to cars.com
        driver.navigate().to("https://www.dice.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("google-location-search")).sendKeys("Washington DC");
        driver.findElement(By.id("submitSearch-button")).click();

        List<WebElement> resultsList = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));
        Assert.assertEquals( 20, resultsList.size());
        for (WebElement eachResult : resultsList) {
            Assert.assertTrue(eachResult.getText().contains("SDET"));
        }
        Thread.sleep(4000);
        resultsList.get(resultsList.size()-1).click();
        Assert.assertTrue(driver.getTitle().contains("SDET"));
        driver.close();
    }
}
