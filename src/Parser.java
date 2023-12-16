import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    //no objects, this is 162
    private Parser() {}

    /**
     * @param file file to be parsed
     * @param columns num of columns in your csv
     * @return
     * @throws IOException
     */
    //getting dangerously close to data structures content with all these lists
    public static ArrayList<String[]> parseCSV(File file) throws IOException {
        ArrayList<String[]> rows = new ArrayList<String[]>();
        BufferedReader readread = new BufferedReader(new FileReader(file));
        String row = readread.readLine();
        while ((row = readread.readLine()) != null) {
            rows.add(row.split(","));
        }
        //resource safe :)
        readread.close();
        return rows;
    }

}
