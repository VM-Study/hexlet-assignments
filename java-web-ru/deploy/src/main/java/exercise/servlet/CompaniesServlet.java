package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;
import static java.util.Objects.isNull;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        String search = request.getParameter("search");
        List<String> companies = getCompanies();
        if (!isNull(request.getQueryString()) && !isNull(search) && !search.isEmpty()) {
            companies = companies.stream()
                    .filter(s -> s.contains(search))
                    .collect(Collectors.toList());
        }
        
        PrintWriter writer = response.getWriter();
        if (companies.isEmpty()) {
            writer.println("Companies not found");
        } else {
            for (String company : companies) {
                writer.println(company);
            }
        }

        // END
    }
}
