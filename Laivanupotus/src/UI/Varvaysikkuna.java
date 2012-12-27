
package UI;

import Mallit.Ruudukko;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import sovelluslogiikka.Logiikka;

public class Varvaysikkuna {
    
    private Logiikka ohjain;
    private JPanel ruutujenpohja;
    private JLabel[][] ruudut;
    private final int ruudukonkoko;
    private Ruudukko ruudukko;
    private Color rajavari;
    
    public Varvaysikkuna(int koko){
        this.ruudukonkoko = koko;
        muodostaKayttoliittyma();        
    }
    
    public void asetaOhjain(Logiikka ohjain){
        this.ohjain = ohjain;        
    }
    
    public void muodostaKayttoliittyma(){
        ruutujenpohja = new JPanel();
        ruutujenpohja.setLayout(new GridLayout(ruudukonkoko, ruudukonkoko));
        
        ruudut = new JLabel[ruudukonkoko][ruudukonkoko];
        rajavari = new Color(0, 0, 0);
        teeRuudukko(ruudut);
    }
    
    public void teeRuudukko(JLabel[][] ruudut){
        for (int i = 0; i < ruudukonkoko; i++) {
            for (int j = 0; j < ruudukonkoko; j++) {
                ruudut[i][j] = new JLabel();
                ruudut[i][j].setBorder(new LineBorder(rajavari));
                ruudut[i][j].setOpaque(true);
                
                ruutujenpohja.add(ruudut[i][j]);
            }
        }
    }
}
