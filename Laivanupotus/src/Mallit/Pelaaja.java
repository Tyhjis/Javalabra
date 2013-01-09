/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Krisu
 */
public class Pelaaja implements Serializable {
    
    private String nimi;
    private double pisteet;
    /**
     * Konstruktori, joka asettaa Pelaajan nimen.
     * @param nimi String-olio. Haluttu nimi.
     */
    public Pelaaja(String nimi){
        this.nimi = nimi;
        pisteet = 0;
    }
    /**
     * Nimen palautus
     * @return Palauttaa nimen.
     */
    public String getNimi(){
        return nimi;
    }
    /**
     * Asettaa pelaajalle pisteet.
     * @param pisteet Asetettavat pisteet.
     */
    public void asetaPisteet(double pisteet){
        this.pisteet = pisteet;
    }
    
    /**
     * Palauttaa pelaajalle asetetut pisteet.
     * @return pisteet
     */
    public double getPisteet(){
        return pisteet;
    }
    /**
     * Palauttaa pelaajan tiedot muodossa: "nimi Pisteet: pisteet".
     * @return String tiedot
     */
    @Override
    public String toString(){
        NumberFormat merkitsevat = new DecimalFormat("#0.000");        
        return nimi+". Pisteet: "+merkitsevat.format(pisteet);
    }
}
