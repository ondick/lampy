package lambdy.streamy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Streamos {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list2 = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20);
        List<String> list3 = Arrays.asList("Anna","Petr");

        //cisla(list);
        //cisla2(list2);
        //cisla3(list3);
        //cisla4(list3);
        //cisla5(list3);
        cisla6(list3);
    }
    static void cisla(List<Integer> list) {
        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
    }

    static void cisla2(List<Integer> list) {
        list.stream().filter(x -> x % 3 == 0).forEach(System.out::println);
        double average = list.stream().mapToInt(x -> x).sum() / list.size();
        System.out.println(average);
    }

    static void cisla3(List<String> list) {
        list.stream().map(String::length).forEach(System.out::println);
        List<String> longUpperCase = list.stream().filter(names -> names.length() >= 4).map(String::toUpperCase).toList();
        System.out.println(longUpperCase);
    }

    static void cisla4(List<String> list) {
        List<String> aNames = list.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        List<String> firstLetterNames = list.stream().map(name -> name.substring(0,1)).toList();
        System.out.println(firstLetterNames);
        String joined = list.stream().collect(Collectors.joining(", "));
        System.out.println(joined);
    }
    static void cisla5(List<String> list) {
        long  count = list.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);
        boolean count2 = list.stream().anyMatch(name -> name.contains("e"));
        System.out.println(count2);
    }
    static void cisla6(List<String> list) {
        Optional<String>first = list.stream().filter(name -> name.length()>3).findFirst();
        first.ifPresent(System.out::println);
        list.stream().filter(name -> name.length()>3).limit(3).forEach(System.out::println);

    }

}
