
package Account;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

    
    Image profilePicture;
    String name;
    
    
    final Label emailLbl;
    final Label phoneLbl;
    final Label addressLbl;
    final Label salaryLbl;
    final Label bioLbl;
    
    TextField [] infoTextFields = new TextField[4];
    TextArea bioTxt;
    
    Button editProfileBtn;
    Button submitEdit;
    
    ImageView accountView;
    ImageView menuView;

    public Interface() {
        
        for (int i = 0; i < infoTextFields.length; i++) {
            infoTextFields[i] = new TextField();
        }
        
        bioTxt = new TextArea();
        emailLbl = new Label("EMAIL");
        phoneLbl = new Label("PHONE");
        addressLbl = new Label("ADDRESS");
        salaryLbl = new Label("SALARY");
        bioLbl = new Label("BIO");
        
        editProfileBtn = new Button("edit profile");
        submitEdit = new Button("SUBMIT");
        submitEdit.setVisible(false);
        
        accountView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.account);
        menuView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.menu);
    }
    
    
    
    public void start() {
        
        Stage primaryStage = new Stage();
        
        BorderPane page = new BorderPane();
        
        VBox sideMenu = new VBox(50);
        HBox profile = new HBox(100);
        
        VBox profileHeader = new VBox(50);
        HBox profileInfo = new HBox(100);
        
        VBox profileInfoLbls = new VBox(50);
        VBox profileInfoTxt = new VBox(50);
        VBox editProfile = new VBox(100);
        
        ImageView logoView = new ImageView(Receptionist.CheckIn.RoomInfo.Interface.header);
        
       
        sideMenu.getChildren().addAll(accountView, menuView);
        sideMenu.setPadding(new Insets(300, 0, 0, 20));
        
        ImageView profilePictureView = new ImageView(profilePicture);
        profilePictureView.setFitHeight(200);
        profilePictureView.setFitWidth(200);
        
        
        Label nameLbl = new Label(name);
        
        nameLbl.getStyleClass().add("name");
        nameLbl.setAlignment(Pos.CENTER);
        profileHeader.getChildren().addAll(profilePictureView, nameLbl);
        
        profileInfoLbls.getChildren().addAll(emailLbl, phoneLbl, addressLbl, salaryLbl, bioLbl);
        
        for (TextField infoTextField : infoTextFields) {
            infoTextField.setEditable(false);
            infoTextField.getStyleClass().add("noneditable");
            profileInfoTxt.getChildren().add(infoTextField);
        }
        bioTxt.setEditable(false);
        bioTxt.getStyleClass().add("noneditable");
        profileInfoTxt.getChildren().add(bioTxt);
        
        
        profileInfo.getChildren().addAll(profileInfoLbls, profileInfoTxt);
        profileInfo.getStyleClass().add("profile");
        profileInfo.setPadding(new Insets(50, 0, 0, 200));
        
        profile.getChildren().addAll(profileHeader, profileInfo);
        profile.setPadding(new Insets(100, 50, 50, 200));
        
        
        
        editProfile.getChildren().addAll(editProfileBtn, submitEdit);
        editProfile.setPadding(new Insets(300, 100, 0, 0));
        
        
        page.setTop(logoView);
        page.setLeft(sideMenu);
        page.setCenter(profile);
        page.setRight(editProfile);
        
        Scene scene = new Scene(page, 1800, 1200);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Interface.class.getResource("/Account/style.css").toExternalForm());
        primaryStage.setMaximized(true);
        primaryStage.show();
        
    }
}
