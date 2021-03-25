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



public class CautarePacient implements Initializable {
    Connection con = null;
    ResultSet resultSet = null;

    @FXML
    private Button date;
    @FXML
    private Label lbl;
    @FXML
    private Label lblErrors;

    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;


    @FXML
    private Button back;


    public void cautare_pacient(  String nume1,String prenume1 )
    {

        try {

            CallableStatement searchAngajat = con.prepareCall("{call cautarePacient(?,?,?)}");


            searchAngajat.setString(1, nume1);
            searchAngajat.setString(2, prenume1);
            searchAngajat.setString(3, "Pacient");

            Integer ok=0;
            String nume2 = null;
            String prenume2 = null;

            ResultSet rs = null;
            resultSet = searchAngajat.executeQuery();
            Statement stm = con.createStatement();
            rs = stm.executeQuery("Select * from utilizator");
            while (rs.next()) {
                nume2 = rs.getString("nume");
                prenume2 = rs.getString("prenume");

                if (nume2.equals(nume1) && prenume2.equals(prenume1)) {
                    lbl.setText("Pacient gasit in baza de date!");
                    ok=1;

                }
            }
            if(ok==0) {
                lbl.setText("Nu s-a gasit pacientul in baza de date!");
            }

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


            cautare_pacient(nume1,prenume1);

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
    public CautarePacient() {
        con = ConnectionLogin.getConnection();
    }




}





