package aydin.firebasedemo;

import java.io.IOException;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private TextField emailTF;
    @FXML
    private Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        String email = emailTF.getText();

        //complete dis :3
        UserRecord userRecord = DemoApp.fauth.

        if (email.equals("")) {
            DemoApp.setRoot("primary");
        }
        else{
            Alert newAlert = new Alert(Alert.AlertType.ERROR);
            newAlert.setTitle("Error");
            newAlert.setHeaderText("CRUD!");
            newAlert.setContentText("You have to enter a invalid email address.");
            newAlert.showAndWait();
        }

        emailTF.clear();
    }

    @FXML
    void registerButtonClicked(ActionEvent event) {
        registerUser();
    }

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("user222@example.com")
                .setEmailVerified(false)
                .setPassword("secretPassword")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setDisabled(false);

        //contains everything about the user record that is stored in the Authentication tab of firebase
        UserRecord userRecord;
        try {
            //ask firebase to create a user in the database
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        }

    }
}
