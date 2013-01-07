
package UI.Hiiritoiminnot;

import UI.Varvaysikkuna;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import sovelluslogiikka.Peli;

public class Varvaystapahtuma implements MouseListener {

    private final int posx;
    private final int posy;
    private Varvaysikkuna nakyma;
    /**
     * Konstruktori.
     * @param posx Asettaa x-akselin koordinaatin.
     * @param posy Asettaa y-akselin koordinaatin.
     * @param nakyma Asettaa viitteen graafiseen käyttöliittymään.
     */
    public Varvaystapahtuma(int posx, int posy, Varvaysikkuna nakyma){
        this.posx = posx;
        this.posy = posy;
        this.nakyma = nakyma;
    }
    /**
     * Pyrkii sijoittamaan laivan pelaajan ruudukolle.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        nakyma.sijoitaLaiva(posx, posy);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
