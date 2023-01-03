package exercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import io.javalin.Javalin;
import io.ebean.DB;

import exercise.domain.User;
import exercise.domain.query.QUser;
import io.ebean.Database;

class AppTest {

    private static Javalin app;
    private static String baseUrl;

    // BEGIN
    // метод, который перед началом тестов запускает приложение.
    @BeforeAll
    public static void beforeAll() {
        // В методе получите экземпляр приложения
        app = App.getApp();

        // Запустите приложение при помощи метода start() на случайном порту
        app.start(0);

        // Получите порт, на котором запустилось приложение
        int port = app.port();

        // сформируйте базовый URL и запишите его в свойство baseUrl класса
        baseUrl = "http://localhost:" + port;
    }

    // метод, который после завершения всех тестов остановит приложение
    @AfterAll
    public static void afterAll() {
        app.stop();
    }
    // END

    // Между тестами база данных очищается
    // Благодаря этому тесты не влияют друг на друга
    @BeforeEach
    void beforeEach() {
        Database db = DB.getDefault();
        db.truncate("user");
        User existingUser = new User("Wendell", "Legros", "a@a.com", "123456");
        existingUser.save();
    }

    // проверяется работа исходной страницы приложения, вывод всех пользователей
    @Test
    void testUsers() {

        // Выполняем GET запрос на адрес http://localhost:port/users
        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users")
            .asString();
        // Получаем тело ответа
        String content = response.getBody();

        // Проверяем код ответа
        assertThat(response.getStatus()).isEqualTo(200);
        // Проверяем, что страница содержит определенный текст
        assertThat(response.getBody()).contains("Wendell Legros");
    }

    // проверяется вывод формы создания пользователя
    @Test
    void testNewUser() {

        HttpResponse<String> response = Unirest
            .get(baseUrl + "/users/new")
            .asString();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    // BEGIN
    // проверяет, что при отправке валидных данных приходит ответ с кодом 302,
    // новый пользователь создаётся и добавляется в базу данных
    @Test
    void testCreateUser() {

        String firstName = "Aleksandr";
        String lastName = "Vasiliev";
        String email = "aleks@yandex.ru";
        String password = "123456";

        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", firstName)
                .field("lastName", lastName)
                .field("email", email)
                .field("password", password)
                .asEmpty();

        // ответ с кодом 302
        assertThat(responsePost.getStatus()).isEqualTo(302);
        assertThat(responsePost.getHeaders().getFirst("Location")).isEqualTo("/users");

        // проверить, что пользователь с такими данными есть в базе,
        // получите его из базы и
        // проверьте, что его данные соответствуют тем, что были отправлены в запросе
        User actualUser = new QUser()
                .lastName.equalTo(lastName)
                .findOne();

        assertThat(actualUser).isNotNull();
        assertThat(actualUser.getFirstName()).isEqualTo(firstName);
        assertThat(actualUser.getLastName()).isEqualTo(lastName);
        assertThat(actualUser.getEmail()).isEqualTo(email);
    }

    // что при отправке не валидных данных приходит ответ с кодом 422
    // новый пользователь не добавляется в базу данных
    void testCreateUserWithIncorrectName1() {

        String firstName = "Aleksandr";
        String lastName = "";
        String email = "al@yandex.ru";
        String password = "12345";

        HttpResponse<String> responsePost = Unirest
                .post(baseUrl + "/users")
                .field("firstName", firstName)
                .field("lastName", lastName)
                .field("email", email)
                .field("password", password)
                .asString();

        assertThat(responsePost.getStatus()).isEqualTo(422);

        String content = responsePost.getBody();

        assertThat(content).contains("Aleksandr");
        assertThat(content).contains("al@yandex.ru");
    }
    // END
}
