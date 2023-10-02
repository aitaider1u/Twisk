package twisk.vues;

import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueGuichetIG extends VueEtapeIG implements Observateur {
    private Label nbrJetons;
    private HBox file;

    public VueGuichetIG(MondeIG mondeIG, EtapeIG etape) {
        super(mondeIG, etape);
        this.couleur = "green";
        this.nbrJetons = new Label(" : "+etape.getNbJetons()+" Jetons");
        this.information.getChildren().add(nbrJetons);
        this.information.setAlignment(Pos.CENTER);
        file = new HBox();
        for (int i = 0 ; i<7;i++)
        {
            HBox zone = new HBox();
            zone.setMinSize(TailleComposants.getInstance().getHauteurActivite()*0.30,TailleComposants.getInstance().getHauteurActivite()*0.30);
            zone.setMaxSize(TailleComposants.getInstance().getHauteurActivite()*0.30,TailleComposants.getInstance().getHauteurActivite()*0.30);
            zone.setStyle("-fx-background-color : #cecece;-fx-border-color: black;");
            file.getChildren().add(zone);
        }
        this.setAlignment(Pos.CENTER);
        file.setAlignment(Pos.CENTER);
        file.setMinSize(TailleComposants.getInstance().getLargeurActivite()*0.80,TailleComposants.getInstance().getHauteurActivite()*0.30);
        file.setMaxSize(TailleComposants.getInstance().getLargeurActivite()*0.80,TailleComposants.getInstance().getHauteurActivite()*0.30);
        this.getChildren().addAll(this.file);
        //file.setStyle("-fx-background-color : #cecece;-fx-border-color: black;");
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
