package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    protected ArrayList<Observateur> observateurs = new ArrayList<>();

    public SujetObserve(){
    }

    public void ajouterObservateur(Observateur observateur)
    {
        observateurs.add(observateur);
    }

    public void notifierObservateur()
    {
        for(Observateur obs : observateurs)
            obs.reagir();
    }

}
