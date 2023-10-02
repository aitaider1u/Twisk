package twisk.monde.test;

import org.junit.jupiter.api.Test;
import twisk.monde.*;
import twisk.outils.FabriqueNumero;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe Test de la classe Etape
 */
class EtapeTest {
    /**
     * Test de la methode comptant le nombre de successeurs d'une etape
     */
    @Test
    void nbSuccesseurs()
    {
        FabriqueNumero num = FabriqueNumero.getInstance();
        Etape etape = new Activite("a");
        assertEquals(etape.nbSuccesseurs(),0);
        assertEquals(0,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        etape.ajouterSuccesseur(new Activite("ab",10,20));
        assertEquals(1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),1);
        etape.ajouterSuccesseur(new Activite("ab1",1,2),new Activite("ab2"),new Activite("ab3"));
        assertEquals(4,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),4);
        etape.ajouterSuccesseur(new Activite("c",1,2),new Activite("d"),new Activite("e"),new Activite("f",1,2),new Activite("j"),new Activite("k"));
        assertEquals(10,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),10);
        num.reset();
        assertEquals(-1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());

        etape = new Guichet("a");
        assertEquals(0,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("b"));
        assertEquals(1,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),1);
        etape.ajouterSuccesseur(new Activite("ab2"),new Activite("ab3"));
        assertEquals(3,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),3);
        etape.ajouterSuccesseur(new Activite("c",1,2),new Activite("f",1,2),new Activite("j"),new Activite("k"));
        assertEquals(7,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),7);

        num.reset();
        assertEquals(-1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());

        etape = new SasEntree();
        assertEquals(0,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("A"), new Guichet("g"));
        assertEquals(2,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),2);
        etape.ajouterSuccesseur(new Activite("b"), new Guichet("c"),new Activite("d"));
        assertEquals(5,num.getCptEtape());
        assertEquals(2,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),5);
        etape.ajouterSuccesseur(new Guichet("e"), new Guichet("f"),new Guichet("g"));
        assertEquals(8,num.getCptEtape());
        assertEquals(5,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),8);
        etape.ajouterSuccesseur(new SasEntree("g"));
        assertEquals(9,num.getCptEtape());
        assertEquals(5,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),9);

        num.reset();
        assertEquals(-1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());

        etape = new SasSortie();
        assertEquals(etape.nbSuccesseurs(),0);
        assertEquals(0,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        etape.ajouterSuccesseur(new Activite("a"), new Guichet("b"));
        assertEquals(2,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),2);
        etape.ajouterSuccesseur(new Activite("c"),new Activite("d"));
        assertEquals(4,num.getCptEtape());
        assertEquals(1,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),4);
        etape.ajouterSuccesseur(new Activite("e"), new Guichet("f"),new Activite("g"));
        assertEquals(7,num.getCptEtape());
        assertEquals(2,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),7);
        etape.ajouterSuccesseur(new Guichet("e"), new Guichet("f"),new Guichet("g"));
        assertEquals(10,num.getCptEtape());
        assertEquals(5,num.getCptSemaphore());
        assertEquals(etape.nbSuccesseurs(),10);

        Etape etape2 = new ActiviteRestreinte("a");
        assertEquals(11,num.getCptEtape());
        assertEquals(5,num.getCptSemaphore());
        assertEquals(etape2.nbSuccesseurs(),0);
        etape2.ajouterSuccesseur(new Activite("a"), new Guichet("b"),new Activite("c",5,2));
        assertEquals(14,num.getCptEtape());
        assertEquals(6,num.getCptSemaphore());
        assertEquals(etape2.nbSuccesseurs(),3);
        etape2.ajouterSuccesseur(new Guichet("d"),new Activite("e"), new Guichet("f"),new Activite("g"));
        assertEquals(18,num.getCptEtape());
        assertEquals(8,num.getCptSemaphore());
        assertEquals(etape2.nbSuccesseurs(),7);
        etape2.ajouterSuccesseur(new Guichet("h"),new Activite("i"), new Guichet("j"));
        assertEquals(etape2.nbSuccesseurs(),10);
        assertEquals(21,num.getCptEtape());
        assertEquals(10,num.getCptSemaphore());
        etape2.ajouterSuccesseur(new Guichet("h"),new Activite("i"), new Guichet("j"));
        assertEquals(etape2.nbSuccesseurs(),13);
        assertEquals(24,num.getCptEtape());
        assertEquals(12,num.getCptSemaphore());

    }

    /**
     * Test de la methode d'ajout d'un ou de plusieurs Successeurs à une etape
     */
    @Test
    void ajouterSuccesseur()
    {
        FabriqueNumero num = FabriqueNumero.getInstance();
        System.out.println("hello world"+ num.getCptEtape( ));
        System.out.println("hello wold "+ num.getCptSemaphore( ));
        Etape etape = new Activite("a");
        assertEquals(etape.nbSuccesseurs(),0);

        etape.ajouterSuccesseur(new Activite("ab",10,20));
        assertEquals(etape.nbSuccesseurs(),1);
        etape.ajouterSuccesseur(new Activite("ab1",1,2),new Activite("ab2"),new Activite("ab3"));
        assertEquals(etape.nbSuccesseurs(),4);
        etape.ajouterSuccesseur(new Activite("c",1,2),new Activite("d"),new Activite("e"),new Activite("f",1,2),new Activite("j"),new Activite("k"));
        assertEquals(etape.nbSuccesseurs(),10);

        etape = new Guichet("a");
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("b"));
        assertEquals(etape.nbSuccesseurs(),1);
        etape.ajouterSuccesseur(new Activite("ab2"),new Activite("ab3"));
        assertEquals(etape.nbSuccesseurs(),3);
        etape.ajouterSuccesseur(new Activite("c",1,2),new Activite("f",1,2),new Activite("j"),new Activite("k"));
        assertEquals(etape.nbSuccesseurs(),7);

        etape = new SasEntree();
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("A"), new Guichet("g"));
        assertEquals(etape.nbSuccesseurs(),2);
        etape.ajouterSuccesseur(new Activite("b"), new Guichet("c"),new Activite("d"));
        assertEquals(etape.nbSuccesseurs(),5);

        etape = new SasSortie();
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("a"), new Guichet("b"));
        assertEquals(etape.nbSuccesseurs(),2);
        etape.ajouterSuccesseur(new Activite("c"),new Activite("d"));
        assertEquals(etape.nbSuccesseurs(),4);
        etape.ajouterSuccesseur(new Activite("e"), new Guichet("f"),new Activite("g"));
        assertEquals(etape.nbSuccesseurs(),7);

        etape = new ActiviteRestreinte("a");
        assertEquals(etape.nbSuccesseurs(),0);
        etape.ajouterSuccesseur(new Activite("a"), new Guichet("b"),new Activite("c",5,2));
        assertEquals(etape.nbSuccesseurs(),3);
        etape.ajouterSuccesseur(new Guichet("d"),new Activite("e"), new Guichet("f"),new Activite("g"));
        assertEquals(etape.nbSuccesseurs(),7);
        etape.ajouterSuccesseur(new Guichet("e"),new Activite("i"), new Guichet("j"));
        assertEquals(etape.nbSuccesseurs(),10);
    }

    /**
     * Test de la methode qui vérifie si une Etape est une Activité
     */
    @Test
    void estUneActivite()
    {
        Etape etape = new Activite("a",5,3);
        assertTrue(etape.estUneActivite());
        etape = new Activite("b");
        assertTrue(etape.estUneActivite());
        etape = new Guichet("c");
        assertFalse(etape.estUneActivite());
        etape = new Guichet("c",12);
        assertFalse(etape.estUneActivite());
        etape = new ActiviteRestreinte("c");
        assertTrue(etape.estUneActivite());
        etape = new SasSortie("d");
        assertTrue(etape.estUneActivite());
        etape = new SasEntree();
        assertTrue(etape.estUneActivite());
    }

    /**
     * Test de la methode qui vérifie si une Etape est un Guichet
     */
    @Test
    void estUnGuichet(){
        Etape etape = new Activite("a",5,3);
        assertFalse(etape.estUnGuichet());
        etape = new Activite("b");
        assertFalse(etape.estUnGuichet());
        etape = new Guichet("c");
        assertTrue(etape.estUnGuichet());
        etape = new Guichet("c",12);
        assertTrue(etape.estUnGuichet());
        etape = new ActiviteRestreinte("c");
        assertFalse(etape.estUnGuichet());
        etape = new SasSortie("d");
        assertFalse(etape.estUnGuichet());
        etape = new SasEntree();
        assertFalse(etape.estUnGuichet());
    }


    /**
     * Test de la methode toC générant le code C en fonction de la nature de
     * l'Etape et de l'action menée
     */
    @Test
    void toC(){
        SasSortie sasSortie = new SasSortie();
        assertEquals(sasSortie.getNumeroEtape(),0);
        assertEquals(sasSortie.toC(),"");
        SasEntree sasEntree = new SasEntree();
        assertEquals(sasEntree.getNumeroEtape(),1);
        assertEquals(sasEntree.toC(),"entrer(1);\n");
        Activite activite1= new Activite("activité 1",6,3);
        assertEquals(activite1.getNumeroEtape(),2);
        sasEntree.ajouterSuccesseur(activite1);
        assertEquals(sasEntree.toC(),"entrer(1);\ndelai(4,2);\ntransfert(1,2);\n");
        assertEquals(activite1.toC(),""); // elle n'a pas de successeur
        Activite activite2= new Activite("activité 2");
        assertEquals(activite2.getNumeroEtape(),3);
        assertEquals(activite2.toC(),"");// elle n'a pas de successeur
        activite1.ajouterSuccesseur(activite2);
        assertEquals(activite2.getNumeroEtape(),3);
        assertEquals(activite1.toC(),"delai(6,3);\ntransfert(2,3);\n");
        activite2.ajouterSuccesseur(sasSortie);
        assertEquals(activite2.toC(),"delai(4,2);\ntransfert(3,0);\n");
        FabriqueNumero fabriqueNumero = FabriqueNumero.getInstance();
        fabriqueNumero.reset();
        SasEntree sasEntree1 = new SasEntree();                                 //0
        assertEquals(0,sasEntree1.getNumeroEtape());
        Guichet guichet = new Guichet("guichet");                          //1
        assertEquals(1,guichet.getNumeroEtape());
        ActiviteRestreinte activiteRestreinte = new ActiviteRestreinte("activité",2,3,5);  //2
        assertEquals(2,activiteRestreinte.getNumeroEtape());
        guichet.ajouterSuccesseur(activiteRestreinte);
        assertEquals("P(ids,1);\ntransfert(1,2);\ndelai(2,3);\nV(ids,1);\n",guichet.toC());
        System.out.println("_________________");
        SasSortie sasSortie1 = new SasSortie();
        assertEquals(3,sasSortie1.getNumeroEtape());
        activiteRestreinte.ajouterSuccesseur(sasSortie1);
        assertEquals("transfert(2,3);\n",activiteRestreinte.toC());
        assertEquals("",sasSortie1.toC());
    }
}
