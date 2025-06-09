/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radicistrategie;

/**
 * Implementace řadicí strategie: QuickSort
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class QuickSort implements RadiciStrategieRozhrani {

    /**
     *
     * @param data je pole celych cisel
     */
    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    /**
     * Pomocná metoda pro QuickSort.
     * @param data Pole čísel
     * @param od Počáteční index pro řazení
     * @param po Konečný index pro řazení
     */
    private void quickSort(int[] data, int od, int po) {
        if (od < po) {
            // Pivot je prvek na střední pozici
            int pivot = data[(od + po) / 2];
            // Rozdělení pole podle pivotu
            int[] indices = rozdeleni(data, od, po, pivot);
            // Rekurzivní volání pro levý a pravý podseznam
            quickSort(data, od, indices[1]);
            quickSort(data, indices[0], po);
        }
    }

    /**
     * Rozdělení pole podle pivotu.
     * @param data Pole čísel
     * @param od Počáteční index
     * @param po Konečný index
     * @param pivot Hodnota pivotu
     * @return Pole, které obsahuje indexy pro levý a pravý podseznam
     */
    private int[] rozdeleni(int[] data, int od, int po, int pivot) {
        int levy = od;
        int pravy = po;
        while (levy <= pravy) {
            // Hledáme prvek větší než pivot zleva
            while (data[levy] < pivot) levy++;
            // Hledáme prvek menší než pivot zprava
            while (data[pravy] > pivot) pravy--;
            // Pokud levý index je menší nebo rovný pravému
            if (levy <= pravy) {
                // Výměna hodnot
                int temp = data[levy];
                data[levy] = data[pravy];
                data[pravy] = temp;
                levy++;
                pravy--;
            }
        }
        // Vrátí indexy pro levý a pravý podseznam
        return new int[] {levy, pravy};
    }
}