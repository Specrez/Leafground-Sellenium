import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void clickButton() {
        driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']/span")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xy = getPosition.getLocation();
        int x = (int) xy.getX();
        int y = (int) xy.getY();
        System.out.println("x: " + x + " y: " + y);

        WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String colour = buttonColour.getCssValue("background-color");
        System.out.println("colour: " + colour);

        WebElement heightandsize = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = heightandsize.getSize().getHeight();
        int width = heightandsize.getSize().getWidth();
        System.out.println("width: " + width);
        System.out.println("height: " + height);
    }

}
