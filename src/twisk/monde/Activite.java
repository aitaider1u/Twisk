package twisk.monde;


public class Activite extends Etape{
    private int temps = 4;
    private int ecartTemps = 2;

    public Activite(String nom) {
        super(nom);
    }

    public Activite(String nom, int temps, int ecartTemps) {
        super(nom);
        this.temps = temps;
        this.ecartTemps = ecartTemps;
    }

    @Override
    public boolean estUneActivite() {
        return !super.estUneActivite();
    }

    @Override
    public int getTemps() {
        return super.getTemps() +temps;
    }

    /**
     * Setter de la donnée membre temps
     * @return int : temp
     */
    public void setTemps(int temps) {
        this.temps = temps;
    }

    @Override
    public int getEcartTemps() {
        return super.getEcartTemps()+ ecartTemps;
    }

    /**
     * Setter de la donnée membre ecartTemps
     * @return int : ecartTemps
     */
    public void setEcartTemps(int ecartTemps) {
        this.ecartTemps = ecartTemps;
    }

    @Override
    public String toC() {
        StringBuilder str = new StringBuilder();
        str.append("delai("+this.getTemps()+","+this.getEcartTemps()+");\n");
        if(this.nbSuccesseurs() == 1) {
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

    @Override
    public Boolean estUneSortie() {
        return super.estUneSortie();
    }

    @Override
    public Boolean estUneEntree() {
        return super.estUneEntree();
    }
}
