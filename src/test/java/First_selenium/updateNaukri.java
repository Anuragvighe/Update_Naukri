package First_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalTime;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class updateNaukri {
    public void updateNaukri(String ID, String Pass, String msg, String chaR,String Profile,boolean flag) throws InterruptedException {
        if (flag) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\mvn project\\New\\chromedriver-win64\\chromedriver.exe");
            //C:\Users\HP\OneDrive\Desktop\mvn project\chromedriver-win64\chromedriver.exe
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.id("usernameField")).sendKeys(ID);
            Thread.sleep(100);
            driver.findElement(By.id("passwordField")).sendKeys(Pass);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[contains(@type, 'submit') and text()='Login']")).click();
            Thread.sleep(4000);
            By completeBtn = By.xpath("//a[text()='Complete' and @href='/mnjuser/profile']");
            By viewBtn = By.xpath("//a[text()='View' and @href='/mnjuser/profile']");
            By check = By.xpath("//div[contains(@class,'chatBot-ic-cross')]");

            List<WebElement> elements = driver.findElements(check);

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                elements.get(0).click();
            }

            if (driver.findElements(completeBtn).size() > 0) {
                driver.findElement(completeBtn).click();
            } else {
                driver.findElement(viewBtn).click();
            }
            Thread.sleep(2000);
            if ("Fresher".equals(Profile)) {
                driver.findElement(By.xpath("//div[contains(@class,'personal-details summary-container')]//*[contains(@class,'new-pencil')]")).click();
            } else {
                driver.findElement(By.xpath("//div[contains(@class, 'hdn')]//*[contains(@class, 'icon edit') and text()='editOneTheme']")).click();
            }
            Thread.sleep(1000);
            driver.findElement(By.id("name")).sendKeys(Keys.BACK_SPACE);
            Thread.sleep(1000);
            driver.findElement(By.id("name")).sendKeys(chaR);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 500);");
            Thread.sleep(1000);
            if ("Freshar".equals(Profile)) {
                driver.findElement(By.id("submit-btn")).click();
            } else {
                driver.findElement(By.id("saveBasicDetailsBtn")).click();
            }
            Thread.sleep(1000);
            System.out.println("-------------------------------------------------------------------------------------------");



            elements = driver.findElements(
                    By.xpath("//span[contains(@class,'mod-date-val')]")
            );

            Assert.assertFalse(
                    elements.isEmpty(),
                    "Validation Failed: Last Updated element is not available"
            );

            WebElement lastUpdated = elements.get(0);

            Assert.assertTrue(
                    lastUpdated.isDisplayed(),
                    "Validation Failed: Last Updated element is not visible"
            );

            String text = lastUpdated.getText();

            Assert.assertTrue(
                    text.contains("Today"),
                    "Validation Failed: Expected 'Today' but found: " + text

            );
            System.out.println("Validation Passed: Last updated " + text);
            System.out.println(msg + " - P R O F I L E ___ U P D A T E D ___ S U C C E S S F U L L Y");

            driver.quit();

            // 2. Check current time AFTER Naukri update
            LocalTime now = LocalTime.now();

            int hour = now.getHour();

            //System.out.println("Current time: " + now);
            //System.out.println("User email: " + email);

            // 3. Send notification between 9:00 AM and 9:59 AM
            if (hour == 16) {

                EmailUtil.sendEmail(
                        ID,
                        "Naukri Profile Updated",
                        "Hello " + msg + ",\n\n"
                                + "Your Naukri profile was updated successfully.\n\n"
                                + "Update time: " + now
                );
                System.out.println(
                        "Notification Sent"
                );
                System.out.println("-------------------------------------------------------------------------------------------");


            }else {
                System.out.println(
                        "Notification Not Sent"
                );
                System.out.println("-------------------------------------------------------------------------------------------");

            }



        }
    }

}


