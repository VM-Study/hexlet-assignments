package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static void main(String[] args) {
        List<Map<String, String>> users = List.of(
                Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "female"),
                Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "female"),
                Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female")
        );

        List<String> men = Sorter.takeOldestMans(users);
        System.out.println(men); // ["John Smith", "Andrey Petrov", "Vladimir Nikolaev"]

        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        System.out.println(Arrays.deepToString(image)); // =>
        // [
        //     [*, *, *, *],
        //     [*,  ,  , *],
        //     [*,  ,  , *],
        //     [*, *, *, *],
        // ]

        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage)); // =>

        // [
        //     [*, *, *, *, *, *, *, *],
        //     [*, *, *, *, *, *, *, *],
        //     [*, *,  ,  ,  ,  , *, *],
        //     [*, *,  ,  ,  ,  , *, *],
        //     [*, *,  ,  ,  ,  , *, *],
        //     [*, *,  ,  ,  ,  , *, *],
        //     [*, *, *, *, *, *, *, *],
        //     [*, *, *, *, *, *, *, *],
        // ]


    }

    public static String[][] enlargeArrayImage(String[][] image) {
        String[] a = Arrays.stream(image).flatMap(arg -> Arrays.stream(arg))
                .toArray(String[]::new);
        System.out.println("A: " + Arrays.toString(a));

        String[] b = Arrays.stream(a).flatMap(s -> Stream.of(s, s))
                .toArray(s -> new String[s]);
        System.out.println("B: " + Arrays.toString(b));

        String[][] c = Arrays.stream(image)
                .flatMap(s1 -> Stream.of(s1, s1))
                    .map(s2 -> Arrays.stream(s2)
                        .flatMap(s3 -> Stream.of(s3, s3)).toArray(String[]::new))
                .toArray(String[][]::new);

        System.out.println("C: " + Arrays.deepToString(c));


        return c;
    }
}
// END
