package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        String[] emails = {
                "info@gmail.com",
                "info@yandex.ru",
                "mk@host.com",
                "support@hexlet.io",
                "info@hotmail.com",
                "support.yandex.ru@host.com"
        };

        List<String> emailsList = Arrays.asList(emails);
        System.out.println(App.getCountOfFreeEmails(emailsList)); // 3
    }
}

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> list) {
        Set<String> acceptableNames = Set.of("gmail.com", "yandex.ru", "hotmail.com");
        return list.stream()
                .filter(s1 -> acceptableNames.contains(s1.substring(s1.indexOf('@') + 1)))
                .count();
    }

}

// END
