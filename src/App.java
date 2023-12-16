import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        File pkdx = new File("./src/pokemon.csv");
        ArrayList<String[]> csv = Parser.parseCSV(pkdx);

        //storing these as strings to make my life easier
        String[] pkmnNum = new String[csv.size()];
        String[] pkmnName = new String[csv.size()];
        String[] pkmnClass = new String[csv.size()];
        String[] pkmnType1 = new String[csv.size()];
        String[] pkmnType2 = new String[csv.size()];

        for(int i = 0; i < csv.size(); i++) {
            pkmnNum[i] = csv.get(i)[0];
            pkmnName[i] = csv.get(i)[1];
            pkmnClass[i] = csv.get(i)[2];
            pkmnType1[i] = csv.get(i)[3];
            pkmnType2[i] = csv.get(i)[4];
        }

        //this might be the last time scanscan gets used this semester
        //fly high, scanscan :(
        Scanner scanscan = new Scanner(System.in);
        System.out.print("Welcome to the pokedex, ");
        while (true) {
            System.out.println("would you like to search by name or number?");
            switch(scanscan.next()) {
            case "name":
                System.out.println("Enter a name to search by:");
                int i = find(pkmnName, scanscan.next());
                if (i == -1) {
                    System.out.println("No known pokemon by that name");
                } else {
                    System.out.print(pkmnName[i] + ", Pokemon number " + pkmnNum[i] + ", " + pkmnClass[i] + ", ");
                    if (pkmnType2[i].equals("none")) {
                        System.out.println("Type: " + pkmnType1[i]);
                    } else {
                        System.out.println("Type 1: " + pkmnType1[i] + ", Type 2: " + pkmnType2[i]);
                    }
                }
                System.out.println("Would you like to search again? (y/n)");
                String r = scanscan.next();
                if (r.equalsIgnoreCase("n")) {
                    scanscan.close();
                    System.out.println("Thank you for using the pokedex!");
                    System.exit(0);
                }
                break;
            case "number":
                System.out.println("Enter a number to search by:");
                int inum = find(pkmnNum, scanscan.next());
                if (inum == -1) {
                    System.out.println("No known pokemon by that number");
                } else {
                    System.out.print(pkmnName[inum] + ", Pokemon number " + pkmnNum[inum] + ", " + pkmnClass[inum] + ", ");
                    if (pkmnType2[inum].equals("none")){
                        System.out.println("Type: " + pkmnType1[inum]);
                    } else {
                        System.out.println("Type 1: " + pkmnType1[inum] + ", Type 2: " + pkmnType2[inum]);
                    }
                }
                System.out.println("Would you like to search again? (y/n)");
                String rr = scanscan.next();
                if (rr.equalsIgnoreCase("n")) {
                    scanscan.close();
                    System.out.println("Thank you for using the pokedex!");
                    System.exit(0);
                }
                break;
            default:
                scanscan.close();
                System.out.println("invalid arguments, get outta here");
                System.exit(0);
            }
        }

    }

    //i would've done the whole sort arrays together and then binary search to find it faster 
    //but im feeling lazy and its the last assignment and i already churned out a csv parser
    /**
     * @param arr array to look in
     * @param find what youre looking for
     * @return index of found element, -1 if not found
     */
    static int find(String[] arr, String find) {
        //bracketless code cause it looks cooler
        for(int i = 0; i < arr.length; i++)
            if (arr[i].equals(find))
                return i;
        return -1;
    }

}
