/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.AI;
import Mallit.Pelaaja;
import Mallit.Ruudukko;

/**
 *
 * @author Krisu
 */
public class Yksinpeli implements PeliIF {
    
    private Pelaaja pelaaja;
    private AI tekoaly;
    private Ruudukko ruudukko1, ruudukko2;
    
    public Yksinpeli(String nimi, int koko, int[] laivojenkoko){
        pelaaja = new Pelaaja(nimi);
        tekoaly = new AI();
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
    }

    @Override
    public void varvaaLaivat() {
       
    }

    @Override
    public void aloitaPeli() {
    }

    @Override
    public void pelaaVuoro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
