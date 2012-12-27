/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

public class Laiva {
    
    private int pituus;
    private Ruudukko ruudukko;
    
    public Laiva(int pituus, Ruudukko ruudukko){
        this.pituus = pituus;
        this.ruudukko = ruudukko;
    }
    
    public int getPituus(){
        return pituus;
    }
    
    public void ammuLaivaan(){
        pituus--;
        if(pituus == 0){
            ruudukko.poistaLaiva();
        }
    }
}
