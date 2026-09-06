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


    }
}
