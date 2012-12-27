/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;
import Mallit.Laiva;
import Mallit.Ruudukko;
import Mallit.Pelaaja;
import java.util.ArrayList;
import UI.*;
/**
 *
 * @author Krisu
 */
public class Logiikka {
    
    
    private Aloitusruutu aloitus;
    
    public Logiikka(Aloitusruutu aloitus){
        this.aloitus = aloitus;
    }
    
    public void luoPeli(){
        
    }
    
    public static void main(String[] args){
        Aloitusruutu rek = new Aloitusruutu();
        Logiikka ohjain = new Logiikka(rek);
        
    }
    
    
}
