import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebFormOneTests extends Setup{

    @Test
    public void submitPracticeWebForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");


        WebElement acceptCookiesButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();
        Thread.sleep(3000);

        List<WebElement> elements = driver.findElements(By.className("form-control"));

        elements.get(0).sendKeys("John");
        elements.get(1).sendKeys("12345678999");
        WebElement calenderElement = driver.findElement(By.id("edit-date"));
        calenderElement.click();
        calenderElement.sendKeys("12", "12", "1234");
        elements.get(3).sendKeys("example@gmail.com");
        elements.get(4).sendKeys("This is a bit about myself");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");

        driver.findElement(By.id("edit-uploadocument-upload"))
                .sendKeys(System.getProperty("user.dir")+"/src/test/resources/java.png");


        WebElement checkbox = driver.findElement(By.xpath("//input[@id='edit-age' and @type='checkbox']"));
        Thread.sleep(3000);
        checkbox.click();

        driver.findElement(By.id("edit-submit")).click();

        Thread.sleep(3000);
        String actualResult = driver.findElement(By.tagName("h1")).getText();
        String expectedResult = "Thank you for your submission!";
        System.out.println("Actual Result: " + actualResult);
        Assertions.assertTrue(actualResult.contains(expectedResult));
    }
}
