package twisk.outils;


public class FabriqueNumero {
    private int cptEtape = -1;
    int cptSemaphore = 0;
    private static FabriqueNumero instance = new FabriqueNumero();

    private FabriqueNumero() { }

    public static  FabriqueNumero getInstance()
    {
        return instance ;
    }

    /**
     * Methode de numérotation d'une Etape
     * @return int : le numéro de l'Etape
     */
    public int numeroterEtape()
    {
        this.cptEtape++;
        return  this.cptEtape;
    }

    /**
     * Methode de numérotation d'un semaphore
     * @return int : le numéro du semaphore
     */
    public int numeroSemaphore()
    {
        this.cptSemaphore++;
        return  this.cptSemaphore;
    }

    /**
     * Getter du compteur d'Etape cptEtape
     * @return int : cptEtape
     */
    public int getCptEtape() {
        return cptEtape;
    }

    /**
     * Methode de réinitialisation des compteurs d'Etapes et de Semaphores
     */
    public void reset() {
        this.cptEtape = -1;
        this.cptSemaphore = 0;
    }

    /**
     * Getter du compteur de semaphores  cptSemaphore
     * @return int : cptSemaphore
     */
    public int getCptSemaphore() {
        return cptSemaphore;
    }
}
