public class ThreadCavallo implements Runnable
{
    private String name;
    private boolean last;
    private int roadLength;

    public ThreadCavallo(int rl, String n, boolean l)
    {
        name = n;
        last = l;
        roadLength = rl;
    }

    public String getName()
    {
        return name;
    }

    public boolean getLast()
    {
        return last;
    }

    @Override
    public void run()
    {
        if(this.last)
        {
            notifyAll();
        }
        for(int i = 0; i <= this.roadLength; i++)
        {
            System.out.println(this.getName() + " ha percorso " + i + " metri");
        }
        
        System.out.println("Il cavallo " + this.getName() + " è arrivato");
    }

}