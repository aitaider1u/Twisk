package twisk.outils;


public class FabriqueIdentifiant {
    private int noEtape = 0;
    private int nbrActivite =0; // a  ajouter pour les nom des activite lors de l'instanciation
    private int nbrGuichet = 0 ; // a  ajouter pour les nom des guichet lors de l'instanciation
    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
    private FabriqueIdentifiant()
    {
    }

    public static FabriqueIdentifiant getInstance() {
        return instance;
    }

    public int numActivite() {
        nbrActivite++;
        return  nbrActivite;
    }

   public int numGuichet() {
        nbrGuichet++;
        return nbrGuichet;
    }

    public String getIdentifiantEtape()
    {
        noEtape++;
        return "Etape " + noEtape;
    }

}