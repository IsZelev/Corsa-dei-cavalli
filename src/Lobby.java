import java.util.ArrayList;
import java.util.Scanner;

public class Lobby
{
    public static void main(String[] args) throws InterruptedException
    {
        try(Scanner input = new Scanner(System.in))
        {
            ArrayList<ThreadCavallo> cavalli = new ArrayList<ThreadCavallo>();
            
            System.out.println("Inserire la lunghezza del percorso");
            int rL = input.nextInt();
            
            System.out.println("La lunghezza del percorso è " + rL + " metri");
            input.nextLine();

            System.out.println("Inserire il numero dei cavalli partecipanti");
            int n = input.nextInt();
            input.nextLine();
        
            while(n > 0)
            {
                System.out.println("Inserire il nome del cavallo ");
                String horseName = input.nextLine();
                System.out.println("Inserire la velocità del cavallo in metri al secondo");
                int ms = input.nextInt();
                input.nextLine();

                boolean last = (n == 1? true : false);
                ThreadCavallo cavallo = new ThreadCavallo(rL, horseName, ms, last);
                cavalli.add(cavallo);
                System.out.println(horseName + " partecipa alla gara \n");
                n--;
            }
            Corsa corsa_cavalli = new Corsa(rL, cavalli);
            corsa_cavalli.startCorsa();
        }
    }    
}