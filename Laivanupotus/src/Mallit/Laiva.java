/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mallit;

public class Laiva {
    
    private int pituus;
    
    public Laiva(int pituus){
        this.pituus = pituus;
    }
    
    public int getPituus(){
        return pituus;
    }
    
    public void ammuLaivaan(){
        pituus--;
    }
}
