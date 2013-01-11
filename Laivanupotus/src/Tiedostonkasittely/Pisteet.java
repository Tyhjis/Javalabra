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
    
    File tiedosto;
    ArrayList<Pelaaja> lista;
    ObjectOutputStream listanvieja;
    ObjectInputStream listanhakija;
    FileOutputStream tiedostonvieja;
    FileInputStream tiedostonhakija;
    private String tiedostonnimi;
    
    /**
     * Konstruktori. Asettaa tiedoston oletusnimen. Oletusnimenä "pojot".
     */
    public Pisteet(){
        tiedostonnimi = "pojot";
    }
    /**
     * Uuden tiedoston luominen.
     * @return Palauttaa true, jos tiedoston luominen onnistui.
     */
    public boolean luoUusiTiedosto(){
        tiedosto = new File(tiedostonnimi);
        try{
            tiedosto.createNewFile();
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
            tiedostonhakija = new FileInputStream(tiedostonnimi);
            listanhakija = new ObjectInputStream(tiedostonhakija);
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
     * @return Palauttaa 1, jos tiedostoja käsitteleviä virtaolioita ei löydy. 2 tai 3, jos tiedostoa ei voi lukea. Jos onnistuu, palauttaa 0.
     */
    public int haeListaTiedostosta(){
       if(listanhakija == null || tiedostonhakija == null){
           lataaTiedosto();
       }
       else{
           try{
               lista = (ArrayList<Pelaaja>) listanhakija.readObject();
           }
           catch(ClassNotFoundException ex){
               return 1;
           }
           catch(IOException ex){
               return 2;
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
            tiedostonvieja = new FileOutputStream(tiedostonnimi);
            listanvieja = new ObjectOutputStream(tiedostonvieja);
            listanvieja.writeObject(lista);
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
    /**
     * Setteri tiedoston nimen asettamiseen.
     * @param tNimi Haluttu nimi tiedostolle. Ei ole pakko käyttää.
     */
    public void setTiedostonninimi(String tNimi){
        tiedostonnimi = tNimi;
    }
    /**
     * Poistaa halutessa tiedoston.
     * @return palauttaa true, jos tiedosto on löydetty ja poistettu.
     */
    public boolean poistaTiedosto(){
        tiedosto = new File(tiedostonnimi);
        if(tiedosto.exists()){
            tiedosto.delete();
            return true;
        }
        return false;
    }
}
