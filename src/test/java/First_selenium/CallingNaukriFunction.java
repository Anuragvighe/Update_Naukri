package First_selenium;

import org.testng.annotations.Test;
import java.util.Map;

public class CallingNaukriFunction extends JsonDataProvider{
    JsonDataProvider JDP=new JsonDataProvider();
    updateNaukri UN=new updateNaukri();
    public CallingNaukriFunction() throws InterruptedException {
    }

    @Test(priority = 1, dataProvider = "naukriUsers")

    public void CallingNaukriFunction(Map<String, String> user)
            throws InterruptedException {

        UN.updateNaukri(
                user.get("email"),
                user.get("password"),
                user.get("username"),
                user.get("flag")
        );
    }

}

