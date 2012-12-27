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
    
    
    private IkkunaIF nakyma;
    private Pelaaja pelaaja1, pelaaja2;
    private Ruudukko ruudukko1, ruudukko2;
    private static Logiikka ohjain;
    
    public Logiikka(IkkunaIF nakyma){
        this.nakyma = nakyma;
    }
    
    public void luoPeli(){
        
    }
    
    public static void main(String[] args){
        Aloitusikkuna rek = new Aloitusikkuna();
        ohjain = new Logiikka(rek);
        rek.asetaOhjain(ohjain);
    }
    
    public void aloitaYksinpeli(){
        Kyselyikkuna kokojenkysely = new Kyselyikkuna();        
    }
    
    public void aloitaKaksinpeli(){
        
    }   
    
}
