package twisk;


import twisk.monde.*;
import twisk.outils.ClassLoaderPerso;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientTwisk {

    public static void main(String[] args) throws InterruptedException {
        Monde monde2 = new Monde();
        Etape act = new Activite("monde2", 20, 1);
        //monde2.aCommeEntree(act);
        //monde2.aCommeSortie(act);
        //monde2.ajouter(act);
        Monde monde = new Monde();
        Activite piscine = new Activite("piscine", 3, 1);
        Activite hello = new Activite("hello", 3, 1);
        Activite act1 = new Activite("act1", 3, 1);
        Activite act2 = new Activite("act2", 3, 1);
        Guichet guich = new Guichet("guich",2);
        act1.ajouterSuccesseur(guich);
        guich.ajouterSuccesseur(act2);
        monde2.aCommeEntree(act1);
        monde2.aCommeSortie(act2);
        monde2.ajouter(act1,act2,guich);
        ClassLoaderPerso classLoaderPerso = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
        try {
            Class classSimuler = classLoaderPerso.loadClass("twisk.simulation.Simulation");
            classLoaderPerso = null;
            System.gc();
            Runtime.getRuntime().gc();
            Object objet = classSimuler.newInstance();
            System.out.println(objet.getClass().getName());
            objet.getClass().getMethod("setNbClients", int.class).invoke(objet, 3);
            objet.getClass().getMethod("simuler", Monde.class).invoke(objet, monde2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("*******************************************************************************");
        System.out.println("**********************************DEUXIEME MONDE*******************************");
        System.out.println("*******************************************************************************");

        classLoaderPerso = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
        try {

            Class classSimuler = classLoaderPerso.loadClass("twisk.simulation.Simulation");
            classLoaderPerso = null;
            System.gc();
            Runtime.getRuntime().gc();
            Object objet = classSimuler.newInstance();
            System.out.println(objet.getClass().getName());
            objet.getClass().getMethod("setNbClients", int.class).invoke(objet, 20);
            objet.getClass().getMethod("simuler", Monde.class).invoke(objet, monde);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
