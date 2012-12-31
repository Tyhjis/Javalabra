/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;
import UI.*;
/**
 *
 * @author Krisu
 */
public class Logiikka {
    
    
    private IkkunaIF nakyma;
    private static Logiikka ohjain;
    
    public Logiikka(IkkunaIF nakyma){
        this.nakyma = nakyma;
    }

    public void luoKyselyikkuna() {
        Kyselyikkuna kokojenkysely = new Kyselyikkuna();
        ohjain = new Logiikka(kokojenkysely);
        kokojenkysely.asetaOhjain(ohjain);
    }
    
    public void luoPeli(){
        
    }
    
    public static void main(String[] args){
        Aloitusikkuna rek = new Aloitusikkuna();
        ohjain = new Logiikka(rek);
        rek.asetaOhjain(ohjain);
    }
    
    public void aloitaPeli(){
        luoKyselyikkuna();
    }
    
    public void aloitaKaksinpeli(){
        
    }
    
    public void aloitaYksinpeli(){
        
    }
    
}
