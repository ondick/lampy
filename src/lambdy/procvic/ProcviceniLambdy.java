package lambdy.procvic;

import lambdy.dil05.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProcviceniLambdy {
    public static void main(String[] args) {
        List<String> jmena = List.of("Kuba", "Dan", "Lukáš", "", "Kuba", "Míša");
        List<Integer> body = List.of(2, 3, 4, 6, 5, 7, 3);
        // delkyJmen(jmena);
        // delkyJmen(List.of());
        // dvaSeznamy();
        // ulozHodnotu();
         pocetVRozsahu(body);
    }

    static void delkyJmen(List<String> jmena) {
        String prefix = "K";
        // TODO Vyber jména, která začínají na prefix, a vypiš jejich délky.
        Predicate<String> zacinaPrefixem = name -> name.startsWith(prefix);
        Consumer<String> print = s -> System.out.println(s.length());
        for (String name : jmena) {
            if (zacinaPrefixem.test(name)) {
                print.accept(name);
            }
        }


    }

    static void dvaSeznamy() {
        // TODO Vytvoř přes Supplier dvě samostatné soupisky a vypiš je.
        Supplier<List<String>> supplier = ArrayList::new;
        List<String> list = supplier.get();
        List<String> list2 = supplier.get();
        list.add("Ondra");
        list2.add("Vašek");
        Consumer<String> print = s -> System.out.println(s);
        list.forEach(s -> print.accept(s));
        list2.forEach(s -> print.accept(s));


    }

    static void ulozHodnotu() {

        int limit = 2;
        limit++;
        int snaphot = limit;
        Runnable vypis = () -> System.out.println(snaphot);
        limit++;
        vypis.run();
    }

    static void pocetVRozsahu(List<Integer> body) {
        int minimum = 3;
        int maximum = 6;
        // TODO Slož podmínky a vypiš počet hodnot v intervalu.
        Predicate<Integer> min = i -> i >= minimum;
        Predicate<Integer> max = i -> i <= maximum;
        Predicate<Integer> triAzSest = min.and(max);
        for (Integer i : body) {
            if (triAzSest.test(i)) {
                System.out.println(i);
            }
        }


    }
}