package twisk.vues;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import twisk.exceptions.TwiskException;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

import java.util.Iterator;


public class VueMondeIG extends Pane implements Observateur {
    private MondeIG mondeIG;
    public VueMondeIG(MondeIG mondeIG) {
        this.mondeIG = mondeIG;
        this.mondeIG.ajouterObservateur(this);
        this.setOnMouseClicked(event -> {try {
                this.mondeIG.ajouter(new PointDeControleIG(event.getX(),event.getY()));
            }
            catch (TwiskException e)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.setContentText("");
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(10000));
                pauseTransition.play();
                pauseTransition.setOnFinished(event1 -> alert.close());
                alert.show();
            }
        });


        this.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != this && event.getDragboard().getString().contains("Etape"))
            {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        this.setOnDragDropped((DragEvent event) -> {
            boolean success = false;
            if (event.getDragboard().getString().contains("Etape")){
                event.acceptTransferModes(TransferMode.MOVE);
                String nodeId = event.getDragboard().getString();
                if(nodeId != null)
                {
                    this.mondeIG.deplacerEtape(event.getDragboard().getString(),(int)event.getX()+TailleComposants.getInstance().getLargeurActivite()/2,(int) event.getY()+TailleComposants.getInstance().getHauteurActivite()/2);
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
    }

    @Override
    public void reagir(){
        if(this.mondeIG.estChangementDansLeMonde()) {
            this.getChildren().clear();
            this.ajouterLesVueArcsDansVueMonde();

            for(EtapeIG e : mondeIG)
            {
                VueEtapeIG vueEtapeIG;
                if(e.estUneActivite()){
                    vueEtapeIG = new VueActiviteIG(mondeIG,e);
                    this.getChildren().addAll(vueEtapeIG);
                }
                else if( e.estUnGuichet()){
                    vueEtapeIG = new VueGuichetIG(mondeIG,e);
                    this.getChildren().addAll(vueEtapeIG);
                }
                this.ajouterVuePntDeCtrlDansVueMonde(e);
            }
    }

    }

    public void ajouterVuePntDeCtrlDansVueMonde(EtapeIG etapeIG)
    {
        for(PointDeControleIG point : etapeIG)
        {
            VuePointDeControleIG vuePoint = new VuePointDeControleIG(mondeIG,etapeIG,point,point.getPosCentreX(),point.getPosCentreY(),20);
            this.getChildren().add(vuePoint);
        }
    }

    public void ajouterLesVueArcsDansVueMonde()
    {
        Iterator<ArcIG> ite =this.mondeIG.iteratorArcs();
        while (ite.hasNext())
        {
            ArcIG arcIG = ite.next();
            if(arcIG.estUneLigneDroiteIG()){
                VueArcIG vueArcIG = new VueLigneDroiteIG(this.mondeIG,arcIG);
                this.getChildren().add(vueArcIG);
            }
            else if (arcIG.estCourbeIG())
            {
                VueArcIG vueArcIG = new VueCourbeIG(this.mondeIG,arcIG);
                this.getChildren().add(vueArcIG);
            }
        }
    }

}
