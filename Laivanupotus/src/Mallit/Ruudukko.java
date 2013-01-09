
package Mallit;

import java.util.ArrayList;
/**
 * Luokka, joka kuvastaa laivanupotuspelin koordinaatistoa. Koordinaatiston ruudut koostuvat Ruutu-olioista.
 * @author Krisu
 */
public class Ruudukko {
    
    private Ruutu[][] ruudukko;
    private int laivojenmaara;
    /**
     * Konstruktori. Alustaa ruuudukon.
     * @param koko Ruudukon haluttu koko. Jos parametrina annetaan luku 0. Konstruktori ei tee mitään.
     */
    public Ruudukko(int koko){
        if(koko > 0){
            ruudukko = new Ruutu[koko][koko];
            alustaRuudukko();  
        }        
    }
    /**
     * 
     */
    private void alustaRuudukko(){        
        for(int i = 0; i < ruudukko.length; i++){
            for(int j = 0; j < ruudukko.length; j++){
                ruudukko[i][j] = new Ruutu(j, i);
            }
        }
    }
    /**
     * Haluttuun ruutuun ampuminen.
     * @param posx kertoo x-akselin koordinaatin.
     * @param posy kertoo y-akselin koordinaatin.
     * @return palauttaa true, jos ruutuun ei ollut vielä ammuttu. Muuten false.
     */
    public boolean ammuRuutuun(int posx, int posy){
        if(!ruudukko[posy][posx].onkoAmmuttu()){
            ruudukko[posy][posx].ammu();
            return true;
        }
        return false;
    }
    /**
     * Vähentää laivojen määrää yhdellä.
     */
    public void poistaLaiva(){
        laivojenmaara--;
    }
    /**
     * Palauttaa ruudukon koon.
     * @return ruudukon koon palautus, jos ruudukko on luotu. Muuten palauttaa 0.
     */
    public int getKoko(){
        if(ruudukko != null){
            return ruudukko.length;
        }
        else{
            return 0;
        }
    }
    /**
     * 
     * @return Ruudukossa vielä olevien laivojen määrä.
     */
    public int getLaivojenMaara(){
        return laivojenmaara;
    }
    /**
     * Palauttaa viitteen haluttuun ruutuun koordinaatistossa.
     * @param posx
     * @param posy
     * @return palauttaa viitteen jos annetut koordinaatit ovat ruudukon rajojen sisällä. Muuten palauttaa null.
     */
    public Ruutu getRuutu(int posx, int posy){
        if(tarkistaKoordinaatit(posx, posy)){
            return ruudukko[posy][posx];
        }
        return null;
    }
    
    private boolean tarkistaKoordinaatit(int posx, int posy){
        return posx >= 0 && posx < getKoko() && posy >= 0 && posy < getKoko();
    }
    /**
     * Laivan lisääminen ruudukkoon.
     * @param laiva asettaa viitteen laivalle.
     * @param posx Haluttu x-akselin koordinaatti laivan kokalle.
     * @param posy Haluttu y-akselin koordinaatti laivan kokalle.
     * @param horizontal Kertoo halutaanko laiva asettaa ruudukkoon vaakatasoon vai ei. True = vaakataso. False = pystyasento.
     * @return palauttaa true, jos laivan asettaminen onnistui. Muuten false.
     */
    public boolean lisaaLaiva(Laiva laiva, int posx, int posy, boolean horizontal){
        //Laivan asettaminen ruudukkoon. Posx ja posy -muuttujat kertovat laivan kokan halutun paikan. Horizontal taas onko laiva vaakatasossa vai ei.
        int pituus = laiva.getPituus();
        //Ensin tarkistetaan onko vapaata paikkaa tässä kohdassa laivalle.
        if(tarkistaVoikoLaivanLisata(pituus, posx, posy, horizontal)){
            if(horizontal){
                for(int i = posx; i <= posx+pituus-1; i++){
                    ruudukko[posy][i].asetaLaiva(laiva);
                }
            }
            else{
                for(int i = posy; i <= posy+pituus-1; i++){
                    ruudukko[i][posx].asetaLaiva(laiva);
                }
            }
            laiva.laivanAsetus(this);
            laivojenmaara++;
            return true;
        }
        return false; //Jos ei onnistunut palautetaan false.
    }
    /**
     * Tarkistaa voiko laivan lisätä haluttuun kohtaan ruudukolle.
     * @param pituus Asetettavan laivan pituus.
     * @param posx Haluttu x-koordinaatin sijainti.
     * @param posy Haluttu y-koordinaatin sijainti.
     * @param vaakataso Kertoo halutaanko laiva asettaa vaakatasoon. True, jos vaakataso.
     * @return Palauttaa true, jos laiva voidaan asettaa ruudukkoon.
     */
    private boolean tarkistaVoikoLaivanLisata(int pituus, int posx, int posy, boolean vaakataso){
        if(vaakataso){
            if(posx+pituus-1 > ruudukko.length-1){
                return false;
            }
            for(int i = posx; i <= posx+pituus-1; i++){
                if(ruudukko[posy][i].sisaltaakoLaivan()){
                    return false;
                }
            }
        }
        else{
            if(posy+pituus-1 > ruudukko.length-1){
                return false;
            }
            for(int i = posy; i <= posy+pituus-1; i++){
                if(ruudukko[i][posx].sisaltaakoLaivan()){
                    return false;
                }
            }
        }
        return true; //Jos vapaa paikka löytyy, palautetaan true.        
    }
    /**
     * Palauttaa viitteen ruudukosta kaksiulotteisena boolean-taulukkona. Taulukon alkio on true, jos kyseisessä paikassa on laiva.
     * @return kaksiulotteinen boolean-taulukko.
     */
    public boolean[][] haeRuudukkoBooleantaulukkona(){
        /*Palauttaa ruudukon boolean-taulukkona*/
        if(ruudukko != null){
           int pit = getKoko();
            boolean[][] pal = new boolean[pit][pit];
            for(int i = 0; i < pit; i++){
                for(int j = 0; j < pit; j++){
                    pal[i][j] = ruudukko[i][j].sisaltaakoLaivan();
                }
            }
            return pal; 
        }
        return null;       
    }
}
