package twisk.outils;

public class TailleComposants {
    private int largeurActivite ,hauteurActivite,hauteurTriangleFleche,largeurTriangleFleche,largeurVueArc;
    private double raduinPointDeControl;
    private static TailleComposants instance = new TailleComposants();

    private TailleComposants()
    {
        this.largeurActivite = 200;
        this.hauteurActivite = 90;
        this.raduinPointDeControl = 8;
        this.hauteurTriangleFleche=30;
        this.largeurTriangleFleche = 8;
        this.largeurVueArc = 4;
    }

    public int getLargeurActivite() {
        return largeurActivite;
    }

    public void setLargeurActivite(int largeurActivite) {
        this.largeurActivite = largeurActivite;
    }

    public int getHauteurActivite() {
        return hauteurActivite;
    }


    public void setHauteurActivite(int hauteurActivite) {
        this.hauteurActivite = hauteurActivite;
    }


    public static TailleComposants getInstance() {
        return instance;
    }

    public void setSizeActivite(int largeurActivite, int hauteurActivite)
    {
        this.setLargeurActivite(largeurActivite);
        this.setHauteurActivite(hauteurActivite);
    }

    public double getRaduinPointDeControl() {
        return raduinPointDeControl;
    }

    public void setRaduinPointDeControl(double raduinPointDeControl) {
        this.raduinPointDeControl = raduinPointDeControl;
    }

    public int getHauteurTriangleFleche() {
        return hauteurTriangleFleche;
    }
    public int getLargeurTriangleFleche() {
        return largeurTriangleFleche;
    }

    public int getLargeurVueArc() {
        return largeurVueArc;
    }

    public void setLargeurVueArc(int largeurVueArc) {
        this.largeurVueArc = largeurVueArc;
    }
}
