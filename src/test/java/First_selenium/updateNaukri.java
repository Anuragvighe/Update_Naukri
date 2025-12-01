package First_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class updateNaukri {
    public void updateNaukri(String ID, String Pass,String msg,String chaR) throws InterruptedException {
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
//        WebElement we1=driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a[@href='/mnjuser/profile' and text()='Complete']"));
//        WebElement we2=driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a[@href='/mnjuser/profile' and text()='View']"));
//        if(we1.isDisplayed()){
//            Thread.sleep(3000);
//            we1.click();}
//        else{
//            Thread.sleep(3000);
//            we2.click();}

        By completeBtn = By.xpath("//a[text()='Complete' and @href='/mnjuser/profile']");
        By viewBtn     = By.xpath("//a[text()='View' and @href='/mnjuser/profile']");

        if (driver.findElements(completeBtn).size() > 0) {
            driver.findElement(completeBtn).click();
        } else {
            driver.findElement(viewBtn).click();
        }

        //we1.click();
        //driver.findElement(By.xpath("//div[@class='view-profile-wrapper']//a[@href='/mnjuser/profile' and text()='Complete']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class, 'hdn')]//*[contains(@class, 'icon edit') and text()='editOneTheme']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys(chaR);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);");
        Thread.sleep(1000);
        driver.findElement(By.id("saveBasicDetailsBtn")).click();
        Thread.sleep(1000);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(msg+"- U P D A T E D _________ S U C C E S S F U L L Y");
        System.out.println("-------------------------------------------------------------------------------------------");

        driver.quit();

    }
}


