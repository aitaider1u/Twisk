package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;



public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG mondeIG;
    protected HBox information = new HBox();
    protected HBox imageEtInfo = new HBox();
    protected Label nom ;
    protected EtapeIG etapeIG;
    protected String couleur;
    protected ImageView imageEntree;
    protected ImageView imageSortie;

    public VueEtapeIG(MondeIG mondeIG,EtapeIG etape){
        TailleComposants tailleComposants = TailleComposants.getInstance();
        imageEntree = new ImageView(new Image("twisk/ressources/images/entry.png",35,35,true,true));
        imageSortie = new ImageView(new Image("twisk/ressources/images/exit.png",35,35,true,true));
        this.mondeIG = mondeIG;
        this.etapeIG = etape;
        this.nom = new Label(etape.getNom());
        this.information.getChildren().add(nom);
        this.information.setAlignment(Pos.CENTER);
        this.imageEtInfo.setAlignment(Pos.CENTER);
        this.imageEtInfo.setSpacing(5);
        this.imageEtInfo.setPadding(new Insets(0,0,0,0));
        this.imageEtInfo.getChildren().addAll(imageEntree,this.information,imageSortie);
        this.imageEtInfo.setMinWidth(tailleComposants.getLargeurActivite());
        this.imageEtInfo.setMaxWidth(tailleComposants.getLargeurActivite());
        this.getChildren().add(this.imageEtInfo);
        this.setMinSize(tailleComposants.getLargeurActivite(),tailleComposants.getHauteurActivite());
        this.relocate(etape.getPosX(),etape.getPosY());
        imageEntree.setVisible(false);
        imageSortie.setVisible(false);
        this.maseAjourDAffichage();
        this.setOnMouseClicked(event -> {
            this.mondeIG.selectioneOuDesectionEtapeIG(this.etapeIG);
            this.changerCouleurEnCasDeSelection();
        });
        this.setOnDragDetected((MouseEvent event) ->{
            Dragboard dragBroard = this.startDragAndDrop(TransferMode.MOVE);
            this.setId(this.etapeIG.getIdentifiant());
            ClipboardContent content = new ClipboardContent();
            content.putString(this.etapeIG.getIdentifiant());
            Image capture = this.snapshot(null,null);
            dragBroard.setDragView(capture);//,capture.getWidth()/2,capture.getHeight()/2);
            //dragBroard.setDragViewOffsetX(capture.getWidth()/2);
            //dragBroard.setDragViewOffsetY(capture.getHeight()/2);
            //content.putImage(capture);
            dragBroard.setContent(content);
            event.consume();
        });
    }

    @Override
    public void reagir()
    {

    }

    public void maseAjourDAffichage()
    {
            this.imageEntree.setVisible(etapeIG.estUneEntree());
            this.imageSortie.setVisible(etapeIG.estUneSortie());
    }
    public void changerCouleurEnCasDeSelection() { }
}
