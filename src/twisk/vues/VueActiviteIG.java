package twisk.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueActiviteIG extends VueEtapeIG implements Observateur {
    private Label temp;
    private HBox zoneClient;

    public VueActiviteIG(MondeIG mondeIG, EtapeIG etape) {
        super(mondeIG, etape);
        this.couleur = "blue";
        this.temp = new Label(" "+etape.getTemp()+"±"+etape.getDeltaTemp());
        this.information.getChildren().add(temp);
        this.information.setAlignment(Pos.CENTER);
        zoneClient = new HBox();
        this.setAlignment(Pos.CENTER);
        zoneClient.setMinSize(TailleComposants.getInstance().getLargeurActivite()*0.80,TailleComposants.getInstance().getHauteurActivite()*0.55);
        zoneClient.setMaxSize(TailleComposants.getInstance().getLargeurActivite()*0.80,TailleComposants.getInstance().getHauteurActivite()*0.55);
        this.getChildren().addAll(this.zoneClient);
        zoneClient.setStyle("-fx-background-color : #cecece;-fx-border-color: black;");
        this.changerCouleurEnCasDeSelection();
    }


    @Override
    public void reagir(){

    }


    @Override
    public void changerCouleurEnCasDeSelection()
    {
        if (this.etapeIG.estSelectionee())
            this.setStyle("-fx-background-color: #f49090;-fx-background-radius: 10px;-fx-border-radius: 10px;-fx-border-width: 4px;-fx-border-color: RED;-fx-effect: dropshadow(three-pass-box, purple, 10, 0, 0, 0);");
        else
            this.setStyle("-fx-background-color: white;-fx-background-radius: 10px;-fx-border-radius: 10px;-fx-border-width: 2px;-fx-border-color: "+couleur+";-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.8), 10, 0, 0, 0);");
    }

}
