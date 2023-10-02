package twisk.monde;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape>{

    private ArrayList<Etape> lesEtapes = new ArrayList<>();
    public GestionnaireEtapes() {
    }
    public GestionnaireEtapes(Etape... etapes){
          this.lesEtapes.addAll(Arrays.asList(etapes));
    }

    /**
     * Methode d'ajout d'une ou plusieurs Etapes au gestionnaire d'étapes
     * @param etapes Etape[] : la ou les Etapes a ajouter
     */
    public void ajouter(Etape... etapes)
    {
        this.lesEtapes.addAll(Arrays.asList(etapes));
    }

    /**
     * Methode comptant la taille du gestionnaire d'Etapes
     * @return int : le nombre d'Etapes
     */
    public int nbEtapes()
    {
        return this.lesEtapes.size();
    }

    /**
     * Methode créant l'iterateur du gestionaire d'Etapes
     * @return Iterator<Etape> : l'iterateur du gestionaire d'Etapes
     */
    @Override
    public Iterator<Etape> iterator() {
        return lesEtapes.iterator();
    }
}
