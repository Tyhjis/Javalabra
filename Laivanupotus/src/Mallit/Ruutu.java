/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

/**
 *
 * @author Krisu
 */
public class Ruutu {
    
    private int posx;
    private int posy;
    private boolean ammuttu;
    private boolean onkolaiva;
    
    public Ruutu(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
        this.ammuttu = false;
        this.onkolaiva = false;
    }
    
    public int[] getPosition(){
        return new int[] {posx, posy};
    }
    
    public boolean onkoAmmuttu(){
        return ammuttu;
    }
    
    public boolean sisaltaakoLaivan(){
        return onkolaiva;
    }
    
    public void ammuRuutuun(){
        this.ammuttu = true;
    }
    
    public void asetaLaiva(){
        this.onkolaiva = true;
    }
    
    public boolean onkoTuhottu(){
        return onkolaiva && ammuttu;
    }
}
