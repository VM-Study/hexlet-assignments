package exercise.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        InputStream file = getClass().getClassLoader().getResourceAsStream("users.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> usersList = mapper.readValue(file, List.class);

        return usersList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {
        // BEGIN
        List<Map<String, String>> usersList = getUsers();

        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application | Users</title>
                        <link rel=\"stylesheet\" href=\"mysite.css\">
                    </head>
                    <body>
                        <table>
                            
                """);
        for (Map<String, String> user : usersList) {
            body.append("<tr>");
            body.append("<td>" + user.get("id") + "</td>");
            body.append("<td> <a href=\"/users/" + user.get("id") + "\">"
                    + user.get("firstName") + " " + user.get("lastName") + "</a> </td>");
            body.append("</tr>");
        }


        body.append("""
                            
                        </table>
                    </body>
                </html>
                """);

        // Устанавливаем тип содержимого ответа и кодировку
        response.setContentType("text/html;charset=UTF-8");
        // При помощи метода setStatus() можно установить код ответа
        // response.setStatus(HttpServletResponseSC_OK)

        PrintWriter out = response.getWriter();
        out.println(body);

        // END
    }

    private void showUser(HttpServletRequest request,
                          HttpServletResponse response,
                          String id)
            throws IOException {
        // BEGIN
        if (id.equals("mysite.css")) {
            return;
        }

        List<Map<String, String>> usersList = getUsers();
        List<Map<String, String>> userMap = usersList.stream()
                .filter(stringStringMap -> stringStringMap.get("id").equals(id))
                .findFirst()
                .stream().toList();

        StringBuilder body = new StringBuilder();
        if (userMap.isEmpty()) {

            response.sendError(HttpServletResponse.SC_NOT_FOUND);

        } else {
            Map<String, String> user = userMap.get(0);
            body.append("""
                    <!DOCTYPE html>
                    <html lang=\"ru\">
                        <head>
                            <meta charset=\"UTF-8\">
                            <title>Example application | Users</title>
                            <link rel=\"stylesheet\" href=\"mysite.css\">
                        </head>
                        <body>
                            <table>                            
                    """);

            body.append("<tr>");
            body.append("<td>" + user.get("id") + "</td>");
            body.append("<td>" + user.get("firstName") + " " + user.get("lastName") + "</td>");
            body.append("<td>" + user.get("email") + "</td>");
            body.append("</tr>");
            body.append("""                                
                            </table>
                        </body>
                    </html>
                    """);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }
}
