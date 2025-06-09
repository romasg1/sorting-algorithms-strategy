/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radicistrategie;

/**
 * Implementace řadicí strategie: BubbleSort.
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class BubbleSort implements RadiciStrategieRozhrani {

    /**
     *
     * @param data je pole celych cisel
     */
    @Override
    public void sort(int[] data) {
        int d, i, pom;
        for (d = 0; d < data.length - 1; d++) {
            // „probublávání“ menších prvků zprava doleva
            for (i = data.length - 1; i > d; i--) {
                if (data[i - 1] > data[i]) {
                    // Výměna prvků, pokud jsou v špatném pořadí
                    pom = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = pom;
                }
            }
        }
    }
}
