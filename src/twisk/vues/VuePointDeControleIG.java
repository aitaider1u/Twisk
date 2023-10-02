package twisk.vues;
import javafx.scene.Cursor;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

public class VuePointDeControleIG extends Circle implements Observateur {

    private PointDeControleIG pointDeControleIG ;
    private EtapeIG etapeIG;
    private MondeIG mondeIG;
    public VuePointDeControleIG(MondeIG mondeIG, EtapeIG etapeIG, PointDeControleIG point, double centerX, double centerY, double radius) {
            super(centerX, centerY, TailleComposants.getInstance().getRaduinPointDeControl());
            this.mondeIG = mondeIG;
            this.etapeIG = etapeIG;
            this.pointDeControleIG = point;
            this.setFill(Color.web("#FD46F5"));
            this.setCursor(Cursor.CROSSHAIR);
    }

    @Override
    public void reagir()
    {

    }
}
