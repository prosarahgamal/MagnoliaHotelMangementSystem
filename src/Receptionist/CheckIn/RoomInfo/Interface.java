
package Receptionist.CheckIn.RoomInfo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

    Stage primaryStage = new Stage();
    
    public static Image header = new Image("/images/header.png");
    public static Image account = new Image("/images/menuAccount.png");
    public static Image menu = new Image("/images/menuButton.png");
    
    public static Image [] roomTypes;
    private Image [] roomViewsImgs;
    private Image [] smokeOrNot;
    
    ImageView [] roomTypesViews;
    ImageView [] roomViews;
    ImageView [] smokeView;
    
    ImageView accountView;
    ImageView menuView;
    
    DatePicker dateTxt;
    
    Button getRoom;

    public Interface() {

        dateTxt = new DatePicker();
        accountView = new ImageView(account);
        menuView = new ImageView(menu);
        getRoom = new Button("GET A ROOM");
        
        roomTypes = new Image[7];
        
        roomTypes[0] = new Image("/images/roomsTypes/single.png");
        roomTypes[1] = new Image("/images/roomsTypes/double.png");
        roomTypes[2] = new Image("/images/roomsTypes/triple.png");
        roomTypes[3] = new Image("/images/roomsTypes/quad.png");
        roomTypes[4] = new Image("/images/roomsTypes/queen.png");
        roomTypes[5] = new Image("/images/roomsTypes/king.png");
        roomTypes[6] = new Image("/images/roomsTypes/studio.png");
        
        roomViewsImgs = new Image[2];
        
        roomViewsImgs[0] = new Image("/images/roomsViews/green.png");
        roomViewsImgs[1] = new Image("/images/roomsViews/blue.png");
        
        smokeOrNot = new Image[2];
        
        smokeOrNot[0] = new Image("/images/smoke/nonsmoke.png");
        smokeOrNot[1] = new Image("/images/smoke/smoker.png");
        
        roomTypesViews = new ImageView[7];
        roomViews = new ImageView[2];
        smokeView = new ImageView[2];
        
        for (int i = 0; i < roomTypesViews.length; i++) {
            roomTypesViews[i] = new ImageView(roomTypes[i]); 
        }

        for (int i = 0; i < roomViews.length; i++) {
            roomViews[i] = new ImageView(roomViewsImgs[i]);
        }

        for (int i = 0; i < smokeView.length; i++) {
            smokeView[i] = new ImageView(smokeOrNot[i]);
        }
        
    }
    
    
    
    public void start() {
        
        
        
        BorderPane page = new BorderPane();
        VBox sideMenu = new VBox(50);
        VBox infoBox = new VBox(30);
        HBox dateBox = new HBox(30);
        VBox typeBox = new VBox(10);
        VBox viewBox = new VBox(10);
        VBox smokeBox = new VBox(10);
        HBox types = new HBox();
        HBox views = new HBox();
        HBox smoke = new HBox();
        Pane getRoomPane = new Pane();
        
        sideMenu.setPadding(new Insets(300, 0, 0, 20));
        
        infoBox.setPadding(new Insets(20, 0, 0, 50));
        
        dateBox.setPadding(new Insets(0, 0, 0, 650));
        
        types.setPadding(new Insets(0, 0, 0, 40));
        views.setPadding(new Insets(0, 0, 0, 40));
        smoke.setPadding(new Insets(0, 0, 0, 40));
        
        getRoomPane.setPadding(new Insets(300, 100, 0, 0));
        
        
        
        ImageView headerView = new ImageView(header);
        
        
        
        sideMenu.getChildren().addAll(accountView, menuView);
        
        Label dateLbl = new Label("ARRIVE DATE");
        
        dateLbl.getStyleClass().add("lbl");
        dateTxt.getStyleClass().add("datePick");
        
        dateBox.getChildren().addAll(dateLbl, dateTxt);
        
        Label typeLbl = new Label("ROOM TYPE");
        Label viewLbl = new Label("VIEW");
        Label smokeLbl = new Label("SMOKING");
        typeLbl.getStyleClass().add("lbl");
        viewLbl.getStyleClass().add("lbl");
        smokeLbl.getStyleClass().add("lbl");
        
        
        
        for (int i = 0; i < roomTypesViews.length; i++) {
            types.getChildren().add(roomTypesViews[i]);
            roomTypesViews[i].getStyleClass().add("type");
        }
        
        
        
        for (int i = 0; i < roomViews.length; i++) {
            views.getChildren().add(roomViews[i]);
            roomViews[i].getStyleClass().add("type");
        }
        
        
        
        for (int i = 0; i < smokeView.length; i++) {
            smoke.getChildren().add(smokeView[i]);
            smokeView[i].getStyleClass().add("type");
        }
        
        typeBox.getChildren().addAll(typeLbl, types);
        viewBox.getChildren().addAll(viewLbl, views);
        smokeBox.getChildren().addAll(smokeLbl, smoke);
        
        infoBox.getChildren().addAll(dateBox, typeBox, viewBox, smokeBox);
        
        
        getRoomPane.getChildren().add(getRoom);
        getRoom.getStyleClass().add("btn");
        
        
        page.setTop(headerView);
        page.setLeft(sideMenu);
        page.setRight(getRoomPane);
        BorderPane.setAlignment(sideMenu, Pos.CENTER);
        page.setCenter(infoBox);
        
       
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckIn/RoomInfo/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
}
