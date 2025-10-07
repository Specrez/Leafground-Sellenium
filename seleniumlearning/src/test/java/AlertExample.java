import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alerttest(){
        WebElement alertbox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertbox.click();
        driver.switchTo().alert().accept();

        WebElement dismiss = driver.findElement(By.id("j_idt88:j_idt93"));
        dismiss.click();
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();


        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));
        promtBox.click();
        Alert alert2 = driver.switchTo().alert();
        String alertText = alert2.getText();
        System.out.println("alert text is" + alertText);
        alert2.sendKeys("my name is oshadha");
        alert2.accept();

    }
}

