import java.io.*;
import java.util.ArrayList;

public class Writelines
{
    public Writelines(String filename, ArrayList<String> r) throws IOException
    {
        ArrayList<String> ranking = r;
        String linea = "La classifica è \n" + "Al primo posto " + ranking.get(0) + "\n" + "Al secondo posto " + ranking.get(1) + "\n" + "Al terzo posto " + ranking.get(2);
        
        PrintWriter output = new PrintWriter(new FileWriter(filename));
        BufferedWriter input = new BufferedWriter(output);

        input.write(linea);
        input.newLine();

        input.close();
        output.close();
    }
}    