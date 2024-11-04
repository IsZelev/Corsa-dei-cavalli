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

        for(ThreadCavallo cavallo : cavalli)
        {
            Thread thread = new Thread(cavallo);
            thread.start();
        }
        try
        {
            for(ThreadCavallo cavallo : cavalli)
            {
                Thread thread = new Thread(cavallo);
                thread.join();
            }    
        } catch(Exception e){}
    }
}