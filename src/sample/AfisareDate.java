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



public class AfisareDate implements Initializable {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    @FXML
    private Button date;
    @FXML
    private Label nume;
    @FXML
    private Label prenume;
    @FXML
    private Label functie;

    @FXML
    private Label tara;

    @FXML
    private Label judet;

    @FXML
    private Label oras;
    @FXML
    private Label strada;
    @FXML
    private Label nr;
    @FXML
    private Label codpostal;


    @FXML
    private Button back;


    private Integer Id_date1;

    public void functieId(Integer Id)
    {
        this.Id_date1=Id;
    }

  public void afisare_date(Integer  Id)
  {
      try{
          CallableStatement getData=con.prepareCall("{call AFISARE_DATE_PERSONALE(?)}");
          if(Id==null)
          {
              getData.setNull(1,Types.INTEGER);
          }
          else{
              getData.setInt(1,Id);
          }
          ResultSet resultSet= getData.executeQuery();
          while(resultSet.next())
          {

                     nume.setText( resultSet.getString("nume"));
                     prenume.setText(resultSet.getString("prenume"));
                      functie.setText(resultSet.getString("functie"));
                      tara.setText(resultSet.getString("tara"));
                      judet.setText(resultSet.getString("judet"));
                      oras.setText(resultSet.getString("oras"));
                      strada.setText(resultSet.getString("strada"));
                      nr.setText(resultSet.getString("numar"));
                      codpostal.setText(resultSet.getString("cod_postal"));
          }
      }
      catch(SQLException e)
      {
          e.printStackTrace();
      }
  }

    public void handleButtonDate1Action(MouseEvent event) {

        if (event.getSource() == date) {


            afisare_date(Id_date1);
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

    }
    public AfisareDate() {
        con = ConnectionLogin.getConnection();
    }




}



