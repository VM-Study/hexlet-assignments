package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            return jsonMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car unserialize(String jsonText) {
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            return jsonMapper.readValue(jsonText, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END
}
