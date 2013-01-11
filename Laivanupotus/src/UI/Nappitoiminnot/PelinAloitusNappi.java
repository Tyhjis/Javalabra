/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Nappitoiminnot;

import UI.Aloitusikkuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Krisu
 */
public class PelinAloitusNappi implements ActionListener{

    Aloitusikkuna nakyma;
    
    public PelinAloitusNappi(Aloitusikkuna nakyma){
        this.nakyma = nakyma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nakyma.aloitaPeli();
    }
    
}
