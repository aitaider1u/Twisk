package twisk.mondeIG;

import twisk.outils.CalculatriceDeFromuleGeometrique;
import twisk.outils.TailleComposants;
import java.util.ArrayList;

public abstract class ArcIG {
    protected String idfArcIG;
    protected ArrayList<PointDeControleIG> pointDeControleIGDeArc = new ArrayList<>();
    protected boolean estSelectionner = false;
    public ArcIG(String idfArcIG) {
        this.idfArcIG = idfArcIG;
    }

    public ArcIG() {
    }


    public PointDeControleIG getPointDepart() {
        return this.pointDeControleIGDeArc.get(0);
    }

    public PointDeControleIG getPointArrivee() {
        return this.pointDeControleIGDeArc.get(nbrPointDeControleIG()-1);
    }

    public PointDeControleIG getPointDeControleIGIndex(int index)
    {
        return this.pointDeControleIGDeArc.get(index);
    }

    abstract public int nbrPointDeControleIG();


    public String getIdfArcIG() {
        return idfArcIG;
    }
    public boolean estUneLigneDroiteIG()
    {
        return false;
    }

    public  Boolean estCourbeIG()
    {
        return false;
    }

    public Double[] pointTriangeDeFleche() {
        CalculatriceDeFromuleGeometrique calc = CalculatriceDeFromuleGeometrique.getInstance();
        TailleComposants tailleComposants = TailleComposants.getInstance();
        return calc.calcLesCordonneeDeLaFleche(getPointDeControleIGIndex(nbrPointDeControleIG()-2),getPointArrivee(),tailleComposants.getHauteurTriangleFleche(),tailleComposants.getLargeurTriangleFleche());

    }

    public Double[] poitCentreDuSegmentBasDuTriangle() { // 0 pour x , 1 pour y
        CalculatriceDeFromuleGeometrique calc = CalculatriceDeFromuleGeometrique.getInstance();
        TailleComposants taille = TailleComposants.getInstance();
        return calc.pointCentreDuSegmentBasDuTriangle(this.getPointDeControleIGIndex(nbrPointDeControleIG()-2),this.getPointArrivee(),taille.getHauteurTriangleFleche());
    }

    public boolean estSelectionner() {
        return estSelectionner;
    }

    public void setEstSelectionner(boolean estSelectionner) {
        this.estSelectionner = estSelectionner;
    }


    public void deplacerLePointDeDepartDeArc(PointDeControleIG pointDeControleIG)
    {
        this.getPointDepart().setPosCentreX(pointDeControleIG.getPosCentreX());
        this.getPointDepart().setPosCentreY(pointDeControleIG.getPosCentreY());
    }

    public void deplacerLePointDArriveeDeArc(PointDeControleIG pointDeControleIG)
    {
        this.getPointArrivee().setPosCentreX(pointDeControleIG.getPosCentreX());
        this.getPointArrivee().setPosCentreY(pointDeControleIG.getPosCentreY());
    }


}
