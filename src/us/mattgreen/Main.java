package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Boolean.parseBoolean;

public class Main {

    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of animal would you like to create?");
        System.out.println("1: Dog");
        System.out.println("2: Cat");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            System.out.println("Dog Name:");
            String name = scanner.nextLine();
            System.out.println("Is the dog friendly (True/False):");
            String friendly = scanner.nextLine();
            try {
                Boolean friendly1 = parseBoolean(friendly);
                zoo.add(new Dog(friendly1, name));
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }

        else if (input.equals("2")) {
            System.out.println("Cat Name:");
            String name = scanner.nextLine();
            System.out.println("Mice Killed:");
            String miceKilled = scanner.nextLine();
            try {
                int miceKilled1 = Integer.parseInt(miceKilled);
                zoo.add(new Cat(miceKilled1, name));
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }

        else {
            System.out.println("Invalid input");
        }


        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }
}
