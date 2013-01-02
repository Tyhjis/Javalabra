
package sovelluslogiikka;

import Mallit.Pelaaja;
import Mallit.Ruudukko;
import UI.Taisteluikkuna;
import UI.Varvaysikkuna;
import java.util.ArrayList;

public class Kaksinpeli{
    
    private Pelaaja pelaaja1, pelaaja2;
    private Ruudukko ruudukko1, ruudukko2;
    private Varvaysikkuna laivojenvarvays;
    private Taisteluikkuna taistelu;
    private ArrayList<Integer> laivojenkoot;
    
    public Kaksinpeli(String nimi1, String nimi2, int koko, int[] koot){
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
        pelaaja1 = new Pelaaja(nimi1);
        pelaaja2 = new Pelaaja(nimi2);
        pelaaja1.asetaRuudukko(ruudukko1);
        pelaaja2.asetaRuudukko(ruudukko2);
    }
    
    public void luoVarvattavatLaivat(int[] koot){
        for(int i = 0; i < koot.length; i++){
            
        }
    }
    
    
}
