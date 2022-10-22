import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

import java.io.*;

public class Main {
    private static final String REGEX = "[a-zA-Z]+";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text;
        Map<String, Integer> map = new HashMap<>();
        while((text = br.readLine()) != null && text.length() != 0) {
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text);
            while(m.find()) {
                map.put(m.group().toLowerCase(), map.getOrDefault(m.group().toLowerCase().toLowerCase(), 0)+1);
            }
        }
        TreeSet<String> keys = new TreeSet<>(map.keySet());
        for(String key : keys) {
            System.out.println(key);
        }
    }
}