public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int maxCount = 0;
        String codon = "CAG";
        int i = 0;
        while (i <= dna.length() - 3) {
            if (dna.charAt(i) != codon.charAt(0)) {
                i++;
                count = 0;
                continue;
            }
            if (dna.substring(i, i + 3).equals(codon)) {
                count++;
                i = i + 3;
            }
            else {
                count = 0;
                i++;
            }
            if (count > maxCount) maxCount = count;
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '\n' && s.charAt(i) != '\t' && s.charAt(i) != ' ')
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        int[] repeats = {
                0, 10, 36, 40, 181
        };
        String[] diagnosis = { "not human", "normal", "high risk", "Huntington’s", "not human" };
        for (int i = 1; i < repeats.length; i++) {
            if (maxRepeats < repeats[i]) {
                return diagnosis[i - 1];
            }
        }
        return diagnosis[diagnosis.length - 1];
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String s = StdIn.readAll();
        String s1 = removeWhitespace(s);
        int countCodon = maxRepeats(s1);
        StdOut.println("max repeats = " + countCodon);
        String diagnose = diagnose(countCodon);
        StdOut.println(diagnose);
    }

}
