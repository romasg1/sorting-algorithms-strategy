/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radicistrategie;

/**
 * Implementace řadicí strategie: InsertionSort
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class InsertionSort implements RadiciStrategieRozhrani {

    /**
     *
     * @param data je pole celych cisel
     */
    @Override
    public void sort(int[] data) {
        int d, i, vkladany;
        for (d = 1; d < data.length; d++) {
            vkladany = data[d];  // odložení vkládaného prvku
            i = d;
            while (i > 0 && data[i - 1] > vkladany) {
                data[i] = data[i - 1];
                i = i - 1;
            }
            data[i] = vkladany;  // vložení vkládaného prvku na správné místo
        }
    }
}
