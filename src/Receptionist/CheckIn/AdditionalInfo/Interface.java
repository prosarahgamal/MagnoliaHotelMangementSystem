/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receptionist.CheckIn.AdditionalInfo;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Sara
 */
public class Interface{
    
    Stage primaryStage;

    Image meal1;
    Image meal2;
    Image meal3;
    
    Image car1;
    Image car2;
    Image car3;
    Image car4;
    Image car5;
    Image car6;
    Image car7;
    
    Button previousBtn;
    Button finishBtn;
    CheckBox foodCheckBox;
    
    ImageView meal1View;
    ImageView meal2View;
    ImageView meal3View;

    CheckBox carCheckBox;
    
    ImageView car1View;
    ImageView car2View;
    ImageView car3View;
    ImageView car4View;
    ImageView car5View;
    ImageView car6View;
    ImageView car7View;
    
    CheckBox privateDriverCheckBox;

    public Interface() {
        
        primaryStage = new Stage();
        meal1 = new Image("images/meals/Breakfast.png");
        meal2 = new Image("images/meals/Breakfast & Dinner.png");
        meal3 = new Image("images/meals/Breakfast & Dinner & Lunch.png");
        
        car1 = new Image("images/cars/bmw.png");
        car2 = new Image("images/cars/infiniti.png");
        car3 = new Image("images/cars/audi.png");
        car4 = new Image("images/cars/mercedes.png");
        car5 = new Image("images/cars/nissan.png");
        car6 = new Image("images/cars/porsche.png");
        car7 = new Image("images/cars/toyota.png");
        
        previousBtn = new Button("PREVIOUS");
        finishBtn = new Button("FINISH");
        
        foodCheckBox = new CheckBox();
        carCheckBox = new CheckBox();
        
        meal1View = new ImageView(meal1);
        meal2View = new ImageView(meal2);
        meal3View = new ImageView(meal3);
        
        car1View = new ImageView(car1);
        car2View = new ImageView(car2);
        car3View = new ImageView(car3);
        car4View = new ImageView(car4);
        car5View = new ImageView(car5);
        car6View = new ImageView(car6);
        car7View = new ImageView(car7);
        
        privateDriverCheckBox = new CheckBox();
    }
    
    
    
    
    public void start() {
        
        
        
        BorderPane page = new BorderPane();
        
        VBox btns = new VBox(70);
        
        VBox options = new VBox(50);
        
        VBox foodBox = new VBox(10);
        HBox food = new HBox(5);
        HBox foodOptions = new HBox(5);
        
        VBox carBox = new VBox(10);
        HBox car = new HBox(5);
        HBox carOptions = new HBox();
        HBox carPrivateDriver = new HBox(5);
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
        
        previousBtn.getStyleClass().add("btn");
        
        finishBtn.getStyleClass().add("finishBtn");
        
        btns.getChildren().addAll(previousBtn, finishBtn);
        btns.setPadding(new Insets(200, 100, 0, 100));
        
        
        Label foodLbl = new Label("FOOD");
        
        food.getChildren().addAll(foodCheckBox, foodLbl);

        meal1View.getStyleClass().add("view");
        meal2View.getStyleClass().add("view");
        meal3View.getStyleClass().add("view");
        
        foodOptions.getChildren().addAll(meal1View, meal2View, meal3View);
        foodOptions.setPadding(new Insets(0, 0, 0, 15));
        
        foodBox.getChildren().addAll(food, foodOptions);
        
        
        Label carLbl = new Label("CAR");
        
        car.getChildren().addAll(carCheckBox, carLbl);
        
        car1View.getStyleClass().add("view");
        car2View.getStyleClass().add("view");
        car3View.getStyleClass().add("view");
        car4View.getStyleClass().add("view");
        car5View.getStyleClass().add("view");
        car6View.getStyleClass().add("view");
        car7View.getStyleClass().add("view");
        
        
        carOptions.getChildren().addAll(car1View, car2View, car3View, car4View, car5View, car6View, car7View);
        carOptions.setPadding(new Insets(0, 0, 0, 15));
        
        
        Label privateDriverLbl = new Label("PRIVATE DRIVER");
        
        carPrivateDriver.getChildren().addAll(privateDriverCheckBox, privateDriverLbl);
        carPrivateDriver.setPadding(new Insets(50, 0, 0, 0));
        
        carBox.getChildren().addAll(car, carOptions, carPrivateDriver);
        carBox.setPadding(new Insets(0, 0, 0, 10));
        
        options.getChildren().addAll(foodBox, carBox);
        options.setPadding(new Insets(50, 0, 0, 0));
        
        
        page.setTop(logoView);
        page.setLeft(btns);
        page.setCenter(options);
        
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckIn/AdditionalInfo/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
