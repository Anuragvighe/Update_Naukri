package First_selenium;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonDataProvider {

    @DataProvider(name = "naukriUsers")
    public Object[][] getNaukriUsers() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, String>> users =
                mapper.readValue(
                        new File("src/test/resources/User.json"),
                        List.class
                );

        Object[][] data = new Object[users.size()][1];

        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }
        return data;
    }
}
