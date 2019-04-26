
package Receptionist.CheckIn.GuestInfo;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
//values for padding
    final int space1 = 50;
    final int space2 = 30;
    final int space3 = 10;
    final int space4 = 100;
    
    Stage primaryStage;
    
    TextField firstNameTxt;
    TextField middleNameTxt;
    TextField lastNameTxt;
    
    TextField idTxt;
    TextField emailTxt;
    TextField mobileTxt;
    
    TextField numOfDaysTxt;
    
    RadioButton female;
    RadioButton male;
    ToggleGroup genderGroup;

    CheckBox updateCheckBox;
    ComboBox<String> statusComboBox;
    
    TextArea addressTxt;
    
    Button nextBtn;
    Button clearBtn;
    Button cancelBtn;

    
    public Interface() {
        
        primaryStage = new Stage();
        
        firstNameTxt = new TextField();
        middleNameTxt = new TextField();
        lastNameTxt = new TextField();
        idTxt = new TextField();
        emailTxt = new TextField();
        mobileTxt = new TextField();
        numOfDaysTxt = new TextField();
        
        female = new RadioButton();
        male = new RadioButton();
        
        genderGroup = new ToggleGroup();
        female.setToggleGroup(genderGroup);
        male.setToggleGroup(genderGroup);
        
        updateCheckBox = new CheckBox();
        
        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Married", "Single");
        
        addressTxt = new TextArea();
        
        nextBtn = new Button("NEXT");
        clearBtn = new Button("CLEAR");
        cancelBtn = new Button("CANCEL");
    }
    
    

    public void start(){
        
        
        
        BorderPane page = new BorderPane();
        
        VBox top = new VBox();
        Pane topSpace = new Pane();
        
        VBox form = new VBox(space2);
        VBox btns = new VBox(space1);
        
        HBox nameBox = new HBox(space4);
        VBox firstNameBox = new VBox(space3);
        VBox middleNameBox = new VBox(space3);
        VBox lastNameBox = new VBox(space3);
        
        HBox contactBox = new HBox(space4);
        VBox idBox = new VBox(space3);
        VBox emailBox = new VBox(space3);
        VBox mobileBox = new VBox(space3);
        
        HBox numOfDaysBox = new HBox(space1);
        
        HBox generaBox = new HBox(space1);
        
        HBox updateBox = new HBox(space1);
        
        HBox statusBox = new HBox(space1);
        
        VBox addressBox = new VBox(space3);
        
        Pane leftSpace = new Pane();
        
        Pane bottomSpace = new Pane();
        
        leftSpace.setMinWidth(100);
        
        bottomSpace.setMinHeight(150);
        
        topSpace.setMinHeight(50);
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        top.getChildren().addAll(logoView, topSpace);

        Label firstNameLbl = new Label("FIRST NAME");
        Label middleNameLbl = new Label("MIDDLE NAME");
        Label lastNameLbl = new Label("LAST NAME");
        
//form
        
        
        firstNameBox.getChildren().addAll(firstNameLbl, firstNameTxt);
        middleNameBox.getChildren().addAll(middleNameLbl, middleNameTxt);
        lastNameBox.getChildren().addAll(lastNameLbl, lastNameTxt);
        nameBox.getChildren().addAll(firstNameBox, middleNameBox, lastNameBox);
        
        Label idLbl = new Label("ID");
        Label emailLbl =new Label("E-MAIL");
        Label mobileLbl = new Label("MOBILE");
        

        
        idBox.getChildren().addAll(idLbl, idTxt);
        emailBox.getChildren().addAll(emailLbl, emailTxt);
        mobileBox.getChildren().addAll(mobileLbl, mobileTxt);
        contactBox.getChildren().addAll(idBox, emailBox, mobileBox);
        
        Label numOfDaysLbl = new Label("NUMBER OF DAYS");
        
        
        numOfDaysBox.getChildren().addAll(numOfDaysLbl, numOfDaysTxt);

        
        Label femaleLbl = new Label("FEMALE");
        Label maleLbl = new Label("MALE");
        
        
        
        generaBox.getChildren().addAll(female, femaleLbl, male, maleLbl);
        
        
        Label updateLbl = new Label("UPDATEABLE");
        
        updateBox.getChildren().addAll(updateCheckBox, updateLbl);
        
        Label statusLbl = new Label("STATUS");
        
        
        statusBox.getChildren().addAll(statusLbl, statusComboBox);
        
        Label addressLbl = new Label("ADDRESS");
        addressTxt.setMaxSize(700, 100);
        
        addressBox.getChildren().addAll(addressLbl, addressTxt);
        
        form.getChildren().addAll(nameBox, contactBox, numOfDaysBox, generaBox, updateBox, statusBox, addressBox);
        form.getStyleClass().add("form");
        form.setPadding(new Insets(20, 0, 0, 30));
        
        
//btns   
        
        nextBtn.getStyleClass().add("btn");
        
        clearBtn.getStyleClass().add("btn");

        cancelBtn.getStyleClass().add("cancelBtn");
        
        btns.getChildren().addAll(nextBtn, clearBtn, cancelBtn);
        btns.setPadding(new Insets(150, 100, 0, 100));

        page.setTop(top);
        page.setCenter(form);
        page.setRight(btns);
        page.setLeft(leftSpace);
        page.setBottom(bottomSpace);
        
        Scene scene = new Scene(page, 1920, 1050);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Receptionist/CheckIn/GuestInfo/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
    
}
