package twisk.outils.test;

import org.junit.jupiter.api.Test;
import twisk.outils.FabriqueNumero;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de Test de la classe FabriqueNumero
 */
class FabriqueNumeroTest {
    /**
     * Test de la Methode numeroterEtape()
     */
    @Test
    void numeroterEtape()
    {
        FabriqueNumero num = FabriqueNumero.getInstance();
        assertEquals(-1,num.getCptEtape());
        int cpt = num.numeroterEtape();
        assertEquals(cpt,0);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,1);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,2);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,3);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,4);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,5);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,6);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,7);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,8);
        assertEquals(cpt,num.getCptEtape());
        num.reset();
        assertEquals(-1,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,0);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,1);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,2);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,3);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,4);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,5);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,6);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,7);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,8);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,9);
        assertEquals(cpt,num.getCptEtape());
        cpt = num.numeroterEtape();
        assertEquals(cpt,10);
        assertEquals(cpt,num.getCptEtape());
        num.reset();
        assertEquals(-1,num.getCptEtape());

    }




    /**
     * Test de la Methode reset()
     */
    @Test
    void reset(){
        FabriqueNumero num = FabriqueNumero.getInstance();
        assertEquals(-1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());
        int cptEtape = num.numeroterEtape();
        int cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,0);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,1);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,1);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,2);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,2);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,3);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,3);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,4);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,4);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,5);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,5);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,6);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,6);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,7);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,7);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,8);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,8);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,9);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        num.reset();
        assertEquals(-1,num.getCptEtape());
        assertEquals(0,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,0);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,1);
        assertEquals(cptSemaphore,num.getCptSemaphore());


        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,1);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,2);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,2);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,3);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,3);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,4);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,4);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,5);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,5);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,6);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        cptEtape = num.numeroterEtape();
        cptSemaphore = num.numeroSemaphore();
        assertEquals(cptEtape,6);
        assertEquals(cptEtape,num.getCptEtape());
        assertEquals(cptSemaphore,7);
        assertEquals(cptSemaphore,num.getCptSemaphore());

        num.reset();
        assertEquals(0,num.getCptSemaphore());
        assertEquals(-1,num.getCptEtape());
        num.reset();
        assertEquals(0,num.getCptSemaphore());
        assertEquals(-1,num.getCptEtape());
    }

    /**
     * Test de la Methode numeroSemaphore()
     */
    @Test
    void numeroSemaphore() {
        FabriqueNumero num = FabriqueNumero.getInstance();
        assertEquals(0,num.getCptSemaphore());
        int cpt = num.numeroSemaphore();
        assertEquals(cpt,1);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,2);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,3);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,4);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,5);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,6);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,7);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,8);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,9);
        assertEquals(cpt,num.getCptSemaphore());
        num.reset();
        assertEquals(0,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,1);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,2);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,3);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,4);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,5);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,6);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,7);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,8);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,9);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,10);
        assertEquals(cpt,num.getCptSemaphore());
        cpt = num.numeroSemaphore();
        assertEquals(cpt,11);
        assertEquals(cpt,num.getCptSemaphore());
        num.reset();
        assertEquals(0,num.getCptSemaphore());

    }


}