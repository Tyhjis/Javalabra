
package Mallit;

import java.util.ArrayList;

public class Ruudukko {
    
    private Ruutu[][] ruudukko;
    private int laivojenmaara;
    private ArrayList<Laiva> laivat;
    
    public Ruudukko(int koko){
        ruudukko = new Ruutu[koko][koko];
        alustaRuudukko();
        laivat = new ArrayList();
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
        if(!laivat.isEmpty()){
            
        }
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
            }
            else{
                for(int i = posy; i <= posy+pit-1; i++){
                    ruudukko[i][posx].asetaLaiva(laiva);
                }
            }
            laiva.laivanAsetus(this);
            laivat.add(laiva);
            laivojenmaara++;
            return true;
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
