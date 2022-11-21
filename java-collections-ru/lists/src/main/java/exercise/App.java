package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        List<String> list = new ArrayList<>();
        String[] arrSymbols = symbols.toLowerCase().split("");
        String[] arrWord = word.toLowerCase().split("");
        for (String symbol : arrSymbols) {
            list.add(symbol);
        }
        if (list.size() < word.length()) {
            return false;
        }
        for (String symbol : arrWord) {
            if (!list.remove(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(App.scrabble("rkqodlw", "world"));   // true
        System.out.println(App.scrabble("ajv", "java"));        // false
        System.out.println(App.scrabble("avjafff", "JaVa"));    // true
        System.out.println(App.scrabble("", "hexlet"));         // false
        System.out.println(App.scrabble("thlxertwq", "hexlet"));         // false

    }

}
