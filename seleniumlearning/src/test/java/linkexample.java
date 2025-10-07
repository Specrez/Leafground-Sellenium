import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class linkexample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void LinkTest() throws InterruptedException {

        // 1. Dashboard link
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        // 2. Destination link (safe way: get href BEFORE clicking)
        WebElement wheretogo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretogo.getAttribute("href");
        System.out.println("This link is going to: " + path);

        wheretogo.click();
        driver.navigate().back();

        // 3. Broken link check
        WebElement brokenlink = driver.findElement(By.linkText("Broken?"));
        brokenlink.click();

        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("This is a broken link (404)");
        } else {
            System.out.println("This is not broken");
        }
        driver.navigate().back();

        // 4. Duplicate link (clicking again)
        homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        // 5. Count all page links
        List<WebElement> countfullpageLinks = driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Page link count: " + pageLinkCount);

        // 6. Count links inside layout section (don’t click, just find children)
        WebElement layoutelement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countlayoutLinks = layoutelement.findElements(By.tagName("a"));
        System.out.println("Layout element link count: " + countlayoutLinks.size());
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
