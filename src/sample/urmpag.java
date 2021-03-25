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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;



public class urmpag implements Initializable {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @FXML
    private Label lblErrors;
    @FXML
    private Button date;
    @FXML
    private Button date2;
    @FXML
    private Button date9;
    @FXML
    private Button date3;
    @FXML
    private Button date6;

    @FXML
    private Button date4;
    @FXML
    private Button date5;
    @FXML
    private Button date8;
    @FXML
    private Button date10;
    @FXML
    private Button logout;

    private Integer Id_date;

    public void functieId(Integer Id)
    {

        this.Id_date=Id;
    }
    @FXML
    public void handleButtonDateAction(MouseEvent event) {

        if (event.getSource() == date) {
            //login here

                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    FXMLLoader loader=new FXMLLoader();
                    loader.setLocation(getClass().getResource(("afisaredate.fxml")));
                    Parent root=loader.load();
                    AfisareDate controllerdate=loader.getController();
                    controllerdate.functieId(Id_date);
                    Scene scene=new Scene(root, 600, 400);
                    stage.setScene(scene);
                    stage.show();



                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }

    }
    @FXML
    public void handleButtonDate2Action(MouseEvent event) {

        if (event.getSource() == date2) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("adaugareangajat.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonDate3Action(MouseEvent event) {

        if (event.getSource() == date3) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("stergereangajat.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }






    @FXML
    public void handleButtonDate4Action(MouseEvent event) {

        if (event.getSource() == date4 ){
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("cautareangajat.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonDate5Action(MouseEvent event) {

        if (event.getSource() == date5 ){
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("adaugarepacient.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonDate6Action(MouseEvent event) {

        if (event.getSource() == date6 ){
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("cautarepacient.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }

    @FXML
    public void handleButtonDate8Action(MouseEvent event) {

        if (event.getSource() == date8) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("stergerepacient.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonDate9Action(MouseEvent event) {

        if (event.getSource() == date9) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("vizpacienti.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    @FXML
    public void handleButtonDate10Action(MouseEvent event) {

        if (event.getSource() == date10) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("stergereangajat.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();



            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
    public void handleButtonLogOutAction(MouseEvent event) {

        if (event.getSource() == logout) {
            //login here

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource(("sample.fxml")));
                Parent root=loader.load();
                Scene scene=new Scene(root, 600, 400);
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
    public urmpag() {
        con = ConnectionLogin.getConnection();
    }




}


