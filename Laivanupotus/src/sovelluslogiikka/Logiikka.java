/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;
import Mallit.Laiva;
import Mallit.Ruudukko;
import Mallit.Pelaaja;
import java.util.ArrayList;
/**
 *
 * @author Krisu
 */
public class Logiikka {
    
    Ruudukko ruudukko1;
    Ruudukko ruudukko2;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    ArrayList<Laiva> laivat;
    
    int koko;
    
    public Logiikka(String name1, String name2, int koko){
        pelaaja1 = new Pelaaja(name1);
        pelaaja2 = new Pelaaja(name2);
        this.koko = koko;
    }
    
    public void luoPeli(){
        ruudukko1 = new Ruudukko(koko);
        ruudukko2 = new Ruudukko(koko);
    }
    
    public static void main(String[] args){
        Ruudukko r = new Ruudukko(10);
        Laiva la = new Laiva(3);
        Laiva la1 = new Laiva(2);
        
        System.out.println(r.lisaaLaiva(la, 3, 2, true));
        System.out.println(r.lisaaLaiva(la1, 3, 1, false));
        System.out.println(r.getRuutu(3, 2).sisaltaakoLaivan());
        System.out.println(r.getRuutu(4, 2).sisaltaakoLaivan());
        System.out.println(r.getRuutu(5, 2).sisaltaakoLaivan());
        System.out.println(la.getPituus());
        r.ammuRuutuun(3, 2);
        System.out.println(la.getPituus());
        r.ammuRuutuun(4, 2);
        System.out.println(la.getPituus());
        r.ammuRuutuun(5, 2);
        System.out.println(la.getPituus());
    }
    
    
}
