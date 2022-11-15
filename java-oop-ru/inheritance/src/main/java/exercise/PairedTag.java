package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
class PairedTag extends Tag {
    private final String body;
    private final List<Tag> childrenList;

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> childrenList) {
        super(name, attributes);
        this.body = body;
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        StringBuilder tagText = new StringBuilder();
        tagText
                .append(super.toString())
                .append(body);


        for (Tag tag : childrenList) {
            tagText.append(tag.toString());
        }
        tagText
                .append("</")
                .append(super.getName())
                .append(">");
        return tagText.toString();
    }
}
// END
