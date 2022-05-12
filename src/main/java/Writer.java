import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    public static void save(ArrayList<Recipes> recipes, String filepath){
        try {
            FileWriter writer=new FileWriter(filepath);
            for(Recipes recipes1:recipes){
                writer.write("Nev: "+recipes1.getName()+"\n");
                writer.write("Leiras: "+recipes1.getDescription()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
