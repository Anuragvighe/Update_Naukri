package First_selenium;

import org.testng.annotations.Test;

public class CallingNaukriFunction extends updateNaukri{
    updateNaukri UN=new updateNaukri();
    public CallingNaukriFunction() throws InterruptedException {
    }

    @Test(priority = 1)
    public void CallingNaukriFunction28498() throws InterruptedException {
        UN.updateNaukri("anuragvighe28498@gmail.com","Anurag@123","ANURAG28498","e");
    }
    @Test(priority = 2)
    public void CallingNaukriFunction333() throws InterruptedException {
        UN.updateNaukri("anuragvighe333@gmail.com","Anurag@123","ANURAG333","e");
    }
    @Test(priority = 3)
    public void CallingNaukriFunction28() throws InterruptedException {
        UN.updateNaukri("vigheprajwal28@gmail.com","Pass@1234","PRAJWAL28","e");
    }
    @Test(priority = 4)
    public void CallingNaukriFunction45() throws InterruptedException {
        UN.updateNaukri("anuragvighe45@gmail.com","Anurag@123","ANURAG AZURE DATA ENGINEER","e");
    }

    @Test(priority = 5)
    public void CallingNaukriFunctionSap() throws InterruptedException {
        UN.updateNaukri("dsapekshi@gmail.com","Sapekshi@1234","SAPEKSHI","o");
    }

    @Test(priority = 6)
    public void CallingNaukriFunctionSunny() throws InterruptedException {
        UN.updateNaukri("sunnytayade89@gmail.com","Pooja@8912","SUNNY","e");
    }

}

