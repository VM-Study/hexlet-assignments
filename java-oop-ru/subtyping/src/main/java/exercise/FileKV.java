package exercise;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private final String path;

    FileKV(String path, Map<String, String> dataMap) {
        this.path = path;
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            set(key, value);
        }
    }

    @Override
    public void set(String key, String value) {
        String dataFile = Utils.readFile(path);
        Map<String, String> dataMap = Utils.unserialize(dataFile);
        dataMap.put(key, value);
        String updatedDataFile = Utils.serialize(dataMap);
        Utils.writeFile(path, updatedDataFile);
    }

    @Override
    public void unset(String key) {
        String dataFile = Utils.readFile(path);
        Map<String, String> dataMap = Utils.unserialize(dataFile);
        dataMap.remove(key);
        String updatedDataFile = Utils.serialize(dataMap);
        Utils.writeFile(path, updatedDataFile);
    }

    @Override
    public String get(String key, String defaultValue) {
        String dataFile = Utils.readFile(path);
        Map<String, String> dataMap = Utils.unserialize(dataFile);
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String dataFile = Utils.readFile(path);
        Map<String, String> dataMap = Utils.unserialize(dataFile);
        return new HashMap<>(dataMap);
    }
}

// END
