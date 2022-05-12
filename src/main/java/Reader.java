import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<Recipes> read(String filepath){
        ArrayList<Recipes> x  = new ArrayList<>();
        char[] d=new char[100];
        try {
            FileReader reader=new FileReader(filepath);
            x.add(String.copyValueOf(d));
            reader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return x;
    }
}
