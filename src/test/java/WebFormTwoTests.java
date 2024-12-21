import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebFormTwoTests extends Setup{

    @Test
    public void submitGuestRegistrationForm() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form/");

        //Generating random email and password
        String randomEmail = RandomDataGenerator.generateRandomEmail();
        String randomPassword = RandomDataGenerator.generateRandomPassword();

        List<WebElement> inputElement = driver.findElements(By.tagName("input"));
        inputElement.get(4).sendKeys("John");
        inputElement.get(5).sendKeys(randomEmail);
        inputElement.get(6).sendKeys(randomPassword);
        Thread.sleep(2000);
        inputElement.get(7).sendKeys("Doe");

        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='Male']"));
        maleRadioButton.click();

        inputElement.get(11).click();
        List <WebElement> DOByearPicker = driver.findElements(By.className("numInput"));
        DOByearPicker.get(0).click();
        DOByearPicker.get(0).sendKeys("1998");

        List <WebElement> DOBdatePicker = driver.findElements(By.xpath("//span[contains(text(), '12')]"));
        DOBdatePicker.get(0).click();

        inputElement.get(14).sendKeys("1234567890");
        inputElement.get(15).sendKeys("1111111111");
        inputElement.get(16).sendKeys("USA");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");

        WebElement dropdownElement = driver.findElement(By.id("country_1665629257"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Bangladesh");

        inputElement.get(17).click();
        List <WebElement> DOAyearPicker = driver.findElements(By.className("numInput"));
        DOAyearPicker.get(1).click();
        DOAyearPicker.get(1).sendKeys("2024");


        List <WebElement> DOAdatePicker = driver.findElements(By.xpath("//span[contains(text(), '17')]"));
        DOAdatePicker.get(1).click();


        inputElement.get(20).sendKeys("2");

        driver.findElement(By.tagName("textarea")).sendKeys("Software Engineer at Innova");

        inputElement.get(21).sendKeys("201 & 2");

        WebElement parkingRadioButton = driver.findElement(By.cssSelector("input[value='Yes']"));
        parkingRadioButton.click();

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0, 500)");

        WebElement preferenceRadioButton = driver.findElement(By.cssSelector("input[value='Single Room']"));
        preferenceRadioButton.click();

        WebElement restrictionRadioButton = driver.findElement(By.cssSelector("input[value='None']"));
        restrictionRadioButton.click();

        WebElement dropDownElement = driver.findElement(By.id("select_1665628361"));
        Select dropDownOption = new Select(dropDownElement);
        dropDownOption.selectByVisibleText("Town Hall");

        List <WebElement> checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        checkbox.get(0).click();

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0, 200)");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(3000);

        List <WebElement> actualResult = driver.findElements(By.tagName("ul"));
        String r1 = actualResult.get(9).getText();
        String expectedResult = "User successfully registered.";

        System.out.println("Actual Result: " + r1);

        Assertions.assertTrue(r1.contains(
                expectedResult
        ));

    }
}
