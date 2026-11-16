package lambdy.dil03;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.time.*;
import java.time.format.*;

public class Lekce03 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
        // ukazkaConsumer();
        // ukazkaPredikaty();
        // ukazkaSupplier();
        // consumer();
        // interval();
        // transformace();
        // dodavatele();
        // pozdrav();
         jmena();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaConsumer() {
        Consumer<String> lenght = a -> System.out.println(a.length());
        Consumer<String> both = lenght.andThen(lenght);

        both.accept("Hello");
        // TODO ukazka: postupuj podle pracovniho snimku.
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaPredikaty() {
        // TODO ukazka: postupuj podle pracovniho snimku.
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaSupplier() {
        // TODO ukazka: postupuj podle pracovniho snimku.
    }

    // Uloha 3.1. Čtyři řádky: Java, 4, prázdný řádek, 0.
    static void consumer() {
        // TODO 3.1: Consumer. Zde pis sve reseni.
    }

    // Uloha 3.2. inRange: false, true, true, false. outside má vždy opačný výsledek.
    static void interval() {
        int[] values = {10, 11, 100, 101};
        Predicate<Integer> above10 = n -> n > 10;
        Predicate<Integer> atMost100 = n -> n <= 100;
        Predicate<Integer> inRange = above10.and(atMost100);
        Predicate<Integer> outside = inRange.negate();
        for (int n : values) {
            System.out.println(n + ": " + inRange.test(n) + ", " + outside.test(n))
            ;
        }
        // TODO 3.2: Interval (10, 100]. Zde pis sve reseni.
    }

    // Uloha 3.3. Vysledek: JAVA / Vysledek: s koncovou mezerou / Java.
    static void transformace() {
        // TODO 3.3: Skládání Function. Zde pis sve reseni.
    }

    // Uloha 3.4. Pevné testy: vyborne, nedostatecne, 09:05. Náhodná známka i aktuální čas se mění.
    static void dodavatele() {
        // TODO 3.4: Známka a čas. Zde pis sve reseni.
        IntFunction<String> describe = grade -> switch (grade) {
            case 1 -> "vyborne";
            case 2 -> "chvalitebne";
            case 3 -> "dobre";
            case 4 -> "dostatecne";
            case 5 -> "nedostatecne";
            default -> throw new IllegalArgumentException("znamka");
        };
        System.out.println(describe.apply(1));
        System.out.println(describe.apply(5));
        Supplier<String> grade = () -> describe.apply(1 + (int) (Math.random() * 5)
        );
        System.out.println(grade.get());
    }

    // Uloha 3.5. Celkem tři řádky Ahoj; volání s nulou nic nepřidá.
    static void pozdrav() {
        // TODO 3.5: Vlastní Greeting. Zde pis sve reseni.
        Greeting greeting = (text, count) -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
            }
        };
        greeting.repeat("Ahoj", 3);
        greeting.repeat("Ahoj", 0);
    }

    // Uloha 3.6. Výpis ADAM a ALENA. Pro prázdný seznam žádný výpis.
    static void jmena() {
        List<String> names = List.of("Eva", "", "Adam", "Alena");
        // TODO 3.6: Zpracování jmen. Zde pis sve reseni.
        Predicate<String> startsA = s -> s.startsWith("A");
        Function<String, String> upper = s -> s.toUpperCase(Locale.ROOT);
        Consumer<String> print = s -> System.out.println(s);
        for (String name : names) {
            if (startsA.test(name)) {
                print.accept(upper.apply(name));
            }
        }

    }
}
