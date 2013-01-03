
package UI;

import UI.Hiiritoiminnot.Varvaystapahtuma;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import sovelluslogiikka.Peli;

public class Varvaysikkuna extends JFrame{
    
    private Peli ohjain;
    private JPanel tausta, ruutujenpohja, tietojenpohja;
    private JLabel[][] ruudut;
    private JLabel laivojajaljella;
    private final int ruudukonkoko;
    private Color rajavari, varausvari;
    private Stack laivojenkoot;
    private JRadioButton pysty, vaaka;
    private ButtonGroup asento;
    private JButton jatka;
    private int asetettavalaiva;
    
    public Varvaysikkuna(int koko, int[] laivojenkoot){
        this.ruudukonkoko = koko;
        luoKokojenPino(laivojenkoot);
        muodostaKayttoliittyma();
    }
    
    private void luoKokojenPino(int[] koot){
        int pit = koot.length;
        laivojenkoot = new Stack();
        for(int i = 0; i < pit; i++){
            laivojenkoot.push(koot[i]);
        }
    }
    
    public void asetaOhjain(Peli ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        luoOliot();
        asetaKomponentit();
        setContentPane(tausta);
        haeAsetettavanLaivanPituus();
        setSize(500, 500);
        setVisible(true);
    }
    
    public void luoOliot(){
        tausta = new JPanel();
        ruudut = new JLabel[ruudukonkoko][ruudukonkoko];
        rajavari = new Color(0, 0, 0);
        varausvari = new Color(128, 128, 128);
        tietojenpohja = new JPanel();
        ruutujenpohja = new JPanel();
        jatka = new JButton("Taisteluun!");
        jatka.addActionListener(new TaistelunAloitusnappi());
        ruutujenpohja.setLayout(new GridLayout(ruudukonkoko, ruudukonkoko));
        tausta.setLayout(new BorderLayout());
        teeRuudukko();
        asento = new ButtonGroup();
        pysty = new JRadioButton("Pystyasento");
        vaaka = new JRadioButton("Vaaka-asento");        
        laivojajaljella = new JLabel(new Integer(laivojenkoot.size()).toString());
    }
    
    public void asetaKomponentit(){
        asento.add(pysty);
        asento.add(vaaka);
        pysty.setSelected(true);
        tietojenpohja.add(pysty);
        tietojenpohja.add(vaaka);
        tietojenpohja.add(laivojajaljella);
        tietojenpohja.add(jatka);
        ruutujenpohja.setSize(500, 500);
        tausta.setSize(600, 500);
        tausta.add(ruutujenpohja, BorderLayout.CENTER);
        tausta.add(tietojenpohja, BorderLayout.NORTH);        
    }
    
    public void haeAsetettavanLaivanPituus(){
        if(!laivojenkoot.empty()){
            asetettavalaiva = (int) laivojenkoot.pop();
        }
        else{
            asetettavalaiva = 0;
        }
    }
    
    private void teeRuudukko(){
        for (int i = 0; i < ruudukonkoko; i++) {
            for (int j = 0; j < ruudukonkoko; j++) {
                ruudut[i][j] = new JLabel();
                ruudut[i][j].addMouseListener(new Varvaystapahtuma(j, i, this));
                ruudut[i][j].setBorder(new LineBorder(rajavari));
                ruudut[i][j].setOpaque(true);
                ruutujenpohja.add(ruudut[i][j]);
            }
        }
    }
    
    public void maalaaRuudut(int pit, int posx, int posy, boolean horizontal){
        if(horizontal){
            for(int i = posx; i <= posx+pit-1; i++){
                ruudut[posy][i].setBackground(varausvari);
            }
        }
        else{
            for(int i = posy; i <= posy+pit-1; i++){
                ruudut[i][posx].setBackground(varausvari);
            }
        }
        haeAsetettavanLaivanPituus();
    }
    
    public void naytaLaivaRuudukossa(int posx, int posy){
        
    }
    
    public void sijoitaLaiva(int posx, int posy){
        ohjain.varvaaLaiva(asetettavalaiva, posx, posy, vaaka.isSelected());
    }
    
    public void naytaVirheilmoitus(){
        JOptionPane.showMessageDialog(null, "Laivan asettaminen ruudukkoon ei onnistunut! Kokeile jotain muuta paikkaa.", "Oho!", JOptionPane.ERROR_MESSAGE);
    }
    
    public class TaistelunAloitusnappi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(asetettavalaiva == 0){
                ohjain.aloitaPeli();
                dispose();
            }
            else if(asetettavalaiva > 0){
                JOptionPane.showMessageDialog(null, "Aseta laivat ensin!", "Oho!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
