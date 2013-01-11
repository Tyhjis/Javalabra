
package UI;

import UI.Hiiritoiminnot.Ampumistapahtuma;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;
import sovelluslogiikka.Peli;
/**
 * Laivanupotuspelin taisteluikkuna. Kuvastaa pelaamisen tapahtumia.
 * @author Krisu
 */
public class Taisteluikkuna extends JFrame {
    
    private JPanel ruudukko1, ruudukko2, tausta, laivojenmaarat, vuorontausta;
    private JLabel[][] ruudut1, ruudut2;
    private JLabel laivoja1, laivoja2, vuorot;
    private Peli ohjain;
    private final int ruudukonkoko;
    private int laivojenmaara1, laivojenmaara2;
    private boolean[][] pelaajanruudut;
    private Color keltainen, musta, punainen, harmaa;
    /**
     * Konstruktori. Muodostaa Käyttöliittymän.
     * @param koko Haluttu ruudukon koko.
     * @param maara Alussa olevien laivojen määrä.
     * @param pelaajanruudut Kaksiulotteinen boolean-taulukko pelaajan ruudukon laivojen näyttämistä varten.
     */
    public Taisteluikkuna(int koko, int maara, boolean[][] pelaajanruudut){
        ruudukonkoko = koko;
        laivojenmaara1 = maara;
        laivojenmaara2 = maara;
        this.pelaajanruudut = pelaajanruudut;
        muodostaKayttoliittyma();
    }
     /**
      * Asettaa kontrollerin MVC-tyyppisessä ohjelmassa.
      * @param ohjain Viite Peli-tyyppinen ohjain.
      */
    public void asetaOhjain(Peli ohjain){
        this.ohjain = ohjain;
    }
    /**
     * Luo käyttöliittymän oliot ja asettaa ne ikkunaan.
     */
    private void muodostaKayttoliittyma(){
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
    /**
     * Apumetodi käyttöliittymän muodostamiseen. Luo käyttöliittymän komponentit.
     */
    private void luoOliot(){
        tausta = new JPanel();
        laivojenmaarat = new JPanel();
        vuorontausta = new JPanel();
        
        laivoja1 = new JLabel("Pelaajan laivat: "+new Integer(laivojenmaara1).toString());
        laivoja2 = new JLabel("Tietokoneen laivat: "+new Integer(laivojenmaara2).toString());
        vuorot = new JLabel("Vuoro: "+new Integer(0).toString());
        
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
    /**
     * Apumetodi käyttöliittymän muodostamiseen. Luo ruudukon, joka kuvastaa pelaajan omistamaa koordinaatistoa.
     */
    private void luoPelaajanRuudukko(){
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
    /**
     * Apumetodi käyttöliittymän muodostamiseen. Luo ruudukon, joka kuvastaa tekoälyn omistamaa koordinaatistoa.
     */
    private void luoTekoalynRuudukko(){
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
    /**
     * Päivittää pelin kulun tiedot käyttäjälle. Vaihtaa käytyjen vuorojen ja jäljellä olevien laivojen määrää.
     * @param pelships Pelaajan laivojen määrä.
     * @param aiships Tekoälyn laivojen määrä.
     * @param vuoro Käydyt vuorot.
     */
    public void paivitaTiedot(int pelships, int aiships, int vuoro){
        laivoja1.setText("Pelaajan laivat: "+new Integer(pelships).toString());
        laivoja2.setText("Tekoalyn laivat: "+new Integer(aiships).toString());
        vuorot.setText("Vuoro: "+new Integer(vuoro).toString());        
    }
    /**
     * Pelin lopetusmetodi. Pelaaja on voittanut pelin.
     * @param nimi Pelaajan nimi.
     * @param pisteet Pelaajan saamat pisteet.
     */
    public void voitto(String nimi, double pisteet){
        JOptionPane.showMessageDialog(null, "Onneksi olkoon "+nimi+"! Voitit. Sait "+pisteet+" pistettä.");
        ohjain.uusiPeli();
        dispose();
    }
    /**
     * Pelin lopetusmetodi. Pelaaja on hävinnyt pelin.
     */
    public void havio(){
        JOptionPane.showMessageDialog(null, "Oho! Valitettavasti hävisit pelin.");
        ohjain.uusiPeli();
        dispose();
    }
    /**
     * Kutsuu kontrolleria pelaamaan vuoron.
     * @param posx Haluttu x-akselin koordinaatti. Ampuu tekoälyn ruudukkoon.
     * @param posy Haluttu y-akselin koordinaatti. Ampuu tekoälyn ruudukkoon.
     */
    public void ammuRuudukkoon(int posx, int posy){
        ohjain.pelaaVuoro(posx, posy);
    }
    /**
     * Maalaa halutun ruudun keltaiseksi tekoälyn ruudukosta.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     */
    public void maalaaAIruudKeltaiseksi(int posx, int posy){
        ruudut2[posy][posx].setBackground(keltainen);
    }
    /**
     * Maalaa halutun ruudun punaiseksi tekoälyn ruudukosta.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     */
    public void maalaaAIruudPunaiseksi(int posx, int posy){
        ruudut2[posy][posx].setBackground(punainen);
    }
    /**
     * Maalaa halutun ruudun keltaiseksi pelaajan ruudukosta.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     */
    public void maalaaPelruudKeltaiseksi(int posx, int posy){
        ruudut1[posy][posx].setBackground(keltainen);
    }
    /**
     * Maalaa halutun ruudun punaiseksi pelaajan ruudukosta.
     * @param posx Haluttu x-akselin koordinaatti.
     * @param posy Haluttu y-akselin koordinaatti.
     */
    public void maalaaPelruudPunaiseksi(int posx, int posy){
        ruudut1[posy][posx].setBackground(punainen);
    }
    /**
     * Esittää virheilmoituksen. Kutsutaan, jos ruutuun ei voi ampua.
     */
    public void esitaVirheilmoitus(){
        JOptionPane.showMessageDialog(null, "Valitse jokin muu ruutu.", "Oho!", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
}
