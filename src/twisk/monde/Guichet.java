package twisk.monde;

import twisk.outils.FabriqueNumero;

public class Guichet extends Etape{
    private int nbJetons;
    private int numeroSemaphore;

    public Guichet(String nom) {
        super(nom);
        FabriqueNumero num = FabriqueNumero.getInstance();
        this.numeroSemaphore = num.numeroSemaphore();
    }

    public Guichet(String nom, int nbJetons) {
        super(nom);
        this.nbJetons = nbJetons;
        FabriqueNumero num = FabriqueNumero.getInstance();
        this.numeroSemaphore = num.numeroSemaphore();
    }


    @Override
    public boolean estUnGuichet() {
        return ! super.estUnGuichet();
    }

    /**
     * Getter du nombre de jetons du Guichet nbjetons
     * @return int : nombre de jetons du Guichet nbjetons
     */
    @Override
    public int getNbJetons() {
        return nbJetons;
    }

    /**
     * Setter du nombre de jetons du Guichet nbjetons
     * @param nbJetons int : le nombre de jetons désiré
     */
    public void setNbJetons(int nbJetons) {
        this.nbJetons = nbJetons;
    }

    /**
     * Getter du numéro Sémaphore du Guichet NumeroSemaphore
     * @return int : numéro Sémaphore du Guichet NumeroSemaphore
     */
    public int getNumeroSemaphore() {
        return numeroSemaphore;
    }

    @Override
    public String toC(){
        StringBuilder str = new StringBuilder();
        str.append("P(ids,"+ this.getNumeroSemaphore()+");\n");
        str.append("transfert("+this.nomConstanteEnC()+","+ this.getLesSuccesseurs().getSuccesseurIndice(0).nomConstanteEnC()+ ");\n");//car le guichet a une seul activité qui le suit
        str.append("delai("+this.getLesSuccesseurs().getSuccesseurIndice(0).getTemps()+","+this.getLesSuccesseurs().getSuccesseurIndice(0).getEcartTemps()+");\n");
        str.append("V(ids,"+ this.getNumeroSemaphore()+");\n");
        str.append(this.getSuccesseurIndice(0).toC());// 0 car le guichet il a un seul successeur
        return str.toString();
    }
}
