package lambdy.dil01;

import java.util.Comparator;

public class Lekce01 {
    public static void main(String[] args) {
        // Odkomentuj prave jedno volani podle pracovniho snimku.
        // Prvni spusteni je bez vypisu; zatim neni zapnuta zadna uloha.
        //ukazkaRunnable();
        //runnablePrinter();
        //spojeni();
        //kalkulacka();
        // porovnaniDelek();
         formatovani();
    }

    // Spolecna ukazka: podle pokynu v prezentaci.
    static void ukazkaRunnable() {
        Runnable task = () -> System.out.println("Ahoj");
        task.run();
        // TODO ukazka: postupuj podle pracovniho snimku.
    }

    // Uloha 1.1. Tři řádky: Welcome, Java a prázdný řádek.
    static void runnablePrinter() {
        // TODO 1.1: Runnable a Printer. Zde pis sve reseni.
        Runnable r = () -> System.out.println("Welcome");
        Printer p = text -> System.out.println(text);
        r.run();
        p.print("Java");
        p.print("");

    }

    // Uloha 1.2. Výpis AB a B. Prázdný řetězec nezpůsobí chybu.
    static void spojeni() {
        // TODO 1.2: Vlastní Concatenator. Zde pis sve reseni.
        Concatenator c = (a, b) -> (a + b);
        System.out.println(c.concat("A", "B"));
        System.out.println(c.concat("", "B"));
    }

    // Uloha 1.3. Pro (10, 4): 14, 40, 6. Pro (-2, 0): -2, 0, -2.
    static void kalkulacka() {
        // TODO 1.3: Tři operace. Zde pis sve reseni.
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;
        System.out.println(add.compute(10, 4));
        System.out.println(multiply.compute(10, 4));
        System.out.println(subtract.compute(10, 4));
        System.out.println(add.compute(-2, 0));
        System.out.println(multiply.compute(-2, 0));
        System.out.println(subtract.compute(-2, 0));
    }

    // Uloha 1.4. Znaménka výsledků jsou záporné, záporné, nula.
    static void porovnaniDelek() {
        // TODO 1.4: Porovnání délek. Zde pis sve reseni.
        Comparator<String> podleDelky = (a, b) -> Integer.compare(a.length(), b.length());
        System.out.println(podleDelky.compare("pes", "kocka"));
        System.out.println(podleDelky.compare("", "a"));
        System.out.println(podleDelky.compare("pes", "les"));



    }

    // Uloha 1.5. Pro Tom: Hello, Tom / WELCOME, TOM / User: Tom. Pro prázdné jméno zůstane jen prefix.
    static void formatovani() {
        // TODO 1.5: MessageFormatter. Zde pis sve reseni.
        MessageFormatter fn1 = n -> "Hello, "+n;
        MessageFormatter fn2 = n -> "WELCOME, "+n;
        MessageFormatter fn3 = n -> "User: "+n;
        System.out.println(fn1.format("Tom"));
        System.out.println(fn2.format("Tom"));
        System.out.println(fn3.format("Tom"));
    }
}
