
package Mallit;

public class Laiva {
    
    private int pituus;
    private Ruudukko ruudukko;
    /**
     * Laivan konstruktori. Asettaa pituuden. 
     * @param pituus asetettava pituus.
     */
    public Laiva(int pituus){
        this.pituus = pituus;
        ruudukko = null;
    }
    /**
     * 
     * @return palauttaa oliolle asetetun pituuden.
     */
    public int getPituus(){
        return pituus;
    }
    /**
     * Vähentää olion pituutta. Jos pituus laskee nollaan, sekä viite Ruudukko-olioon löytyy, kutsutaan ruudukon poistaLaiva-metodia.
     */    
    public void ammuLaivaan(){
        if(pituus > 0){
           pituus--; 
        }
        if(pituus == 0 && ruudukko != null){
            ruudukko.poistaLaiva();
        }
    }
    /**
     * Asettaa laivan johonkin tiettyyn Ruudukko-olioon.
     * @param r sisältää viitteen ruudukkoon, johon laiva asetetaan.
     */
    public void laivanAsetus(Ruudukko r){
        this.ruudukko = r;
    }
}
