package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{
    private GestionnaireEtapes lesEtapes = new GestionnaireEtapes();
    private SasEntree entree;
    private SasSortie sortie;

    public Monde(){
        this.entree = new SasEntree();
        this.sortie = new SasSortie();
        this.lesEtapes.ajouter(entree,sortie);
    }


    /**
     * Methode reliant l'entree du Monde à une ou plusieur Etapes
     * @param etapes Etape[] : les successeurs du Sas d'Entree
     */
    public void aCommeEntree(Etape... etapes)
    {
        this.entree.ajouterSuccesseur(etapes);
    }

    /**
     * Methode reliant une ou plusieur Etapes au sas de Sortie du Monde
     * @param etapes Etape[] : Les Etapes ayant comme successeurs le Sas d'Entree
     */
    public void aCommeSortie(Etape... etapes) {
        for (Etape e : etapes) {
            e.ajouterSuccesseur( this.sortie);
        }
    }

    /**
     * Getter du Gestionnaire d'Etape lesEtapes
     * @return GestionnaireEtapes : Gestionnaire d'Etape lesEtapes
     */
    public GestionnaireEtapes getLesEtapes() {
        return lesEtapes;
    }

    /**
     * Methode d'ajout d'une ou plusieurs Etapes au gestionnaire d'Etapes du Monde
     * @param etapes Etape[] : les Etapes a ajouter
     */
    public void  ajouter(Etape... etapes){
        this.lesEtapes.ajouter(etapes);
    }

    /**
     * Methode retournant le nombre de Guichets contenus dans le Monde
     * @return int: le nombre de Guichets contenus dans le Monde
     */
    public int nbGuichet()
    {
        FabriqueNumero num = FabriqueNumero.getInstance();
        return num.getCptSemaphore();
    }

    /**
     * Methode retournant le nombre d'Etapes contenues dans le Monde
     * @return int: le nombre d'Etapes contenues dans le Monde
     */
    public int nbEtapes()
    {
        FabriqueNumero num = FabriqueNumero.getInstance();
        return num.getCptEtape()+1;
    }

    @Override
    public Iterator<Etape> iterator()
    {
        return lesEtapes.iterator();
    }

    /**
     * Getter du Sas d'Entree du Monde
     * @return SasEntree : Sas d'Entree du Monde
     */
    public SasEntree getEntree() {
        return entree;
    }

    /**
     * Getter du Sas de Sortie du Monde
     * @return SasSortie : Sas de Sortie du Monde
     */
    public SasSortie getSortie() {
        return sortie;
    }

    /**
     * Methode générant le code C d'un monde
     * @return String le code C d'un monde
     */
    public String toC(){
        StringBuilder str = new StringBuilder();
        str.append("#include \"def.h\"\n");
        str.append("#include <stdio.h>\n");
        str.append("#include <time.h>\n");
        str.append("\n");
        str.append("\n");
        for(Etape e : this)
        {
             str.append(e.codeCanstanteEnC());
        }
        str.append("\n");
        str.append("\n");
        str.append("void simulation(int ids)\n");
        str.append("{\n");
        Etape e =  this.getEntree();
        str.append(e.toC());
        str.append("}\n");
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Etape entree = this.getEntree();
        str.append(entree.toString());
        str.append(sortie.toString());
        return str.toString();
    }
}
