package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    @FXML private TextField nameField;
    @FXML private ListView listView;
    @FXML private Label title;

    MYSQL_Connection mysql = new MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    ResultSet rs;
    ArrayList<String> list = new ArrayList<>();

    public void addField(){
        try {
            PreparedStatement testStatement;
            String sqlStatement = "SELECT * from ChillernNavn;";
            testStatement = myConnection.prepareStatement(sqlStatement);
            rs = testStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)); //gets the first column's rows.
            }



            testStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printToListView(){
        listView.setItems(FXCollections.observableList(getUpdatedList()));
    }


    public ArrayList<String> getUpdatedList(){
        list.clear();
        String sqlStatement = "SELECT * from ChillernNavn;";
        try {
            PreparedStatement ps = myConnection.prepareStatement(sqlStatement);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()){
                list.add(rs.getString(1));
            }
            System.out.print(list);
            ResultSetMetaData rsmd = rs.getMetaData();
            title.setText(rsmd.getColumnName(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void initialize(){
        printToListView();
    }

    public void onClickAddName(ActionEvent actionEvent) {
//        getUpdatedList().add(nameField.getText());
//        listView.setItems(FXCollections.observableList(list));
        String sqlStatement = "INSERT INTO ChillernNavn (first_name) VALUES ('"+nameField.getText()+"')";
        try {
            PreparedStatement addNameStatement = myConnection.prepareStatement(sqlStatement);
            addNameStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        listView.setItems(FXCollections.observableList(getUpdatedList()));
    }

    public void onClickupdatedb(ActionEvent actionEvent) {
        listView.setItems(FXCollections.observableList(getUpdatedList()));
    }
}
