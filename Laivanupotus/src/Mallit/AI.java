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
    private int[] viimeksiammutut;
    private final int[] kokeiltavat;
    private Stack laivojenkoot;
    private boolean osuiko, upposiko;
    
    public AI(Ruudukko r, int[] laivojenkoot){
        kokeiltavat = new int[] {1, -1};
        this.r = r;
        luoLaivojenPino(laivojenkoot);
        this.koko = r.getKoko();
        this.laivat = laivojenkoot.length;
        viimeksiammutut = new int[2];
        osuiko = false;
        posx = new Random();
        posy = new Random();
        hor = new Random();
        haeAsetettavaLaiva();
    }
    
    private void luoLaivojenPino(int[] koot){
        laivojenkoot = new Stack();
        for(int i = 0; i < koot.length; i++){
            laivojenkoot.push(koot[i]);
        }
    }
    
    public void asetaLaivaRuudukkoon(int laivankoko){
        boolean asetettu = false;
        boolean horizontal;
        int x, y;
        while(!asetettu){
            x = posx.nextInt(koko);
            y = posy.nextInt(koko);
            horizontal = hor.nextBoolean();
            asetettu = r.lisaaLaiva(new Laiva(laivankoko), x, y, horizontal); 
        }
        haeAsetettavaLaiva();
    }
    
    public void haeAsetettavaLaiva(){
        int asetettavalaiva = 0;
        if(!laivojenkoot.empty()){
            asetettavalaiva = (int) laivojenkoot.pop();
            asetaLaivaRuudukkoon(asetettavalaiva);
        }
    }
    
    public int[] getAmmuttavatKoordinaatit(){
        int[] pal = new int[2];
        boolean kokeilehor = false;
        if(osuiko){
            if(upposiko){
                pal = luoTaysinUudetKoordinaatit();
            }
            else{
                kokeilehor = hor.nextBoolean();
                if(kokeilehor){
                    pal[0] = kokeiltavat[posx.nextInt(2)];
                    pal[1] = viimeksiammutut[1];
                }
                else{
                    pal[0] = viimeksiammutut[0];
                    pal[1] = kokeiltavat[posy.nextInt(2)];
                }
            }
        }
        else{
            pal = luoTaysinUudetKoordinaatit();
        }
        return pal;
    }
    
    public int[] luoTaysinUudetKoordinaatit(){
        int[] pal = new int[2];
        pal[0] = posx.nextInt(10);
        viimeksiammutut[0] = pal[0];
        pal[1] = posy.nextInt(10);
        viimeksiammutut[1] = pal[1];
        return pal;
    }
    
    public void setLaivaanOsui(int x, int y){
        this.osuiko = true;
        viimeksiammutut[0] = x;
        viimeksiammutut[1] = y;
    }
    
    public void setUpotettu(boolean upposi){
        this.upposiko = upposi;
    }
    
    public boolean getOsuikoLaivaan(){
        return osuiko;
    }
    
}
