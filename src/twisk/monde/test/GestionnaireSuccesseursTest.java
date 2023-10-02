package twisk.monde.test;

import org.junit.jupiter.api.Test;
import twisk.monde.*;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe Test de la classe du Gestionnaire des successeurs
 */
class GestionnaireSuccesseursTest {

    /**
     * Test de la méthode comptant le nombre d'étapes dans le gestionnaire des successeurs
     */
    @Test
    void nbEtapes()
    {
        GestionnaireSuccesseurs succ = new GestionnaireSuccesseurs();
        assertEquals(0,succ.nbEtapes());
        succ.ajouter(new ActiviteRestreinte("a",10,3,20));
        assertEquals(1,succ.nbEtapes());
        succ.ajouter(new Activite("a1",12,4),new Guichet("a2",7));
        assertEquals(3,succ.nbEtapes());
        succ.ajouter(new Activite("a3",12,4),new Guichet("a4",7),new SasEntree("a5"),new SasSortie("a6"));
        assertEquals(7,succ.nbEtapes());
    }

    /**
     * Test de l'itérateur du gestionnaire de successeurs
     */
    @Test
    void iterator()
    {
         GestionnaireSuccesseurs succ = new GestionnaireSuccesseurs();
         Iterator <Etape> ite = succ.iterator();
         assertFalse(ite.hasNext());
         succ.ajouter(new Activite("a1",4,5), new Guichet("a2",7),new Activite("a3",4,2));
         ite = succ.iterator();
         assertTrue(ite.hasNext());
         assertEquals(ite.next().getNom(),"a1");
         assertTrue(ite.hasNext());
         assertEquals(ite.next().getNom(),"a2");
         assertTrue(ite.hasNext());
         assertEquals(ite.next().getNom(),"a3");
         assertFalse(ite.hasNext());


    }
}