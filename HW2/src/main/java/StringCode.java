import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
// CS108 HW1 -- String static methods
import java.lang.String;

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     */
    public static int maxRun(String str) {
        int i = 1;
        int d = 1;
        char cur = str.charAt(0);
        int maxx = -1000000007;
        while (i != str.length()) {
            if (cur == str.charAt(i)) {
                d++;
            } else {
                cur = str.charAt(i);
                maxx = Math.max(maxx, d);
                d = 1;
            }
            i++;
        }
        return d;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     */
    public static String blowup(String str) {
        StringBuilder sub = new StringBuilder();
        int i = 0;

        while (i != str.length()) {
            char c = str.charAt(i);
            if (i == str.length() - 1 && Character.isDigit(c)) {
                break;
            }
            if (Character.isDigit(c)) {
                if (str.charAt(i + 1) == '\n') ;
                for (int j = 1; j <= c - '0'; j++) {
                    sub.append(str.charAt(i + 1));
                }
            } else {
                sub.append(c);
            }
            i++;
        }
        return sub.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
           for(int i=0; i<=a.length()-len;i++){
               String subA = a.substring(i, i+len);
               for(int j=0;j<=b.length()-len;j++){
                   String subB = b.substring(j ,j+len);
                     if(subB.equals(subA)) return true;
               }
           }
           return false;
    }

    public static void main(String[] args) {
        String a;
        String b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        int len = sc.nextInt();
        System.out.println(maxRun(a));
        System.out.println(blowup(b));
        System.out.println(stringIntersect(a, b, len));
    }
}
