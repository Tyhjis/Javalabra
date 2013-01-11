/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Mallit.*;
import Tiedostonkasittely.Pisteet;
import UI.Taisteluikkuna;
import UI.Varvaysikkuna;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Kontrolleri. Pitää yllä pelin toimintoja.
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
    private int vuoro;
    private int pellaivat;
    private int ailaivat;
    /**
     * Konstruktori. Luo peliin tarvittavat oliot.
     * @param nimi Pelaajalle asetettava nimi.
     * @param koko Ruudukoille asetettava sivun pituus.
     * @param koot Kokonaislukutaulukko, joka ilmaisee Haluttujen laivojen pituudet.
     */    
    public Peli(String nimi, int koko, int[] koot){
        pelaaja = new Pelaaja(nimi);
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
        tekoaly = new AI(ruudukko2, koot);
        tekoaly.asetaLaivatRuudukkoon();
        this.koko = koko;
        this.koot = koot;
        this.vuoro = 0;
   }
   /**
    * Graafisen käyttöliittymän värväysruudun luominen.
    */
   public void luoVarvaysRuutu(){
       varvays = new Varvaysikkuna(koko, koot);
       varvays.asetaOhjain(this);
   }
   /**
    * Kontrolloi laivojen asettelua pelaajan ruudukolle.
    * @param laivanpit Asetettavan laivan pituus.
    * @param posx Haluttu x-akselin koordinaatti.
    * @param posy Haluttu y-akselin koordinaatti.
    * @param horizontal Kertoo, halutaanko laiva asettaa vaakatasoon. True = vaaka. False = pysty.
    */
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
   /**
    * Luo uuden taisteluikkunan.
    */
   public void aloitaPeli(){
       //Luo Taisteluikkunan
       boolean[][] pelaajanruudut = ruudukko1.haeRuudukkoBooleantaulukkona();
       taistelu = new Taisteluikkuna(ruudukko1.getKoko(), koot.length, pelaajanruudut);
       taistelu.asetaOhjain(this);
   }
   /**
    * Pelaa vuoron. Vuoro aloitetaan pelaajan syötteillä haluttuun ruutuun.
    * @param posx Haluttu x-akselin koordinaatti.
    * @param posy Haluttu y-akselin koordinaatti.
    */
   public void pelaaVuoro(int posx, int posy){
       //Pelaajan ammunta. Jos ruutuun voi ampua, kutsutaan myös metodia, joka toteuttaa tekoälyn ammunnan.
       if(ruudukko2.ammuRuutuun(posx, posy)){
           vuoro++;
           if(ruudukko2.getRuutu(posx, posy).onkoTuhottu()){
               taistelu.maalaaAIruudKeltaiseksi(posx, posy);
           }
           else{
               taistelu.maalaaAIruudPunaiseksi(posx, posy);
           }
           if(!tarkistaOnkoPeliOhi()){
               tekoalynAmmunta();
               tietojenPaivitys();
               if(tarkistaOnkoPeliOhi()){
                   pelinLopetus();
               }
           }
           else{
               tietojenPaivitys();
               pelinLopetus();
           }           
       }
       else{
           taistelu.esitaVirheilmoitus();
       }
   }

   /**
    * Tarkistusmetodi pelin lopettamiseen. Jos pelaajalla tai tekoälyllä ei ole enää laivoja ruudukollaan. Peli lopetetaan.
    * @return Palauttaa true jos peli lopetetaan.
    */
    private boolean tarkistaOnkoPeliOhi(){
        pellaivat = ruudukko1.getLaivojenMaara();
        ailaivat = ruudukko2.getLaivojenMaara();
        if(pellaivat == 0 || ailaivat == 0){
            return true;
        }
        return false;
    }
    /**
     * Metodi voittamisen ilmaisemiseen.
     * @return palauttaa true, jos pelaaja on voittanut pelin.
     */
    private boolean voittaminen(){
        if(ailaivat == 0){
            return true;
        }
        return false;
    }
    /**
     * Päivittää tiedot jäljelläolevista laivoista ja käydyistä vuoroista taisteluruudussa.
     */
    private void tietojenPaivitys(){
        pellaivat = ruudukko1.getLaivojenMaara();
        ailaivat = ruudukko2.getLaivojenMaara();
        taistelu.paivitaTiedot(pellaivat, ailaivat, vuoro);
    }
    /**
     * Pelin loppumisen toiminnot.
     */
    public void pelinLopetus(){
        if(voittaminen()){
            double pisteet = laskePisteet();
            pelaaja.asetaPisteet(pisteet);
            pisteidenTallentaminen();
            taistelu.voitto(pelaaja.getNimi(), pisteet);
        }
        else{
            taistelu.havio();
        }
    }
    /**
     * Tallentaa pelaajan pisteet tiedostolle.
     */
    public void pisteidenTallentaminen(){
        Pisteet tallennus = new Pisteet();
        int tark = tallennus.lataaTiedosto();
        if(tark != 0){
            boolean luoko = tallennus.luoUusiTiedosto();
            if(luoko){
                tallennus.kirjoitaTiedostolle(pelaaja);
            }
        }
        else if(tark == 0){
            tallennus.kirjoitaTiedostolle(pelaaja);
        }
    }
    /**
     * Luo uuden pelin.
     */
    public void uusiPeli(){
        PelinAloitus uusi = new PelinAloitus();
        uusi.aloita();        
    }
   
   /**
    * Hallitsee tekoälyn ampumisen metodeja.
    */
   public void tekoalynAmmunta(){
       //Tekoalyn ammunta. AI-oliolta haetaan koordinaatit, jotka koostuvat kahdesta satunnaisluvusta.
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
   /**
    * Saatujen pisteiden laskeminen. Pisteisiin vaikuttavat laivojen määrä, laivojen yhteenlaskettu pituus, ruudukon ruutujen kokonaismäärä sekä käydyt vuorot.
    * @return Palauttaa pelissä saavutetut pisteet.
    */
   private double laskePisteet(){
       double ruutujenm = koko*koko;
       double yhtkoot = alustaLaivojenYhteenlasketutPituudet();
       double laivat = koot.length;
       double pisteet = (laivat/yhtkoot) - (laivat/ruutujenm);
       pisteet = (pisteet/vuoro)*10000;
       return pisteet;
   }
   /**
    * Laskee kaikkien laivojen pituudet yhteen.
    * @return Palauttaa laivojen yhteenlasketun pituuden.
    */
   private double alustaLaivojenYhteenlasketutPituudet(){
       double pituudet = 0;
       for(int i = 0; i < koot.length; i++){
           pituudet = pituudet+koot[i];
       }
       return pituudet;
   }
}
