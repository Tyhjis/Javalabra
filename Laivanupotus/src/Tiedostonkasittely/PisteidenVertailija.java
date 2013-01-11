/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiedostonkasittely;

import Mallit.Pelaaja;
import java.util.Comparator;

/**
 * Comparator. Asettaa pelaajat laskevaan järjestykseen annettujen pisteiden perusteella.
 * @author Krisu
 */
public class PisteidenVertailija implements Comparator{

    /**
     * Pelaajien järjestäminen.
     * @param o1 Ensimmäinen objektiparametri.
     * @param o2 Toinen objektiparametri.
     * @return palauttaa -1, jos ensimmäisen parametrin pistemäärä on suurempi kuin toisen. 0 jos pistemäärä on sama. 1 jos pistemäärä on pienempi.
     */
    @Override
    public int compare(Object o1, Object o2) {
        Pelaaja p1 = (Pelaaja) o1;
        Pelaaja p2 = (Pelaaja) o2;
        if(p1.getPisteet() > p2.getPisteet()){
            return -1;
        }
        else if(p1.getPisteet() < p2.getPisteet()){
            return 1;
        }
        return 0;
    }
    
}
