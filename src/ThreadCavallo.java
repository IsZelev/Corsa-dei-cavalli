public class ThreadCavallo implements Runnable
{
    private String name;
    private boolean last;
    private int speed;
    private int roadLength;

    public ThreadCavallo(int rl, String n, int ms, boolean l)
    {
        roadLength = rl;
        name = n;
        speed = ms;
        last = l;
    }

    public String getName()
    {
        return name;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public boolean getLast()
    {
        return last;
    }

    @Override
    public void run()
    {
        for(int i = 0; i <= this.roadLength; i+=speed)
        {
            System.out.println(this.getName() + " ha percorso " + i + " metri");
            try
            {
                Thread.sleep(2000-(speed)*100);
            } catch (InterruptedException e){}
        }
       System.out.println("Il cavallo " + this.getName() + " è arrivato");
       
    }
}