
package Mallit;

public class Laiva {
    
    private int pituus;
    private Ruudukko ruudukko;
    
    public Laiva(int pituus){
        this.pituus = pituus;
        ruudukko = null;
    }
    
    public int getPituus(){
        return pituus;
    }
    
    public void ammuLaivaan(){
        if(pituus > 0){
           pituus--; 
        }
        if(pituus == 0 && ruudukko != null){
            ruudukko.poistaLaiva();
        }
    }
    
    public void laivanAsetus(Ruudukko r){
        this.ruudukko = r;
    }
}
