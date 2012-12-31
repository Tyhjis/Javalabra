
package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.Logiikka;

public class Kyselyikkuna extends JFrame implements IkkunaIF {

    private Logiikka ohjain;
    private JPanel sisalto;
    private ButtonGroup moodivalinnat, pelaajavalinnat;
    private JRadioButton klassinen, moderni, yksipelaaja, kaksipelaajaa;
    private JButton jatka;
    private Object[] valitse;
    private String ruudukonkokostr, laivojenmaarastr;
    private KyselyDialogi dialogi;
    private int[] defkoot, kustomit;
    private int laivojenmaara, ruudukonkoko;
    private JTextField pelaaja1nimi, pelaaja2nimi;
    
    public Kyselyikkuna(){
        muodostaKayttoliittyma();
    }
    
    @Override
    public void asetaOhjain(Logiikka ohjain) {
        this.ohjain = ohjain;
    }

    @Override
    public void muodostaKayttoliittyma() {
        setTitle("Laivanupotus");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        defkoot = new int [] {5, 4, 3, 3, 2};
        sisalto = new JPanel();
        moodivalinnat = new ButtonGroup();
        pelaajavalinnat = new ButtonGroup();
        klassinen = new JRadioButton("Klassinen peli");
        moderni = new JRadioButton("Kehittyneempi versio");
        yksipelaaja = new JRadioButton("1 pelaaja");
        kaksipelaajaa = new JRadioButton("2 pelaajaa");
        jatka = new JButton("Jatka");
        pelaaja1nimi = new JTextField("Pelaaja1");
        pelaaja2nimi = new JTextField("Pelaaja2");
        jatka.addActionListener(new JatkaNapinToiminta());        
        moodivalinnat.add(klassinen);
        moodivalinnat.add(moderni);
        pelaajavalinnat.add(yksipelaaja);
        pelaajavalinnat.add(kaksipelaajaa);
        klassinen.setSelected(true);
        yksipelaaja.setSelected(true);
        sisalto.add(klassinen);
        sisalto.add(moderni);
        sisalto.add(yksipelaaja);
        sisalto.add(kaksipelaajaa);
        sisalto.add(jatka);
        setContentPane(sisalto);
        setSize(500, 500);
        setVisible(true);
    }
    
    public void kyseleKootJaMaarat(){
        while(!tarkistaSyote(ruudukonkokostr, true)){
            ruudukonkokostr = JOptionPane.showInputDialog("Syota haluamasi ruudukon koko valilta 10-20.");
        }
        while(!tarkistaSyote(laivojenmaarastr, false)){
            laivojenmaarastr = JOptionPane.showInputDialog("Syota haluamasi laivojen maara valilta 1-10.\nTai syota 0, jos haluat klassisen version laivat.");
        }
        ruudukonkoko = Integer.parseInt(ruudukonkokostr);
        laivojenmaara = Integer.parseInt(laivojenmaarastr);
        int i = 0;
        String s;
        valitse = new Object[] {1, 2, 3, 4, 5};
        while(i < laivojenmaara){
            s = (String) JOptionPane.showInputDialog(this, "Syota laivan pituus.", "Laiva", JOptionPane.PLAIN_MESSAGE, null, valitse, valitse[i]);
            kustomit[i] = Integer.parseInt(s);
            i++;
        }
    }
    
    public boolean tarkistaSyote(String syote, boolean ruudukko){
        int n = 0;
        try{
            if(syote != null){
                n = Integer.parseInt(syote);
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Tapahtui virhe!\nAntamasi syote ei ollut numero.", "Virhe", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ruudukko){
            if(n > 9 && n < 21){
                return true;
            }
            return false;
        }
        else{
            if(n > -1 && n < 11){
                return true;
            }
            return false;
        }
    }   
    
    class JatkaNapinToiminta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moderni.isSelected()){
                kyseleKootJaMaarat();
            }
        }
    }
    
}
