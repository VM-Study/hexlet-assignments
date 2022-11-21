package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(s -> s.get("gender").equals("male"))
                .sorted(Comparator.comparing(s -> s.get("birthday")))
                .map(s -> s.get("name"))
                .collect(Collectors.toList());
    }
}


// END
