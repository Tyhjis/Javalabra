
package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.Logiikka;

public class Taisteluikkuna extends JFrame {
    
    private JPanel ruudukko1, ruudukko2;
    private JPanel info;
    private JLabel[][] ruudut;
    private Logiikka ohjain;
    
    public Taisteluikkuna(){
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(Logiikka ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
}
