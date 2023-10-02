package twisk.vues;

import javafx.scene.Cursor;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;


public abstract class VueArcIG extends Pane implements Observateur {
    protected ArcIG arcIG ;
    protected Polyline triangle  = new Polyline();
    protected MondeIG mondeIG ;
    public VueArcIG(MondeIG mondeIG,ArcIG arcIG){
        this.mondeIG = mondeIG;
        this.arcIG = arcIG;
        triangle.getPoints().addAll(arcIG.pointTriangeDeFleche());
        triangle.getPoints().addAll(arcIG.getPointArrivee().getPosCentreX(),arcIG.getPointArrivee().getPosCentreY());
        triangle.setOnMouseClicked(event -> this.mondeIG.selectioneOuDesectiondUnArc(this.arcIG));
        triangle.setPickOnBounds(true);
        triangle.setCursor(Cursor.OPEN_HAND);
        this.getChildren().add(triangle);
        this.setPickOnBounds(false);

    }

    @Override
    public void reagir()
    {

    }



}
