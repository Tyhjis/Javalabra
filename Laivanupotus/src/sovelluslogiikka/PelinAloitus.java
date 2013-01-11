/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.Pelaaja;
import Tiedostonkasittely.Pisteet;
import UI.Aloitusikkuna;
import UI.Kyselyikkuna;
import java.util.ArrayList;

/**
 *
 * @author Krisu
 */
public class PelinAloitus {
    
    private Aloitusikkuna aloitus;
    private Kyselyikkuna kysely;
    private Pisteet pisteet;
    private Peli peli;
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
     * 
     * @return 
     */
    public ArrayList<Pelaaja> haeParhaatPelaajat(){
        pisteet = new Pisteet();
        int tarkistus = pisteet.lataaTiedosto();
        if(tarkistus != 0){
            pisteet.luoUusiTiedosto();
        }
        ArrayList<Pelaaja> palautettava = pisteet.getLista();
        return palautettava;
    }
    /**
     * 
     */
    public void luoKyselyikkuna() {
        kysely = new Kyselyikkuna();
        kysely.asetaOhjain(this);
    }
    
    public void aloita(){
        aloitus = new Aloitusikkuna();
        aloitus.asetaOhjain(this);
        ArrayList<Pelaaja> pelaajat = haeParhaatPelaajat();
        if(pelaajat != null){
            String parhaat = "Parhaat pelaajat:\n\n"+luoMerkkijonoPelaajista(pelaajat);
            aloitus.asetaParhaatPelaajat(parhaat);
        }
        else{
            aloitus.asetaParhaatPelaajat("Parhaat pelaajat:");
        }
    }
    /**
     * Luo merkkijonon ArrayList<Pelaaja> -oliosta.
     * @return Palauttaa merkkijonon, jossa on tiedostosta löytyneet parhaat pelaajat listattuna.
     */
    public String luoMerkkijonoPelaajista(ArrayList<Pelaaja> pelaajat){
        String palautettava = "";
        int i = 1;
        for(Pelaaja p: pelaajat){
            palautettava = palautettava+i+". "+p.toString()+"\n\n";
            i++;
        }
        return palautettava;
    }
}
