/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;
import Mallit.Pelaaja;
import Tiedostonkasittely.Pisteet;
import UI.*;
import java.util.ArrayList;
/**
 *
 * @author Krisu
 */
public class Logiikka {
    /**
     * main-metodi. Ohjelman ajo alkaa tästä.
     * @param args 
     */
    public static void main(String[] args){
        PelinAloitus alku = new PelinAloitus();
        alku.aloita();
    }
    
}
