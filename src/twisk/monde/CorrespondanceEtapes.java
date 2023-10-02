package twisk.monde;

import twisk.mondeIG.EtapeIG;

import java.util.HashMap;

public class CorrespondanceEtapes {
    private HashMap<EtapeIG,Etape> Correspondance = new HashMap<>();
    public CorrespondanceEtapes() {
    }
    public void ajouter(EtapeIG etapeIG, Etape etape) { this.Correspondance.put(etapeIG,etape); }
    public Etape get(EtapeIG etapeIG){return  this.Correspondance.get(etapeIG);}
}
