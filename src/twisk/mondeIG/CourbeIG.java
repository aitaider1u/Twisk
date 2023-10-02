package twisk.mondeIG;

import java.util.ArrayList;


public class CourbeIG extends ArcIG {

    public CourbeIG(String idfArcIG, ArrayList<PointDeControleIG> point){
        super(idfArcIG);
        this.ajouter(point);
    }

    public void ajouter(ArrayList<PointDeControleIG> point)
    {
        this.pointDeControleIGDeArc.addAll(point);
    }

    @Override
    public int nbrPointDeControleIG() {
        return 4;
    }

    @Override
    public Boolean estCourbeIG() {
        return true;
    }
}
