/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.Pelaaja;
import Mallit.Ruudukko;

/**
 *
 * @author Krisu
 */
public class Kaksinpeli {
    
    private Pelaaja pelaaja1, pelaaja2;
    private Ruudukko ruudukko1, ruudukko2;
    
    public Kaksinpeli(String nimi1, String nimi2, int koko){
        pelaaja1 = new Pelaaja(nimi1);
        pelaaja2 = new Pelaaja(nimi2);
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
    }
}
