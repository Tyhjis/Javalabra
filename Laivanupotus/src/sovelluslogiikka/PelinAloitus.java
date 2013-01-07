/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Tiedostonkasittely.Pisteet;
import UI.Aloitusikkuna;
import UI.Kyselyikkuna;

/**
 *
 * @author Krisu
 */
public class PelinAloitus {
    
    Aloitusikkuna start;
    Kyselyikkuna kysely;
    Peli peli;
    /**
     * Uuden pelin luominen.
     * @param nimi1 Pelaajalle asetettava nimi.
     * @param ruudukonkoko Haluttu ruudukon sivun pituus.
     * @param laivojenkoot Kokonaislukutaulukko halutuille laivojen pituuksille.
     */
    public void luoPeli(String nimi1, int ruudukonkoko, int[] laivojenkoot){
        peli = new Peli(nimi1, ruudukonkoko, laivojenkoot);
        peli.luoVarvaysRuutu();
    }
    /**
     * Parhaiden pelaajien listaus. Luo ilmentymän tiedostoja käsittelevästä oliosta.
     */
    public void haeParhaatPelaajat(){
        Pisteet pist = new Pisteet();
        pist.lataaTiedosto();
    }
    /**
     * 
     */
    public void luoKyselyikkuna() {
        kysely = new Kyselyikkuna();
        kysely.asetaOhjain(this);
    }
    
    public void aloita(){
        start = new Aloitusikkuna();
        start.asetaOhjain(this);
    }
}
