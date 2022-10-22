import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();

        System.out.println("combination(26,1) = " + combination(26,1));

        if(checkStrictAscending(arr)) {
            System.out.print(retrieveIndex(arr));
        } else {
            System.out.print(0);
        }

        
    }
    
    public static int retrieveIndex(char[] arr) {
        int len = arr.length;
        int index = 0;
        // add all the index before this length
        for(int i = 1; i < len; i++) {
            index += combination(26, i);
        }
        // then check at this length, this string should be at what position
        for(int i = 0; i < len-1; i++) {
            int gap = (i == 0) ? (int)(arr[i] - 'a') : (int)(arr[i] - arr[i-1]) - 1;
            int n = (int)('z' - arr[i]);
            for(int j = 0; j < gap; j++) {
                index += combination(n+j+1, len-i-1);
            }
        }
        index += (len == 1) ? (int)(arr[len-1] - 'a')+1 : (arr[len-1] - arr[len-2]);
        return index;
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

    public static long combination(int n, int r) {
        long comb = factorial(n) / (factorial(r) * factorial(n-r));
        return comb;
    }

    public static long factorial(int n) {
        if(n==0)
            return 1;
        long res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
