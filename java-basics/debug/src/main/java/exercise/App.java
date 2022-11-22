package exercise;

class App {
    // BEGIN

    // END
    public static String getTypeOfTriangle(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Треугольник не существует";
        }
        if (a == b && b == c) {
            return "Равносторонний";
        }
        if (a != b && a != c && b != c) {
            return "Разносторонний";
        }
        return "Равнобедренный";

    }

    public static int getFinalGrade(int exam, int project) {
        if (exam > 90 || project > 10) {
            return 100;
        } else if (exam > 75 && project >= 5) {
            return 90;
        } else if (exam > 50 && project >= 2) {
            return 75;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(App.getTypeOfTriangle(1, 2, 7));  // "Треугольник не существует"
        System.out.println(App.getTypeOfTriangle(5, 6, 7));  // "Разносторонний"
        System.out.println(App.getTypeOfTriangle(1, -2, 7)); // "Треугольник не существует");

        System.out.println(App.getFinalGrade(100, 12)); // 100
        System.out.println(App.getFinalGrade(99, 0));   // 100
        System.out.println(App.getFinalGrade(10, 15));  // 100
        System.out.println(App.getFinalGrade(85, 5));   // 90
        System.out.println(App.getFinalGrade(55, 3));   // 75
        System.out.println(App.getFinalGrade(55, 0));   // 0
    }
}
