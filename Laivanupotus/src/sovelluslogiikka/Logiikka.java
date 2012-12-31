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
    private Yksinpeli yksinpeli;
    private Kaksinpeli kaksinpeli;
    
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
    
    public void alustaPeli(){
        luoKyselyikkuna();
    }
    
    public void aloitaPeli(boolean yksinpeli){
        
    }
    
    public void aloitaKaksinpeli(String nimi1, String nimi2, int ruudukonkoko, int[] laivojenkoot){
        kaksinpeli = new Kaksinpeli(nimi1, nimi2, ruudukonkoko, laivojenkoot);
    }
    
    public void aloitaYksinpeli(String nimi1, int ruudukonkoko, int[] laivojenkoot){
        yksinpeli = new Yksinpeli(nimi1, ruudukonkoko, laivojenkoot);
    }
    
    public void kyseleKootJaMaarat(boolean yksinpeli, String nimi1, String nimi2){
        
    }
    
}
