/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radicistrategie;

/**
 * Implementace řadicí strategie: SelectionSort
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class SelectionSort implements RadiciStrategieRozhrani {

    /**
     *
     * @param data je pole celych cisel
     */
    @Override
    public void sort(int[] data) {
        int d, minIndex, i, pom;
        for (d = 0; d < data.length - 1; d++) {
            minIndex = d; // předpokládáme, že minIndex je na pozici d
            for (i = d + 1; i < data.length; i++) {
                if (data[i] < data[minIndex]) {
                    minIndex = i; // aktualizujeme minIndex, pokud nalezneme menší prvek
                }
            }
            // Prohození nalezeného minimálního prvku s prvkem na pozici d
            pom = data[minIndex];
            data[minIndex] = data[d];
            data[d] = pom;
        }
    }
}
