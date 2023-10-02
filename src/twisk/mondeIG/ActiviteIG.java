package twisk.mondeIG;

public class ActiviteIG extends EtapeIG {
    private int temp = 4;
    private int deltaTemp = 2;
    private boolean estUneActiviteRestreinte = false;

    public ActiviteIG(String nom, String identifiant, int largeur, int hauteur) {
        super(nom, identifiant, largeur, hauteur);
    }

    //pour les tests on position x et y
    public ActiviteIG(String nom, String identifiant, int posX, int posY, int largeur, int hauteur) {
        super(nom, identifiant, posX, posY, largeur, hauteur);
    }

    @Override
    public boolean estUneActivite() {
        return true;
    }
    @Override
    public boolean estUneActiviteRestreinte(){
        return  estUneActiviteRestreinte;
    }
    @Override
    public void setEstUneActiviteRestreinte(boolean bool){
        this.estUneActiviteRestreinte = bool;
    }

    @Override
    public void setTemp(int temp) {
        super.setTemp(temp);
        this.temp = temp;
    }

    @Override
    public void setDeltaTemp(int temp) {
        super.setDeltaTemp(temp);
        this.deltaTemp = temp;
    }

    @Override
    public int getTemp() {
        return temp;

    }

    @Override
    public int getDeltaTemp() {
        return deltaTemp;
    }




}
