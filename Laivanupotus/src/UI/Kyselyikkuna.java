
package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.Logiikka;

public class Kyselyikkuna extends JFrame implements IkkunaIF {

    private Logiikka ohjain;
    private JPanel pohja, sisalto, kyselynsisalto;
    private ButtonGroup moodivalinnat, pelaajavalinnat;
    private JRadioButton klassinen, moderni, yksipelaaja, kaksipelaajaa;
    private JButton jatka;
    private String ruudukonkokostr, laivojenmaarastr;
    private int[] defkoot, kustomkoot;
    private int laivojenmaara, ruudukonkoko;
    private JTextField pelaaja1nimi, pelaaja2nimi;
    private String nimi1, nimi2;
    private final Object[] valinnat;
    private JComboBox[] valitse;
    private JLabel[] indeksit;
    
    public Kyselyikkuna(){
        valinnat = new Object[] {1, 2, 3, 4, 5};
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
        pohja = new JPanel();
        sisalto = new JPanel();
        kyselynsisalto = new JPanel();
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
        moderni.addActionListener(new PelityylinToiminta());
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
        sisalto.add(pelaaja1nimi);
        sisalto.add(pelaaja2nimi);
        pohja.add(sisalto);
        pohja.add(kyselynsisalto);
        setContentPane(pohja);
        setSize(500, 500);
        setVisible(true);
    }
    
    public void lisaaKomponentitKayttoliittymaan() {
        valitse = new JComboBox[laivojenmaara];
        indeksit = new JLabel[laivojenmaara];
        kyselynsisalto.setLayout(new GridLayout(laivojenmaara, 2));
        Integer apu;
        for(int i = 0; i < laivojenmaara; i++){
            apu = new Integer(i+1);
            indeksit[i] = new JLabel(apu.toString());
            kyselynsisalto.add(indeksit[i]);
            valitse[i] = new JComboBox(valinnat);
            valitse[i].setSelectedIndex(0);
            valitse[i].setEditable(true);
            kyselynsisalto.add(valitse[i]);
            setContentPane(pohja);
        }
    }
    
    public void alustaKokoJaMaara(){
        while(!tarkistaSyote(ruudukonkokostr, true)){
            ruudukonkokostr = JOptionPane.showInputDialog("Syota haluamasi ruudukon koko valilta 10-20.");
        }
        while(!tarkistaSyote(laivojenmaarastr, false)){
            laivojenmaarastr = JOptionPane.showInputDialog("Syota haluamasi laivojen maara valilta 1-10.\nTai syota 0, jos haluat samat kuin klassisessa");
        }
        ruudukonkoko = Integer.parseInt(ruudukonkokostr);
        laivojenmaara = Integer.parseInt(laivojenmaarastr);
    }
    
    public void alustaLaivojenKoot(){
        Integer n;
        String s;
        kustomkoot = new int[laivojenmaara];
        for(int i = 0; i < laivojenmaara; i++){
            s = valitse[i].getSelectedItem().toString();
            n = new Integer(s);
            kustomkoot[i] = n.intValue();
        }
    }
    
    public boolean tarkistaSyote(String s, boolean ruudukko){
        Integer n = new Integer("-1");
        try{
            if(s != null){
                n = new Integer(s);
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Tapahtui virhe! Et antanut kunnollista syotetta.", "Virhe", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ruudukko){
            if(n.intValue() > 9 && n.intValue() < 21){
                return true;
            }
        }
        else{
            if(n.intValue() > -1 && n.intValue() < 11){
                return true;
            }
        }
        return false;
    }
    
    
    class JatkaNapinToiminta implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moderni.isSelected()){
                alustaLaivojenKoot();
                if(yksipelaaja.isSelected()){
                    ohjain.aloitaYksinpeli(pelaaja1nimi.getText(), ruudukonkoko, kustomkoot);
                }
                else{
                    ohjain.aloitaKaksinpeli(pelaaja1nimi.getText(), pelaaja2nimi.getText(), ruudukonkoko, kustomkoot);
                }
            }
            else{
                if(yksipelaaja.isSelected()){
                    ohjain.aloitaYksinpeli(pelaaja1nimi.getText(), ruudukonkoko, defkoot);
                }
                else{
                    ohjain.aloitaKaksinpeli(pelaaja1nimi.getText(), pelaaja2nimi.getText(), ruudukonkoko, defkoot);
                }
            }
        }
    }
    
    class PelityylinToiminta implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            alustaKokoJaMaara();
            lisaaKomponentitKayttoliittymaan();
        }
        
    }
    
}
