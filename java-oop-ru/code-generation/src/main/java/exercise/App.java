package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// BEGIN
class App {
    public static void main(String[] args) {
        User owner = new User(1, "Ivan", "P", 25);
        // Вызываем автоматически сгенерированный геттер
        System.out.println(owner.getFirstName()); // "Ivan"

        Car car = new Car(1, "bmv", "x5", "black", owner);
        String jsonRepresentation = car.serialize();
        System.out.println(jsonRepresentation); // =>
          /*
          {
            "id":1,
            "brand":"bmv",
            "model":"x5",
            "color":"black",
            "owner":{
                "id":1,
                "firstName":"Ivan",
                "lastName":"P",
                "age":25
            }
          }
          */

        // получаем JSON представление объекта
        String jsonRepresentation2 = car.serialize();
        Car instance = Car.unserialize(jsonRepresentation2);
        System.out.println(instance.getBrand()); // "bmv"
        System.out.println(instance.getModel()); // "x5"

        Path path1 = Paths.get("file1.json");
        Car car1 = new Car(1, "audi", "q3", "black", owner);
        App.save(path1, car1); // Сохраняет представление объекта в файл

        Path path2 = Paths.get("file1.json");
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car2.getModel()); // "passat"
    }

    public static void save(Path filePath, Car car) {
        String content = car.serialize();
        try {
            Files.writeString(filePath, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path filePath) {
        try {
            String content = Files.readString(filePath);
            return Car.unserialize(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// END
