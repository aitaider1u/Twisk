package twisk.mondeIG;

public class GuichetIG extends EtapeIG{
    private int nbJetons = 5;

    public GuichetIG(String nom, String identifiant, int largeur, int hauteur) {
        super(nom, identifiant, largeur, hauteur);
    }

    public GuichetIG(String nom, String identifiant, int posX, int posY, int largeur, int hauteur) {
        super(nom, identifiant, posX, posY, largeur, hauteur);
    }

    @Override
    public boolean estUnGuichet() { return true; }

    @Override
    public int getNbJetons() {
        return nbJetons;
    }

    @Override
    public void setNbJetons(int nbJetons) {
        this.nbJetons = nbJetons;
    }
}
