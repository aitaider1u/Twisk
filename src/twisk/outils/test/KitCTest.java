package twisk.outils.test;

import org.junit.jupiter.api.Test;
import twisk.outils.KitC;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe Test de la classe KitC
 */
class KitCTest {
    /**
     * Test de la Methode de création de l'environnement
     */
    @Test
    void creerEnvironnement() {
        KitC kitC = new KitC();
        kitC.creerEnvironnement();
        File dossier=new File("/tmp/twisk");
        File fichier1=new File("/tmp/twisk/programmeC.o");
        File fichier2=new File("/tmp/twisk/def.h");

        assertTrue(dossier.exists() && dossier.isDirectory());
        assertTrue(fichier1.exists() && fichier1.isFile());
        assertTrue(fichier2.exists() && fichier2.isFile());
    }

    /**
     * Test de la Methode de Cration de Fichier
     */
    @Test
    void creerFichier() {
        KitC kitC = new KitC();
        kitC.creerFichier("hello twiskProject");
        File fichier1=new File("/tmp/twisk/client.c");
        assertTrue(fichier1.exists() && fichier1.isFile());
    }
}