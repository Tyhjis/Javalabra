/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

import java.util.Random;
import java.util.Stack;
import sovelluslogiikka.Peli;

/**
 * Laivanupotuspelin tekoäly. Sisältää laivojen asettamista ja ruudukkoon ampumista hallitsevat metodit.
 * @author Krisu
 */
public class AI {
    
    private Ruudukko r;
    private Random posx, posy, hor;
    private int koko, laivat;
    private Stack laivojenkoot;
    
    /**
     * AI-luokan konstruktori, joka asettaa luokan perusmuuttujat kohdalleen, sekä kutsuu yksityistä metodia, joka luo pinon, josta laivat yksitellen sijoitetaan.
     * 
     * @param r Ruudukko-olio, joka antaa viitteen tekoälyn muokattavaan ruudukkoon.
     * @param laivojenkoot Kokonaislukutaulukko, joka sisältää ruudukkoon asetettavien taulukoiden koot.
     */    
    public AI(Ruudukko r, int[] laivojenkoot){
        this.r = r;
        luoLaivojenPino(laivojenkoot);
        this.koko = r.getKoko();
        this.laivat = laivojenkoot.length;
        posx = new Random();
        posy = new Random();
        hor = new Random();
    }
    /**
     * Luo pinon, joka sisältää laivojen koot. Tekoäly käyttää pinoa laivojen lisäämiseen.
     * @param koot Kokonaislukutaulukko. Viite laivojen pinoihin.
     */
    private void luoLaivojenPino(int[] koot){
        laivojenkoot = new Stack();
        for(int i = 0; i < koot.length; i++){
            laivojenkoot.push(koot[i]);
        }
    }
    /**
     * Asettaa laivat viitattuun ruudukkoon käyttäen kolmea satunnaislukugeneraattoria.
     */
    public void asetaLaivatRuudukkoon(){
        if(r != null){
           boolean horizontal;
           int x, y;
           int laivanpit = 0;
           for(int i = 0; i < laivat; i++){               
               laivanpit = haeAsetettavaLaiva();
               boolean asetettu = false;
               while(!asetettu){                   
                   x = posx.nextInt(koko);
                   y = posy.nextInt(koko);
                   horizontal = hor.nextBoolean();
                   asetettu = r.lisaaLaiva(new Laiva(laivanpit), x, y, horizontal); 
               }
           }
        }
        
    }
    /**
     * Palauttaa ja poistaa pinosta seuraavan asetettavan laivan.
     * @return Kokonaisluku. Laivojen kokojen pinosta päällimmäinen.
     */
    public int haeAsetettavaLaiva(){
        int asetettavalaiva = 0;
        if(!laivojenkoot.empty()){
            asetettavalaiva = (int) laivojenkoot.pop();
        }
        return asetettavalaiva;
    }
    
     /**
      * Luo kokonaislukutaulukon kahden satunnaislukugeneraattorin avulla.
      * @return palauttaa kokonaislukutaulukon.
      */
    public int[] haeAmmuttavatKoordinaatit(){
        /*Palauttaa koordinaatit, joihin tekoäly haluaa ampua.*/
        int[] pal = new int[2];
        pal[0] = posx.nextInt(koko);
        pal[1] = posy.nextInt(koko);
        return pal;
    }
}
