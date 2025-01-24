package First_selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updateNaukri {
    public void updateNaukri(String ID, String Pass) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\mvn project\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("usernameField")).sendKeys(ID);
        Thread.sleep(100);
        driver.findElement(By.id("passwordField")).sendKeys(Pass);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@type, 'submit') and text()='Login']")).click();
        //driver.findElement(By.className("nI-gNb-icon-img")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[3]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class, 'hdn')]//*[contains(@class, 'icon edit') and text()='editOneTheme']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("e");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Thread.sleep(1000);
        driver.findElement(By.id("saveBasicDetailsBtn")).click();
        Thread.sleep(1000);
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        System.out.println("done");
        driver.quit();

    }
}


