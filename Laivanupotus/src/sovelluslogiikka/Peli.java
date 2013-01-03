/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.*;
import UI.Taisteluikkuna;
import UI.Varvaysikkuna;

/**
 *
 * @author Krisu
 */
public class Peli {
    
    private Pelaaja pelaaja;
    private AI tekoaly;
    private Ruudukko ruudukko1, ruudukko2;
    private Varvaysikkuna varvays;
    private Taisteluikkuna taistelu;
    private int koko;
    private int[] koot;
        
    public Peli(String nimi, int koko, int[] koot){
        pelaaja = new Pelaaja(nimi);
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
        tekoaly = new AI(ruudukko2, koot);
        tekoaly.asetaLaivatRuudukkoon();
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
           if(varvays != null){
               varvays.maalaaRuudut(laivanpit, posx, posy, hor);
           }
       }
       else{
           if(varvays != null){
               varvays.naytaVirheilmoitus();
           }           
       }
   }
   
   public void aloitaPeli(){
       //Luo Taisteluikkunan
       boolean[][] pelaajanruudut = ruudukko1.haeRuudukkoBooleantaulukkona();
       taistelu = new Taisteluikkuna(ruudukko1.getKoko(), koot.length, pelaajanruudut);
       taistelu.asetaOhjain(this);
   }
   
   public void pelaaVuoro(int posx, int posy){
       //Pelaajan ammunta
       if(ruudukko2.ammuRuutuun(posx, posy)){
           if(ruudukko2.getRuutu(posx, posy).onkoTuhottu()){
               taistelu.maalaaAIruudKeltaiseksi(posx, posy);
           }
           else{
               taistelu.maalaaAIruudPunaiseksi(posx, posy);
           }
           tekoalynAmmunta();
           int pellaivat = ruudukko1.getLaivojenMaara();
           int ailaivat = ruudukko2.getLaivojenMaara();
           taistelu.paivitaTiedot(pellaivat, ailaivat);
       }
       else{
           taistelu.esitaVirheilmoitus();
       }
   }
   
   public void tekoalynAmmunta(){
       //Tekoalyn ammunta
       if(taistelu != null){
          int[] tekoalynkoord;
          boolean ammuttu = false;
          while(!ammuttu){
              tekoalynkoord = tekoaly.haeAmmuttavatKoordinaatit();
              int x = tekoalynkoord[0];
              int y = tekoalynkoord[1];
              ammuttu = ruudukko1.ammuRuutuun(x, y);
              if(ruudukko1.getRuutu(x, y).onkoTuhottu() && ammuttu){
                  taistelu.maalaaPelruudKeltaiseksi(x, y);
              }
              else if(!ruudukko1.getRuutu(x, y).onkoTuhottu() && ammuttu){
                  taistelu.maalaaPelruudPunaiseksi(x, y);
              }
          }
       }       
   }
}
