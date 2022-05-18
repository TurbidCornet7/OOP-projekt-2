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

        Label label1 = new Label("Krüpteeri tekst");
        HBox hBox = new HBox(label1);
        label1.setFont(new Font("Helvetica", 20));
        hBox.setAlignment(Pos.CENTER);

        Label label2 = new Label("Dekrüpteeri tekst");
        HBox hBox2 = new HBox(label2);
        label2.setFont(new Font("Helvetica", 20));
        hBox2.setAlignment(Pos.CENTER);


        borderPane1.setTop(hBox);
        borderPane2.setTop(hBox2);

        TextArea textArea = new TextArea("");
        textArea.setPromptText("Sisesta tekst, mida krüpteerida");
        VBox tekst = new VBox(textArea);
        tekst.setAlignment(Pos.CENTER);
        borderPane1.setCenter(tekst);

        TextField nihe = new TextField("");
        nihe.setPromptText("Sisesta nihe, täisarvuna");

        Button button = new Button("Krüpteeri");

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
        Image image = new Image("https://lh3.googleusercontent.com/8UVva4HhOxREWiIOtB2eGYFcGhXuwJU5VOqHD60BrCSPJCsQhG5VWqmZsO37hOmVx3OAok73Llt_ol4xPVxSbBxezuJJJHFqSPXH=w600");
        primaryStage.getIcons().add(image);


        primaryStage.setTitle("Caseari krüpteering");

        primaryStage.show();
    }
}
