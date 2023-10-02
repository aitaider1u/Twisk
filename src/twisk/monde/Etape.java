package twisk.monde;
import twisk.outils.FabriqueNumero;

import java.text.Normalizer;
import java.util.Iterator;

public abstract class  Etape implements Iterable<Etape>{
    private String nom;
    private int numeroEtape;
    private GestionnaireSuccesseurs lesSuccesseurs ;



    public Etape(String nom) {
        FabriqueNumero numero = FabriqueNumero.getInstance();
        this.numeroEtape = numero.numeroterEtape();
        this.nom = nom;
        lesSuccesseurs = new GestionnaireSuccesseurs();
    }

    /**
     * Methode comptant le nombre de Successeurs d'une Etape
     * @return int : le nombre de Successeurs d'une Etape
     */
    public int nbSuccesseurs()
    {
        return this.lesSuccesseurs.nbEtapes();
    }

    /**
     * Methode d'ajout de Successeurs à une Etape
     * @param e Etape[] : Tableau d'étapes
     */
    public void ajouterSuccesseur(Etape... e)
    {
        this.lesSuccesseurs.ajouter(e);
    }

    /**
     * Methode indiquant si une Etape est une activité
     * @return boolean : retourne False si appliquée à une Etape qui n'est pas une Activité
     */
    public boolean estUneActivite()
    {
        return false;
    }

    /**
     * Methode indiquant si une Etape est un Guichet
     * @return boolean : retourne False si appliquée à une Etape qui n'est pas un Guichet
     */
    public boolean estUnGuichet()
    {
        return false;
    }

    /**
     * Methode retournant l'iterateur de successeurs d'une Etape
     * @return Iterator<Etape> : l'itérateur des successeurs d'une Etape
     */
    public Iterator<Etape> iterator()
    {
        return this.lesSuccesseurs.iterator();
    }

    /**
     * Getter du nom de l'Etape
     * @return String le nom de l'Etape
     */
    public String getNom() {
        return nom;
    }

    /**
     * Methode présentant le nom de l'Etape, ainsi que son nombre de Successeurs et leurs noms
     * @return String La chaine de caractères détaillant les informations d'une Etape
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.nom+" : "+this.nbSuccesseurs() +" successeur - ");
        for(Etape e : this.lesSuccesseurs)
        {
            str.append(e.getNom()).append(", ");
        }
        str.append("\n");
        for(Etape e : this.lesSuccesseurs)
        {
            if (!e.estUneSortie())
                str.append(e.toString());
        }
        return str.toString();
    }

    /**
     * Methode pour renommner une Etape (Setter)
     * @param nom String : le nom à écrire
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Methode retournant le numéro d'une Etape (Getter)
     * @return int : le nombre numéro d'une Etape
     */
    public int getNumeroEtape() {
        return numeroEtape;
    }

    /**
     * Methode retournant le Gestionnaire des successeurs d'une Etape (Getter)
     * @return GestionnaireSuccesseurs : le Gestionnire de successeurs
     */
    public GestionnaireSuccesseurs getLesSuccesseurs() {
        return lesSuccesseurs;
    }

    /**
     * Methode retournant le successeur d'indice donné en paramètre
     * @param indice int : l'indice du successeur désiré (commence par 0)
     * @return Etape : le Successeur d'indice i d'une etape
     */
    public Etape getSuccesseurIndice(int indice)
    {
        return this.lesSuccesseurs.getSuccesseurIndice(indice);
    }

    /**
     * Methode sans paramètres retournant le code C d'une Etape
     * @return String : le code C de l'Etape
     */
    public String toC() {
        return "";
    }

    /**
     * Getter du Temps passé dans une Etape
     * @return int le Temps moyen temps
     */
    public int getTemps(){ return 0; }

    /**
     * Getter de l'ecart moyen de temps passé dans une Etape
     * @return int : l'ecart moyen ecartTemps
     */
    public int getEcartTemps() { return 0 ;}

    /**
     * Methode testant si une Etape est une Sortie
     * @return boolean : true si c'est une sortie
     */
    public Boolean estUneSortie(){ return false;}

    /**
     * Methode testant si une Etape est une Entree
     * @return boolean : true si c'est une Entree
     */
    public Boolean estUneEntree(){ return false;}

    /**
     * Methode qui permet de constuire le nom de la constante en C a partir du nom de l'Etape
     * @return String : nom de la constante
     */
    public String nomConstanteEnC()
    {
        String str = this.nom;
        str = Normalizer.normalize(str,Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");//c'est pour eviter les accent
        return str.toUpperCase().replace(" ","_");
    }

    /**
     * Methode qui permet de creer le code C de definition de canstante en C
     * @return String : Code C de la constante
     */
    public String codeCanstanteEnC()
    {
        String str = this.nom.replace(" ","_");
        return "#define " + this.nomConstanteEnC() +" "+ this.numeroEtape+ "\n";
    }

    /**
     * Methode comptant le nombre de jetons
     * @return int : le nombre de jetons
     */
    public int getNbJetons() {
        return 0;
    }
}
