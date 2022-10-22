import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int[] order = new int[text.length()];
        int count = 0;
        for(int i = 0; i < text.length()-1; i++) {
            char tmp = text.charAt(i);
            if(order[i] == 0) {
                count++;
                for(int j = i+1; j < text.length(); j++) {
                    if(order[j] == 0) {
                        if(text.charAt(j) <= tmp) {
                            order[j] = count;
                            tmp = text.charAt(j);
                        }
                    } 
                }
            }
            
        }
        if(order[text.length()-1] == 0) count++;
        System.out.print(count);
    }
}
