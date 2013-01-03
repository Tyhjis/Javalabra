
package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ampumistapahtuma implements MouseListener {

    private int posx, posy;
    private Taisteluikkuna nakyma;
    
    public Ampumistapahtuma(int posx, int posy, Taisteluikkuna nakyma){
        this.posx = posx;
        this.posy = posy;
        this.nakyma = nakyma;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
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
