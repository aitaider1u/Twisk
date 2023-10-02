package twisk.vues;

import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueLigneDroiteIG extends VueArcIG{

    public VueLigneDroiteIG(MondeIG mondeIG, ArcIG arcIG) {
        super(mondeIG,arcIG);
        Line ligne = new Line(arcIG.getPointDepart().getPosCentreX(),arcIG.getPointDepart().getPosCentreY(),arcIG.poitCentreDuSegmentBasDuTriangle()[0],arcIG.poitCentreDuSegmentBasDuTriangle()[1]);
        ligne.setFill(Color.web("#FD46F5"));
        getChildren().addAll(ligne);
        ligne.setStrokeWidth(TailleComposants.getInstance().getLargeurVueArc());
        ligne.setCursor(Cursor.OPEN_HAND);
        ligne.setOnMouseClicked(event -> this.mondeIG.selectioneOuDesectiondUnArc(this.arcIG));
        if(arcIG.estSelectionner())
        {
            ligne.setStroke(Color.RED);
        }
        else
        {
            ligne.setStroke(Color.BLACK);
        }

    }

    @Override
    public void reagir() {

    }
}
