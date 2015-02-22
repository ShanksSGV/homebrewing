package it.dannyshanks.trattamentoacqua;

import it.dannyshanks.trattamentoacqua.gui.MainFrame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;

import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Danny
 */
public class TrattamentoAcqua {

    private final static String DATABASE = "database.xls";
    private final static String ACQUE_COMMERCIALI = "Acque Commerciali"; //uguali ai fogli excel
    private final static String ACQUE_RIFERIMENTO = "Acque Riferimento";

    public static ArrayList<AcquaCommerciale> AcqueCommerciali;
    public static ArrayList<AcquaRiferimento> AcqueRiferimento;

    public static void main(String[] args) {

        try {
            AcqueCommerciali = initAcqueCommerciali();
            AcqueRiferimento = initAcqueRiferimento();

            MainFrame mainFrame = new MainFrame();

            mainFrame.setSize(700, 500);
            mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainFrame.setVisible(true);

        } catch (IOException | BiffException e) {
            System.out.println("Errore nella lettura da database!");
        }

    }

    private static ArrayList<AcquaCommerciale> initAcqueCommerciali() throws IOException, BiffException {
        ArrayList<AcquaCommerciale> listaAC = new ArrayList<>();

        Workbook database = Workbook.getWorkbook(new File(DATABASE));
        Sheet sheet = database.getSheet(0);
        for (int i = 1; i < sheet.getRows(); i++) {
            String nome = sheet.getCell(0, i).getContents();
            if (nome != "") {
                AcquaCommerciale ac = new AcquaCommerciale(nome,
                        (float) Float.valueOf(sheet.getCell(1, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(2, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(3, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(4, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(5, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(6, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(7, i).getContents().replace(",", ".")));
                listaAC.add(ac);
            }
        }
        return listaAC;
    }

    private static ArrayList<AcquaRiferimento> initAcqueRiferimento() throws IOException, BiffException {
        ArrayList<AcquaRiferimento> listaAR = new ArrayList<>();
        Workbook database = Workbook.getWorkbook(new File(DATABASE));
        Sheet sheet = database.getSheet(1);

        for (int i = 1; i < sheet.getRows(); i++) {
            String nome = sheet.getCell(0, i).getContents();
            if (nome != "") {
                AcquaRiferimento ar = new AcquaRiferimento(nome,
                        (float) Float.valueOf(sheet.getCell(1, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(2, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(3, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(4, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(5, i).getContents().replace(",", ".")),
                        (float) Float.valueOf(sheet.getCell(6, i).getContents().replace(",", ".")));
                listaAR.add(ar);
            }
        }
        return listaAR;
    }

    public static void saveAll() {
        try {
            WritableWorkbook database = Workbook.createWorkbook(new File("database.xls"));
            WritableSheet acSheet = database.createSheet(ACQUE_COMMERCIALI, 0);
            WritableSheet arSheet = database.createSheet(ACQUE_RIFERIMENTO, 1);
            try {
                acSheet.addCell(new Label(0, 0, "Nome"));
                acSheet.addCell(new Label(1, 0, "Calcio Ca2+"));
                acSheet.addCell(new Label(2, 0, "Magnesio Mg2+"));
                acSheet.addCell(new Label(3, 0, "Sodio Na+"));
                acSheet.addCell(new Label(4, 0, "Solfati SO4--"));
                acSheet.addCell(new Label(5, 0, "Bicarbonato HCO3-"));
                acSheet.addCell(new Label(6, 0, "Nitrati NO3-"));
                acSheet.addCell(new Label(7, 0, "Cloruri Cl-"));

                for (int i = 0; i < AcqueCommerciali.size(); i++) {
                    AcquaCommerciale a = AcqueCommerciali.get(i);
                    Label nome = new Label(0, i + 1, a.getName());
                    Number calcio = new Number(1, i + 1, a.getCalcio());
                    Number magnesio = new Number(2, i + 1, a.getMagnesio());
                    Number sodio = new Number(3, i + 1, a.getSodio());
                    Number solfati = new Number(4, i + 1, a.getSolfato());
                    Number bicarbonati = new Number(5, i + 1, a.getBicarbonato());
                    Number nitrati = new Number(6, i + 1, a.getNitrato());
                    Number cloruri = new Number(7, i + 1, a.getCloruro());

                    acSheet.addCell(nome);
                    acSheet.addCell(calcio);
                    acSheet.addCell(magnesio);
                    acSheet.addCell(sodio);
                    acSheet.addCell(solfati);
                    acSheet.addCell(bicarbonati);
                    acSheet.addCell(nitrati);
                    acSheet.addCell(cloruri);
                }
            } catch (WriteException ex) {
                Logger.getLogger(TrattamentoAcqua.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                arSheet.addCell(new Label(0, 0, "Nome"));
                arSheet.addCell(new Label(1, 0, "Calcio Ca2+"));
                arSheet.addCell(new Label(2, 0, "Magnesio Mg2+"));
                arSheet.addCell(new Label(3, 0, "Sodio Na+"));
                arSheet.addCell(new Label(4, 0, "Solfati SO4--"));
                arSheet.addCell(new Label(5, 0, "Bicarbonato HCO3-"));
                arSheet.addCell(new Label(6, 0, "Cloruri Cl-"));

                for (int i = 0; i < AcqueRiferimento.size(); i++) {
                    AcquaRiferimento a = AcqueRiferimento.get(i);
                    Label nome = new Label(0, i + 1, a.getName());
                    Number calcio = new Number(1, i + 1, a.getCalcio());
                    Number magnesio = new Number(2, i + 1, a.getMagnesio());
                    Number sodio = new Number(3, i + 1, a.getSodio());
                    Number solfati = new Number(4, i + 1, a.getSolfato());
                    Number bicarbonati = new Number(5, i + 1, a.getBicarbonato());
                    Number cloruri = new Number(6, i + 1, a.getCloruro());

                    arSheet.addCell(nome);
                    arSheet.addCell(calcio);
                    arSheet.addCell(magnesio);
                    arSheet.addCell(sodio);
                    arSheet.addCell(solfati);
                    arSheet.addCell(bicarbonati);
                    arSheet.addCell(cloruri);
                }
            } catch (WriteException ex) {
                Logger.getLogger(TrattamentoAcqua.class.getName()).log(Level.SEVERE, null, ex);
            }

            database.write();
            database.close();
        } catch (IOException | WriteException ex) {
            Logger.getLogger(TrattamentoAcqua.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
