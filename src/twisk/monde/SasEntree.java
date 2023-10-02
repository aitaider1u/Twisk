package twisk.monde;

public class SasEntree extends Activite{

    public SasEntree(String nom) {
        super(nom);
    }

    public SasEntree() {
        super("Entrée");
    }

    @Override
    public String toC() {
        StringBuilder str = new StringBuilder(50);
        str.append("entrer("+this.nomConstanteEnC()+");\n");
        str.append(super.toC());
        return str.toString();
    }

    @Override
    public Boolean estUneEntree() {
        return !super.estUneEntree();
    }
}

