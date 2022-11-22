package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        return Stream.of(content.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replace("\"", ""))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .filter(command -> command.startsWith("X_FORWARDED"))
                .map(command -> command.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }
}
//END
