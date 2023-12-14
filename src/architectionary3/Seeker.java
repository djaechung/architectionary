package architectionary3;

import java.util.ArrayList;
import java.util.HashMap;

/** The seeker takes a string of known and unknown characters and
 * produces a list of potential themes from the official wordbank
 * which are consistent with the known information.
 */
public class Seeker {

    /** Constructor for a Seeker object. */
    Seeker(){}

    /** Takes in the length of the theme and a string representation of the knowns
     * and unknowns of the theme and sorts through all known themes to produce a list
     * of possible results in string form.
     * @param length the length of the theme being queried (how many characters)
     * @param theme the string representation of the theme. * means unknown.
     * @return an ArrayList of strings representing the possible themes based on known
     * characters.
     */
    ArrayList<String> find(int length, String theme) {

        ArrayList<String> results = new ArrayList<String>();
        int numChars = length;
        char[] chars = theme.toCharArray();
        int numSpaces = 0;

        HashMap<Integer, Character> knowns = new HashMap<Integer, Character>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '_') {
                knowns.put(i, chars[i]);
            }
            if (chars[i] == ' ') {
                numSpaces ++;
            }
        }

        ArrayList<String> options = new ArrayList<String>();
        for (String entry: _wordBank.catalog) {
            if (entry.length() == numChars) {
                options.add(entry);
            }
        }

        for (String candidate: options) {
            boolean consistent = true;
            int numSpacesReal = 0;
            for (int pos: knowns.keySet()) {
                if (!(candidate.charAt(pos) == (knowns.get(pos)))) {
                    consistent = false;
                    break;
                }
            }
            for (int i = 0; i < numChars; i++) {
                if (candidate.charAt(i) == ' ') {
                    numSpacesReal++;
                }
            }
            if (numSpaces != numSpacesReal) {
                consistent = false;
            }
            if (consistent) {
                results.add(candidate);
            }
        }
        return results;
    }

    /** The wordbank of themes this seeker has to work with. */
    private WordBank _wordBank = new WordBank();
}