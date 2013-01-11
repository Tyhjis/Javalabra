
package UI;

import UI.Nappitoiminnot.PelinAloitusNappi;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.PelinAloitus;
/**
 * 
 * @author Krisu
 */
public class Aloitusikkuna extends JFrame{
    
    private JButton aloitapeli;
    private JPanel tausta;
    private JTextArea pelaajat;
    private PelinAloitus ohjain;
    /**
     * Konstruktori. Kutsuu muodostaKayttoliittyma-metodia.
     */
    public Aloitusikkuna(){
        muodostaKayttoliittyma();
    }
    /**
     * Asettaa kontrollerin MVC-tyyppisessä ohjelmassa.
     * @param ohjain PelinAloitus-tyyppinen ohjain.
     */
    public void asetaOhjain(PelinAloitus ohjain){
        this.ohjain = ohjain;
    }
    /**
     * 
     */
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tausta = new JPanel();
        pelaajat = new JTextArea();
        pelaajat.setEditable(false);
        aloitapeli = new JButton("Aloita Peli");
        aloitapeli.addActionListener(new PelinAloitusNappi(this));
        tausta.setLayout(new BoxLayout(tausta, BoxLayout.PAGE_AXIS));
        tausta.add(aloitapeli);
        tausta.add(pelaajat);
        setContentPane(tausta);
        setSize(500, 500);
        setVisible(true);
    }
    /**
     * Tarkoitus listata parhaat pelaajat.
     * @param lista Parametrina annetaan ArrayList-olio, joka sisältää parhaat pelaajat.
     */
    public void asetaParhaatPelaajat(String lista){
        pelaajat.setText(lista);
    }
    /**
     * Esittää virheilmoituksen, jos uuden tiedoston luonti onnistui.
     */
    public void esitaVirheilmoitusTiedostonLuontiOnnistui(){
        JOptionPane.showMessageDialog(null, "Tiedostoa parhaista pelaajista ei löytynyt. Uusi tyhjä tiedosto on luotu.", "Oho!", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Esittää virheilmoituksen, jos uuden tiedoston luonti epäonnistui.
     */
    public void esitaVirheilmoitusTiedostonLuontiEpaonnistui(){
        JOptionPane.showMessageDialog(null, "Tiedostoan parhaista pelaajista ei löytynyt. Uutta tiedostoa ei voitu luoda.", "Oho!", JOptionPane.ERROR_MESSAGE);
    }
    
    public void aloitaPeli(){
        ohjain.luoKyselyikkuna();
        dispose();
    }
    
}


