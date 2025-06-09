# Měření řadících metod – Strategy Pattern

Projekt měří výkon různých řadících algoritmů pomocí návrhového vzoru Strategy (NetBeans).

## Popis úlohy
- Implementace 4 tříd, z nichž každá obaluje jiný řadící algoritmus.
- Třída **Řadič** spravuje data a aktuální strategii řazení, umí data zamíchat, obnovit původní pořadí a seřadit je podle zvolené strategie.
- Třída **Měřič** vytváří objekt Řadiče a měří dobu řazení jednotlivými strategiemi.
- Výstupem jsou tabulky rychlosti řazení pro různé velikosti polí a typy vstupních dat (malá, střední, velká pole; seřazená, schodová, opačně seřazená).

## Jak spustit
1. Otevřete projekt v NetBeans.
2. Zkompilujte a spusťte třídu `Meric`.
3. Výsledky se zobrazí v konzoli - tabulka.
