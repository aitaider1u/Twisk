package twisk.monde.test;

import org.junit.jupiter.api.Test;
import twisk.monde.*;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de Test de la classe GestionnaireEtapes
 */
class GestionnaireEtapesTest {

    /**
     * Test de la méthode comptant le nombre d'étapes dans le Gestionnaire d'étapes
     */
    @Test
    void nbEtapes()
    {
        GestionnaireEtapes etape = new GestionnaireEtapes();
        assertEquals(0,etape.nbEtapes());
        etape.ajouter(new Activite("a3",12,4),new Guichet("a4",7),new SasEntree("a5"),new SasSortie("a6"));
        assertEquals(4,etape.nbEtapes());
        etape.ajouter(new Activite("a1",12,4),new Guichet("a2",7));
        assertEquals(6,etape.nbEtapes());
        etape.ajouter(new ActiviteRestreinte("a",10,3,20));
        assertEquals(7,etape.nbEtapes());
    }

    /**
     * Test de l'itérateur  du gestionnaire d'étapes
     */
    @Test
    void iterator(){
        GestionnaireEtapes etape = new GestionnaireEtapes();
        Iterator<Etape> ite = etape.iterator();
        assertFalse(ite.hasNext());
        etape.ajouter(new Activite("a1",4,5), new Guichet("a2",7),new Activite("a3",4,2));
        ite = etape.iterator();
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getNom(),"a1");
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getNom(),"a2");
        assertTrue(ite.hasNext());
        assertEquals(ite.next().getNom(),"a3");
        assertFalse(ite.hasNext());

    }
}