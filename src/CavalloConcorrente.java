public class CavalloConcorrente implements Runnable
{
    

    public void run()
    {
        CavalloConcorrente cavalloRunnable = new CavalloConcorrente();
        Thread  cavalloThread = new Thread(cavalloRunnable);
        cavalloThread.start();
    }

}
