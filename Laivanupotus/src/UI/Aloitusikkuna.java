
package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.Logiikka;

public class Aloitusikkuna extends JFrame implements IkkunaIF{
    
    private JButton kaksinpeli, yksinpeli, parhaat, lataus;
    private JPanel sisalto;
    private JMenuBar toiminnot;
    private JMenu tiedosto;
    private Logiikka ohjain;
    
    public Aloitusikkuna(){
        muodostaKayttoliittyma();
    }
    
    public void asetaOhjain(Logiikka ohjain){
        this.ohjain = ohjain;
    }
    
    public void muodostaKayttoliittyma(){
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        sisalto = new JPanel();
        kaksinpeli = new JButton("Kaksinpeli");
        yksinpeli = new JButton("Yksinpeli");
        parhaat = new JButton("Parhaat pelaajat");
        lataus = new JButton("Lataa peli");
        toiminnot = new JMenuBar();
        tiedosto = new JMenu("Tiedosto");
        sisalto.setLayout(new BoxLayout(sisalto, BoxLayout.PAGE_AXIS));
        sisalto.add(yksinpeli);
        sisalto.add(kaksinpeli);
        sisalto.add(parhaat);
        sisalto.add(lataus);
        toiminnot.add(tiedosto);
        setJMenuBar(toiminnot);        
        setContentPane(sisalto);
        setSize(200, 200);
        setVisible(true);
    }
    
    class Kaksinpelinappi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            ohjain.aloitaKaksinpeli();            
        }
        
    }
}


