import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Corsa
{
    private int roadLength;
    private ArrayList<ThreadCavallo> cavalli;
    private ArrayList<String> ranking = new ArrayList<String>(Arrays.asList("vuoto", "vuoto", "vuoto"));

    public Corsa(int rL, ArrayList<ThreadCavallo> c)
    {
        roadLength = rL;
        cavalli = c;
    }

    public int getRoadLength()
    {
        return roadLength;
    }

    public ArrayList<String> getRanking()
    {
        return ranking;
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
        } catch(Exception e){}
        System.out.println("La gara è terminata");
        System.out.println("La classifica è \n" + "Al primo posto " + ranking.get(0) + "\n" + "Al secondo posto " + ranking.get(1) + "\n" + "Al terzo posto " + ranking.get(2));
        
        String filename;
        try(Scanner input = new Scanner(System.in))
        {
            System.out.println("inserire il nome del file dove salvare le modifiche");
            filename = input.nextLine();
        }
        try
        {
            Writelines cp = new Writelines(filename + ".txt", getRanking());
        }
        catch(IOException ex)
        {
            System.out.println("Errore di I/O.");
            System.exit(1);
        }
    }

    public void generateRanking(String horse)
    {
        boolean horseAdded = false;
        for(int pos = 0; pos < ranking.size(); pos++)
        {
            if(ranking.get(pos).equals("vuoto"))
            {
                ranking.set(pos, horse);
                horseAdded = true;
                break;
            }
            pos++;
        }
        if(!horseAdded)
        {
            ranking.add(horse);
        }

        /* 
        array MUST have be at least 3 full positions when printing in file, fill empty positions if a horse gets injured
        or remove as much positions as horses injured when printing rankings in the file @ (Writelines row 9)
        */ 
    }
}