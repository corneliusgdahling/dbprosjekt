package sample;

import java.sql.*;

public class Controller {


    public void addField(){
        MYSQL_Connection mysql = new MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        try {
            PreparedStatement testStatement;
            boolean found = false;
            String sqlStatement = "SELECT * from ChillernNavn;";
            testStatement = myConnection.prepareStatement(sqlStatement);
            ResultSet rs;
            rs = testStatement.executeQuery();
            found = rs.next();
            if (found){
                System.out.println(rs.getString(1));
            }
            else{
                System.out.println("There was a problem");
            }
            testStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args){
        Controller c = new Controller();
        c.addField();
    }
}
