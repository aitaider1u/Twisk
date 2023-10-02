package twisk.mondeIG.test;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.*;
import twisk.outils.TailleComposants;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class EtapeIGTest {


    @Test
    void iterator() {
        EtapeIG etapeIG = new ActiviteIG("hello","activite1",100,200,180,90);
        Iterator<PointDeControleIG> ite = etapeIG.iterator();
        assertTrue(ite.hasNext());
        PointDeControleIG point = ite.next();
        assertTrue(ite.hasNext());
        point = ite.next();
        assertTrue(ite.hasNext());
        point = ite.next();
        assertTrue(ite.hasNext());
        point = ite.next();
        assertFalse(ite.hasNext());
    }


    @Test
    void getPointDeControlIndice() {
        EtapeIG etapeIG = new ActiviteIG("hello","activite1",100,200,180,90);
        PointDeControleIG point = etapeIG.getPointDeControlIndice("activite1PointCtrlBas");
        assertEquals(190,point.getPosCentreX());
        assertEquals(290,point.getPosCentreY());
        assertEquals("activite1PointCtrlBas",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlGauche");
        assertEquals(100,point.getPosCentreX());
        assertEquals(245,point.getPosCentreY());
        assertEquals("activite1PointCtrlGauche",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlHaut");
        assertEquals(190,point.getPosCentreX());
        assertEquals(200,point.getPosCentreY());
        assertEquals("activite1PointCtrlHaut",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlDroite");
        assertEquals(280,point.getPosCentreX());
        assertEquals(245,point.getPosCentreY());
        assertEquals("activite1PointCtrlDroite",point.getIdfPointCrl());

        etapeIG = new ActiviteIG("hello","activite1",500,500,50,50);
        point = etapeIG.getPointDeControlIndice("activite1PointCtrlBas");
        assertEquals(525,point.getPosCentreX());
        assertEquals(550,point.getPosCentreY());
        assertEquals("activite1PointCtrlBas",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlGauche");
        assertEquals(500,point.getPosCentreX());
        assertEquals(525,point.getPosCentreY());
        assertEquals("activite1PointCtrlGauche",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlHaut");
        assertEquals(525,point.getPosCentreX());
        assertEquals(500,point.getPosCentreY());
        assertEquals("activite1PointCtrlHaut",point.getIdfPointCrl());

        point = etapeIG.getPointDeControlIndice("activite1PointCtrlDroite");
        assertEquals(550,point.getPosCentreX());
        assertEquals(525,point.getPosCentreY());
        assertEquals("activite1PointCtrlDroite",point.getIdfPointCrl());

    }


    @Test
    void definirPointDeControls() {
    EtapeIG activite = new ActiviteIG("activité","Etape 1",200,200,50,50);
    activite.definirPointDeControls();
    TailleComposants taille = TailleComposants.getInstance();
    Iterator<PointDeControleIG> ite = activite.iterator();
    assertTrue(ite.hasNext());
    PointDeControleIG point = ite.next();
    assertEquals("Etape 1PointCtrlGauche",point.getIdfPointCrl());
    assertEquals(200,point.getPosCentreX());
    assertEquals(200+taille.getHauteurActivite()/2,point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlBas",point.getIdfPointCrl());
    assertEquals(200+taille.getLargeurActivite()/2,point.getPosCentreX());
    assertEquals(200+taille.getHauteurActivite(),point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlHaut",point.getIdfPointCrl());
    assertEquals(200+taille.getLargeurActivite()/2,point.getPosCentreX());
    assertEquals(200,point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlDroite",point.getIdfPointCrl());
    assertEquals(200+taille.getLargeurActivite(),point.getPosCentreX());
    assertEquals(200+taille.getHauteurActivite()/2,point.getPosCentreY());

    activite = new ActiviteIG("activité","Etape 1",1000,500,50,50);
    activite.definirPointDeControls();
    ite = activite.iterator();
    assertTrue(ite.hasNext());
    point = ite.next();
    assertEquals("Etape 1PointCtrlGauche",point.getIdfPointCrl());
    assertEquals(1000,point.getPosCentreX());
    assertEquals(500+taille.getHauteurActivite()/2,point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlBas",point.getIdfPointCrl());
    assertEquals(1000+taille.getLargeurActivite()/2,point.getPosCentreX());
    assertEquals(500+taille.getHauteurActivite(),point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlHaut",point.getIdfPointCrl());
    assertEquals(1000+taille.getLargeurActivite()/2,point.getPosCentreX());
    assertEquals(500,point.getPosCentreY());
    point = ite.next();
    assertEquals("Etape 1PointCtrlDroite",point.getIdfPointCrl());
    assertEquals(1000+taille.getLargeurActivite(),point.getPosCentreX());
    assertEquals(500+taille.getHauteurActivite()/2,point.getPosCentreY());
    }

    @Test
    void testIterator(){
        EtapeIG activite = new ActiviteIG("activité","Etape 1",200,200,50,50);
        Iterator<PointDeControleIG> point = activite.iterator();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertFalse(point.hasNext());

        activite = new ActiviteIG("activité","Etape 1",10,1000,100,100);
        point = activite.iterator();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertTrue(point.hasNext());
        point.next();
        assertFalse(point.hasNext());
    }

    @Test
    void testGetPointDeControlIndice()
    {
        EtapeIG activite = new ActiviteIG("activité","Etape",330,300,50,50);
        TailleComposants taille = TailleComposants.getInstance();
        PointDeControleIG point = activite.getPointDeControlIndice("EtapePointCtrlDroite");
        assertEquals(330+taille.getLargeurActivite(),point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite()/2,point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlHaut");
        assertEquals(330+taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(300,point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlBas");
        assertEquals(330+taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite(),point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlDroite");
        assertEquals(330+taille.getLargeurActivite(),point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite()/2,point.getPosCentreY());


        activite = new ActiviteIG("activité","Etape",330,300,50,50);
        point = activite.getPointDeControlIndice("EtapePointCtrlDroite");
        assertEquals(330+taille.getLargeurActivite(),point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite()/2,point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlHaut");
        assertEquals(330+taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(300,point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlBas");
        assertEquals(330+taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite(),point.getPosCentreY());

        point = activite.getPointDeControlIndice("EtapePointCtrlDroite");
        assertEquals(330+taille.getLargeurActivite(),point.getPosCentreX());
        assertEquals(300+taille.getHauteurActivite()/2,point.getPosCentreY());
    }



    @Test
    void depalacerEtape()
    {
        EtapeIG activite = new ActiviteIG("activité","Etape",330,300,50,50);
        assertEquals(330,activite.getPosX());
        assertEquals(300,activite.getPosY());

        activite.depalacerEtape(267,898);
        assertEquals(267,activite.getPosX());
        assertEquals(898,activite.getPosY());

        activite = new ActiviteIG("activité","Etape",0,0,50,50);
        assertEquals(0,activite.getPosX());
        assertEquals(0,activite.getPosY());

        activite.depalacerEtape(0,0);
        assertEquals(0,activite.getPosX());
        assertEquals(0,activite.getPosY());

        activite = new ActiviteIG("activité","Etape",10,100,50,50);
        assertEquals(10,activite.getPosX());
        assertEquals(100,activite.getPosY());

        activite.depalacerEtape(0,0);
        assertEquals(0,activite.getPosX());
        assertEquals(0,activite.getPosY());

        activite = new ActiviteIG("activité","Etape",10,100,50,50);
        assertEquals(10,activite.getPosX());
        assertEquals(100,activite.getPosY());
        activite.depalacerEtape(99,100);
        assertEquals(99,activite.getPosX());
        assertEquals(100,activite.getPosY());

    }

    @Test
    void estArcsRelierAEtape(){
        EtapeIG activite = new ActiviteIG("activité","Etape1",330,300,50,50);
        ArcIG arcIG = new LigneDroiteIG("Etape1",new PointDeControleIG(10,10),new PointDeControleIG(19,10));
        assertFalse(activite.estArcsRelierAEtape(arcIG));


        activite = new ActiviteIG("activité","Etape1",330,300,50,50);
        arcIG = new LigneDroiteIG("Etape1",new PointDeControleIG("hello1",activite,10,10),new PointDeControleIG("hello2",activite,19,10));
        assertFalse(activite.estArcsRelierAEtape(arcIG));

    }

    @Test
    void pointDeControleDEtapeRelierAArc()
    {
        TailleComposants taille = TailleComposants.getInstance();
        EtapeIG activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        EtapeIG activite2 = new ActiviteIG("activité","Etape2",330,300,50,50);
        PointDeControleIG p1 = new PointDeControleIG("Etape1hello",activite1,10,10);
        PointDeControleIG p2 = new PointDeControleIG("Etape2hello1",activite2,10,10);
        ArcIG arcIG = new LigneDroiteIG("Etape1helloEtape2hello1",p1,p2);
        assertNull(activite1.pointDeControleDEtapeRelierAArc(arcIG));
        assertNull(activite2.pointDeControleDEtapeRelierAArc(arcIG));
        //System.out.println(point.getIdfPointCrl());

        activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        activite2 = new ActiviteIG("activité","Etape2",500,800,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlBas"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlHaut"));
        PointDeControleIG point = activite1.pointDeControleDEtapeRelierAArc(arcIG);
        assertEquals("Etape1PointCtrlBas",point.getIdfPointCrl());
        assertEquals(330+ taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(300+ taille.getHauteurActivite(),point.getPosCentreY());
        point = activite2.pointDeControleDEtapeRelierAArc(arcIG);
        assertEquals("Etape2PointCtrlHaut",point.getIdfPointCrl());
        assertEquals(500+ taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(800,point.getPosCentreY());


        activite1 = new ActiviteIG("activité","activite1",200,258,50,50);
        activite2 = new ActiviteIG("activité","activite2",759,850,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlDroite"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlBas"));
        point = activite1.pointDeControleDEtapeRelierAArc(arcIG);
        assertEquals("activite1PointCtrlDroite",point.getIdfPointCrl());
        assertEquals(200+ taille.getLargeurActivite(),point.getPosCentreX());
        assertEquals(258+ taille.getHauteurActivite()/2,point.getPosCentreY());
        point = activite2.pointDeControleDEtapeRelierAArc(arcIG);
        assertEquals("activite2PointCtrlBas",point.getIdfPointCrl());
        assertEquals(759+ taille.getLargeurActivite()/2,point.getPosCentreX());
        assertEquals(850+taille.getHauteurActivite(),point.getPosCentreY());
    }

    @Test
    void estArcsRelierAEtapeAvecLePointDepard()
    {
        EtapeIG activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        EtapeIG activite2 = new ActiviteIG("activité","Etape2",330,300,50,50);
        PointDeControleIG p1 = new PointDeControleIG("Etape1hello",activite1,10,10);
        PointDeControleIG p2 = new PointDeControleIG("Etape2hello1",activite2,10,10);
        ArcIG arcIG = new LigneDroiteIG("Etape1helloEtape2hello1",p1,p2);
        assertFalse(activite1.estArcsRelierAEtapeAvecLePointDepard(arcIG));
        assertFalse(activite2.estArcsRelierAEtapeAvecLePointDepard(arcIG));

        activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        activite2 = new ActiviteIG("activité","Etape2",500,800,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlBas"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlHaut"));
        assertTrue(activite1.estArcsRelierAEtapeAvecLePointDepard(arcIG));
        assertFalse(activite2.estArcsRelierAEtapeAvecLePointDepard(arcIG));

        activite1 = new ActiviteIG("activité","activite1",200,258,50,50);
        activite2 = new ActiviteIG("activité","activite2",759,850,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlDroite"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlBas"));
        assertTrue(activite1.estArcsRelierAEtapeAvecLePointDepard(arcIG));
        assertFalse(activite2.estArcsRelierAEtapeAvecLePointDepard(arcIG));

    }

    @Test
    void estArcsRelierAEtapeAvecLePointArrivee()
    {
        EtapeIG activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        EtapeIG activite2 = new ActiviteIG("activité","Etape2",330,300,50,50);
        PointDeControleIG p1 = new PointDeControleIG("Etape1hello",activite1,10,10);
        PointDeControleIG p2 = new PointDeControleIG("Etape2hello1",activite2,10,10);
        ArcIG arcIG = new LigneDroiteIG("Etape1helloEtape2hello1",p1,p2);
        assertFalse(activite1.estArcsRelierAEtapeAvecLePointArrivee(arcIG));
        assertFalse(activite2.estArcsRelierAEtapeAvecLePointArrivee(arcIG));

        activite1 = new ActiviteIG("activité","Etape1",330,300,50,50);
        activite2 = new ActiviteIG("activité","Etape2",500,800,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlBas"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlHaut"));
        assertFalse(activite1.estArcsRelierAEtapeAvecLePointArrivee(arcIG));
        assertTrue(activite2.estArcsRelierAEtapeAvecLePointArrivee(arcIG));

        activite1 = new ActiviteIG("activité","activite1",200,258,50,50);
        activite2 = new ActiviteIG("activité","activite2",759,850,50,50);
        arcIG = new LigneDroiteIG(activite1.getPointDeControlIndice(activite1.getIdentifiant()+"PointCtrlDroite"),activite2.getPointDeControlIndice(activite2.getIdentifiant()+"PointCtrlBas"));
        assertFalse(activite1.estArcsRelierAEtapeAvecLePointArrivee(arcIG));
        assertTrue(activite2.estArcsRelierAEtapeAvecLePointArrivee(arcIG));
    }

}