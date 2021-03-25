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

import java.net.URL;
import java.sql.*;

import java.util.ResourceBundle;



public class AdaugarePacient implements Initializable {
    Connection con = null;
    ResultSet resultSet = null;


    @FXML
    private Button date;
    @FXML
    private TextField tara;
    @FXML
    private TextField judet;
    @FXML
    private TextField oras;
    @FXML
    private TextField strada;
    @FXML
    private TextField stare;
    @FXML
    private TextField cnp;
    @FXML
    private TextField codpostal;
    @FXML
    private TextField mail;
    @FXML
    private TextField nume;
    @FXML
    private TextField prenume;

    @FXML
    private TextField suma;
    @FXML
    private TextField parola;

    @FXML
    private TextField tel;


    @FXML
    private TextField nr;




    @FXML
    private Label lblErrors;

    @FXML
    private Button back;
    ResultSet rs = null;


    public void adaugare_pacient(  String mail1  ,String nume1 ,String prenume1,
                                   String tel1, String cnp1,String tara1,String judet1,String oras1,
                                   String strada1, Integer nr1,String codpostal1,String stare1,Integer suma1,
                                   String  parola1 )
    {

        try {

            CallableStatement getAngajat = con.prepareCall("{call addPacient(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            getAngajat.setString(1,mail1);
            getAngajat.setString(2,nume1);
            getAngajat.setString(3,prenume1);
            getAngajat.setString(4,tel1);
            getAngajat.setString(5,cnp1);
            getAngajat.setString(6,tara1);
            getAngajat.setString(7,judet1);
            getAngajat.setString(8,oras1);
            getAngajat.setString(9,strada1);
            getAngajat.setInt(10,nr1);
            getAngajat.setString(11,codpostal1);
            getAngajat.setString(12,stare1);
            getAngajat.setInt(13,suma1);
            getAngajat.setString(14,parola1);



            resultSet = getAngajat.executeQuery();
            Statement stm1 = con.createStatement();
            getAngajat.close();
            rs = stm1.executeQuery("SELECT * from utilizator");
            while (rs.next()) {

                String nume=rs.getString("nume");
                System.out.println(nume);


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

            String tara1 = tara.getText();
            String judet1 = judet.getText();
            String oras1=oras.getText();
            String strada1 = strada.getText();
            String cnp1=cnp.getText();
            String codpostal1 = codpostal.getText();
            Integer suma1 = Integer.parseInt(suma.getText());
            String mail1 = mail.getText();
            String nume1 = nume.getText();
            String prenume1 = prenume.getText();
            String stare1 = stare.getText();
            String parola1=parola.getText();
            String tel1 = tel.getText();
            Integer nr1= Integer.parseInt(nr.getText());


            adaugare_pacient( mail1  ,nume1 ,prenume1,tel1,cnp1,tara1,judet1,oras1,strada1,nr1,codpostal1,stare1,suma1,
                    parola1);
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
    public AdaugarePacient() {
        con = ConnectionLogin.getConnection();
    }




}




