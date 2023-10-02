package twisk.mondeIG.test;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class ArcIGTest {

    @Test
    void getPointDepart() {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(10,20),new PointDeControleIG(5,5));
        PointDeControleIG point = ligne.getPointDepart();
        assertEquals(10,point.getPosCentreX());
        assertEquals(20,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(5,5));
        point = ligne.getPointDepart();
        assertEquals(0,point.getPosCentreX());
        assertEquals(0,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,111),new PointDeControleIG(5,5));
        point = ligne.getPointDepart();
        assertEquals(100,point.getPosCentreX());
        assertEquals(111,point.getPosCentreY());
        ArrayList<PointDeControleIG> points= new ArrayList<>();

        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertEquals(10,courbe.getPointDepart().getPosCentreX());
        assertEquals(10,courbe.getPointDepart().getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(230,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(0,courbe.getPointDepart().getPosCentreX());
        assertEquals(1000,courbe.getPointDepart().getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(99,courbe.getPointDepart().getPosCentreX());
        assertEquals(100,courbe.getPointDepart().getPosCentreY());
    }

    @Test
    void getPointArrivee()
    {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(10,20),new PointDeControleIG(5,5));
        PointDeControleIG point = ligne.getPointArrivee();
        assertEquals(5,point.getPosCentreX());
        assertEquals(5,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(123,45));
        point = ligne.getPointArrivee();
        assertEquals(123,point.getPosCentreX());
        assertEquals(45,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,111),new PointDeControleIG(0,100));
        point = ligne.getPointArrivee();
        assertEquals(0,point.getPosCentreX());
        assertEquals(100,point.getPosCentreY());
        ArrayList<PointDeControleIG> points= new ArrayList<>();

        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertEquals(230,courbe.getPointArrivee().getPosCentreX());
        assertEquals(110,courbe.getPointArrivee().getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(30,courbe.getPointArrivee().getPosCentreX());
        assertEquals(2210,courbe.getPointArrivee().getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(2300,courbe.getPointArrivee().getPosCentreX());
        assertEquals(2210,courbe.getPointArrivee().getPosCentreY());
    }

    @Test
    void getPointDeControleIGIndex()
    {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(10,20),new PointDeControleIG(5,5));
        PointDeControleIG point = ligne.getPointDeControleIGIndex(1);
        assertEquals(5,point.getPosCentreX());
        assertEquals(5,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(123,45));
        point = ligne.getPointDeControleIGIndex(0);
        assertEquals(0,point.getPosCentreX());
        assertEquals(0,point.getPosCentreY());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,111),new PointDeControleIG(0,100));
        point = ligne.getPointDeControleIGIndex(0);
        assertEquals(100,point.getPosCentreX());
        assertEquals(111,point.getPosCentreY());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertEquals(60,courbe.getPointDeControleIGIndex(2).getPosCentreX());
        assertEquals(110,courbe.getPointDeControleIGIndex(2).getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(20,courbe.getPointDeControleIGIndex(1).getPosCentreX());
        assertEquals(110,courbe.getPointDeControleIGIndex(1).getPosCentreY());
        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(2300,courbe.getPointDeControleIGIndex(3).getPosCentreX());
        assertEquals(2210,courbe.getPointDeControleIGIndex(3).getPosCentreY());
    }

    @Test
    void nbrPointDeControleIG() {
         ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(10,20),new PointDeControleIG(5,5));
        assertEquals(2,ligne.nbrPointDeControleIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(123,45));
        assertEquals(2,ligne.nbrPointDeControleIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,111),new PointDeControleIG(0,100));
        assertEquals(2,ligne.nbrPointDeControleIG());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertEquals(4,courbe.nbrPointDeControleIG());

        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(4,courbe.nbrPointDeControleIG());

        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertEquals(4,courbe.nbrPointDeControleIG());


    }


    @Test
    void estUneLigneDroiteIG()
    {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(30,3),new PointDeControleIG(5,38));
        assertTrue(ligne.estUneLigneDroiteIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(8,38));
        assertTrue(ligne.estUneLigneDroiteIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,110),new PointDeControleIG(150,180));
        assertTrue(ligne.estUneLigneDroiteIG());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertFalse(courbe.estUneLigneDroiteIG());
        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        assertFalse(courbe.estUneLigneDroiteIG());

        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertFalse(courbe.estUneLigneDroiteIG());


    }

    @Test
    void estCourbeIG()
    {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(30,3),new PointDeControleIG(5,38));
        assertFalse(ligne.estCourbeIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(8,38));
        assertFalse(ligne.estCourbeIG());
        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,110),new PointDeControleIG(150,180));
        assertFalse(ligne.estCourbeIG());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        assertTrue(courbe.estCourbeIG());
        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        assertTrue(courbe.estCourbeIG());

        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        assertTrue(courbe.estCourbeIG());
    }


    @Test
    void deplacerLePointDeDepartDeArc() {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(30,3),new PointDeControleIG(5,38));
        ligne.deplacerLePointDeDepartDeArc(new PointDeControleIG(20,20));
        assertEquals(20,ligne.getPointDepart().getPosCentreX());
        assertEquals(20,ligne.getPointDepart().getPosCentreY());

        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(8,38));
        ligne.deplacerLePointDeDepartDeArc(new PointDeControleIG(100,150));
        assertEquals(100,ligne.getPointDepart().getPosCentreX());
        assertEquals(150,ligne.getPointDepart().getPosCentreY());

        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,110),new PointDeControleIG(150,180));
        ligne.deplacerLePointDeDepartDeArc(new PointDeControleIG(1000,750));
        assertEquals(1000,ligne.getPointDepart().getPosCentreX());
        assertEquals(750,ligne.getPointDepart().getPosCentreY());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDeDepartDeArc(new PointDeControleIG(100,75));
        assertEquals(100,courbe.getPointDepart().getPosCentreX());
        assertEquals(75,courbe.getPointDepart().getPosCentreY());

        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDeDepartDeArc(new PointDeControleIG(0,1000));
        assertEquals(0,courbe.getPointDepart().getPosCentreX());
        assertEquals(1000,courbe.getPointDepart().getPosCentreY());

        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDeDepartDeArc(new PointDeControleIG(500,360));
        assertEquals(500,courbe.getPointDepart().getPosCentreX());
        assertEquals(360,courbe.getPointDepart().getPosCentreY());
    }

    @Test
    void deplacerLePointDArriveeDeArc() {
        ArcIG ligne = new LigneDroiteIG("ligne",new PointDeControleIG(30,3),new PointDeControleIG(5,38));
        ligne.deplacerLePointDArriveeDeArc(new PointDeControleIG(20,20));
        assertEquals(20,ligne.getPointArrivee().getPosCentreX());
        assertEquals(20,ligne.getPointArrivee().getPosCentreY());

        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(0,0),new PointDeControleIG(8,38));
        ligne.deplacerLePointDArriveeDeArc(new PointDeControleIG(100,150));
        assertEquals(100,ligne.getPointArrivee().getPosCentreX());
        assertEquals(150,ligne.getPointArrivee().getPosCentreY());

        ligne = new LigneDroiteIG("ligne",new PointDeControleIG(100,110),new PointDeControleIG(150,180));
        ligne.deplacerLePointDArriveeDeArc(new PointDeControleIG(1000,750));
        assertEquals(1000,ligne.getPointArrivee().getPosCentreX());
        assertEquals(750,ligne.getPointArrivee().getPosCentreY());

        ArrayList<PointDeControleIG> points= new ArrayList<>();
        points.add(new PointDeControleIG(10,10));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(60,110));
        points.add(new PointDeControleIG(230,110));
        ArcIG courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDArriveeDeArc(new PointDeControleIG(100,75));
        assertEquals(100,courbe.getPointArrivee().getPosCentreX());
        assertEquals(75,courbe.getPointArrivee().getPosCentreY());

        points.clear();
        points.add(new PointDeControleIG(0,1000));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(30,2210));
        courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDArriveeDeArc(new PointDeControleIG(0,1000));
        assertEquals(0,courbe.getPointArrivee().getPosCentreX());
        assertEquals(1000,courbe.getPointArrivee().getPosCentreY());

        points.clear();
        points.add(new PointDeControleIG(99,100));
        points.add(new PointDeControleIG(20,110));
        points.add(new PointDeControleIG(230,320));
        points.add(new PointDeControleIG(2300,2210));
        courbe = new CourbeIG("ligne",points);
        courbe.deplacerLePointDArriveeDeArc(new PointDeControleIG(500,360));
        assertEquals(500,courbe.getPointArrivee().getPosCentreX());
        assertEquals(360,courbe.getPointArrivee().getPosCentreY());

    }
}