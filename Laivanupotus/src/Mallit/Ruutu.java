/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

/**
 *
 * @author Krisu
 */
public class Ruutu {
    
    private int posx; //Ruudun
    private int posy; //paikka ruudukossa.
    private boolean ammuttu;
    private boolean onkolaiva;
    private Laiva laiva; //Sisaltaa viitteen laivaan.
    /**
     * Konstruktori. Asetetaan koordinaatit.
     * @param posx x-akselin haluttu koordinaatti.
     * @param posy y-akselin haluttu koordinaatti.
     */
    public Ruutu(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
        this.ammuttu = false;
        this.onkolaiva = false;
    }
    /**
     * Palauttaa taulukon, joka sisältää koordinaatit.
     * @return kokonaislukutaulukko, joka sisältää koordinaatit järjestyksessä: (x, y).
     */
    public int[] getPosition(){
        return new int[] {posx, posy};
    }
    /**
     * Kertoo, onko ruutuun ammuttu.
     * @return palauttaa true, jos ruutuun on ammuttu. Muuten false.
     */
    public boolean onkoAmmuttu(){
        return ammuttu;
    }
    /**
     * Kertoo, onko ruutuun asetettu laiva.
     * @return palauttaa true, jos ruudussa on laiva. Muuten false.
     */
    public boolean sisaltaakoLaivan(){
        return onkolaiva;
    }
    /**
     * Asettaa ruudun ammutuksi. Jos ruutu sisältää myös laivan, lyhentää laivan pituutta.
     */
    public void ammu(){
        this.ammuttu = true;
        if(onkoTuhottu())
            laiva.ammuLaivaan();
    }    
    /**
     * Asettaa laivan ruutuun.
     * @param laiva sisältää viitteen laiva-olioon.
     */
    public void asetaLaiva(Laiva laiva){
        this.onkolaiva = true;
        this.laiva = laiva;
    }
    /**
     * Kertoo, onko ruudussa tuhottu laiva.
     * @return palauttaa true, jos ruutuun on sekä ammuttu, että ruutu on sisältänyt laivan. Muuten palauttaa false.
     */
    public boolean onkoTuhottu(){
        return onkolaiva && ammuttu;
    }
    /**
     * toString-esitys sisaltaakoLaivan-metodista
     * @return Palauttaa "1", jos ruutu sisältää laivan. Muuten palauttaa "0".
     */
    public String toString(){
        if(sisaltaakoLaivan()){
            return "1";
        }
        else{
            return "0";
        }
    }
}
