package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        // Получение значения по ключу
        System.out.println(storage.get("key", "default")); // "10"
        System.out.println(storage.get("unknown", "default")); // "default"
        // Установка нового значения
        storage.set("key2", "value2");
        System.out.println(storage.get("key2", "default")); // "value2"
        // Удаление ключа
        storage.unset("key2");
        System.out.println(storage.get("key2", "default")); // "default"
        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        System.out.println(data); // => {key=10};

        KeyValueStorage storage2 = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        System.out.println(storage2.get("key", "default")); // "value"

    }

    public static void swapKeyValue(KeyValueStorage data) {
        for (Entry<String, String> entry : data.toMap().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            data.set(value, key);
            data.unset(key);
        }
    }
}

// END
