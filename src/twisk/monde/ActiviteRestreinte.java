package twisk.monde;

public class ActiviteRestreinte extends Activite{
    public ActiviteRestreinte(String nom) {
        super(nom);
    }

    public ActiviteRestreinte(String nom, int temps, int ecartTemps, int nbClient) {
        super(nom, temps, ecartTemps);
    }

    public ActiviteRestreinte(String nom, int temps, int ecartTemps) {
        super(nom, temps, ecartTemps);
    }

    @Override
    public String toC() {
        StringBuilder str = new StringBuilder();
        if(this.nbSuccesseurs() ==1) {
            str.append("transfert("+this.nomConstanteEnC()+","+this.getLesSuccesseurs().getSuccesseurIndice(0).nomConstanteEnC()+");\n");
            str.append(this.getSuccesseurIndice(0).toC());
        }
        else if(this.nbSuccesseurs()>1)
        {
            str.append("int nb = (int) ( (rand() / (float) RAND_MAX ) * "+this.nbSuccesseurs() +" ) ;\n");
            str.append("switch (nb) {\n");
            int cpt =0;
            for(Etape e : this.getLesSuccesseurs())
            {
                str.append("case "+ cpt +": \n");
                str.append("transfert("+this.nomConstanteEnC()+","+this.getLesSuccesseurs().getSuccesseurIndice(cpt).nomConstanteEnC()+");\n");
                str.append(e.toC());
                str.append("break ;\n");
                cpt++;
            }
            str.append("}");
        }
        return str.toString();
    }

}
