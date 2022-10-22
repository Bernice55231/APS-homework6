import java.io.*;
import java.util.*;

public class Main {
    public static int INDEX;
    public static int FINAL = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String content = br.readLine();

        if(checkStrictAscending(content.toCharArray())) {
            INDEX = 0;
            for(int i = 1; i <= content.length(); i++) {
                simulating(content, "", (char)('a' - 1), i);
            }
        } else {
            FINAL = 0;
        }
        
        System.out.print(FINAL);
    }

    public static void simulating(String match, String curr, char tmp, int remain_len) {
        if(remain_len == 0) {
            INDEX++;
            if(curr.equals(match)) {
                FINAL = INDEX;
            }
            // System.out.println("curr=" + curr + " INDEX=" + INDEX);
            return;
        }
        for(char c = (char)(tmp + 1); c <= 'z'; c++) {
            curr += (char)c;
            simulating(match, curr, c, remain_len-1);
            if(FINAL != -1) return;
            curr = curr.substring(0, curr.length()-1);
        }
    }
    public static boolean checkStrictAscending(char[] arr) {
        String origin = new String(arr);
        Arrays.sort(arr);
        String current = new String(arr);
        if(!origin.equals(current)) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;

    }
}
