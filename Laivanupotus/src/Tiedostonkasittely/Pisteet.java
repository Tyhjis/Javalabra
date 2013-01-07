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
 *
 * @author Krisu
 */
public class Pisteet {
    
    File f;
    ArrayList<Pelaaja> lista;
    ObjectOutputStream oout;
    ObjectInputStream oin;
    FileOutputStream fout;
    FileInputStream fin;
    
    public Pisteet(){
        
    }
    /**
     * Uuden tiedoston luominen.
     * @return Palauttaa true, jos tiedoston luominen onnistui.
     */
    public boolean luoUusiTiedosto(){
        f = new File("pojot.txt");
        try{
            f.createNewFile();
        }
        catch(IOException ex){
            return false;
        }
        return true;
    }
    /**
     * Jo olemassaolevan tiedoston lataaminen.
     */
    public void lataaTiedosto(){
        try{
            fin = new FileInputStream("pojot.txt");
            oin = new ObjectInputStream(fin);
            lista = (ArrayList) oin.readObject();
        }
        catch(FileNotFoundException ex){
            System.err.print(ex);
            luoUusiTiedosto();
        }
        catch(IOException ex){
            System.err.print(ex);
            luoUusiTiedosto();
        }
        catch(ClassNotFoundException ex){
            System.err.print(ex);
        }
    }
    /**
     * Jo olemassaolevaan tiedostoon kirjoittaminen.
     * @param p
     * @return 
     */
    public boolean kirjoitaTiedostolle(Pelaaja p){
        lataaTiedosto();
        if(lista == null){
            lista = new ArrayList();
        }
        lista.add(p);
        if(lista.size() > 1){
            Collections.sort(lista, new PisteidenVertailija());
        }
        
        try{
            fout = new FileOutputStream("pojot.txt");
            oout = new ObjectOutputStream(fout);
            oout.writeObject(fout);
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
        lataaTiedosto();
        return lista;
    }
}
