package exercise;

import java.util.Arrays;

public class Kennel {
    private static final int MAX_ELEMENTS = 100;
    private static String[][] puppyList = new String[MAX_ELEMENTS][2];
    private static int puppyNumber = 0;


    public static int getPuppyCount() {
        return puppyNumber;
    }

    public static boolean isContainPuppy(String name) {
        int numberPuppy = getPuppyCount();
        if (numberPuppy == 0) {
            return false;
        }
        for (int i = 0; i < numberPuppy; i++) {
            if (puppyList[i][0].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getNamesByBreed(String breed) {
        String[] namePrintAllItems = new String[MAX_ELEMENTS];
        int nameIndexNumber = 0;
        int numberPuppy = getPuppyCount();
        for (int i = 0; i < numberPuppy; i++) {
            if (puppyList[i][1].equals(breed)) {
                namePrintAllItems[nameIndexNumber] = puppyList[i][0];
                nameIndexNumber++;
            }
        }
        return Arrays.copyOfRange(namePrintAllItems, 0, nameIndexNumber);
    }

    public static boolean removePuppy(String name) {
        int numberPuppy = getPuppyCount();
        boolean isRemove = false;
        for (int i = 0; i < numberPuppy; i++) {
            if (puppyList[i][0].equals(name)) {
                isRemove = true;
                puppyNumber--;
            }
            if (isRemove) {
                puppyList[i][0] = puppyList[i + 1][0];
                puppyList[i][1] = puppyList[i + 1][1];
            }
        }
        return isRemove;
    }


    public static void addPuppy(String[] puppyAdd) {
        int newIndex = getPuppyCount();
        puppyList[newIndex][0] = puppyAdd[0];
        puppyList[newIndex][1] = puppyAdd[1];
        puppyNumber++;
    }

    public static void addSomePuppies(String[][] puppyAdd) {
        for (String[] onePuppy : puppyAdd) {
            addPuppy(onePuppy);
        }
    }

    public static String[][] getAllPuppies() {
        int numberPuppy = getPuppyCount();
        String[][] puppiesListPrint = new String[numberPuppy][2];
        for (int i = 0; i < numberPuppy; i++) {
            puppiesListPrint[i][0] = puppyList[i][0];
            puppiesListPrint[i][1] = puppyList[i][1];
        }
        return puppiesListPrint;
    }

    public static void resetKennel() {
        int numberPuppy = getPuppyCount();
        for (int i = 0; i < numberPuppy; i++) {
            puppyList[i][0] = null;
            puppyList[i][1] = null;
        }
        puppyNumber = 0;
    }

    public static void main(String[] args) {
        String[] puppy1 = {"Rex", "boxer"};
        Kennel.addPuppy(puppy1);
        String[][] puppies2 = {
                {"Buddy", "chihuahua"},
                {"Toby", "chihuahua"},
        };
        Kennel.addSomePuppies(puppies2);
        System.out.println(Kennel.getPuppyCount()); // 3
        System.out.println(Kennel.isContainPuppy("Buddy")); // true
        String[][] puppies = Kennel.getAllPuppies();
        System.out.println(Arrays.deepToString(puppies));
        // => [[Rex, boxer], [Buddy, chihuahua], [Toby, chihuahua]]

        String[] names = Kennel.getNamesByBreed("chihuahua");
        System.out.println(Arrays.toString(names)); // => [Buddy, Toby]

        Kennel.resetKennel();
        System.out.println(Kennel.getPuppyCount()); // 3

        String[][] puppies3 = {
                {"Teddy", "dog"},
                {"Lessie", "doberman"},
        };
        Kennel.addSomePuppies(puppies3);
        System.out.println(Kennel.removePuppy("Jack"));   // false
        System.out.println(Kennel.removePuppy("Lessie")); // true

        String[][] allPuppies = Kennel.getAllPuppies();
        System.out.println(Arrays.deepToString(allPuppies));
        // => [[Teddy, dog]]
    }
}
