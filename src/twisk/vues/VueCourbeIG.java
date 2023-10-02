package twisk.vues;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import twisk.mondeIG.ArcIG;

import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueCourbeIG extends VueArcIG {
    public VueCourbeIG(MondeIG mondeIG, ArcIG arcIG) {
        super(mondeIG,arcIG);
        CubicCurve courbe1 = new CubicCurve();
        courbe1.setStartX(arcIG.getPointDeControleIGIndex(0).getPosCentreX());
        courbe1.setStartY(arcIG.getPointDeControleIGIndex(0).getPosCentreY());
        courbe1.setControlX1(arcIG.getPointDeControleIGIndex(1).getPosCentreX());
        courbe1.setControlY1(arcIG.getPointDeControleIGIndex(1).getPosCentreY());
        courbe1.setControlX2(arcIG.getPointDeControleIGIndex(2).getPosCentreX());
        courbe1.setControlY2(arcIG.getPointDeControleIGIndex(2).getPosCentreY());
        courbe1.setEndX(arcIG.poitCentreDuSegmentBasDuTriangle()[0]);
        courbe1.setEndY(arcIG.poitCentreDuSegmentBasDuTriangle()[1]);
        courbe1.setFill(null);
        courbe1.setStyle("-fx-border-color: black;");
        courbe1.setStrokeWidth(TailleComposants.getInstance().getLargeurVueArc());
        courbe1.setCursor(Cursor.OPEN_HAND);
        courbe1.setOnMouseClicked(event -> this.mondeIG.selectioneOuDesectiondUnArc(this.arcIG));
        if(arcIG.estSelectionner()){
            courbe1.setStroke(Color.RED);
        }else{
            courbe1.setStroke(Color.BLACK);
        }
        this.getChildren().addAll(courbe1);
    }

        @Override
        public void reagir(){
        }

}
