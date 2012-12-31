
package UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import sovelluslogiikka.PeliIF;

public class Varvaysikkuna {
    
    private PeliIF ohjain;
    private JPanel ruutujenpohja;
    private JLabel[][] ruudut;
    private final int ruudukonkoko;
    private Color rajavari;
    ArrayList<Integer> laivojenkoot;
    
    public Varvaysikkuna(int koko, ArrayList<Integer> laivojenkoot){
        this.ruudukonkoko = koko;
        this.laivojenkoot = laivojenkoot;
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(PeliIF ohjain){
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
                ruudut[i][j].addMouseListener(new Varvaystapahtuma(j, i, this));
                ruudut[i][j].setOpaque(true);
                ruutujenpohja.add(ruudut[i][j]);
            }
        }
    }
}
