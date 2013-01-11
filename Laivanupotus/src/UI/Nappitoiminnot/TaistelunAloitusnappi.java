/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Nappitoiminnot;

import UI.Varvaysikkuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Krisu
 */
public class TaistelunAloitusnappi implements ActionListener{

    private Varvaysikkuna nakyma;
    
    public TaistelunAloitusnappi(Varvaysikkuna nakyma){
        this.nakyma = nakyma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nakyma.tarkistaVoikoPelinAloittaa();
    }
    
}
