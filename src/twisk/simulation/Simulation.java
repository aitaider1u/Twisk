package twisk.simulation;
import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.outils.KitC;

public class Simulation {
    //hello
    private  KitC kitC = new KitC();

    private int nbClients = 5;

    public Simulation() {

        kitC.creerEnvironnement();

    }

    public int getNbClients() {

        return nbClients;

    }

    /**

     * Setter du nombre de clients nbClients

     * @param nbClients int : le nombre de clients

     */

    public void setNbClients(int nbClients) {

        this.nbClients = nbClients;

    }

    /**

     * Methode permettant de simuler le Monde en paramètre

     * en créant le fichier contenant le code C généré à partir de celui-ci,

     * le compilant et créant la librairie nécéssaire.

     *

     * @param monde Monde : le Monde à simuler

     */

    public void simuler(Monde monde)  {
        kitC.creerFichier(monde.toC());
        kitC.compiler();
        kitC.construireLaLibrairie();
        System.load("/tmp/twisk/libTwisk.so");
        ///FabriqueNumero.getInstance().getCptSemaphore()
        System.out.println(monde.toString()); //affichage du monde
        int[]  tabJetonsGuichet = new int[monde.nbGuichet()];
        int i = 0;
        for(Etape e : monde)
        {
            if (e.estUnGuichet())
            {
                tabJetonsGuichet[i] = e.getNbJetons();
                i++;
            }
        }
        int[] tab = start_simulation(monde.nbEtapes(), monde.nbGuichet(), this.nbClients, tabJetonsGuichet);
        System.out.println("monde d'etape du monde :"+ monde.nbEtapes());
        System.out.println("monde de guichets du monde :"+ monde.nbGuichet());
        System.out.println("monde de client du monde :"+ this.nbClients);
        System.out.println("tabJetonsGuichet.lenght :"+ tabJetonsGuichet.length);
        System.out.print("les client :  ");
        for (int j = 0 ; j<tab.length ; j++)
        {
            System.out.print(tab[j] +" | ");
        }
        int[] ouMesClient;
        do{
             ouMesClient = ou_sont_les_clients(monde.nbEtapes(),tab.length);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println(this.affichageRecurssif(monde,monde.getEntree(), ouMesClient,nbClients));
        }while (ouMesClient[monde.getSortie().getNumeroEtape()*(tab.length+1)] != nbClients);
        nettoyage();
    }

    public native int[] start_simulation(int nbEtapes,int nbGuichets,int nbClients, int[] tabJetonsGuichet);

    public native int[] ou_sont_les_clients(int nbEtapes, int nbClients);

    public native void nettoyage();

    /**

     * Méthode permettant un affichable lisible des Etapes du Monde

     * @param monde Monde : le monde à afficher

     * @param e Etape : Etape en cours à afficher

     * @param tab int[] : Tableau d'entiers indiquant ou sont les clients

     * @param nbrClient int : le nombre de clients

     * @return String : la chaine de caractère représentant l'affichage des Etapes.

     */

    public String affichageRecurssif(Monde monde,Etape e,int[] tab,int nbrClient)

    {

        StringBuilder str = new StringBuilder();

        if(!e.estUneSortie())

        {

            str.append("etape "+e.getNumeroEtape()+" ("+e.getNom() +") "+ tab[e.getNumeroEtape()*(nbrClient+1)] + " client : ");

            for(int i =1 ; i< (tab[e.getNumeroEtape()*(nbrClient+1)]+1) ;i++)

            {

                str.append(tab[(e.getNumeroEtape()*(nbrClient+1))+i] + " | ");

            }

            str.append("\n");

            for (int i =0 ; i<e.nbSuccesseurs() ;i++)

            {

                str.append(this.affichageRecurssif(monde,e.getSuccesseurIndice(i),tab,nbrClient));

            }

        }

        if(e.estUneEntree())

        {

            str.append("etape "+monde.getSortie().getNumeroEtape()+" ("+monde.getSortie().getNom() +") "+ tab[monde.getSortie().getNumeroEtape()*(nbrClient+1)] + " client : ");

            for(int i =1 ; i<(tab[monde.getSortie().getNumeroEtape()*(nbrClient+1)]+1) ;i++)

            {

                str.append(tab[(monde.getSortie().getNumeroEtape()*(nbrClient+1))+i] + " | ");

            }

            str.append("\n");

        }

        return str.toString();

    }

}
