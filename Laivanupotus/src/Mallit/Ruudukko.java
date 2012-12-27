/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

/**
 *
 * @author Krisu
 */
public class Ruudukko {
    
    private Ruutu[][] ruudukko;
    private int laivojenmaara;
    
    public Ruudukko(int koko){
        ruudukko = new Ruutu[koko][koko];
        alustaRuudukko();
    }
    
    private void alustaRuudukko(){        
        for(int i = 0; i < ruudukko.length; i++){
            for(int j = 0; j < ruudukko.length; j++){
                ruudukko[i][j] = new Ruutu(j, i);
            }
        }
    }
    
    public void ammuRuutuun(int posx, int posy){
        ruudukko[posy][posx].ammu();
    }
    
    public void poistaLaiva(){
        laivojenmaara--;
    }
    
    public int getKoko(){
        return ruudukko.length;
    }
    
    public Ruutu getRuutu(int posx, int posy){
        return ruudukko[posy][posx];
    }
    
    public boolean lisaaLaiva(Laiva laiva, int posx, int posy, boolean horizontal){
        //Laivan asettaminen ruudukkoon. Posx ja posy -muuttujat kertovat laivan kokan halutun paikan. Horizontal taas onko laiva vaakatasossa vai ei.
        int pit = laiva.getPituus();
        //Ensin tarkistetaan onko vapaata paikkaa tässä kohdassa laivalle.
        if(checker(pit, posx, posy, horizontal)){
            if(horizontal){
                for(int i = posx; i <= posx+pit-1; i++){
                    ruudukko[posy][i].asetaLaiva(laiva);
                }
                return true;
            }
            else{
                for(int i = posy; i <= posy+pit-1; i++){
                    ruudukko[i][posx].asetaLaiva(laiva);
                }
                return true;
            }
        }
        return false; //Jos ei onnistunut palautetaan false.
    }
    
    public boolean checker(int pit, int posx, int posy, boolean horizontal){
        if(horizontal){
            if(posx+pit-1 > ruudukko.length-1){
                return false;
            }
            for(int i = posx; i <= posx+pit-1; i++){
                if(ruudukko[posy][i].sisaltaakoLaivan()){
                    return false;
                }
            }
        }
        else{
            if(posy+pit-1 > ruudukko.length-1){
                return false;
            }
            for(int i = posy; i <= posy+pit-1; i++){
                if(ruudukko[i][posx].sisaltaakoLaivan()){
                    return false;
                }
            }
        }
        return true; //Jos vapaa paikka löytyy, palautetaan true.        
    }
}
