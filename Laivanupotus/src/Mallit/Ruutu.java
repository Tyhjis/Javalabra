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
    
    private int posx; //Ruudun
    private int posy; //paikka ruudukossa.
    private boolean ammuttu;
    private boolean onkolaiva;
    private Laiva laiva; //Sisaltaa viitteen laivaan.
    
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
    
    public void ammu(){
        this.ammuttu = true;
        if(onkoTuhottu())
            laiva.ammuLaivaan();
    }
    
    public void asetaLaiva(Laiva laiva){
        this.onkolaiva = true;
        this.laiva = laiva;
    }
    
    public boolean onkoTuhottu(){
        return onkolaiva && ammuttu;
    }
}
