package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void main(String[] args) {
        String sentence = "java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        System.out.println(wordsCount); // => {the=1, java=2, is=1, best=1, language=1, programming=1}

        String sentence2 = "the java is the best programming language java";
        Map wordsCount2 = App.getWordCount(sentence2);
        String result = App.toString(wordsCount2);
        System.out.println(result); // =>
        // {
        //   the: 2
        //   java: 2
        //   is: 1
        //   best: 1
        //   language: 1
        //   programming: 1
        // }

        Map wordsCount3 = App.getWordCount("");
        String result2 = App.toString(wordsCount3);
        System.out.println(result2); // => {}

    }

    public static String toString(Map wordsCount) {
        String text = "";
        for (Object key : wordsCount.keySet()) {
            text += "\n  " + key + ": " + wordsCount.get(key);
        }
        if (text.length() > 0) {
            text = "{" + text + "\n}";
        } else {
            text = "{}";
        }
        return text;
    }

    public static Map getWordCount(String sentence) {
        Map<String, Integer> map = new HashMap<>();
        if (sentence.length() > 0) {
            for (String word : sentence.split(" ")) {
                map.put(word, map.getOrDefault(word, 0) + 1);//
//                if (map.containsKey(word)) {
//                    map.put(word, map.get(word) + 1);
//                } else {
//                    map.put(word, 1);
//                }
            }
        }
        return map;
    }

}
//END
