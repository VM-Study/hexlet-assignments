package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// BEGIN
class App {
    public static void main(String[] args) {
        Home flat = new Flat(54.5, 4, 3);
        double area = flat.getArea(); // 58.5
        System.out.println(flat.toString()); // "Квартира площадью 58.5 метров на 3 этаже"

        Home cottage = new Cottage(135, 2);
        double area2 = cottage.getArea(); // 135
        System.out.println(cottage.toString()); // "2 этажный коттедж площадью 135 метров"

        List<Home> appartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildAppartmentsList(appartments, 3);
        System.out.println(result);


        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text); // "fedcba"
        System.out.println(text.charAt(1)); // 'e'
        System.out.println(text.length()); // 6
        System.out.println(text.subSequence(1, 4)); // "edc"
    }

    public static List<String> buildAppartmentsList(List<Home> homeList, int limit) {
        if (limit > homeList.size()) {
            limit = homeList.size();
        }
        List<Home> homeListSort = new ArrayList<>(homeList);
        List<String> homeListString = new ArrayList<>();
        Collections.sort(homeListSort, Comparator.comparing(Home::getArea));
        for (int i = 1; i <= limit; i++) {
            homeListString.add(homeListSort.get(i - 1).toString());
        }
        return homeListString;
    }
}

// END
