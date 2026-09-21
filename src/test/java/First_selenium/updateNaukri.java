package First_selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.KeyStore;
import java.time.LocalTime;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class updateNaukri {
    public void updateNaukri(String ID, String Pass, String msg, String chaR,String Profile,boolean flag) throws InterruptedException {
        WebElement lastUpdated = null;
        WebDriver driver = null;
        boolean profileUpdated = false;
        int H=10;
        if (flag) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\mvn project\\chromedriver-win64\\chromedriver.exe");
            //C:\Users\HP\OneDrive\Desktop\mvn project\chromedriver-win64\chromedriver.exe
            driver = new ChromeDriver();
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
                driver. findElement(viewBtn).click();
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

            List<WebElement> acceptButton = driver.findElements(
                    By.xpath("//button[@type='button' and normalize-space()='Accept all']")
            );

            if (!acceptButton.isEmpty() && acceptButton.get(0).isDisplayed()) {
                acceptButton.get(0).click();
                System.out.println("Cookie consent: Accept all clicked");
            }

            Thread.sleep(1000);

            if ("Freshar".equals(Profile)) {
                driver.findElement(By.id("submit-btn")).click();
            } else {
                driver.findElement(By.id("saveBasicDetailsBtn")).click();
            }
            Thread.sleep(1000);
            System.out.println("-------------------------------------------------------------------------------------------");

            // profileUpdated = false;

            try {

                List<WebElement> elementst = driver.findElements(
                        By.xpath("//span[contains(@class,'mod-date-val')]")
                );

                // First validation
                Assert.assertFalse(
                        elementst.isEmpty(),
                        "Validation Failed: Last Updated element is not available"
                );

                // Only access get(0) after confirming list is not empty
                lastUpdated = elementst.get(0);

                // Second validation
                Assert.assertTrue(
                        lastUpdated.isDisplayed(),
                        "Validation Failed: Last Updated element is not visible"
                );

                // Third validation
                String text = lastUpdated.getText();

                Assert.assertTrue(
                        text.contains("Today"),
                        "Validation Failed: Expected 'Today' but found: " + text
                );

                // ALL validations passed
                profileUpdated = true;

                System.out.println("Validation Passed: Last updated " + text);
                System.out.println(
                        msg + " - P R O F I L E ___ U P D A T E D ___ S U C C E S S F U L L Y"
                );

            } catch (AssertionError e) {

                // Validation failed
                profileUpdated = false;

                System.out.println("PROFILE UPDATE VALIDATION FAILED");
                System.out.println("Reason: " + e.getMessage());

                // Send failure notification
                LocalTime now = LocalTime.now();
                int hour = now.getHour();

                if (hour == H) {
                    EmailUtil.sendEmail(
                            ID,
                            "DoNotReply_Naukri Profile Update Failed",
                            "Hello " + msg + ",\n\n"
                                    + "Not able to update profile automatically.\n\n"
                                    + "Please update the information on the Naukri portal manually using the following steps:\n\n"
                                    + "1. Login In Naukri Portal.\n"
                                    + "2. Click On Complete Profile/View Profile\n"
                                    + "3. Click the pencil (✏️) icon next to your name to navigate to the Basic Information section.\n"
                                    + "4. Review and update all missing or incomplete information.\n"
                                    + "5. Ensure that all fields marked with an asterisk (*) are completed, as they are mandatory.\n"
                                    + "6. Save the changes and verify that all mandatory fields have been updated successfully.\n\n"

                    );
                    System.out.println("Failure Notification Sent");
                }



                // Keep TestNG test as FAILED
                throw e;
            }

            String text = lastUpdated.getText();
    
            Assert.assertTrue(
                    text.contains("Today"),
                    "Validation Failed: Expected 'Today' but found: " + text
    
            );
            //System.out.println("Validation Passed: Last updated " + text);
            //System.out.println(msg + " - P R O F I L E ___ U P D A T E D ___ S U C C E S S F U L L Y");
    
            driver.quit();
        }

        System.out.println("Profile Updated = " + profileUpdated);

        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        if (profileUpdated && hour == H) {

            EmailUtil.sendEmail(
                    ID,
                    "DoNotReply_Naukri Profile Updated",
                    "Hello " + msg + ",\n\n"
                            + "Your Naukri profile was updated successfully.\n\n"
                            + "Update time: " + now
            );

            System.out.println("Success Notification Sent");

        } else {

            System.out.println("Success Notification Not Sent");
        }
        System.out.println("-------------------------------------------------------------------------------------------");

    }
    }




