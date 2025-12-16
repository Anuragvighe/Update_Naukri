package First_selenium;

import org.testng.annotations.Test;

public class CallingNaukriFunction extends updateNaukri{
    updateNaukri UN=new updateNaukri();
    public CallingNaukriFunction() throws InterruptedException {
    }

    @Test(priority = 1)
    public void CallingNaukriFunction_Anurag28498() throws InterruptedException {
        UN.updateNaukri("anuragvighe28498@gmail.com","Anurag@123","ANURAG28498","e");
    }
    @Test(priority = 2)
    public void CallingNaukriFunction_Anurag333() throws InterruptedException {
        UN.updateNaukri("anuragvighe333@gmail.com","Anurag@123","ANURAG333","e");
    }
    @Test(priority = 3)
    public void CallingNaukriFunction_Prajwal() throws InterruptedException {
        UN.updateNaukri("vigheprajwal28@gmail.com","Pass@1234","PRAJWAL28","e");
    }
    @Test(priority = 4)
    public void CallingNaukriFunction_Anurag45() throws InterruptedException {
        UN.updateNaukri("anuragvighe45@gmail.com","Anurag@123","ANURAG AZURE DATA ENGINEER","e");
    }

    @Test(priority = 5)
    public void CallingNaukriFunction_Sap() throws InterruptedException {
        UN.updateNaukri("dsapekshi@gmail.com","Sapekshi@1234","SAPEKSHI","o");
    }

    @Test(priority = 6)
    public void CallingNaukriFunction_Sunny() throws InterruptedException {
        UN.updateNaukri("sunnytayade89@gmail.com","Pooja@8912","SUNNY","e");
    }
    @Test(priority = 7)
    public void CallingNaukriFunction_Pallavi() throws InterruptedException {
        UN.updateNaukri("virkhadepallavi28@gmail.com","Sept@is1234","PALLAVI","e");
    }

    @Test(priority = 8)
    public void CallingNaukriFunction_Chandan() throws InterruptedException {
        UN.updateNaukri("cchakrabarty954@gmail.com","Google@12345","CHANDAN","y");
    }

    @Test(priority = 9)
    public void CallingNaukriFunction_Manish() throws InterruptedException {
        UN.updateNaukri("Manishodnala@gmail.com","Manish@123","MANISH","a");
    }
}

