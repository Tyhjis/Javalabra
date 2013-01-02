/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.*;
import UI.Varvaysikkuna;

/**
 *
 * @author Krisu
 */
public class Yksinpeli {
    
    private Pelaaja pelaaja;
    private AI tekoaly;
    private Ruudukko ruudukko1, ruudukko2;
    private Varvaysikkuna varvays;
    private int koko;
    private int[] koot;
        
    public Yksinpeli(String nimi, int koko, int[] koot){
        pelaaja = new Pelaaja(nimi);
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
        pelaaja.asetaRuudukko(ruudukko1);
        tekoaly = new AI(ruudukko2, koot);
        this.koko = koko;
        this.koot = koot;
   }
   
   public void luoVarvaysRuutu(){
       varvays = new Varvaysikkuna(koko, koot);
       varvays.asetaOhjain(this);
   }
   
   public void varvaaLaiva(int laivanpit, int posx, int posy, boolean horizontal){
       Laiva laiva = new Laiva(laivanpit);
       boolean hor = horizontal;
       if(ruudukko1.lisaaLaiva(laiva, posx, posy, hor)){
           varvays.maalaaRuudut(laivanpit, posx, posy, hor);
       }
       else{
           varvays.naytaVirheilmoitus();
       }
   }
   
   public void aloitaPeli(){
       varvays.dispose();
   }
   
   public void pelaaVuoro(){
       
   }
   
   public void tulosta(){
       ruudukko2.tulosta();
   }
}
