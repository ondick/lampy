package lambdy.dil05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lekce05 {
    public static void main(String[] args) {
        // Podle snímku odkomentuj právě jedno volání.
        // ukazkaLimit();
        // ukazkaSeznam();
        // zachyceni(); // 5.1
        // soucet(); // 5.2
         propojeni(); // 5.3, rozšiřující
    }

    // Ukázka zachycení limitu.
    static void ukazkaLimit() {
        int limit = 10;
        // TODO Doplň lambdu a spusť ji přes run().
        Runnable r = () -> System.out.println(limit);
        r.run();
    }

    // Ukázka změny obsahu seznamu.
    static void ukazkaSeznam() {
        List<String> names = new ArrayList<>();
        names.add("Eva");
        names.add("Adam");
        Runnable read = () -> System.out.println(names);
        read.run();
        // TODO Doplň lambdu, přidej Adama a spusť výpis.

    }

    // Úloha 5.1. Výstup 2.
    static void zachyceni() {
        // TODO Ulož průběžnou hodnotu do snapshot a vypiš ji lambdou.
        int changing = 1;
        changing++;
        int snaphot = changing;
        Runnable r = () -> System.out.println(snaphot);
        changing++;
        r.run();
    }

    // Úloha 5.2. Pro [1, 2, 3] výstup 6. Pro [] výstup 0.
    static void soucet() {
        List<Integer> numbers = List.of(1, 2, 3);
        // TODO Sečti čísla cyklem a vypiš součet.
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    // Rozšiřující úloha 5.3. Výstup Adam a Alena na dvou řádcích.
    static void propojeni() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        String prefix ="A";
        Predicate<String> zacinaPrefixem = name -> name.startsWith(prefix);
        Function<String, Student> vytvor = Student::new;
        Supplier<List<Student>> listSupplier = ArrayList::new;
        Consumer<Student> print = s -> System.out.println(s.getName());
        List<Student> students = listSupplier.get();
        for (String name : names) {
            if (zacinaPrefixem.test(name)) {
                students.add(vytvor.apply(name));
                print.accept(vytvor.apply(name));
            }
        }

    }
}