package it.dannyshanks.trattamentoacqua.gui;

import it.dannyshanks.trattamentoacqua.TrattamentoAcqua;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Danny
 */
public class MainFrame extends JFrame {

    JMenuBar mainMenu = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu insert = new JMenu("Inserisci");

    public MainFrame() {
        super("Programma per il trattamento dell'acqua");
        Container c = this.getContentPane();

        setJMenuBar(mainMenu);
        mainMenu.add(file);
        mainMenu.add(insert);

        JMenuItem close = new JMenuItem("Exit");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrattamentoAcqua.saveAll();
                System.exit(0);
            }
        });
        file.add(close);

        JMenuItem aggAcquaComm = new JMenuItem("Acqua Commerciale");
        aggAcquaComm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAcquaCommerciale fac = new FormAcquaCommerciale();
                fac.setVisible(true);
            }
        });
        insert.add(aggAcquaComm);

        JMenuItem aggAcquaRifer = new JMenuItem("Acqua di Riferimento");
        aggAcquaRifer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormAcquaRiferimento far = new FormAcquaRiferimento();
                far.setVisible(true);
            }
        });
        insert.add(aggAcquaRifer);

        MainPanel mainPanel = new MainPanel();
        mainPanel.setSize(600, 600);
        c.add(mainPanel);
    }

}
