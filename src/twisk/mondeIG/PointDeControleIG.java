package twisk.mondeIG;
import twisk.outils.CalculatriceDeFromuleGeometrique;
import twisk.outils.TailleComposants;

public class PointDeControleIG  {
    private double posCentreX;
    private double posCentreY;
    private String idfPointCrl;
    private EtapeIG etapeIG;

    public PointDeControleIG(String idfPointCr,EtapeIG etapeIG,int posCentreX, int posCentreY) {
        this.posCentreX = posCentreX;
        this.posCentreY = posCentreY;
        this.idfPointCrl = idfPointCr;
        this.etapeIG = etapeIG;
    }
    public PointDeControleIG(double posCentreX, double posCentreY) {
        this.posCentreX = posCentreX;
        this.posCentreY = posCentreY;
    }

    public double getPosCentreX() {
        return posCentreX;
    }

    public double getPosCentreY() {
        return posCentreY;
    }

    public EtapeIG getEtapeIG() {
        return etapeIG;
    }

    public String getIdfPointCrl() {
        return idfPointCrl;
    }

    public void setEtapeIG(EtapeIG etapeIG) {
        this.etapeIG = etapeIG;
    }

    public void setPosCentreX(double posCentreX) {
        this.posCentreX = posCentreX;
    }

    public void setPosCentreY(double posCentreY) {
        this.posCentreY = posCentreY;
    }

    public void setIdfPointCrl(String idfPointCrl) {
        this.idfPointCrl = idfPointCrl;
    }
}
