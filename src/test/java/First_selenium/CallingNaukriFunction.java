package First_selenium;
//package First_selenium;

import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.Map;

public class CallingNaukriFunction extends JsonDataProvider {

    updateNaukri UN = new updateNaukri();

    @Test(priority = 1, dataProvider = "naukriUsers")
    public void CallingNaukriFunction(Map<String, Object> user)
            throws InterruptedException {

        // Get user details from JSON
        String email = (String) user.get("email");
        String password = (String) user.get("password");
        String username = (String) user.get("username");
        String LW = (String) user.get("LW");
        String profileType = (String) user.get("ProfileType");
        Boolean flag = (Boolean) user.get("flag");

        // 1. Update Naukri profile
        UN.updateNaukri(
                email,
                password,
                username,
                LW,
                profileType,
                flag
        );

        // 2. Check current time AFTER Naukri update
        LocalTime now = LocalTime.now();

        int hour = now.getHour();

        //System.out.println("Current time: " + now);
        //System.out.println("User email: " + email);

        // 3. Send notification between 9:00 AM and 9:59 AM
        if (hour == 9) {

            EmailUtil.sendEmail(
                    email,
                    "Naukri Profile Updated",
                    "Hello " + username + ",\n\n"
                            + "Your Naukri profile was updated successfully.\n\n"
                            + "Update time: " + now
            );
            System.out.println(
                    "Notification Sent"
            );

        }else {
        System.out.println(
                "Notification Not Sent"
        );}
    }
}
