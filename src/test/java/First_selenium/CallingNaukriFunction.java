package First_selenium;

import org.testng.annotations.Test;

public class CallingNaukriFunction extends updateNaukri{
    updateNaukri UN=new updateNaukri();
    public CallingNaukriFunction() throws InterruptedException {
    }

    @Test(priority = 1)
    public void CallingNaukriFunction28498() throws InterruptedException {
        UN.updateNaukri("anuragvighe28498@gmail.com","Anurag@123","ANURAG28498");
    }
    @Test(priority = 2)
    public void CallingNaukriFunction333() throws InterruptedException {
        UN.updateNaukri("anuragvighe333@gmail.com","Anurag@123","ANURAG333");
    }
    @Test(priority = 3)
    public void CallingNaukriFunction28() throws InterruptedException {
        UN.updateNaukri("vigheprajwal28@gmail.com","Pass@1234","PRAJWAL28");
    }

}

