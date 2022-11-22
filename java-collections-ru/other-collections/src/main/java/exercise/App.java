package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> dictionary = new TreeSet<>(data1.keySet());
        dictionary.addAll(data2.keySet());

        Map<String, String> result = new LinkedHashMap<>();

        for (String key : dictionary) {
            boolean isData1ContainsKey = data1.containsKey(key);
            boolean isData2ContainsKey = data2.containsKey(key);
            if (!isData1ContainsKey) {
                result.put(key, "added");
            }
            else if (!isData2ContainsKey) {
                result.put(key, "deleted");
            }
            else if (data1.get(key) == data2.get(key)) {
                result.put(key, "unchanged");
            }
            else {
                result.put(key, "changed");
            }
        }

        return result;
        //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
}

//END
