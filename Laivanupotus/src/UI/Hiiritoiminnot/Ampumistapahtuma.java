
package UI.Hiiritoiminnot;

import UI.Taisteluikkuna;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Hiirenkuuntelija. Sisällytetään jokaiseen tekoälyn ruutuun Taisteluikkuna-luokassa. Sisältää ruutunsa koordinaatit.
 * @author Krisu
 */
public class Ampumistapahtuma implements MouseListener {

    private int posx, posy;
    private Taisteluikkuna nakyma;
    /**
     * Konstruktori. Asettaa toiminnon koordinaatit.
     * @param posx x-koordinaatti.
     * @param posy y-koordinaatti.
     * @param nakyma Viite graafisen käyttöliittymään.
     */
    public Ampumistapahtuma(int posx, int posy, Taisteluikkuna nakyma){
        this.posx = posx;
        this.posy = posy;
        this.nakyma = nakyma;
    }
    /**
     * Ampuu ruudukkoon.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        nakyma.ammuRuudukkoon(posx, posy);
    }
    /**
     * Ei käytössä.
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }
    /**
     * Ei käytössä.
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    /**
     * Ei käytössä.
     * @param e 
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    /**
     * Ei käytössä.
     * @param e 
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
