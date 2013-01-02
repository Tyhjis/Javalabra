/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

/**
 *
 * @author Krisu
 */
public class Pelaaja {
    
    String nimi;
    Ruudukko r;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
    }
    
    public String getNimi(){
        return nimi;
    }
    
    public void asetaRuudukko(Ruudukko r){
        this.r = r;
    }
}
