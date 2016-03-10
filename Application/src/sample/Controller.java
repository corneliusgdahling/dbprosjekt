package sample;

import com.sun.xml.internal.ws.policy.spi.PrefixMapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class Controller {

    @FXML private Button deleteButton;
    @FXML private TextField nameField;
    @FXML private ListView listView;
    @FXML private Label title;
    @FXML private Label errorBox;

    private String value;


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


    public void onClickAddName(ActionEvent actionEvent) {
        if (!(getUpdatedList().get(getUpdatedList().size()-1).equals(nameField.getText()) || nameField.getText().length() < 1)) {
            String sqlStatement = "INSERT INTO ChillernNavn (first_name) VALUES ('" + nameField.getText() + "')";
            try {
                PreparedStatement addNameStatement = myConnection.prepareStatement(sqlStatement);
                addNameStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            errorBox.setVisible(true);
        }
        System.out.println(list);
        listView.setItems(FXCollections.observableList(getUpdatedList()));
    }

    public void onClickupdatedb(ActionEvent actionEvent) {
        listView.setItems(FXCollections.observableList(getUpdatedList()));
    }

    public void errorBoxClicked(Event event) {
        errorBox.setVisible(false);
    }

    public void setChosenListViewValue(String value){
        this.value = value;
    }

    public String getChosenListViewValue(){
        return this.value;
    }

    public void listviewTracker(){
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
                setChosenListViewValue(newValue);
            }
        });
    }

    public void onClickDelete(ActionEvent actionEvent) {
        System.out.print(getChosenListViewValue());
        String sqlStatement = "DELETE FROM ChillernNavn WHERE first_name = ?";
        try {
            PreparedStatement ps = myConnection.prepareStatement(sqlStatement);
            ps.setString(1, getChosenListViewValue());
            ps.executeUpdate();
            printToListView();
            System.out.println(getUpdatedList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        errorBox.setVisible(false);
        listviewTracker();
        printToListView();
    }
}
