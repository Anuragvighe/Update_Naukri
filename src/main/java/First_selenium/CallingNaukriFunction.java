package First_selenium;

public class CallingNaukriFunction extends updateNaukri{
    public CallingNaukriFunction() throws InterruptedException {
    }

    public static void main(String[] args) throws InterruptedException {
        updateNaukri UN=new updateNaukri();
        UN.updateNaukri("anuragvighe28498@gmail.com","Anurag@123");
        UN.updateNaukri("anuragvighe333@gmail.com","Anurag@123");
    }
}

