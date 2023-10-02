package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import twisk.exceptions.MondeException;
import twisk.mondeIG.MondeIG;

import java.nio.file.Path;


public class VueOutils extends TilePane implements Observateur {
    private Button ajouterActivite = new Button();
    private Button ajouterGuichet = new Button();
    private Button simuler = new Button();

    private MondeIG mondeIG;

    public VueOutils(MondeIG mondeIG){
        this.ajouterActivite.setGraphic(new ImageView(new Image("twisk/ressources/images/plus.png",60,60,true,true)));
        this.ajouterGuichet.setGraphic(new ImageView(new Image("twisk/ressources/images/plusGuichet.png",60,60,true,true)));
        this.simuler.setGraphic(new ImageView(new Image("twisk/ressources/images/simuler.png",60,60,true,true)));
        this.mondeIG = mondeIG;
        Tooltip tooltip = new Tooltip("ajouterActivite une Activité");
        tooltip.setShowDelay(new Duration(100));
        this.setPadding(new Insets(10,10,10,20));
        this.setAlignment(Pos.CENTER);
        this.ajouterActivite.setTooltip(tooltip);
        this.getChildren().addAll(ajouterActivite,ajouterGuichet,simuler);
        this.ajouterActivite.setOnAction(event -> this.mondeIG.ajouter("Activité"));
        this.ajouterGuichet.setOnAction(event -> this.mondeIG.ajouter("Guichet"));
        this.simuler.setOnAction(event -> {
            try {
                this.mondeIG.simuler();
            } catch (MondeException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
            }

        });

    }

    @Override
    public void reagir(){

    }
}