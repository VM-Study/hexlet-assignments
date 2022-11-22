package exercise;

class Converter {
    // BEGIN
    public static int convert(int number, String type) {
        if (type.equals("b")) {
            return number * 1024;
        } else if (type.equals("Kb")) {
            return number / 1024;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println("10 Kb = " + Converter.convert(10, "b") + " b");    // 10240

    }
    // END
}
