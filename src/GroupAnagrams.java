import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public static void main(String[] args) {

        System.out.println(
                groupAnagrams(new String[]{"bat","tab","tap","pat","cat","act","god","dog"})
        );
    }

    public static List<List<String>> groupAnagrams(String[] arr) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : arr){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
