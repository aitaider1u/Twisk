package twisk.mondeIG.test;

import org.junit.jupiter.api.Test;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.*;
import twisk.outils.TailleComposants;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;



class MondeIGTest {

    @Test
    void ajouter() {
        MondeIG monde = new MondeIG();
        assertEquals(0,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(1,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 1").getIdentifiant(),"Etape 1");
        monde.ajouter("Activité");
        assertEquals(2,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 2").getIdentifiant(),"Etape 2");
        monde.ajouter("Activité");
        assertEquals(3,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 3").getIdentifiant(),"Etape 3");
        monde.ajouter("Activité");
        assertEquals(4,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 4").getIdentifiant(),"Etape 4");
        monde.ajouter("Activité");
        assertEquals(5,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 5").getIdentifiant(),"Etape 5");
        monde.ajouter("Activité");
        assertEquals(6,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 6").getIdentifiant(),"Etape 6");
        monde.ajouter("Activité");
        assertEquals(7,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 7").getIdentifiant(),"Etape 7");
        monde.ajouter("Activité");
        assertEquals(8,monde.nbrEtapeIG());
        assertEquals( monde.getEtapeIGKey("Etape 8").getIdentifiant(),"Etape 8");
    }

    @Test
    void iterator() {
        MondeIG monde = new MondeIG();
        Iterator<EtapeIG> ite = monde.iterator();
        assertFalse(ite.hasNext());
        monde.ajouter("Activité");
        ite = monde.iterator();
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getIdentifiant(), "Etape 1");
        assertFalse(ite.hasNext());
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        ite = monde.iterator();
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getIdentifiant(), "Etape 3");
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getIdentifiant(), "Etape 2");
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getIdentifiant(), "Etape 1");
        assertFalse(ite.hasNext());
    }


    @Test
    void nbrEtapeIG(){
        MondeIG monde = new MondeIG();
        assertEquals(0,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(1,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(2,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(3,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(4,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(5,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(6,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(7,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(8,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(9,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(10,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(11,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(12,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals(13,monde.nbrEtapeIG());

    }

    @Test
    void getEtapeIGKey() {
        MondeIG monde = new MondeIG();
        assertEquals(0,monde.nbrEtapeIG());
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 1").getIdentifiant(),"Etape 1");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 2").getIdentifiant(),"Etape 2");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 3").getIdentifiant(),"Etape 3");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 4").getIdentifiant(),"Etape 4");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 5").getIdentifiant(),"Etape 5");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 6").getIdentifiant(),"Etape 6");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 7").getIdentifiant(),"Etape 7");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 8").getIdentifiant(),"Etape 8");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 9").getIdentifiant(),"Etape 5");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 10").getIdentifiant(),"Etape 6");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 11").getIdentifiant(),"Etape 7");
        monde.ajouter("Activité");
        assertEquals( monde.getEtapeIGKey("Etape 12").getIdentifiant(),"Etape 8");
    }



    @Test
    void verifierSiLaArcExisteDeja(){

    }

    @Test
    void creerUnArc() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        assertEquals(0,monde.nbrArcCreer());
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcCreer());
        assertEquals(0,monde.nbrPointDeControleIGSSelectione());
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlDroite"));
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        assertEquals(2,monde.nbrArcCreer());
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlGauche"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlBas"));
        assertEquals(3,monde.nbrArcCreer());

    }


    @Test
    void estEtapesSontRelier() throws TwiskException {

        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");

        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        EtapeIG activite4 = monde.getEtapeIGIndice("Etape 4");

        assertEquals(0, monde.nbrArcCreer());
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlHaut"));
        assertEquals(1, monde.nbrArcCreer());
        assertTrue(monde.estEtapesSontRelier(activite1, activite2));
        assertFalse(monde.estEtapesSontRelier(activite1, activite3));
        assertFalse(monde.estEtapesSontRelier(activite1, activite4));
        assertFalse(monde.estEtapesSontRelier(activite2, activite3));
        assertFalse(monde.estEtapesSontRelier(activite2, activite4));
        assertFalse(monde.estEtapesSontRelier(activite3, activite4));

        assertEquals(0, monde.nbrPointDeControleIGSSelectione());
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlDroite"));
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        assertEquals(2, monde.nbrArcCreer());
        assertTrue(monde.estEtapesSontRelier(activite1, activite2));
        assertTrue(monde.estEtapesSontRelier(activite1, activite3));
        assertFalse(monde.estEtapesSontRelier(activite1, activite4));
        assertFalse(monde.estEtapesSontRelier(activite2, activite3));
        assertFalse(monde.estEtapesSontRelier(activite2, activite4));
        assertFalse(monde.estEtapesSontRelier(activite3, activite4));

        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlGauche"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlBas"));
        assertEquals(3, monde.nbrArcCreer());
        assertTrue(monde.estEtapesSontRelier(activite1, activite2));
        assertTrue(monde.estEtapesSontRelier(activite1, activite3));
        assertFalse(monde.estEtapesSontRelier(activite1, activite4));
        assertTrue(monde.estEtapesSontRelier(activite2, activite3));
        assertFalse(monde.estEtapesSontRelier(activite2, activite4));
        assertFalse(monde.estEtapesSontRelier(activite3, activite4));
    }

    @Test
    void iteratorArcs() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        Iterator<ArcIG> ite = monde.iteratorArcs();
        assertFalse(ite.hasNext());
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlHaut"));
        assertEquals(1, monde.nbrArcCreer());
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlDroite"));
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        assertEquals(2, monde.nbrArcCreer());
        ite = monde.iteratorArcs();
        assertTrue(ite.hasNext());
        assertEquals("Etape 1PointCtrlBasEtape 2PointCtrlHaut",ite.next().getIdfArcIG());
        assertTrue(ite.hasNext());
        assertEquals("Etape 3PointCtrlDroiteEtape 1PointCtrlBas",ite.next().getIdfArcIG());
        assertFalse(ite.hasNext());
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlGauche"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlBas"));
        ite = monde.iteratorArcs();
        assertTrue(ite.hasNext());
        assertEquals("Etape 1PointCtrlBasEtape 2PointCtrlHaut",ite.next().getIdfArcIG());
        assertTrue(ite.hasNext());
        assertEquals("Etape 2PointCtrlGaucheEtape 3PointCtrlBas",ite.next().getIdfArcIG());
        assertTrue(ite.hasNext());
        assertEquals("Etape 3PointCtrlDroiteEtape 1PointCtrlBas",ite.next().getIdfArcIG());
        assertFalse(ite.hasNext());
        monde.ajouter("Activité");
        EtapeIG activite4 = monde.getEtapeIGIndice("Etape 4");
        monde.ajouter(activite4.getPointDeControlIndice("Etape 4PointCtrlDroite"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlHaut"));
        ite = monde.iteratorArcs();
        assertTrue(ite.hasNext());
        ite.next();
        assertTrue(ite.hasNext());
        ite.next();
        assertTrue(ite.hasNext());
        ite.next();
        assertTrue(ite.hasNext());
        ite.next();
        assertFalse(ite.hasNext());

    }

    @Test
    void getEtapeIGIndice(){
        MondeIG mondeIG = new MondeIG();
        mondeIG.ajouter("Activité");
        mondeIG.ajouter("Activité");
        assertEquals("Etape 1",mondeIG.getEtapeIGIndice("Etape 1").getIdentifiant());
        assertEquals("Etape 2",mondeIG.getEtapeIGIndice("Etape 2").getIdentifiant());
        mondeIG.ajouter("Activité");
        mondeIG.ajouter("Activité");
        mondeIG.ajouter("Activité");
        assertEquals("Etape 3",mondeIG.getEtapeIGIndice("Etape 3").getIdentifiant());
        assertEquals("Etape 4",mondeIG.getEtapeIGIndice("Etape 4").getIdentifiant());
        assertEquals("Etape 5",mondeIG.getEtapeIGIndice("Etape 5").getIdentifiant());

    }

    @Test
    void estUnPointDeControleIGDuneEtape(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        assertTrue(monde.estUnPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlBas")));
        assertTrue(monde.estUnPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlHaut")));
        assertTrue(monde.estUnPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlGauche")));
        assertTrue(monde.estUnPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlDroite")));
        //assertTrue(monde.estUnPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlBas"))

    }


    @Test
    void sontLesDeuxPointDeControleIGDuneEtape()
    {

    MondeIG monde = new MondeIG();
    monde.ajouter("Activité");
    monde.ajouter("Activité");
    monde.ajouter("Activité");
    EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
    EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
    EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
    activite3.depalacerEtape(500,500);
    activite2.depalacerEtape(200,300);
    activite1.depalacerEtape(400,300);
    assertTrue(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlDroite"),monde.getEtapeIGIndice("Etape 2").getPointDeControlIndice("Etape 2PointCtrlDroite")));
    assertTrue(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 1").getPointDeControlIndice("Etape 1PointCtrlDroite"),monde.getEtapeIGIndice("Etape 2").getPointDeControlIndice("Etape 2PointCtrlDroite")));
    assertFalse(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 3").getPointDeControlIndice("Etape 3PointCtrlDroite"),new PointDeControleIG(10,10)));
    assertTrue(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 3").getPointDeControlIndice("Etape 3PointCtrlDroite"),new PointDeControleIG(500+TailleComposants.getInstance().getLargeurActivite(), 500+TailleComposants.getInstance().getHauteurActivite()/2)));
    assertTrue(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 2").getPointDeControlIndice("Etape 2PointCtrlHaut"),new PointDeControleIG(200+TailleComposants.getInstance().getLargeurActivite()/2, 300)));
    assertFalse(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 2").getPointDeControlIndice("Etape 2PointCtrlHaut"),new PointDeControleIG(600,200)));
    assertTrue(monde.sontLesDeuxPointDeControleIGDuneEtape(monde.getEtapeIGIndice("Etape 3").getPointDeControlIndice("Etape 3PointCtrlDroite"),monde.getEtapeIGIndice("Etape 2").getPointDeControlIndice("Etape 2PointCtrlDroite")));
    }

    @Test
    void identifiantPointDansEtape(){
         MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        activite3.depalacerEtape(500,500);
        activite2.depalacerEtape(200,300);
        activite1.depalacerEtape(400,300);
        assertEquals("Etape 3PointCtrlHaut",monde.identifiantPointDansEtape(new PointDeControleIG(500+TailleComposants.getInstance().getLargeurActivite()/2,500)));
        assertEquals("",monde.identifiantPointDansEtape(new PointDeControleIG(10+TailleComposants.getInstance().getLargeurActivite()/2,500)));
        assertEquals("Etape 3PointCtrlDroite",monde.identifiantPointDansEtape(new PointDeControleIG(500+TailleComposants.getInstance().getLargeurActivite(),500+TailleComposants.getInstance().getHauteurActivite()/2)));
        assertEquals("Etape 1PointCtrlBas",monde.identifiantPointDansEtape(new PointDeControleIG(400+TailleComposants.getInstance().getLargeurActivite()/2,300+TailleComposants.getInstance().getHauteurActivite())));
        assertEquals("",monde.identifiantPointDansEtape(new PointDeControleIG(2+TailleComposants.getInstance().getLargeurActivite()/2,600)));
        assertEquals("Etape 2PointCtrlDroite",monde.identifiantPointDansEtape(new PointDeControleIG(200+TailleComposants.getInstance().getLargeurActivite(),300+TailleComposants.getInstance().getHauteurActivite()/2)));

    }

    @Test
    void ajouterEtapeSectione() {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        assertEquals(1,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(2,monde.nbrEtapesSelectionee());
}

    @Test
    void enleverUneEtapeSelectione() {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        assertEquals(1,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(3,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(3,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 1"));
        assertEquals(1,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(0,monde.nbrEtapesSelectionee());
}

    @Test
    void supprimerLesEtapeSelectionerEtArcsAttaches() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");///1
        monde.ajouter("Activité");//2
        monde.ajouter("Activité");//3
        monde.ajouter("Activité");//4
        monde.ajouter("Activité");//5
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 4"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(4,monde.nbrEtapesSelectionee());
        assertEquals(5, monde.nbrEtapeIG());
        monde.supprimerLesEtapeSelectionerEtArcsAttaches();
        assertEquals(0,monde.nbrEtapesSelectionee());
        assertEquals(1, monde.nbrEtapeIG());
        monde.ajouter("Activité");//6
        monde.ajouter("Activité");//7

        assertEquals(0, monde.nbrArcCreer());
        monde.ajouter(monde.getEtapeIGIndice("Etape 5").getPointDeControlIndice("Etape 5PointCtrlBas"));
        monde.ajouter(monde.getEtapeIGIndice("Etape 6").getPointDeControlIndice("Etape 6PointCtrlHaut"));
        assertEquals(1, monde.nbrArcCreer());
        monde.ajouter(monde.getEtapeIGIndice("Etape 7").getPointDeControlIndice("Etape 7PointCtrlBas"));
        monde.ajouter(monde.getEtapeIGIndice("Etape 6").getPointDeControlIndice("Etape 6PointCtrlDroite"));
        assertEquals(2, monde.nbrArcCreer());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 5"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 6"));
        monde.supprimerLesEtapeSelectionerEtArcsAttaches();
        assertEquals(0, monde.nbrArcCreer());
        assertEquals(1, monde.nbrEtapeIG());
    }

    @Test
    void nbrEtapesSelectionee(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");///1
        monde.ajouter("Activité");//2
        monde.ajouter("Activité");//3
        monde.ajouter("Activité");//4
        monde.ajouter("Activité");//5
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        assertEquals(1,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 4"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(4,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 5"));
        assertEquals(5,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 5"));
        assertEquals(4,monde.nbrEtapesSelectionee());
        monde.enleverUneEtapeSelectione(monde.getEtapeIGIndice("Etape 3"));
        assertEquals(3,monde.nbrEtapesSelectionee());
    }

    @Test
    void iteratorEtapeSelectionnee(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");///1
        monde.ajouter("Activité");//2
        monde.ajouter("Activité");//3
        monde.ajouter("Activité");//4
        monde.ajouter("Activité");//5
        Iterator<EtapeIG> ite = monde.iteratorEtapeSelectionnee();
        assertFalse(ite.hasNext());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        ite = monde.iteratorEtapeSelectionnee();
        assertTrue(ite.hasNext());
        assertEquals("Etape 1",ite.next().getIdentifiant());
        assertFalse(ite.hasNext());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        ite = monde.iteratorEtapeSelectionnee();
        assertTrue(ite.hasNext());
        assertEquals("Etape 3",ite.next().getIdentifiant());
        assertTrue(ite.hasNext());
        assertEquals("Etape 1",ite.next().getIdentifiant());
        assertFalse(ite.hasNext());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        ite = monde.iteratorEtapeSelectionnee();
        assertTrue(ite.hasNext());
        assertEquals("Etape 3",ite.next().getIdentifiant());
        assertTrue(ite.hasNext());
        assertEquals("Etape 2",ite.next().getIdentifiant());
        assertTrue(ite.hasNext());
        assertEquals("Etape 1",ite.next().getIdentifiant());
        assertFalse(ite.hasNext());
    }

    @Test
    void renommerNomEtapeSelectioner()
    {
        MondeIG mondeIG = new MondeIG();
        mondeIG.ajouter("Activité");
        assertEquals("activite",mondeIG.getEtapeIGIndice("Etape 1").getNom());
        mondeIG.ajouterEtapeSectione(mondeIG.getEtapeIGIndice("Etape 1"));
        mondeIG.renommerNomEtapeSelectioner("hello");
        assertEquals("hello",mondeIG.getEtapeIGIndice("Etape 1").getNom());
        mondeIG.enleverUneEtapeSelectione(mondeIG.getEtapeIGIndice("Etape 1"));
        mondeIG.ajouter("Activité");
        mondeIG.ajouterEtapeSectione(mondeIG.getEtapeIGIndice("Etape 2"));
        assertEquals("activite",mondeIG.getEtapeIGIndice("Etape 2").getNom());
        mondeIG.renommerNomEtapeSelectioner("twisk");
        assertEquals("twisk",mondeIG.getEtapeIGIndice("Etape 2").getNom());
    }


    @Test
    void ajouterArcsSelectioner() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        assertEquals(0,monde.nbrArcCreer());
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcCreer());
        assertEquals(0,monde.nbrArcsSelectioner());
        monde.ajouterArcsSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcsSelectioner());
        assertEquals(0,monde.nbrPointDeControleIGSSelectione());
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlDroite"));
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        assertEquals(2,monde.nbrArcCreer());
        assertEquals(1,monde.nbrArcsSelectioner());
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlGauche"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlBas"));
        assertEquals(3,monde.nbrArcCreer());
        monde.ajouterArcsSelectioner(monde.getArcsIndex("Etape 2PointCtrlGaucheEtape 3PointCtrlBas"));
        assertEquals(2,monde.nbrArcsSelectioner());
    }

    @Test
    void enleverArcSelectioner() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        EtapeIG activite1 = monde.getEtapeIGIndice("Etape 1");
        EtapeIG activite2 = monde.getEtapeIGIndice("Etape 2");
        EtapeIG activite3 = monde.getEtapeIGIndice("Etape 3");
        assertEquals(0,monde.nbrArcCreer());
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcCreer());
        assertEquals(0,monde.nbrArcsSelectioner());
        monde.ajouterArcsSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcsSelectioner());
        assertEquals(0,monde.nbrPointDeControleIGSSelectione());
        monde.enleverArcSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(0,monde.nbrArcsSelectioner());
        assertEquals(1,monde.nbrArcCreer());

        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlDroite"));
        monde.ajouter(activite1.getPointDeControlIndice("Etape 1PointCtrlBas"));
        assertEquals(2,monde.nbrArcCreer());
        assertEquals(0,monde.nbrArcsSelectioner());
        monde.ajouter(activite2.getPointDeControlIndice("Etape 2PointCtrlGauche"));
        monde.ajouter(activite3.getPointDeControlIndice("Etape 3PointCtrlBas"));
        assertEquals(3,monde.nbrArcCreer());
        monde.ajouterArcsSelectioner(monde.getArcsIndex("Etape 2PointCtrlGaucheEtape 3PointCtrlBas"));
        monde.ajouterArcsSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(2,monde.nbrArcsSelectioner());
        monde.enleverArcSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcsSelectioner());
        monde.enleverArcSelectioner(monde.getArcsIndex("Etape 1PointCtrlBasEtape 2PointCtrlHaut"));
        assertEquals(1,monde.nbrArcsSelectioner());
        assertEquals(3,monde.nbrArcCreer());
        monde.enleverArcSelectioner(monde.getArcsIndex("Etape 2PointCtrlGaucheEtape 3PointCtrlBas"));
        assertEquals(0,monde.nbrArcsSelectioner());
        monde.enleverArcSelectioner(monde.getArcsIndex("Etape 2PointCtrlGaucheEtape 3PointCtrlBas"));
        assertEquals(0,monde.nbrArcsSelectioner());
    }


    @Test
    void ajouterCommeEntree(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.ajouterCommeEntree(monde.getEtapeIGIndice("Etape 1"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.ajouterCommeEntree(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
    }

    @Test
    void ajouterCommeSortie(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.ajouterCommeSortie(monde.getEtapeIGIndice("Etape 1"));
        monde.ajouterCommeSortie(monde.getEtapeIGIndice("Etape 1"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.ajouterCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.ajouterCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.ajouterCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
    }


    @Test
    void changerLesEntree(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.changerLesEntree();
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.ajouterCommeEntree(monde.getEtapeIGIndice("Etape 1"));
        monde.changerLesEntree();
        assertTrue(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.changerLesEntree();
        assertTrue(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 2"));
        assertEquals(2,monde.nbrEtapesSelectionee());
        monde.changerLesEntree();
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertTrue(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        assertEquals(0,monde.nbrEtapesSelectionee());
    }


    @Test
    void enleverCommeEntree(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.enleverCommeEntree(monde.getEtapeIGIndice("Etape 1"));
        monde.enleverCommeEntree(monde.getEtapeIGIndice("Etape 1"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
        monde.enleverCommeEntree(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneEntree());
    }

    @Test
    void enleverCommeSortie()
    {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneEntree());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.enleverCommeSortie(monde.getEtapeIGIndice("Etape 1"));
        monde.enleverCommeSortie(monde.getEtapeIGIndice("Etape 1"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.enleverCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.enleverCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
        monde.enleverCommeSortie(monde.getEtapeIGIndice("Etape 2"));
        assertFalse(monde.getEtapeIGIndice("Etape 1").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 2").estUneSortie());
        assertFalse(monde.getEtapeIGIndice("Etape 3").estUneSortie());
    }


    @Test
    void changerLeTempDeLetapeSelectione() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertEquals(4,monde.getEtapeIGIndice("Etape 1").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 2").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 3").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 4").getTemp());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.changerLeTempDeLetapeSelectione("6");
        assertEquals(6,monde.getEtapeIGIndice("Etape 1").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 2").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 3").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 4").getTemp());
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        monde.changerLeTempDeLetapeSelectione("10");
        assertEquals(6,monde.getEtapeIGIndice("Etape 1").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 2").getTemp());
        assertEquals(10,monde.getEtapeIGIndice("Etape 3").getTemp());
        assertEquals(4,monde.getEtapeIGIndice("Etape 4").getTemp());
        assertEquals(0,monde.nbrEtapesSelectionee());
    }

    @Test
    void changerLeDeltaTempDeLetapeSelectione() throws TwiskException {
        MondeIG monde = new MondeIG();
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        monde.ajouter("Activité");
        assertEquals(2,monde.getEtapeIGIndice("Etape 1").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 2").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 3").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 4").getDeltaTemp());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 1"));
        monde.changerLeDeltaTempDeLetapeSelectione("4");
        assertEquals(4,monde.getEtapeIGIndice("Etape 1").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 2").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 3").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 4").getDeltaTemp());
        assertEquals(0,monde.nbrEtapesSelectionee());
        monde.ajouterEtapeSectione(monde.getEtapeIGIndice("Etape 3"));
        monde.changerLeDeltaTempDeLetapeSelectione("10");
        assertEquals(4,monde.getEtapeIGIndice("Etape 1").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 2").getDeltaTemp());
        assertEquals(10,monde.getEtapeIGIndice("Etape 3").getDeltaTemp());
        assertEquals(2,monde.getEtapeIGIndice("Etape 4").getDeltaTemp());
        assertEquals(0,monde.nbrEtapesSelectionee());
    }

}