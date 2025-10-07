import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("141");
        options.addArguments("--headless");
        options.addArguments("--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTest() throws InterruptedException {

        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Oshadha");

        driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("india");

        boolean enable = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Istext enable " + enable);

        WebElement cleartext = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        cleartext.clear();

        WebElement textelement  = driver.findElement(By.id("j_idt88:j_idt97"));
        String value =  textelement.getAttribute("value");
        System.out.println("Value is " + value);

        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("oshadha@gmail.com" + Keys.TAB);

    }

}
