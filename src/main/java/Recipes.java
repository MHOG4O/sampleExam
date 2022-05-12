import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipes {
    private String name;
    private String description;

    public static void main(String[] args) {
        String filepath = "src/main/resources/recept.txt";
        ArrayList<String> recipes = Reader.read(filepath);
        menu(recipes);
        Writer.save(recipes,filepath);
    }
    private static final Scanner scanner=new Scanner(System.in);
    public Recipes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    static void menu(ArrayList<Recipes> recipes) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Valasszon muveletet: ");
            System.out.println("1 - Receptek listazasa\r\n2 - Uj recept hozzaadasa\r\n3 - Recept torlese\r\n4 - Receptek frissitese\r\n0 - Kilepes");
            try {
                System.out.print("--> ");choice =  scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ervenytelen.");
            }
            scanner.nextLine();
            switch (choice) {
                case 1 -> getItems(recipes);
                case 2 -> add(recipes);
                //case 3 -> modifyCar(cars);
                case 3 -> delete(recipes);
                case 4 -> UpdateRecipes.update(recipes);
            }
        }
    }

    public static void add(ArrayList<Recipes> recipes){
        Scanner scanner=new Scanner(System.in);
        String a,b;
        System.out.print("Recept neve: ");a=scanner.nextLine();
        System.out.print("Leiras: ");b=scanner.nextLine();
        recipes.add(new Recipes(a,b));
    }

    private static Recipes find(ArrayList<Recipes> recipes, String plate)
            throws IllegalArgumentException {
        for (Recipes recipe : recipes) {
            if (recipe.getName().equals(plate)) {
                return recipe;
            }
        }
        throw new IllegalArgumentException("Nem talalhato recept a megadott nevvvel: " + plate);
    }

        public static void delete(ArrayList<Recipes> recipes){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Torles: ");
        try {
            recipes.remove(find(recipes, scanner.next()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getItems(ArrayList<Recipes> recipes) {
        System.out.println(recipes.toString());
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "\n---------------------------\n" +
                "Nev: " + name + "\n" +
                "Leiras: " + description +
                "\n---------------------------\n";
    }
}
class UpdateRecipes extends Recipes{
    public UpdateRecipes(String name, String description) {
        super(name, description);
    }

    public static Recipes find(ArrayList<Recipes> recipes, String search)throws IllegalArgumentException{
        Scanner scanner=new Scanner(System.in);
        search=scanner.nextLine();
        for(Recipes recipes1:recipes){
            if(recipes1.getName().equals(search)){
                return recipes1;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen nevu recept\n");
    }

    public static void update(ArrayList<Recipes> recipes){
        System.out.println("Irja be a modositando recept nevet: ");
        Scanner sc;
        String nev,description,x;
        try{
            sc=new Scanner(System.in);x=sc.nextLine();
            Recipes recipes1=find(recipes, x);
            System.out.println("Uj nev: ");sc=new Scanner(System.in);nev=sc.nextLine();
            System.out.println("Uj leiras: ");sc=new Scanner(System.in);description=sc.nextLine();
            recipes.set(recipes.indexOf(recipes1), new Recipes(nev,description));
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}