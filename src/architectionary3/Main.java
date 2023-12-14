package architectionary3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/** Main class for the architectionary build theme-guessing program.
 * Directs the flow of data from initial arguments to the seeker class.
 */
public class Main {

    /** Constructor for main object. Not of much use for this program. */
    Main(){}

    /** The main method calls on the seeker object to seek a list of possible
     * themes based on the information we know.
     * @param args the information known about the theme. Unknown characters
     *             are underscores "_" and spaces count as characters.
     */
    public static void main(String... args) throws FileNotFoundException {

        // Below IF statement was to help Benjamin debug
        if (args[0].equals("hi")) {
            String CWD = System.getProperty("user.dir") + File.separator + "src" + File.separator + "architectionary3" + File.separator;
            //System.out.println(CWD);
            File hiFile = new File(CWD + "wug.txt");
            System.out.println(hiFile.exists());
            FileReader readHi = new FileReader(hiFile);
            System.exit(1);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0;  i < args.length; i++) {
            builder.append(args[i]);
            if (i != args.length-1) {
                builder.append(" ");
            }
        }
        String themeFragment = builder.toString();

        int numChars = themeFragment.length();
        ArrayList<String> results = seeker.find(numChars, themeFragment);

        if (results.isEmpty()) {
            _results = "No results found.";
            return;
        }

        _results = "";
        _results = "<html>";
        for (String result: results) {
            _results += result + "   ";
        }
        _results += "<html>";
        return;
    }

    /** Return the results of the search I requested from the Seeker. */
    public static String getResults() {
        return _results;
    }

    /** The seeker object that does the searching work. */
    private static Seeker seeker = new Seeker();

    /** The results of the search I requested from the Seeker,
     *  all in one string.
     */
    private static String _results = "";

}
