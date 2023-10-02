package twisk.monde.test;

import org.junit.jupiter.api.Test;
import twisk.monde.*;
import twisk.outils.*;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe Test de la classe Monde
 */
class MondeTest {

    /**
     * Test de la methode aCommeEntree qui relie l'entrée du Monde
     * a une ou plusieurs Etapes
     */
    @Test
    void aCommeEntree()
    {

        Monde monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        assertEquals( 0,monde.getEntree().getLesSuccesseurs().nbEtapes());
        monde.aCommeEntree(new Activite("a"),new Guichet("hello"),new Activite("activite"));
        assertEquals( 3,monde.getEntree().getLesSuccesseurs().nbEtapes());
        assertEquals(5,monde.nbEtapes());
        monde.aCommeEntree(new Guichet("a"),new Guichet("hello"));
        assertEquals( 5,monde.getEntree().getLesSuccesseurs().nbEtapes());
        assertEquals(7,monde.nbEtapes());


    }

    /**
     * Test de la méthode aCommeSortie qui relie une ou plusieurs étapes à la
     * sortie du monde
     */
    @Test
    void aCommeSortie()
    {
        Monde monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        assertEquals( 0,monde.getSortie().getLesSuccesseurs().nbEtapes());
        Etape[] etapes = {new Activite("a"),new Guichet("hello"),new Activite("activite")};
        monde.aCommeSortie(etapes);
        for(Etape e : etapes)
        {
            assertEquals(1,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals( 0,monde.getSortie().getLesSuccesseurs().nbEtapes());
        assertEquals( 0,monde.getEntree().getLesSuccesseurs().nbEtapes());
        FabriqueNumero num = FabriqueNumero.getInstance();
        num.reset();
        monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        assertEquals( 0,monde.getSortie().getLesSuccesseurs().nbEtapes());
        Etape[] etapes2 = {new Activite("a"),new Guichet("hello"),new Activite("activite"),new ActiviteRestreinte("b"),new SasEntree("hello")};
        monde.aCommeSortie(etapes2);
        for(Etape e : etapes2)
        {
            assertEquals(1,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals( 0,monde.getSortie().getLesSuccesseurs().nbEtapes());
        assertEquals( 0,monde.getEntree().getLesSuccesseurs().nbEtapes());

    }

    /**
     * Test de la methode d'ajout d'une ou plusieurs etape un Monde existant
     */
    @Test
    void ajouter()
    {
        Monde monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        monde.ajouter(new Guichet("a"),new Guichet("b"),new Guichet("c"));
        for (Etape e : monde )
        {
            assertEquals(0,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals(5,monde.nbEtapes());
        monde.ajouter(new ActiviteRestreinte("hello"),new Activite("afe"),new Activite("az"),new Activite("hello"));
        for (Etape e : monde )
        {
            assertEquals(0,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals(9,monde.nbEtapes());
        FabriqueNumero num =  FabriqueNumero.getInstance();
        num.reset();
        monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        monde.ajouter(new Guichet("a"));
        for (Etape e : monde )
        {
            assertEquals(0,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals(3,monde.nbEtapes());
        monde.ajouter(new ActiviteRestreinte("hello"),new Activite("afe"),new Guichet("az"),new Activite("hello"));
        for (Etape e : monde )
        {
            assertEquals(0,e.getLesSuccesseurs().nbEtapes());
        }
        assertEquals(7,monde.nbEtapes());

    }

    /**
     * Test de la methode comptant le nombre de Guichets
     */
    @Test
    void nbGuichet()
    {
        Monde monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        assertEquals(0,monde.nbGuichet());
        monde.ajouter(new Activite("a"),new Activite("b"),new Activite("c"));
        assertEquals(5,monde.nbEtapes());
        assertEquals(0,monde.nbGuichet());
        monde.ajouter(new Activite("a"),new Guichet("b"));
        assertEquals(7,monde.nbEtapes());
        assertEquals(1,monde.nbGuichet());
        monde.ajouter(new Guichet("g1"),new Guichet("g2"),new Guichet("g3"));
        assertEquals(10,monde.nbEtapes());
        assertEquals(4,monde.nbGuichet());
        monde.ajouter(new Activite("a1"),new Activite("b2"),new Activite("c3"),new Activite("d"));
        assertEquals(14,monde.nbEtapes());
        assertEquals(4,monde.nbGuichet());
        FabriqueNumero num =FabriqueNumero.getInstance();
        num.reset();
        monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        assertEquals(0,monde.nbGuichet());
        monde.ajouter(new Guichet("a"),new Guichet("b"),new Guichet("c"));
        assertEquals(5,monde.nbEtapes());
        assertEquals(3,monde.nbGuichet());
        monde.ajouter(new Guichet("a"),new Guichet("b"));
        assertEquals(7,monde.nbEtapes());
        assertEquals(5,monde.nbGuichet());
        monde.ajouter(new Activite("a1"),new Activite("b2"),new Activite("c3"),new Activite("d"));
        assertEquals(11,monde.nbEtapes());
        assertEquals(5,monde.nbGuichet());
        monde.ajouter(new Guichet("g1"),new Guichet("g2"),new Guichet("g3"));
        assertEquals(14,monde.nbEtapes());
        assertEquals(8,monde.nbGuichet());
    }

    /**
     * Test de la methode comptant le nombre d'étapes dans un monde existant
     */
    @Test
    void nbEtapes()
    {
        Monde monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        monde.ajouter(new Guichet("a"),new Guichet("b"),new Guichet("c"));
        assertEquals(5,monde.nbEtapes());
        monde.ajouter(new ActiviteRestreinte("hello"),new Activite("afe"),new Activite("az"),new Activite("hello"));
        assertEquals(9,monde.nbEtapes());

        FabriqueNumero num =  FabriqueNumero.getInstance();
        num.reset();
        monde = new Monde();
        assertEquals(2,monde.nbEtapes());
        monde.ajouter(new Guichet("a"));
        assertEquals(3,monde.nbEtapes());
        monde.ajouter(new ActiviteRestreinte("hello"),new Activite("afe"),new Guichet("az"),new Activite("hello"));
        assertEquals(7,monde.nbEtapes());
    }

    /**
     * Test de l'itérateur d'étapes du monde
     */
    @Test
    void iterator()
    {
        Monde monde = new Monde();
        Iterator<Etape> ite = monde.iterator();
        assertTrue(ite.hasNext());
        Etape etape = ite.next();
        assertEquals(etape.getNom(),"Entrée");
        etape = ite.next();
        assertEquals(etape.getNom(),"Sortie");
        assertFalse(ite.hasNext());
        monde.ajouter(new ActiviteRestreinte("a1"),new Activite("a2"),new Guichet("a3"),new Activite("a4"));
        ite = monde.iterator();

        etape = ite.next();
        assertEquals(etape.getNom(),"Entrée");
        etape = ite.next();
        assertEquals(etape.getNom(),"Sortie");
        etape = ite.next();
        assertEquals(etape.getNom(),"a1");
        etape = ite.next();
        assertEquals(etape.getNom(),"a2");
        etape = ite.next();
        assertEquals(etape.getNom(),"a3");
        etape = ite.next();
        assertEquals(etape.getNom(),"a4");
    }

    /**
     * Test de la methode toC générant le code d'un monde existant
     */
    @Test
    void toC(){
        Monde monde = new Monde();
        Activite activite = new Activite("activite 1",5,3);
        monde.ajouter(activite);
        monde.aCommeEntree(activite);
        monde.aCommeSortie(activite);
        assertEquals("#include \"def.h\"\n#include <stdio.h>\n\n\nvoid simulation(int ids)\n{\nentrer(0);\ndelai(4,2);\ntransfert(0,2);\ndelai(5,3);\ntransfert(2,1);\n}\n",monde.toC());
        System.out.println("-----------");
        System.out.println("-----------");
        FabriqueNumero fabriqueNumero = FabriqueNumero.getInstance();

        fabriqueNumero.reset();

        Monde monde1 = new Monde();
        Activite activite1 = new Activite("activite 1",5,3);
        Guichet guichet = new Guichet("guichet");
        activite1.ajouterSuccesseur(guichet);
        ActiviteRestreinte activiteRestreinte = new ActiviteRestreinte("activiteRestreinte",10,4,6);
        guichet.ajouterSuccesseur(activiteRestreinte);
        monde1.ajouter(activite1,guichet,activiteRestreinte);
        monde1.aCommeEntree(activite1);
        monde1.aCommeSortie(activiteRestreinte);
        assertEquals("#include \"def.h\"\n#include <stdio.h>\n\n\nvoid simulation(int ids)\n{\nentrer(0);\ndelai(4,2);\ntransfert(0,2);\ndelai(5,3);\ntransfert(2,3);\nP(ids,1);\ntransfert(3,4);\ndelai(10,4);\nV(ids,1);\ntransfert(4,1);\n}\n",monde1.toC());

    }




}