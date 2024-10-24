public class ThreadCavallo implements Runnable
{
    private String name;
    private boolean last;

    public ThreadCavallo(String n, boolean l)
    {
        name = n;
        last = l;
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
            notifyAll();

        for(int i = 0; i > roadLength; i++)
            System.out.println(this.getName() + " ha percorso " + i + " metri");
        
        System.out.println("Il cavallo " + this.getName() + " è arrivato");
    }

}