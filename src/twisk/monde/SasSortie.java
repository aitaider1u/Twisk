package twisk.monde;

public class SasSortie extends Activite{


    public SasSortie(String nom) {
        super(nom);
        this.setTemps(0);
        this.setEcartTemps(0);
    }
    public SasSortie() {
        super("Sortie");
        this.setTemps(1);
        this.setEcartTemps(1);
    }

    @Override
    public String toC() {
        return "";
    }

    @Override
    public Boolean estUneSortie() {
        return !super.estUneSortie();
    }
}
