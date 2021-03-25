package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class VizPacienti implements Initializable {
    Connection con = null;
    ResultSet resultSet = null;

    @FXML
    private Button back;
    @FXML
    private TableView<Pacienti> table;
    @FXML
    private TableColumn <Pacienti,String> col_nume;
    @FXML
    private TableColumn<Pacienti,String> col_prenume;
    @FXML
    private TableColumn<Pacienti,String> col_stare;


    ObservableList<Pacienti> oblist= FXCollections.observableArrayList();
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

        try {
            resultSet=con.createStatement().executeQuery("select * from pacient");
            while(resultSet.next())
            {
                oblist.add(new Pacienti(resultSet.getString("nume"),resultSet.getString("prenume"
                ),resultSet.getString("stareDeSanatate")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        col_nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        col_prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        col_stare.setCellValueFactory(new PropertyValueFactory<>("stareDeSanatate"));

        table.setItems(oblist);





    }
    public VizPacienti() {
        con = ConnectionLogin.getConnection();
    }




}






