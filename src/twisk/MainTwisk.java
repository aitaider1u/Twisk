package twisk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueMenu;
import twisk.vues.VueMondeIG;
import twisk.vues.VueOutils;


public class MainTwisk extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        MondeIG mondeIG = new MondeIG();
        VueOutils outils = new VueOutils(mondeIG);
        VueMenu vueMenu = new VueMenu(mondeIG);
        VueMondeIG vuemonde = new VueMondeIG(mondeIG);
        root.setCenter(vuemonde);
        root.setBottom(outils);
        root.setTop(vueMenu);
        primaryStage.setTitle("Twisk");
        primaryStage.setScene(new Scene(root, 1600, 775));
        primaryStage.show();
    }   

    public static void main(String[] args) {
        launch(args);
    }

}
