package exercise;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


class App {// BEGIN

    public static String buildList(String[] list) {
        StringBuilder finalList = new StringBuilder();
        for (String item : list) {
            finalList.append("  <li>")
                    .append(item)
                    .append("</li>\n");
        }
        if (!finalList.isEmpty()) {
            finalList.insert(0, "<ul>\n");
            finalList.append("</ul>");
        }
        return finalList.toString();
    }

    // END
    public static String getUsersByYear(String[][] usersArr, int year) {
        StringBuilder finalList = new StringBuilder();
        for (String[] strings : usersArr) {
            LocalDate userDate = LocalDate.parse(strings[1]);
            if (userDate.getYear() == year) {
                finalList.append("  <li>")
                        .append(strings[0])
                        .append("</li>\n");
            }
        }
        if (!finalList.isEmpty()) {
            finalList.insert(0, "<ul>\n");
            finalList.append("</ul>");
        }
        return finalList.toString();
    }

    // Это дополнительная задача, которая выполняется по желанию. // 11 Jul 1989"
    public static String getYoungestUser(String[][] users, String date) {
        // BEGIN
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate dateInFormat = LocalDate.parse(date, formatter);

        String minimumName = "";
        LocalDate minimumDate = LocalDate.MIN;
        for (String[] user : users) {
            LocalDate userDate = LocalDate.parse(user[1]);
            if (userDate.compareTo(dateInFormat) < 0 && userDate.compareTo(minimumDate) > 0) {
                minimumDate = userDate;
                minimumName = user[0];
            }
        }
        return minimumName;
    }

    public static void main(String[] args) {
        String[] animals = {"cats", "dogs", "birds"};
        System.out.println(App.buildList(animals));
        // <ul>
        //   <li>cats</li>
        //   <li>dogs</li>
        //   <li>birds</li>
        // </ul>

        String[][] users = {
                {"Andrey Petrov", "1990-11-23"},
                {"Aleksey Ivanov", "1995-02-15"},
                {"John Smith", "1990-03-11"},
                {"Vanessa Vulf", "1985-11-16"},
                {"Vladimir Nikolaev", "1990-12-27"},
                {"Alice Lucas", "1986-01-01"},
        };
        System.out.println(App.getUsersByYear(users, 1990));
        // <ul>
        //   <li>Andrey Petrov</li>
        //   <li>John Smith</li>
        //   <li>Vladimir Nikolaev</li>
        // </ul>

        String[][] users2 = {
                {"Andrey Petrov", "1990-11-23"},
                {"Aleksey Ivanov", "2000-02-15"},
                {"Anna Sidorova", "1996-09-09"},
                {"John Smith", "1989-03-11"},
                {"Vanessa Vulf", "1985-11-16"},
                {"Vladimir Nikolaev", "1990-12-27"},
                {"Alice Lucas", "1986-01-01"},
                {"Elsa Oscar", "1989-03-10"},
        };
        System.out.println(App.getYoungestUser(users2, "11 Jul 1989")); // "John Smith"
    }

}
