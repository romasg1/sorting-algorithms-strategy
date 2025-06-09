/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radicistrategie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Roman Grmela <romasg1@seznam.cz>
 */
public class Radic {
    
    private int[] data;  // Pole dat, které budou řazena
    private int[] puvodniData;  // Pole pro uložení původního stavu dat
    private RadiciStrategieRozhrani strategie;  // Aktuální řadicí strategie

    // Konstruktor třídy, který nastaví data
    public Radic(int[] data) {
        this.data = data;
        this.puvodniData = Arrays.copyOf(data, data.length);  // Uložení původních dat
    }

    // Metoda pro zamíchání dat
    public void zamichat() {
        List<Integer> list = Arrays.asList(Arrays.stream(data).boxed().toArray(Integer[]::new));
        Collections.shuffle(list);  // Použití metody shuffle pro zamíchání
        data = list.stream().mapToInt(Integer::intValue).toArray();  // Převod zpět na int[] pole
    }

    // Metoda pro vrácení dat do původního stavu
    public void resetovat() {
        this.data = Arrays.copyOf(puvodniData, puvodniData.length);  // Obnovení původního stavu
    }

    // Metoda pro seřazení dat podle aktuální strategie
    public void sort() {
        if (strategie != null) {
            strategie.sort(data);  // Zavolání sortovací metody na základě nastavené strategie
        } else {
            System.out.println("Není nastavena žádná strategie řazení.");
        }
    }

    // Metoda pro nastavení řadicí strategie
    public void setStrategie(RadiciStrategieRozhrani strategie) {
        this.strategie = strategie;
    }
    // Metoda pro získání aktuálních dat (pokud je potřeba pro testování)
    public int[] getData() {
        return data;
    }
}
