
package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import sovelluslogiikka.Logiikka;
import sovelluslogiikka.PeliIF;


public class Varvaystapahtuma implements MouseListener {

    private final int posx;
    private final int posy;
    private Varvaysikkuna varvays;
    
    public Varvaystapahtuma(int posx, int posy, Varvaysikkuna varvays){
        this.varvays = varvays;
        this.posx = posx;
        this.posy = posy;
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
