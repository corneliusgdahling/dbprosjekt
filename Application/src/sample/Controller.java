package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    ListView listView;

    MYSQL_Connection mysql = new MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    ResultSet rs;

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
        String sqlStatement = "SELECT * from ChillernNavn;";
        ArrayList<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = myConnection.prepareStatement(sqlStatement);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()){
                list.add(rs.getString(1));
            }
            listView.setItems(FXCollections.observableList(list));
            System.out.print(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        printToListView();
    }
}
