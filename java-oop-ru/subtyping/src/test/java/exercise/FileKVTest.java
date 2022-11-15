package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void testSet_WhenCorrectInputs() {
        Map<String, String> data = Map.of("test1", "aaa");
        KeyValueStorage storage = new FileKV(filepath.toString(), data);
        storage.set("test2", "bbb");
        Map<String, String> expected = Map.of("test1", "aaa", "test2", "bbb");
        assertThat(storage.toMap()).isEqualTo(expected);
    }

    @Test
    void testUnset_WhenCorrectInputs() {
        Map<String, String> data = Map.of("test1", "aaa");
        KeyValueStorage storage = new FileKV(filepath.toString(), data);
        storage.set("test2", "bbb");
        storage.set("test2", "ccc");
        Map<String, String> expected = Map.of("test1", "aaa", "test2", "ccc");
        assertThat(storage.toMap()).isEqualTo(expected);
    }
    // END
}
