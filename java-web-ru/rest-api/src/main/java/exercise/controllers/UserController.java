package exercise.controllers;

import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;
import io.ebean.DB;
import java.util.List;

import exercise.domain.User;
import exercise.domain.query.QUser;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

public class UserController implements CrudHandler {

    // метод getAll(), возвращает список всех пользователей в виде JSON-представления.
    public void getAll(Context ctx) {
        // BEGIN

        List<User> userList = new QUser()
                .orderBy()
                .id.asc()
                .findList();

        // преобразования списка пользователей в JSON
        String json = DB.json().toJson(userList);

        // отправить JSON строку в теле ответа
        ctx.json(json);

        // END
    }

    // метод getOne(), возвращает конкретного пользователя в виде JSON-представления
    public void getOne(Context ctx, String id) {
        // BEGIN

        long numericID = Long.parseLong(id);
        User user = new QUser()
                .id.equalTo(numericID)
                .findOne();

        // преобразования списка пользователей в JSON
        String json = DB.json().toJson(user);

        // отправить JSON строку в теле ответа
        ctx.json(json);

        // END
    }

    // метод create(), создаёт нового пользователя из полученного JSON-представления
    // и добавляет его в базу
    public void create(Context ctx) {
        // BEGIN

        // Получение тела запроса
        String body = ctx.body();

        // Из JSON представления из тела запроса получить экземпляр модели
        User user = DB.json().toBean(User.class, body);
        // добавляет его в базу
        user.save();

        // END
    }

    // метод update(), обновляет данные пользователя в базе данными из полученного JSON-представления
    public void update(Context ctx, String id) {
        // BEGIN

        long numericID = Long.parseLong(id);
        // Получение тела запроса
        String body = ctx.body();

        // Из JSON представления из тела запроса получить экземпляр модели
        User user = DB.json().toBean(User.class, body);

        new QUser()
                .id.equalTo(numericID)
                .asUpdate()
                .set("first_name", user.getFirstName())
                .set("last_name", user.getLastName())
                .set("email", user.getEmail())
                .set("password", user.getPassword())
                .update();

        // END
    }

    // метод, удаляет пользователя из баз
    public void delete(Context ctx, String id) {
        // BEGIN

        long numericID = Long.parseLong(id);
        new QUser()
                .id.equalTo(numericID)
                .delete();
        
        // END
    }
}
