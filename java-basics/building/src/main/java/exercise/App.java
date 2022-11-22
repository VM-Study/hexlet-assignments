package exercise;
import com.google.gson.Gson;
// BEGIN

import java.util.Arrays;

class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String[] fruits = {"apple", "pear", "lemon"};
        //System.out.println(Arrays.toString(fruits));
        //System.out.println(Arrays.toString(App.toJson(fruits))); // => ["apple","pear","lemon"]
    }

    public static String[] toJson(String[] json) {
        Gson gson = new Gson();
        gson.toJson(json);
        return json;
    }
}

// END
