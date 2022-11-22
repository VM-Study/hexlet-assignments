package exercise;

class Card {
    public static void printHiddenCard(String cardNumber, int starsCount) {
        // BEGIN
        System.out.println("*".repeat(starsCount) + cardNumber.substring(cardNumber.length() - 4));
        // END
    }
}
