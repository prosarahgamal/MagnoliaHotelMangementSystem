
package Receptionist.CheckIn.RoomPicker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{

    Stage primaryStage;
    
    public static Image backArrow;
    final Image leftArrow;
    final Image rightArrow;
    final Image fullStar;
    final Image emptyStar;
    
    ImageView backArrowView;
    ImageView leftArrowView;
    ImageView rightArrowView;
    
    final ImageView fullStarView;
    final ImageView emptyStarView;
    
    Label [] lbls;
    Label [] data;
    
    Image img;

    Button takeIt;
    
    public Interface() {
        
        primaryStage = new Stage();
        
        backArrow = new Image("/images/backArrow.png");
        leftArrow = new Image("/images/leftArrow.png");
        rightArrow = new Image("/images/rightArrow.png");
        fullStar = new Image("/images/fullStar.png");
        emptyStar = new Image("/images/emptyStar.png");
        fullStarView = new ImageView(fullStar);
        emptyStarView = new ImageView(emptyStar);
        
        backArrowView = new ImageView(backArrow);
        leftArrowView = new ImageView(leftArrow);
        rightArrowView = new ImageView(rightArrow);
        
        lbls = new Label[6];
        data = new Label[6];
        
        lbls[0] = new Label("Room Type");
        lbls[1] = new Label("Room View");
        lbls[2] = new Label("Smokeing ava");
        lbls[3] = new Label("Cost");
        lbls[4] = new Label("#Reservations");
        lbls[5] = new Label("last CheckIn");
        
        for (int i = 0; i < data.length; i++) {
            data[i] = new Label();
        }
        
        takeIt = new Button("TAKE IT");
        
    }
    
    
    
    
    public void start() {
        
        
        
        BorderPane page = new BorderPane();
        VBox top = new VBox(20);
        VBox topArrowTxt = new VBox();
        Pane backArrowPane = new Pane();
        Pane txtPane = new Pane();
        Pane leftArrowPane = new Pane();
        VBox left = new VBox();
        Pane rightArrowPane = new Pane();
        VBox right = new VBox(150);
        VBox roomsArea = new VBox();
        VBox roomImg = new VBox();
        HBox rate = new HBox(5);
        HBox roomData = new HBox(200);
        HBox roomDataCol1 = new HBox(20);
        HBox roomDataCol2 = new HBox(20);
        VBox roomDataCol1Lbls = new VBox(10);
        VBox roomDataCol1Data = new VBox(10);
        VBox roomDataCol2Lbls = new VBox(10);
        VBox roomDataCol2Data = new VBox(10);
        
        //top
        ImageView headView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
        
        backArrowPane.getChildren().add(backArrowView);
        
        Label avaRooms = new Label("Available Rooms");
        txtPane.getChildren().add(avaRooms);
        avaRooms.setAlignment(Pos.CENTER);
        avaRooms.getStyleClass().add("title");
        
        topArrowTxt.getChildren().addAll(backArrowPane, txtPane);
        topArrowTxt.setPadding(new Insets(0, 0, 50, 50));
        
        top.getChildren().addAll(headView, topArrowTxt);
        
        //left right 
        
        leftArrowPane.getChildren().add(leftArrowView);
        
        left.getChildren().add(leftArrowPane);
        left.setPadding(new Insets(250, 200, 0, 150));
        
        
        rightArrowPane.getChildren().add(rightArrowView);
        
        
        takeIt.getStyleClass().add("btn");
        
        right.getChildren().addAll(rightArrowPane, takeIt);
        right.setPadding(new Insets(250, 50, 0, 200));
      
        /*         room area     */
//room image
        ImageView roomView = new ImageView(img);
        roomView.setFitHeight(300);
        roomView.setFitWidth(400);
        roomImg.getChildren().add(roomView);
        roomImg.setPadding(new Insets(0, 0, 0, 100));
//room rate
        rate.getChildren().addAll(new ImageView(fullStar), new ImageView(fullStar), new ImageView(fullStar), new ImageView(fullStar), emptyStarView);
        rate.setPadding(new Insets(30, 0, 30, 240));
        
        /*         room data                     */
// coloumn one
        
        roomDataCol1Lbls.getChildren().addAll(lbls[0], lbls[1], lbls[2]);
        roomDataCol1Data.getChildren().addAll(data[0], data[1], data[2]);
        roomDataCol1.getChildren().addAll(roomDataCol1Lbls, roomDataCol1Data);

//column two
        roomDataCol2Lbls.getChildren().addAll(lbls[3], lbls[4], lbls[5]);
        roomDataCol2Data.getChildren().addAll(data[3], data[4], data[5]);
        roomDataCol2.getChildren().addAll(roomDataCol2Lbls, roomDataCol2Data);
        
        for (int i = 0; i < lbls.length; i++) {
            lbls[i].getStyleClass().add("lbl");
            data[i].getStyleClass().add("data");
        }
        
        roomData.getChildren().addAll(roomDataCol1, roomDataCol2);
        
        roomsArea.getChildren().addAll(roomImg, rate, roomData);
        roomsArea.setPadding(new Insets(50,0,0,250));
        roomsArea.getStyleClass().add("roomArea");
        
        
        page.setTop(top);
        page.setLeft(left);
        page.setRight(right);
        page.setCenter(roomsArea);
        
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckIn/RoomPicker/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
