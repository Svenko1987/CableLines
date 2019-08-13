package sample.scenes;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CreateScene {
    Scene createScene;

    BorderPane root=new BorderPane();

    HBox hB =new HBox(10);

    GridPane centerArea= new GridPane();

    Label lineNameLb =new Label("Line name");
    Label linePurposeLb =new Label("Line purpose");
    Label cableLb =new Label("Cable type");
    Label amountLb =new Label("Cable amount");
    Label floorLb =new Label("Line floor");

    TextField lineNameTf = new TextField();
    TextField linePurposeTf = new TextField();
    TextField cableTf = new TextField();
    TextField amountTf = new TextField();
    TextField floorTf = new TextField();

    Button submitBt= new Button("Submit");
    Button resetBt= new Button("Reset");




    Button goToCableBt = new Button("Go to Cable");
    Button goToTotalBt = new Button("Go to Total");


    public CreateScene() {
        this.createScene = new Scene(root, 300,400);
        this.createScene.getStylesheets().add("tt.css");
        this.root.setCenter(this.centerArea);
        addToCentralLayout();
        changeColorE();
        changeColorRed();
        addToLayout();
        this.root.setBottom(hB);

    }

    public Scene getCreateScene() {
        return createScene;
    }
    private  void addToLayout(){
        this.hB.getChildren().addAll(this.goToCableBt,this.goToTotalBt);
    }
    private void addToCentralLayout (){
        this.centerArea.add(this.lineNameLb,0,0);
        this.centerArea.add(this.lineNameTf,1,0);
        this.centerArea.add(this.linePurposeLb,0,1);
        this.centerArea.add(this.linePurposeTf,1,1);
        this.centerArea.add(this.cableLb,0,2);
        this.centerArea.add(this.cableTf,1,2);
        this.centerArea.add(this.amountLb,0,3);
        this.centerArea.add(this.amountTf,1,3);
        this.centerArea.add(this.floorLb,0,4);
        this.centerArea.add(this.floorTf,1,4);
        this.centerArea.add(this.submitBt,0,5);
        this.centerArea.add(this.resetBt,1,5);



    }
    private void changeColorE(){
        this.goToCableBt.setPrefSize(100,50);
        this.goToCableBt.setOnAction(actionEvent -> {
            this.goToCableBt.setText("Orange");
            this.goToTotalBt.setText("Not clicked");
            this.hB.setStyle("-fx-background-color: #F0591E;");
        });
    }
    private void changeColorRed(){
        this.goToTotalBt.setPrefSize(100,50);
        this.goToTotalBt.setOnAction(actionEvent -> {
            this.goToTotalBt.setText("Red");
            this.goToCableBt.setText("Not clicked");
            this.hB.setStyle("-fx-background-color: #FF0000;");
        });
    }
}
