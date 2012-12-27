
package UI;

import javax.swing.*;
import sovelluslogiikka.Logiikka;

public class Aloitusruutu extends JFrame{
    
    private JButton uusipeli, parhaat, lataus;
    private JPanel sisalto;
    private JMenuBar toiminnot;
    private JMenu tiedosto;
    private Logiikka ohjain;
    
    public Aloitusruutu(){
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(Logiikka ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sisalto = new JPanel();
        uusipeli = new JButton("Uusi peli");
        parhaat = new JButton("Parhaat pelaajat");
        lataus = new JButton("Lataa peli");
        toiminnot = new JMenuBar();
        tiedosto = new JMenu("Tiedosto");
        sisalto.add(uusipeli);
        sisalto.add(parhaat);
        sisalto.add(lataus);
        toiminnot.add(tiedosto);
        setJMenuBar(toiminnot);        
        setContentPane(sisalto);
        setSize(400, 500);
        setVisible(true);
    }
}
