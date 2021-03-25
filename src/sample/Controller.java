package  sample;

import java.sql.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public   class Controller implements Initializable {

 @FXML
 private Label lblErrors;
 @FXML
 private Button btnSignin;
 @FXML
 private TextField email1;
 @FXML
 private PasswordField parola1;

 @FXML
 private TextField functie1;


 String Email = null;
 String Parola = null;
 public Integer Id=0;
 Connection con = null;
 ResultSet resultSet = null;


 @FXML
 public void handleButtonAction(MouseEvent event) {

  if (event.getSource() == btnSignin) {
   //login here
   if (logIn().equals("Success")) {
    try {

     Node node = (Node) event.getSource();
     Stage stage = (Stage) node.getScene().getWindow();
     FXMLLoader loader=new FXMLLoader();
     loader.setLocation(getClass().getResource(("urmpag.fxml")));
     Parent root=loader.load();
     urmpag controllerpag=loader.getController();
     controllerpag.functieId(Id);
     Scene scene=new Scene(root, 600, 430);
     stage.setScene(scene);
     stage.show();

    } catch (IOException ex) {
     System.err.println(ex.getMessage());
    }

   }
  }
 }


 public void initialize(URL url, ResourceBundle rb) {
  if (con == null) {

   lblErrors.setText("Server Error : Check");
  } else {

   lblErrors.setText("Server is up : Good to go");
  }
 }

 public Controller() {
  con = ConnectionLogin.getConnection();
 }

 private String logIn() {
  String status = "Success";
  String email = email1.getText();
  String parola = parola1.getText();
  String functie=functie1.getText();
  System.out.println(email);

  System.out.println(parola);
  if (email.isEmpty() || parola.isEmpty()) {
   lblErrors.setText("Server Error");
   return "Error";
  } else {
    try {

     Statement stm = con.createStatement();
     resultSet = stm.executeQuery("SELECT * from utilizator");
     while(resultSet.next()) {
      Email = resultSet.getString("email");
      Parola = resultSet.getString("parola");
      Id= resultSet.getInt("id");


      if ((Email.equals(email) && Parola.equals(parola) )&& (functie.equals("Admin") || functie.equals("Superadmin")))
      {
       lblErrors.setText(" Correct Email/Password");
       return status;
      }
      else
      {
       lblErrors.setText("Enter Correct Email/Password");
       status = "Error";
      }
     }
    }
    catch (SQLException ex) {
     System.err.println(ex.getMessage());
     status = "Exception";
    }
   }
   return status;
  }
 }


