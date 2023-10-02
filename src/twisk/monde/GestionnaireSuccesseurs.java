package twisk.monde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GestionnaireSuccesseurs implements Iterable<Etape>{
    private  ArrayList<Etape> successeur = new ArrayList<>();

    public GestionnaireSuccesseurs(){

    }

    /**
     * Methode d'ajout d'une ou plusieurs Etapes au gestionnaire de successeurs d'une Etape
     * @param etape Etape[] : la ou les Etapes a ajouter
     */
    public void ajouter(Etape... etape)
    {
        successeur.addAll(Arrays.asList(etape));
    }

    /**
     * Methode comptant le nombre de successeurs d'une Etape
     * @return int le nombre de successeurs d'une Etape
     */
    public int nbEtapes()
    {
        return this.successeur.size();
    }

    /**
     * Methode Creant l'itérateur sur les successeurs d'une Etape
     * @return Iterator<Etape> : l'itérateur sur les successeurs d'une Etape
     */
    @Override
    public Iterator<Etape> iterator()
    {
        return successeur.iterator();
    }

    /**
     * Methode retourant le successeur d'indice "indice" d'une Etape
     * @param indice int : l'indice désiré
     * @return Etape : l'Etape d'indice "indice"
     */
    public Etape getSuccesseurIndice(int indice)
    {
        return this.successeur.get(indice);
    }
}
