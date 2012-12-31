
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.Logiikka;

public class Aloitusikkuna extends JFrame implements IkkunaIF{
    
    private JButton aloitapeli, parhaat, lataus;
    private JPanel sisalto;
    private JMenuBar toiminnot;
    private JMenu tiedosto;
    private Logiikka ohjain;
    
    public Aloitusikkuna(){
        muodostaKayttoliittyma();
    }
    
    @Override
    public void asetaOhjain(Logiikka ohjain){
        this.ohjain = ohjain;
    }
    
    @Override
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sisalto = new JPanel();
        aloitapeli = new JButton("Aloita Peli");
        aloitapeli.addActionListener(new PelinAloitusNappi());
        parhaat = new JButton("Parhaat pelaajat");
        lataus = new JButton("Lataa peli");
        toiminnot = new JMenuBar();
        tiedosto = new JMenu("Tiedosto");
        sisalto.setLayout(new BoxLayout(sisalto, BoxLayout.PAGE_AXIS));
        sisalto.add(aloitapeli);
        sisalto.add(parhaat);
        sisalto.add(lataus);
        toiminnot.add(tiedosto);
        setJMenuBar(toiminnot);        
        setContentPane(sisalto);
        setSize(200, 200);
        setVisible(true);
    }
    
    class PelinAloitusNappi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            ohjain.aloitaPeli();            
        }
    }
}


