package exercise.controllers;

import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

import io.javalin.core.validation.Validator;
import io.javalin.core.validation.ValidationError;
import io.javalin.core.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;

import exercise.domain.User;
import exercise.domain.query.QUser;

import static java.util.Objects.isNull;

public final class UserController {

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser().orderBy().id.asc().findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser().id.equalTo(id).findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        // Добавляем валидатор для каждого поля
        Validator<String> firstNameValidator = ctx.formParamAsClass("firstName", String.class)
                // Добавляем проверку, что имя не должно быть пустым
                .check(value -> !isNull(value) && !value.isEmpty(), "firstName не должно быть пустым");

        Validator<String> lastNameValidator = ctx.formParamAsClass("lastName", String.class)
                // Добавляем проверку, что имя не должно быть пустым
                .check(value -> !isNull(value) && !value.isEmpty(), "lastName не должно быть пустым");

        Validator<String> emailValidator = ctx.formParamAsClass("email", String.class)
                // Добавляем проверку, что имя не должно быть пустым
                .check(value -> !isNull(value) && !value.isEmpty(), "email не должно быть пустым")
                .check(value -> !isNull(value) && EmailValidator.getInstance().isValid(value), "email должен быть валидным");

        Validator<String> passwordValidator = ctx.formParamAsClass("password", String.class)
                // Добавляем проверку, что имя не должно быть пустым
                .check(value -> !isNull(value) && !value.isEmpty(), "password не должно быть пустым")
                .check(value -> !isNull(value) && value.length() >= 4, "password должен быть не короче 4 символов")
                .check(value -> !isNull(value) && StringUtils.isNumeric(value), "password должен содержать только цифры");

        // Валидируем данные из форм и собираем все ошибки валидации в словарь
        // Если ошибок нет, словарь будет пустой
        Map<String, List<ValidationError<? extends Object>>> errors = JavalinValidation.collectErrors(
                firstNameValidator,
                lastNameValidator,
                emailValidator,
                passwordValidator
                );

        // Если данные не валидные
        if (!errors.isEmpty()) {
            // Устанавливаем код ответа 422 (Unprocessable Entity)
            ctx.status(422);

            // Передаем ошибки и данные компании
            ctx.attribute("errors", errors);

            User invalidUser = new User(firstName, lastName, email, password);
            ctx.attribute("user", invalidUser);
            ctx.render("users/new.html");
            return;
        }


        User user = new User(firstNameValidator.get(), lastNameValidator.get(), emailValidator.get(), passwordValidator.get());
        user.save();

        ctx.sessionAttribute("flash", "успешном создании пользователя");
        ctx.redirect("/users");
        // END
    };
}
