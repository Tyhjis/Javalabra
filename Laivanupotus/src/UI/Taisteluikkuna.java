
package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.Logiikka;
import sovelluslogiikka.Yksinpeli;

public class Taisteluikkuna extends JFrame {
    
    private JPanel ruudukko1, ruudukko2;
    private JPanel info;
    private JLabel[][] ruudut1, ruudut2;
    private Yksinpeli ohjain;
    
    public Taisteluikkuna(int koko){
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(Yksinpeli ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public void luoPelaajanRuudukko(){
        
    }
    
    public void luoTekoalynRuudukko(){
        
    }
}
