package it.dannyshanks.trattamentoacqua;

/**
 *
 * @author Danny
 */
public class AcquaCommerciale {

    private String name;
    private float calcio;
    private float magnesio;
    private float sodio;
    private float solfato;
    private float bicarbonato;
    private float nitrato;
    private float cloruro;

    public AcquaCommerciale(String name, float calcio, float magnesio, float sodio, float solfato, float bicarbonato, float nitrato, float cloruro) {
        this.name = name;
        this.calcio = calcio;
        this.magnesio = magnesio;
        this.sodio = sodio;
        this.solfato = solfato;
        this.bicarbonato = bicarbonato;
        this.nitrato = nitrato;
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

    public void setNitrato(float nitrato) {
        this.nitrato = nitrato;
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

    public float getNitrato() {
        return nitrato;
    }

    public float getCloruro() {
        return cloruro;
    }

    public boolean save() {
        System.out.print(name + calcio + magnesio + sodio + solfato
                + bicarbonato + nitrato + cloruro);

        return false;
    }

}
