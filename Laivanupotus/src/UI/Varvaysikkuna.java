
package UI;

import UI.Hiiritoiminnot.Varvaystapahtuma;
import UI.Nappitoiminnot.TaistelunAloitusnappi;
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
/**
 * Ikkuna, joka kuvastaa graafisesti laivojen asettamista pelaajan ruudukolle.
 * @author Krisu
 */
public class Varvaysikkuna extends JFrame{
    
    private Peli ohjain;
    private JPanel tausta, ruutujenpohja, tietojenpohja;
    private JLabel[][] ruudut;
    private JLabel laivojajaljella;
    private JLabel varvattava;
    private final int ruudukonkoko;
    private Color rajavari, varausvari;
    private Stack laivojenkoot;
    private JRadioButton pysty, vaaka;
    private ButtonGroup asento;
    private JButton jatka;
    private int asetettavalaiva, jaljella;
    /**
     * Konstruktori. Luo uuden Varvaysikkunan annetuilla parametreilla.
     * @param koko Haluttu ruudukon koko.
     * @param laivojenkoot Kokonaislukutaulukko, joka sisältää halutut laivojen pituudet.
     */
    public Varvaysikkuna(int koko, int[] laivojenkoot){
        this.ruudukonkoko = koko;
        luoKokojenPino(laivojenkoot);
        muodostaKayttoliittyma();
    }
    /**
     * Luo pinon asetettavista laivoista.
     * @param koot Kokonaislukutaulukko, jonka alkiot lisätään pinoon.
     */
    private void luoKokojenPino(int[] koot){
        int pit = koot.length;
        laivojenkoot = new Stack();
        for(int i = 0; i < pit; i++){
            laivojenkoot.push(koot[i]);
        }
    }
    /**
     * Kontrollerin asettaminen MVC-tyyppisessä ohjelmassa.
     * @param ohjain Peli-tyypin kontrolleri.
     */
    public void asetaOhjain(Peli ohjain){
        this.ohjain = ohjain;
    }
    /**
     * Käyttöliittymän komponenttien muodostaminen.
     */
    private void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        luoOliot();
        asetaKomponentit();
        setContentPane(tausta);
        haeAsetettavanLaivanPituus();
        setSize(800, 800);
        setVisible(true);
        paivitaTiedot();
    }
    /**
     * Apumetodi käyttöliittymän muodostamiseen. Luo käyttöliittymän oliot.
     */
    private void luoOliot(){
        tausta = new JPanel();
        ruudut = new JLabel[ruudukonkoko][ruudukonkoko];
        rajavari = new Color(0, 0, 0);
        varausvari = new Color(128, 128, 128);
        tietojenpohja = new JPanel();
        ruutujenpohja = new JPanel();
        jatka = new JButton("Taisteluun!");
        jatka.addActionListener(new TaistelunAloitusnappi(this));
        ruutujenpohja.setLayout(new GridLayout(ruudukonkoko, ruudukonkoko));
        tausta.setLayout(new BorderLayout());
        teeRuudukko();
        asento = new ButtonGroup();
        pysty = new JRadioButton("Pystyasento");
        vaaka = new JRadioButton("Vaaka-asento");        
        laivojajaljella = new JLabel("Laivoja jäljellä: ");
        varvattava = new JLabel("Lisättävä laivan pituus: ");
    }
    /**
     * Apumetodi käyttöliittymän muodostamiseen. Asettaa komponentit käyttöliittymään.
     */
    public void asetaKomponentit(){
        asento.add(pysty);
        asento.add(vaaka);
        pysty.setSelected(true);
        tietojenpohja.add(pysty);
        tietojenpohja.add(vaaka);
        tietojenpohja.add(laivojajaljella);
        tietojenpohja.add(varvattava);
        tietojenpohja.add(jatka);
        ruutujenpohja.setSize(700, 700);
        tausta.setSize(800, 700);
        tausta.add(ruutujenpohja, BorderLayout.CENTER);
        tausta.add(tietojenpohja, BorderLayout.NORTH);        
    }
    /**
     * Määrittelee asetettavan laivan pituuden.
     */
    public void haeAsetettavanLaivanPituus(){
        if(!laivojenkoot.empty()){
            asetettavalaiva = (int) laivojenkoot.pop();
        }
        else{
            asetettavalaiva = 0;
        }
    }
    /**
     * Tarkistusmetodi. Jos viimeinen laiva on poistettu pinosta, aloitetaan peli.
     */
    public void tarkistaVoikoPelinAloittaa(){
        if(asetettavalaiva == 0){
                ohjain.aloitaPeli();
                dispose();
        }
        else if(asetettavalaiva > 0){    
            JOptionPane.showMessageDialog(null, "Aseta laivat ensin!", "Oho!", JOptionPane.ERROR_MESSAGE);
        }        
    }
    /**
     * Luo ruudukon, joka kuvastaa laivanupotuspelin koordinaatistoa graafisesti.
     */
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
    /**
     * Näyttää graafisesti mihin laiva on asetettu ruudukolla.
     * @param pit Asetettavan laivan pituus.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     * @param vaaka Kertoo, asetetaanko laiva vaaka- tai pystyasentoon. True = vaaka. False = pysty.
     */
    public void maalaaRuudut(int pit, int posx, int posy, boolean vaaka){
        if(vaaka){
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
        paivitaTiedot();
    }
    /**
     * Kutsuu kontrolleria asettamaan laivan haluttuun paikkaan.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     */
    public void sijoitaLaiva(int posx, int posy){
        ohjain.varvaaLaiva(asetettavalaiva, posx, posy, vaaka.isSelected());
    }
    
    private void paivitaTiedot(){
        varvattava.setText("Asetettavan laivan pituus: "+new Integer(asetettavalaiva).toString());
        jaljella = laivojenkoot.size();
        laivojajaljella.setText("Laivoja jäljellä: "+new Integer(jaljella).toString());
    }
    /**
     * Näyttää virheilmoituksen, jos laivaa ei voitu sovittaa haluttuun paikkaan.
     */
    public void naytaVirheilmoitus(){
        JOptionPane.showMessageDialog(null, "Laivan asettaminen ruudukkoon ei onnistunut! Kokeile jotain muuta paikkaa.", "Oho!", JOptionPane.ERROR_MESSAGE);
    }
}
