package First_selenium;

import org.testng.annotations.Test;
import java.util.Map;

public class CallingNaukriFunction extends JsonDataProvider{
    JsonDataProvider JDP=new JsonDataProvider();
    updateNaukri UN=new updateNaukri();
    //private boolean flag;

    public CallingNaukriFunction() {
    }

    @Test(priority = 1, dataProvider = "naukriUsers")
    public void CallingNaukriFunction(Map<String, Object> user)
            throws InterruptedException {

        UN.updateNaukri(
                (String) user.get("email"),
                (String) user.get("password"),
                (String) user.get("username"),
                (String) user.get("LW"),
                (String) user.get("ProfileType"),
                (Boolean) user.get("flag")
        );
    }

}

