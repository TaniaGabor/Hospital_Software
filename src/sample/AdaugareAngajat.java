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



public class AdaugareAngajat implements Initializable {
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
    private TextField numar;
    @FXML
    private TextField cnp;
    @FXML
    private TextField codpostal;
    @FXML
    private TextField salariu;
    @FXML
    private TextField functie;
    @FXML
    private TextField mail;
    @FXML
    private TextField nume;
    @FXML
    private TextField prenume;
    @FXML
    private TextField grad;
    @FXML
    private TextField competente;
    @FXML
    private TextField post;
    @FXML
    private TextField procent;
    @FXML
    private TextField parola;

    @FXML
    private TextField tel;

    @FXML
    private TextField titlu;
    @FXML
    private TextField tip;
    @FXML
    private TextField nr;

    @FXML
    private TextField codparafa;


    @FXML
    private Label lblErrors;

    @FXML
    private Button back;
    ResultSet rs = null;


    public void adaugare_angajat(  String tara1 , String judet1,String oras1,String strada1,Integer numar1,String cnp1
            ,String codpostal1,Integer salariu1,String functie1,String mail1,String nume1, String prenume1
            ,String grad1,String competente1,String post1,String procent1,String parola1,String tel1,String titlu1,String tip1
            ,Integer nr1,Integer codparafa1 )
    {

        try {

            CallableStatement getAngajat = con.prepareCall("{call ADD_ANGAJAT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            getAngajat.setString(1,tara1);
            getAngajat.setString(2,judet1);
            getAngajat.setString(3,oras1);
            getAngajat.setString(4,strada1);
            getAngajat.setInt(5,numar1);
            getAngajat.setString(6,cnp1);
            getAngajat.setString(7,codpostal1);
            getAngajat.setInt(8,salariu1);
            getAngajat.setString(9,functie1);
            getAngajat.setString(10,mail1);
            getAngajat.setString(11,nume1);
            getAngajat.setString(12,prenume1);
            getAngajat.setString(13,grad1);
            getAngajat.setString(14,competente1);
            getAngajat.setString(15,post1);
            getAngajat.setString(16,procent1);
            getAngajat.setString(17,parola1);
            getAngajat.setString(18,tel1);
            getAngajat.setString(19,titlu1);
            getAngajat.setString(20,tip1);
            getAngajat.setInt(21,nr1);
            getAngajat.setInt(22,codparafa1);


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
            Integer numar1 = Integer.parseInt(numar.getText());
            String cnp1=cnp.getText();
            String codpostal1 = codpostal.getText();
            Integer salariu1 = Integer.parseInt(salariu.getText());
            String functie1=functie.getText();
            String mail1 = mail.getText();
            String nume1 = nume.getText();
            String prenume1 = prenume.getText();
            String grad1 = grad.getText();
            String competente1=competente.getText();
            String post1 = post.getText();
            String procent1 = procent.getText();
            String parola1=parola.getText();
            String tel1 = tel.getText();
            String titlu1  = titlu.getText();
            String tip1=tip.getText();
            Integer nr1= Integer.parseInt(nr.getText());
            Integer codparafa1 = Integer.parseInt(codparafa.getText());


         adaugare_angajat(   tara1 ,judet1 ,oras1 ,strada1 ,numar1 ,cnp1 ,codpostal1 ,salariu1 ,functie1 ,mail1
                 ,nume1 ,prenume1 ,grad1 ,competente1 ,post1 ,procent1 ,parola1 ,tel1 ,titlu1,tip1, nr1,
                 codparafa1  );
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
    public AdaugareAngajat() {
        con = ConnectionLogin.getConnection();
    }




}




