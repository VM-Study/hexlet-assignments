package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class Tag {
    private final String name;
    private final Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        if (attributes.isEmpty()) {
            return "<" + name + ">";
        }

        return "<" + name + attributes.entrySet()
                .stream()
                .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                .collect(Collectors.joining(" ", " ", ">"));
    }

    public String getName() {
        return name;
    }
}

// END
