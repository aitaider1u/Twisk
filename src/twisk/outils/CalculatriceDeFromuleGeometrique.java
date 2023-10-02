package twisk.outils;


import twisk.mondeIG.PointDeControleIG;

public class CalculatriceDeFromuleGeometrique {
    private static CalculatriceDeFromuleGeometrique instance = new CalculatriceDeFromuleGeometrique();

    private CalculatriceDeFromuleGeometrique() { }

    public double calcLongeurLigne(double x1, double x2, double y1,double y2)
    {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }

    //algorithme trouver sur internet : http://xymaths.free.fr/Informatique-Programmation/javascript/canvas-dessin-fleche.php
    public Double[] calcLesCordonneeDeLaFleche(PointDeControleIG debut, PointDeControleIG arrivee, double HauteurTriangle, double LargeurTriangle)
    {
        Double tab[] = new Double[6];
        tab[0] = arrivee.getPosCentreX();
        tab[1] = arrivee.getPosCentreY();
        double debutX = debut.getPosCentreX();
        double debutY = debut.getPosCentreY();

        double p1x,p1y;
        p1x= arrivee.getPosCentreX() + HauteurTriangle*(debutX-arrivee.getPosCentreX())/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());
        p1y= arrivee.getPosCentreY() + HauteurTriangle*(debutY-arrivee.getPosCentreY())/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());

        double p2x,p2y;
        tab[2]=p1x+LargeurTriangle*(-(arrivee.getPosCentreY()-debutY))/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());
        tab[3]=p1y+LargeurTriangle*((arrivee.getPosCentreX()-debutX))/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());

        double p3x,p3y;
        tab[4]= p1x-LargeurTriangle*(-(arrivee.getPosCentreY()-debutY))/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());
        tab[5] = p1y-LargeurTriangle*((arrivee.getPosCentreX()-debutX))/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());

        return tab;
    }

    public Double[] pointCentreDuSegmentBasDuTriangle(PointDeControleIG debut, PointDeControleIG arrivee, double HauteurTriangle)
    {
        Double tab[] = new Double[2];
        double debutX = debut.getPosCentreX();
        double debutY = debut.getPosCentreY();
        tab[0]= arrivee.getPosCentreX() + HauteurTriangle*(debutX-arrivee.getPosCentreX())/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());
        tab[1]= arrivee.getPosCentreY() + HauteurTriangle*(debutY-arrivee.getPosCentreY())/calcLongeurLigne(debutX,arrivee.getPosCentreX(),debutY,arrivee.getPosCentreY());
        return tab;
    }



    public static CalculatriceDeFromuleGeometrique getInstance() {
        return instance;
    }
}
