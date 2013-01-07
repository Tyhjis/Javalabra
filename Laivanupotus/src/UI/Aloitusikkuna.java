
package UI;

import Mallit.Pelaaja;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import sovelluslogiikka.PelinAloitus;
/**
 * 
 * @author Krisu
 */
public class Aloitusikkuna extends JFrame{
    
    private JButton aloitapeli, parhaat, lataus;
    private JPanel tausta, pelaajat;
    private JMenuBar toiminnot;
    private JMenu tiedosto;
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
        aloitapeli = new JButton("Aloita Peli");
        aloitapeli.addActionListener(new PelinAloitusNappi());
        parhaat = new JButton("Parhaat pelaajat");
        parhaat.addActionListener(new ParhaatPelaajatNappi());
        lataus = new JButton("Lataa peli");
        toiminnot = new JMenuBar();
        tiedosto = new JMenu("Tiedosto");
        tausta.setLayout(new BoxLayout(tausta, BoxLayout.PAGE_AXIS));
        tausta.add(aloitapeli);
        tausta.add(parhaat);
        tausta.add(lataus);
        toiminnot.add(tiedosto);
        setJMenuBar(toiminnot);
        setContentPane(tausta);
        setSize(200, 200);
        setVisible(true);
    }
    /**
     * Tarkoitus Listata parhaat pelaajat.
     * @param lista Parametrina annetaan ArrayList-olio, joka sisältää parhaat pelaajat.
     */
    public void asetaParhaatPelaajat(ArrayList<Pelaaja> lista){
        for(Pelaaja p: lista){
            System.out.println(p.toString());
        }
    }
    /**
     * Toiminnankuuntelija pelin aloittamiselle.
     */
    class PelinAloitusNappi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ohjain.luoKyselyikkuna();
            dispose();
        }
    }
    /**
     * Tarkoitus hakea ArrayList-olio kontrollerilta.
     */
    class ParhaatPelaajatNappi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
}


