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
    
    Ruutu[][] ruudukko;
    
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
    
    public int getKoko(){
        return ruudukko.length;
    }
    
    public Ruutu getRuutu(int posx, int posy){
        return ruudukko[posy][posx];
    }
}
