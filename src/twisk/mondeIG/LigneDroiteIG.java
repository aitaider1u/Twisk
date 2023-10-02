package twisk.mondeIG;


public class LigneDroiteIG extends ArcIG {

    public LigneDroiteIG(String idfArcIG, PointDeControleIG point1, PointDeControleIG point2) {
        super(idfArcIG);
        this.pointDeControleIGDeArc.add(point1);
        this.pointDeControleIGDeArc.add(point2);
    }

    public LigneDroiteIG( PointDeControleIG point1, PointDeControleIG point2) {
        this.idfArcIG = point1.getIdfPointCrl()+point2.getIdfPointCrl();
        this.pointDeControleIGDeArc.add(point1);
        this.pointDeControleIGDeArc.add(point2);
    }


    @Override
    public int nbrPointDeControleIG() {
        return 2;
    }

    @Override
    public boolean estUneLigneDroiteIG() {
        return true;
    }

}
