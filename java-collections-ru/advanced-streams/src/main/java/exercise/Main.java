package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("s.conf"));
        String result = App.getForwardedVariables(content);
        System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }
}