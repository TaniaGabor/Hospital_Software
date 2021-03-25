package sample;


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
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.ResourceBundle;



public class StergerePacient implements Initializable {
    Connection con = null;
    ResultSet resultSet = null;

    @FXML
    private Button date;
    @FXML
    private Label lblErrors;

    @FXML
    private Label mesaj;
    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;
    @FXML
    private Button back;
    ResultSet rs = null;


    public void stergere_pacient(  String nume1,String prenume1 )
    {

        try {

            CallableStatement deleteAngajat = con.prepareCall("{call stergerePacient(?,?)}");


            deleteAngajat.setString(1,nume1);
            deleteAngajat.setString(2,prenume1);



            resultSet = deleteAngajat.executeQuery();
            mesaj.setText("Pacient sters cu succes!");


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleButtonDate1Action(MouseEvent event) {

        if (event.getSource() == date) {


            String nume1 = nume.getText();
            String prenume1 = prenume.getText();

            stergere_pacient(nume1,prenume1);

        }
    }

    @FXML
    public void handleButtonBackAction(MouseEvent event) {

        if (event.getSource() == back) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("urmpag.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 500);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
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
    public StergerePacient() {
        con = ConnectionLogin.getConnection();
    }




}





