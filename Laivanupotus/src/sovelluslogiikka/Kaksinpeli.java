/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.Pelaaja;
import Mallit.Ruudukko;
import UI.Taisteluikkuna;
import UI.Varvaysikkuna;
import java.util.ArrayList;

/**
 *
 * @author Krisu
 */
public class Kaksinpeli implements PeliIF {
    
    private Pelaaja pelaaja1, pelaaja2;
    private Ruudukko ruudukko1, ruudukko2;
    private Varvaysikkuna laivojenvarvays;
    private Taisteluikkuna taistelu;
    private ArrayList<Integer> laivojenkoot;
    
    public Kaksinpeli(String nimi1, String nimi2, int koko, int[] laivojenkoot){
        pelaaja1 = new Pelaaja(nimi1);
        pelaaja2 = new Pelaaja(nimi2);
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
    }
    
    public void varvaaLaivat(Ruudukko r) {
        
    }

    @Override
    public void aloitaPeli() {
        
    }

    @Override
    public void pelaaVuoro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void varvaaLaivat() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
