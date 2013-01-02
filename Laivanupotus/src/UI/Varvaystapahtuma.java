
package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import sovelluslogiikka.Yksinpeli;

public class Varvaystapahtuma implements MouseListener {

    private final int posx;
    private final int posy;
    private Varvaysikkuna nakyma;
    
    public Varvaystapahtuma(int posx, int posy, Varvaysikkuna nakyma){
        this.posx = posx;
        this.posy = posy;
        this.nakyma = nakyma;
    }
    
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
