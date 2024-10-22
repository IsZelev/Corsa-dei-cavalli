import java.util.Scanner;

public class Corsa
{
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            System.out.println("Inserire la lunghezza del percorso");
            int roadLength = input.nextInt();
            System.out.println("La lunghezza del percorso è " + roadLength + " metri");
            input.nextLine();
            System.out.println("Inserire il numero dei cavalli partecipanti");
            int n = input.nextInt();
            input.nextLine();
            while(n > 0)
            {
                System.out.println("Inserire il nome del cavallo ");
                String horseName = input.nextLine();
                startRace(horseName, roadLength);
                System.out.println(horseName + " partecipa alla gara \n");
                n--;
            }
            
        }
    }

    public static void startRace(String hn, int road)
    {
        ThreadCavallo threadCavallo = new ThreadCavallo(hn);
        Thread cavallo = new Thread(threadCavallo);
        for (int i=0; i < road; i++)
        {
            System.out.println("Cavallo " + threadCavallo.getName() + " ha percorso " + i + " metri \n");
            if(i == road) cavallo.interrupt();
        }
    }
}