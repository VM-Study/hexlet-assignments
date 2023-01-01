package exercise.controllers;

import io.javalin.http.Handler;
import io.ebean.PagedList;
import java.util.List;

import exercise.domain.query.QArticle;
import exercise.domain.Article;
import exercise.domain.Category;
import exercise.domain.query.QCategory;

public final class ArticleController {

    public static Handler listArticles = ctx -> {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int rowsPerPage = 10;
        int offset = (page - 1) * rowsPerPage;

        PagedList<Article> pagedArticles = new QArticle()
            .setFirstRow(offset)
            .setMaxRows(rowsPerPage)
            .orderBy()
                .id.asc()
            .findPagedList();

        List<Article> articles = pagedArticles.getList();

        ctx.attribute("articles", articles);
        ctx.attribute("page", page);
        ctx.render("articles/index.html");
    };

    public static Handler newArticle = ctx -> {
        List<Category> categories = new QCategory().findList();
        ctx.attribute("categories", categories);
        ctx.render("articles/new.html");
    };

    public static Handler createArticle = ctx -> {
        String title = ctx.formParam("title");
        String body = ctx.formParam("body");
        long categoryId = ctx.formParamAsClass("categoryId", Long.class).getOrDefault(null);

        Category category = new QCategory()
            .id.equalTo(categoryId)
            .findOne();

        Article article = new Article(title, body, category);
        article.save();

        ctx.sessionAttribute("flash", "Статья успешно создана");
        ctx.redirect("/articles");
    };

    public static Handler showArticle = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        Article article = new QArticle()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("article", article);
        ctx.render("articles/show.html");
    };

    public static Handler editArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();

        List<Category> categories = new QCategory().findList();

        // установить атрибут в запрос и таким образом передать данные в шаблон
        ctx.attribute("article", article);
        ctx.attribute("categories", categories);

        // Для рендеринга шаблона передав туда путь к шаблону
        ctx.render("articles/edit.html");

        // END
    };

    public static Handler updateArticle = ctx -> {
        // BEGIN
        String title = ctx.formParam("title");
        String body = ctx.formParam("body");

        long categoryId = ctx.formParamAsClass("categoryId", Long.class).getOrDefault(null);
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        new QArticle()
                .id.equalTo(id)
                .asUpdate()
                .set("title", title)
                .set("body", body)
                // см файл структуры базы данных
                // resources/dbmigration/model/1.0__initial.model.xml
                // <column name="category_id" type="bigint"
                .set("category_id", categoryId)
                .update();

        // Создание flash-сообщения
        ctx.sessionAttribute("flash", "flash-сообщение обновляет данные статьи в базе");

        // редирект на указанный адрес /articles
        ctx.redirect("/articles");
        // END
    };

    public static Handler deleteArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        Article article = new QArticle()
                .id.equalTo(id)
                .findOne();

        // установить атрибут в запрос и таким образом передать данные в шаблон
        ctx.attribute("article", article);

        // Для рендеринга шаблона передав туда путь к шаблону
        ctx.render("articles/delete.html");

        // END
    };

    public static Handler destroyArticle = ctx -> {
        // BEGIN
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        new QArticle()
                .id.equalTo(id)
                .delete();

        // Создание flash-сообщения
        ctx.sessionAttribute("flash", "flash-сообщение об успешном удалении статьи");

        // редирект на указанный адрес /articles
        ctx.redirect("/articles");
        // END
    };
}
