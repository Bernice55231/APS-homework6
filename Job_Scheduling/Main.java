import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] text = br.readLine().split(" ");
        int n = Integer.parseInt(text[0]);
        int m = Integer.parseInt(text[1]);
        boolean conflict = false;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> repeat = new HashMap<>();

        for(int i = 0; i < m+n; i++) {
            text = br.readLine().split(" ");
            if(map.containsKey(Integer.parseInt(text[0]))) {
                // System.out.println("Enter here (io part): " + " Key = " + text[0]);
                conflict = true;
            }      
            else {
                map.put(Integer.parseInt(text[0]), Integer.parseInt(text[1]));
            }
            if(i >= n) {
                repeat.put(Integer.parseInt(text[0]), Integer.parseInt(text[2]));
            }
        }
        // System.out.println("map: ");
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        // }
        // System.out.println("repeat: ");
        // for (Map.Entry<Integer, Integer> entry : repeat.entrySet()) {
        //     System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
        // }
        
        if(conflict) {
            System.out.println("CONFLICT");
        } else {
            conflict = examine(map, repeat);
            if(conflict) 
                System.out.println("CONFLICT");
            else {
                System.out.println("NO CONFLICT");
            }
            
        }
    }

    public static boolean examine(Map<Integer, Integer> map, Map<Integer, Integer> repeat) {
        if(map.isEmpty()) return false;
        TreeSet<Integer> keys = new TreeSet<>(map.keySet());
        int tmp = keys.pollFirst();
        while(!keys.isEmpty()) {
            if(map.get(tmp) <= keys.first()) {
                tmp = keys.pollFirst();
            } else {
                // System.out.println("examine: " + " start_time: " + tmp + " end_time: " + map.get(tmp) + " keys.first(): " + keys.first());
                return true;
            }
        }
        ArrayList<Integer> values = new ArrayList<>(map.values());
        int max_end = 0;
        for(Integer ele : values) {
            if(ele > max_end) {
                max_end = ele;
            }
        }
        for(Integer key : repeat.keySet()) {
            int repeat_time = repeat.get(key);
            if(key + repeat.get(key) < max_end) {
                int loop = (max_end % repeat_time == 0) ? max_end / repeat_time : (max_end / repeat_time + 1);
                for(int i = 1; i <= loop; i++) {
                    map.put(key + repeat_time * i, map.get(key) + repeat_time * i);
                }
            }
        }
        keys = new TreeSet<>(map.keySet());
        tmp = keys.pollFirst();
        while(!keys.isEmpty()) {
            if(map.get(tmp) <= keys.first()) {
                tmp = keys.pollFirst();
            } else {
                // System.out.println("examine: " + " start_time: " + tmp + " end_time: " + map.get(tmp) + " keys.first(): " + keys.first());
                return true;
            }
        }
        return false;

    }
}
