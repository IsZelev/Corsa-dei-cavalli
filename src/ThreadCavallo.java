public class ThreadCavallo implements Runnable
{
    String name;

    public ThreadCavallo(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public void run()
    {
        for(int i = 0; !Thread.interrupted(); i++)
        {
            System.out.println(this.getName() + " ha percorso " + i + " metri");
        }

        System.out.println("Il cavallo " + this.getName() + " è arrivato");
    }
}
