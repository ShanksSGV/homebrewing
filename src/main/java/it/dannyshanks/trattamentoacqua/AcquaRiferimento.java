package it.dannyshanks.trattamentoacqua;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Danny
 */
public class AcquaRiferimento {

    private String name;
    private float calcio;
    private float magnesio;
    private float sodio;
    private float solfato;
    private float bicarbonato;
    private float cloruro;

    public AcquaRiferimento(String name, float calcio, float magnesio, float sodio, float solfato, float bicarbonato, float cloruro) {
        this.name = name;
        this.calcio = calcio;
        this.magnesio = magnesio;
        this.sodio = sodio;
        this.solfato = solfato;
        this.bicarbonato = bicarbonato;
        this.cloruro = cloruro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalcio(float calcio) {
        this.calcio = calcio;
    }

    public void setMagnesio(float magnesio) {
        this.magnesio = magnesio;
    }

    public void setSodio(float sodio) {
        this.sodio = sodio;
    }

    public void setSolfato(float solfato) {
        this.solfato = solfato;
    }

    public void setBicarbonato(float bicarbonato) {
        this.bicarbonato = bicarbonato;
    }

    public void setCloruro(float cloruro) {
        this.cloruro = cloruro;
    }

    public String getName() {
        return name;
    }

    public float getCalcio() {
        return calcio;
    }

    public float getMagnesio() {
        return magnesio;
    }

    public float getSodio() {
        return sodio;
    }

    public float getSolfato() {
        return solfato;
    }

    public float getBicarbonato() {
        return bicarbonato;
    }


    public float getCloruro() {
        return cloruro;
    }

    public boolean save() {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("database.xls"));
            WritableSheet sheet = workbook.createSheet("Acque Riferimento", 1);

            Label label = new Label(0, 3, "Stringa prova");
            sheet.addCell(label);

            workbook.write();
            workbook.close();
            return true;

        } catch (IOException | WriteException ex) {
            Logger.getLogger(AcquaCommerciale.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

}
