
package Mallit;

public class Laiva {
    
    private int pituus;
    private Ruudukko ruudukko;
    
    public Laiva(int pituus){
        this.pituus = pituus;
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
    
    public void laivanAsetus(Ruudukko r){
        this.ruudukko = r;
    }
}
