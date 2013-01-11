/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tiedostonkasittely;

import Mallit.Pelaaja;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Hallitsee pistetilaston tiedostoja.
 * @author Krisu
 */
public class Pisteet {
    
    File f;
    ArrayList<Pelaaja> lista;
    ObjectOutputStream oout;
    ObjectInputStream oin;
    FileOutputStream fout;
    FileInputStream fin;
    private final String tiedostonnimi;
    
    public Pisteet(){
        tiedostonnimi = "pojot";
    }
    /**
     * Uuden tiedoston luominen.
     * @return Palauttaa true, jos tiedoston luominen onnistui.
     */
    public boolean luoUusiTiedosto(){
        f = new File(tiedostonnimi);
        try{
            f.createNewFile();
        }
        catch(IOException ex){
            return false;
        }
        return true;
    }
    /**
     * Lataa olemassaolevan tiedoston.
     * @return Palauttaa 1, jos tiedostoa ei löytynyt. Palauttaa 2, jos lukeminen ei onnistunut.
     */
    public int lataaTiedosto(){
        try{
            fin = new FileInputStream(tiedostonnimi);
            oin = new ObjectInputStream(fin);
        }
        catch(FileNotFoundException ex){
            return 1;
        }
        catch(IOException ex){
            return 2;
        }
        return 0;
    }
    /**
     * Hakee listan pelaajista tiedostosta.
     * @return 
     */
    public int haeListaTiedostosta(){
       if(oin == null || fin == null){
           return 1;
       }
       else{
           try{
               lista = (ArrayList<Pelaaja>) oin.readObject();
           }
           catch(ClassNotFoundException ex){
               return 2;
           }
           catch(IOException ex){
               return 3;
           }
       }
       return 0;
    }
    /**
     * Jo olemassaolevaan tiedostoon kirjoittaminen.
     * @param p Kirjoitettava Pelaaja-olio.
     * @return Palauttaa true, jos kirjoittaminen onnistui.
     */
    public boolean kirjoitaTiedostolle(Pelaaja p){
        haeListaTiedostosta();
        if(lista == null){
            lista = new ArrayList();
        }
        lista.add(p);
        if(lista.size() > 1){
            Collections.sort(lista, new PisteidenVertailija());
        }
        
        try{
            fout = new FileOutputStream(tiedostonnimi);
            oout = new ObjectOutputStream(fout);
            oout.writeObject(lista);
        }
        catch(IOException ex){
            return false;
        }
        return true;
    }
    /**
     * Palauttaa listan parhaista pelaajista laskevassa järjestyksessä.
     * @return ArrayList<Pelaaja> Sisältää pelaajat, jotka ovat voittaneet pelin.
     */
    public ArrayList<Pelaaja> getLista(){
        haeListaTiedostosta();
        return lista;
    }
}
