package First_selenium;

import org.testng.annotations.Test;

public class CallingNaukriFunction extends updateNaukri{
    public CallingNaukriFunction() throws InterruptedException {
    }

    @Test
    public void CallingNaukriFunction() throws InterruptedException {
        updateNaukri UN=new updateNaukri();
        UN.updateNaukri("anuragvighe28498@gmail.com","Anurag@123");
        UN.updateNaukri("anuragvighe333@gmail.com","Anurag@123");
    }
}

