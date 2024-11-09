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
        boolean injured = false;
        int chance = 61;
        int accidentPercent = chance - (speed * 2);
        for(int i = 0; i <= this.roadLength; i+=speed)
        {
            System.out.println(this.getName() + " ha percorso " + i + " metri");
            try
            {
                Thread.sleep(3000-(speed)*100);
            } catch (InterruptedException e){}
            
            int position = (int)(Math.random() * accidentPercent); //random int from 0 to 10, chance for an accident to occur
            int obstacle = (int) (Math.random() * accidentPercent); //sudden obstacle on the field
            
            if(obstacle == position) //if the obstacle is the same value as the horse's position, the horse gets injured and exits the race
            {
                System.out.println(this.getName() + " si è infortunato e deve uscire dalla gara");
                injured = true;
                break;
            }
        }

        if(!injured)
        {
            System.out.println("Il cavallo " + this.getName() + " è arrivato");
        }
    }
}