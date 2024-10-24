import java.util.ArrayList;


public class Corsa
{
    public int roadLength;
    public ArrayList<ThreadCavallo> cavalli;

    public Corsa(int rL, ArrayList<ThreadCavallo> c)
    {
        int roadLength = rL;
        ArrayList<ThreadCavallo> cavalli = c;
    }

    public int getRoadLength()
    {
        return roadLength;
    }

    public ArrayList<ThreadCavallo> getCavalli()
    {
        return cavalli;
    }

    public void startCorsa()
    {
        for(ThreadCavallo cavallo : cavalli)
        {
            cavallo.run();
            try
            {
                cavallo.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}