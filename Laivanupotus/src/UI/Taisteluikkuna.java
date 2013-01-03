
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;
import sovelluslogiikka.Peli;

public class Taisteluikkuna extends JFrame {
    
    private JPanel ruudukko1, ruudukko2, tausta, laivojenmaarat, vuorontausta;
    private JLabel[][] ruudut1, ruudut2;
    private JLabel laivoja1, laivoja2, vuorot;
    private JMenuBar menut;
    private JMenu menu1;
    private Peli ohjain;
    private final int ruudukonkoko;
    private int laivojenmaara1, laivojenmaara2;
    private int vuoro;
    private boolean[][] pelaajanruudut;
    private Color keltainen, musta, punainen, harmaa;
    
    public Taisteluikkuna(int koko, int maara, boolean[][] pelaajanruudut){
        ruudukonkoko = koko;
        laivojenmaara1 = maara;
        laivojenmaara2 = maara;
        vuoro = 1;
        this.pelaajanruudut = pelaajanruudut;
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(Peli ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        luoOliot();
        luoPelaajanRuudukko();
        luoTekoalynRuudukko();
        laivojenmaarat.setSize(500, 75);
        vuorontausta.setSize(500, 75);
        tausta.add(laivojenmaarat);
        tausta.add(vuorontausta);
        ruudukko1.setSize(500, 500);
        ruudukko2.setSize(500, 500);
        tausta.add(ruudukko1);
        tausta.add(ruudukko2);
        setContentPane(tausta);
        setSize(1000, 1000);
        setVisible(true);
    }
    
    public void luoOliot(){
        tausta = new JPanel();
        laivojenmaarat = new JPanel();
        vuorontausta = new JPanel();
        
        laivoja1 = new JLabel("Pelaajan laivat: "+new Integer(laivojenmaara1).toString());
        laivoja2 = new JLabel("Tietokoneen laivat: "+new Integer(laivojenmaara2).toString());
        vuorot = new JLabel("Vuoro: "+new Integer(vuoro).toString());
        
        ruudukko1 = new JPanel();
        ruudukko2 = new JPanel();
        
        ruudukko1.setLayout(new GridLayout(ruudukonkoko, ruudukonkoko));
        ruudukko2.setLayout(new GridLayout(ruudukonkoko, ruudukonkoko));
        tausta.setLayout(new GridLayout(2, 2));
        
        ruudut1 = new JLabel[ruudukonkoko][ruudukonkoko];
        ruudut2 = new JLabel[ruudukonkoko][ruudukonkoko];
        
        keltainen = new Color(255, 255, 0);
        musta = new Color(0, 0, 0);
        punainen = new Color(255, 0, 0);
        harmaa = new Color(128, 128, 128);
        
        laivojenmaarat.add(laivoja1);
        laivojenmaarat.add(laivoja2);
        vuorontausta.add(vuorot);
    }
    
    public void luoPelaajanRuudukko(){
        for(int i = 0; i < ruudukonkoko; i++){
            for(int j = 0; j < ruudukonkoko; j++){
                ruudut1[i][j] = new JLabel();
                ruudut1[i][j].setOpaque(true);
                ruudut1[i][j].setBorder(new LineBorder(musta));
                if(pelaajanruudut[i][j]){
                    ruudut1[i][j].setBackground(harmaa);
                }
                ruudukko1.add(ruudut1[i][j]);
            }
        }
    }
    
    public void luoTekoalynRuudukko(){
        for(int i = 0; i < ruudukonkoko; i++){
            for(int j = 0; j < ruudukonkoko; j++){
                ruudut2[i][j] = new JLabel();
                ruudut2[i][j].setOpaque(true);
                ruudut2[i][j].setBorder(new LineBorder(musta));
                ruudut2[i][j].addMouseListener(new Ampumistapahtuma(j, i, this));
                ruudukko2.add(ruudut2[i][j]);
            }
        }
    }
    
    public void ammuTekoalynRuutuun(int posx, int posy){
        
    }
    
    
    
}
