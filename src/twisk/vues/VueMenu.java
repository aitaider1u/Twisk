package twisk.vues;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.util.Duration;
import twisk.exceptions.TwiskException;
import twisk.monde.Etape;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;
import java.util.Optional;

public class VueMenu extends MenuBar implements Observateur {
    private MondeIG mondeIG;
    private MenuItem renommer;
    private MenuItem delai;
    private MenuItem ecart;
    private MenuItem nbJetons;

    public VueMenu(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
        Menu fichier = new Menu("Fichier");
        Menu edition = new Menu("Edition");
        Menu monde = new Menu("Monde");
        Menu paramettre = new Menu("Paramettre");
        MenuItem quitter = new MenuItem("Quiter");
        fichier.setOnAction(event -> Platform.exit());
        MenuItem supprimer = new MenuItem("Supprimer");
        supprimer.setOnAction(event -> { this.mondeIG.supprimerLesEtapeSelectionerEtArcsAttaches();});
        renommer = new MenuItem("Renommer");
        this.renommer.setDisable(true);
        renommer.setOnAction(event -> {
            TextInputDialog dial = new TextInputDialog("Etape");
            Optional<String> result = dial.showAndWait();
            String entered = "";
            if (result.isPresent()) {

                entered = result.get();
            }
            this.mondeIG.renommerNomEtapeSelectioner(entered);
            this.renommer.setDisable(true);
        });
        MenuItem supprimerLaSelection = new MenuItem("Supprimer La Selection");
        supprimerLaSelection.setOnAction(event -> { this.mondeIG.supprimerLaListeDesElementsSelectioner();
        });
        MenuItem entree = new MenuItem("Entrée");
        entree.setOnAction(event -> this.mondeIG.changerLesEntree());
        MenuItem sortie= new MenuItem("Sortie");
        sortie.setOnAction(event -> this.mondeIG.changerLesSortie());
        monde.getItems().addAll(entree,sortie);
        fichier.getItems().add(quitter);
        edition.getItems().addAll(supprimer,renommer,supprimerLaSelection);

        delai = new MenuItem("Délai");
        ecart = new MenuItem("Écart");
        nbJetons= new MenuItem("Nombre de Jetons");
        this.delai.setDisable(true);
        this.ecart.setDisable(true);
        delai.setOnAction(event ->
        {
            TextInputDialog dial = new TextInputDialog("4");
            Optional<String> result = dial.showAndWait();
            String entered = "";
            if (result.isPresent())
                entered = result.get();
            try
            {
                this.mondeIG.changerLeTempDeLetapeSelectione(entered);
            }
            catch(TwiskException e)
            {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText(e.getMessage());
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(10000));
                pauseTransition.play();
                pauseTransition.setOnFinished(event1 -> a.close());
                a.showAndWait();
            }
        });

        ecart.setOnAction(event ->
        {
            TextInputDialog dial = new TextInputDialog("4");
            Optional<String> result = dial.showAndWait();
            String entered = "";
            if (result.isPresent())
                entered = result.get();
            try
            {
                this.mondeIG.changerLeDeltaTempDeLetapeSelectione(entered);
            }
            catch(TwiskException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(e.getMessage());
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(10000));
                pauseTransition.play();
                pauseTransition.setOnFinished(event1 -> alert.close());
                alert.showAndWait();
            }
        });
        nbJetons.setOnAction(event -> {
            TextInputDialog dial = new TextInputDialog("4");
            Optional<String> result = dial.showAndWait();
            String entered = "";
            if (result.isPresent())
                entered = result.get();
            try
            {
                this.mondeIG.changerNbJetonsDuGuichetSelectione(entered);
            }
            catch(TwiskException e)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(e.getMessage());
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(10000));
                pauseTransition.play();
                pauseTransition.setOnFinished(event1 -> alert.close());
                alert.showAndWait();
            }
        });
        paramettre.getItems().addAll(delai,ecart,nbJetons);
        this.getMenus().addAll(fichier,edition,monde,paramettre);
        this.mondeIG.ajouterObservateur(this);
    }




    @Override
    public void reagir(){

            if (this.mondeIG.nbrEtapesSelectionee()==1) {
                this.renommer.setDisable(false);
                Iterator<EtapeIG> ite = mondeIG.iteratorEtapeSelectionnee();
                EtapeIG etape = ite.next();
                if (etape.estUneActivite()) {
                    this.renommer.setDisable(false);
                    this.delai.setDisable(false);
                    this.ecart.setDisable(false);
                }else if(etape.estUnGuichet()){
                    this.nbJetons.setDisable(false);
                }
            }
            else {
                this.renommer.setDisable(true);
                this.ecart.setDisable(true);
                this.delai.setDisable(true);
                this.nbJetons.setDisable(true);

            }
        }



}
