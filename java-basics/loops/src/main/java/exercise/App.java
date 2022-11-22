package exercise;

class App {
    // BEGIN
    public static String getAbbreviation(String text) {
        String textAbbreviation = "";
        for (int i = 0; i < text.length(); i++) {
            boolean isUpper = Character.isUpperCase(text.charAt(i));
            boolean isSpaceBefore = false;
            boolean isSpace = text.charAt(i) == ' ';
            if (i > 0) {
                isSpaceBefore = text.charAt(i - 1) == ' ';
            }

            if ((isUpper || isSpaceBefore) && !isSpace) {
                textAbbreviation += text.charAt(i);
            }
        }
        return textAbbreviation.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(App.getAbbreviation("Portable Network Graphics"));                // "PNG"
        System.out.println(App.getAbbreviation("Situation normal:      all fucked up"));     // "SNAFU"
    }

    // END
}