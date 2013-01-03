/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

import java.util.Random;
import java.util.Stack;
import sovelluslogiikka.Peli;

/**
 *
 * @author Krisu
 */
public class AI {
    
    private Ruudukko r;
    private Random posx, posy, hor;
    private int koko, laivat;
    private Stack laivojenkoot;
    
    public AI(Ruudukko r, int[] laivojenkoot){
        this.r = r;
        luoLaivojenPino(laivojenkoot);
        this.koko = r.getKoko();
        this.laivat = laivojenkoot.length;
        posx = new Random();
        posy = new Random();
        hor = new Random();
    }
    
    private void luoLaivojenPino(int[] koot){
        laivojenkoot = new Stack();
        for(int i = 0; i < koot.length; i++){
            laivojenkoot.push(koot[i]);
        }
    }
    
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
    
    public int haeAsetettavaLaiva(){
        int asetettavalaiva = 0;
        if(!laivojenkoot.empty()){
            asetettavalaiva = (int) laivojenkoot.pop();
        }
        return asetettavalaiva;
    }
    
    public int[] haeAmmuttavatKoordinaatit(){
        /*Palauttaa koordinaatit, joihin tekoäly haluaa ampua.*/
        int[] pal = new int[2];
        pal[0] = posx.nextInt(koko);
        pal[1] = posy.nextInt(koko);
        return pal;
    }
}
