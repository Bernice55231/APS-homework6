import java.io.*;
import java.util.*;

public class Main {
    public static int INDEX;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] arr = word.toCharArray();

        if(checkStrictAscending(arr)) {
            INDEX = 0;
            char[] dict = new char[5];
            for(int i = 0; i < 5; i++) {
                dict[i] = ' ';
            }
            simulation(word, dict);
            System.out.print(INDEX);
        } else {
            System.out.print(0);
        }
    }

    public static void simulation(String match, char[] dict) {
        // int len = 1;
        char tmp = 'a';
        String curr = new String(dict);
        while(!curr.trim().equals(match)) {
            dict[4] = tmp;
            curr = new String(dict);
            INDEX++;
            // System.out.println("INDEX = " + INDEX + " tmp = " + (char)tmp + " CURR = " + curr.trim());
            tmp = (char) (tmp+1);
            if(tmp > 'z') {
                if(dict[3] == ' ') {
                    dict[3] = 'a';
                } else {
                    if(dict[3] < 'y') {
                        dict[3] = (char)(dict[3] + 1);
                    } else {
                        if(dict[2] == ' ') {
                            dict[2] = 'a';
                            dict[3] = 'b';
                        } else {
                            if(dict[2] < 'x') {
                                dict[2] = (char) (dict[2] + 1);
                                dict[3] = (char) (dict[2] + 1);
                            } else {
                                if(dict[1] == ' ') {
                                    dict[1] = 'a';
                                    dict[2] = 'b';
                                    dict[3] = 'c';
                                } else {
                                    if(dict[1] < 'w') {
                                        dict[1] = (char) (dict[1] + 1);
                                        dict[2] = (char) (dict[1] + 1);
                                        dict[3] = (char) (dict[2] + 1);
                                    } else {
                                        if(dict[0] == ' ') {
                                            dict[0] = 'a';
                                            dict[1] = 'b';
                                            dict[2] = 'c';
                                            dict[3] = 'd';
                                        } else {
                                            dict[0] = (char)(dict[0] + 1);
                                            dict[1] = (char) (dict[0] + 1);
                                            dict[2] = (char) (dict[1] + 1);
                                            dict[3] = (char) (dict[2] + 1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                tmp = (char)(dict[3]+1);
            }
            
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
