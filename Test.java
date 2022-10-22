import java.util.*;
import java.io.*;

public class Test {
    public static int INDEX;
    public static void main(String[] args) {
        INDEX = 0;
        // mapping("acf", "", 'a');
        mapping("acf", "", 'a');
        System.out.println("FINAL INDEX = " + INDEX);
    }

    public static void mapping(String match, String curr, char tmp) {
        if(curr.length() < match.length() - 1) {
            System.out.println("INDEX = " + INDEX + " CURR = " + curr + " ACTUAL = " + curr+tmp + " tmp = " + tmp);
            if(tmp == 'z') {
                INDEX++;
                return;
            } else {
                mapping(match, curr, (char)(tmp+1));
                INDEX++;
                mapping(match, curr+tmp, (char)(tmp+1));
            }
        }
    }
}
