import java.util.ArrayList;

public class Corsa
{
    private int roadLength;
    private ArrayList<ThreadCavallo> cavalli;

    public Corsa(int rL, ArrayList<ThreadCavallo> c)
    {
        roadLength = rL;
        cavalli = c;
    }

    public int getRoadLength()
    {
        return roadLength;
    }

    public ArrayList<ThreadCavallo> getCavalli()
    {
        return cavalli;
    }

    public void startCorsa() throws InterruptedException
    {

        ArrayList<Thread> threadCavalli = new ArrayList<>(); 
        for(ThreadCavallo cavallo : cavalli)
        {
            Thread thread = new Thread(cavallo);
            threadCavalli.add(thread);
            thread.start();
        }
        try
        {
            for(Thread thread : threadCavalli)
            {
                thread.join();
            }
            System.out.println("La gara è terminata");
        } catch(Exception e){}
    }
}