package com.example.project2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Peaklass extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane1 = new BorderPane();
        BorderPane borderPane2 = new BorderPane();
        //loodud 2 tab-i üldisele aknale
        Label label1 = new Label("Krüpteeri tekst");
        HBox hBox = new HBox(label1);
        label1.setFont(new Font("Helvetica", 20));
        hBox.setAlignment(Pos.CENTER);

        Label label2 = new Label("Dekrüpteeri tekst");
        HBox hBox2 = new HBox(label2);
        label2.setFont(new Font("Helvetica", 20));
        hBox2.setAlignment(Pos.CENTER);

        //mõlemad hBoxid lisatud borderpane ülesse, et oleks nn tab-id/vahelehed
        borderPane1.setTop(hBox);
        borderPane2.setTop(hBox2);

        //lisatud üles textbox, kuhu kasutaja saab teksti lisada
        TextArea textArea = new TextArea("");
        textArea.setPromptText("Sisesta tekst, mida krüpteerida");
        VBox tekst = new VBox(textArea);
        tekst.setAlignment(Pos.CENTER);
        borderPane1.setCenter(tekst);
        //tekstboxi alla lisatud uus textfield, kuhu kasutaja saab nihke sisestada
        TextField nihe = new TextField("");
        nihe.setPromptText("Sisesta nihe, täisarvuna");
        Button button = new Button("Krüpteeri");
        //nupud krüpteerimiseks ja dekrüpteerimiseks
        VBox nupp = new VBox(nihe,button);
        nupp.setSpacing(20.0);

        nupp.setAlignment(Pos.CENTER);
        nupp.setPadding(new Insets(50, 50, 50, 50));

        borderPane1.setBottom(nupp);

        TextArea väljund = new TextArea();

        väljund.setEditable(false);

        VBox tekstVäljund = new VBox(väljund);
        tekstVäljund.setAlignment(Pos.CENTER);
        borderPane2.setCenter(tekstVäljund);

        Button button2 = new Button("Vali fail mida dekrüpteerida");
        TextField nihe2 = new TextField("");
        nihe2.setPromptText("Sisesta nihe, täisarvuna");

        VBox nupp2 = new VBox(nihe2, button2);
        nupp2.setSpacing(20);

        nupp2.setAlignment(Pos.CENTER);
        nupp2.setPadding(new Insets(50, 50, 50, 50));

        borderPane2.setBottom(nupp2);
        //kui dekrüpteerida, käivitub event:
        //avaneb failiavamisaken, kust saab faili valida
        //loetakase krüpteeritud tekst uueks Krüpteering-u isendiks
        //väljundi tekstiks sätestatakse krüteeringu isend, millele rakendatud dekrüpteeringu meetod,
        //ehk väljundiks kasutajale kuvatavaks tekstiks saab dekrüpteeritud tekst.
        //dekrüpteeritakse vastavalt kasutaja antud nihkele, ehk kui nihe on vale, on ka väljund vale
        button2.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);

            Krüpteering krüpteering = null;
            try {
                krüpteering = new Krüpteering(Files.readString(file.toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            väljund.setText(krüpteering.deKrypteeri(Integer.parseInt(nihe2.getText())));

        });

        //kui vajutada krüpteeri nuppu, proovitakse luua sisestatud tekstiga isend krüpteering
        //kui sõne on tühi ehk isend viskab erindi, püütakse see kinni ning kasutajale ilmub ette
        //error box (alert isend), kus öeldakse, et tühi tekstiväli ning et proovige uuesti.
        //kui tekst on olemas, siis luuakse uus fail krüpteeritud.txt ning kirjutatakse krüpteeritud tekst vastava nihkega
        //loodud faili
        button.setOnAction(event -> {
            try{
                Krüpteering krüpteering = new Krüpteering(textArea.getText());
                File file = new File("krüpteeritud.txt");
                try {
                    Files.writeString(file.toPath(), krüpteering.krypteeri(Integer.parseInt(nihe.getText())));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }catch(Erind e){
                System.out.println("Tühi tektstiväli!");
                Alert alert = new Alert(Alert.AlertType.ERROR, "Tühi tekstiväli, proovige uuesti!");
                alert.showAndWait();
                //if (alert.getResult() == ButtonType.YES) {
                //    alert.close();
                //}
            }
        });




        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Krüpteeri", borderPane1);
        Tab tab2 = new Tab("Dekrüpteeri", borderPane2);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);




        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox, 500, 500);
        primaryStage.setScene(scene);
        Image image = new Image("caesar.png");
        primaryStage.getIcons().add(image);


        primaryStage.setTitle("Caseari krüpteering");

        primaryStage.show();
    }
}
