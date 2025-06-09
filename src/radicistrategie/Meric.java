package radicistrategie;

import java.util.Random;

/**
 * Třída Měřič pro měření výkonu řadících strategií.
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class Meric {

    // Metoda pro měření výkonu řazení různých strategií
    public void merStrategie() {
        // Definice různých velikostí polí
        int[] velikosti = {100, 1000, 10000};

        // Definice různých typů vstupů
        String[] typyDat = {"serazene", "opacne", "nahodne", "schodovita"};

        // Definice strategií
        RadiciStrategieRozhrani[] strategie = {
            new InsertionSort(),
            new SelectionSort(),
            new BubbleSort(),
            new QuickSort()
        };
        String[] nazvyStrategii = {"InsertionSort", "SelectionSort", "BubbleSort", "QuickSort"};

        // Vytvoření hlavičky tabulky
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s%-20s%-20s%-15s%n", "Velikost", "Typ dat", "Strategie", "Cas (ms)");
        System.out.println("---------------------------------------------------------------");

        // Procházení velikostí a typů dat
        for (int velikost : velikosti) {
            for (String typ : typyDat) {
                int[] pole = generujPole(velikost, typ);

                // Měření každé strategie
                for (int i = 0; i < strategie.length; i++) {
                    Radic radic = new Radic(pole);
                    radic.setStrategie(strategie[i]);

                    radic.resetovat(); // Obnovení původního stavu pole
                    long startTime = System.nanoTime();
                    radic.sort();
                    long endTime = System.nanoTime();

                    double elapsedTime = (endTime - startTime) / 1e6; // Čas v milisekundách
                    System.out.printf("%-15d%-20s%-20s%-15.3f%n", velikost, typ, nazvyStrategii[i], elapsedTime);

                    // Po každých 4 výstupech přidáme oddělovací čáru
                    if ((i + 1) % 4 == 0) {
                        System.out.print("---------------------------------------------------------------");
                    }
                }
                System.out.println();
            }
        }
    }

    // Metoda pro generování pole dat
    private int[] generujPole(int velikost, String typ) {
        Random random = new Random();
        int[] pole = new int[velikost];

        switch (typ) {
            case "serazene":
                for (int i = 0; i < velikost; i++) {
                    pole[i] = i;
                }
                break;
            case "opacne":
                for (int i = 0; i < velikost; i++) {
                    pole[i] = velikost - i;
                }
                break;
            case "nahodne":
                for (int i = 0; i < velikost; i++) {
                    pole[i] = random.nextInt(10000);
                }
                break;
            case "schodovita":
                int krok = Math.max(1, velikost / 10); // Velikost jednoho "schodu"
                int hodnota = 0;
                for (int i = 0; i < velikost; i++) {
                    pole[i] = hodnota;
                    if ((i + 1) % krok == 0) {
                        hodnota++;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Neznamy typ dat: " + typ);
        }
        return pole;
    }
}
