package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AddForhold {

    private Scanner sc = new Scanner(System.in);

    public AddForhold(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        try {

            PreparedStatement ps = myConnection.prepareStatement(getSQLStatement());
            ps.setInt(1, getForhold_id());
            ps.setInt(2, getØkt_id());
            ps.setInt(3, getPrestasjon());
            ps.setInt(4, getForm());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getØkt_id(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        ResultSet rs;
        String getØkt_idStatement = "SELECT Økt_id FROM Treningsøkt ORDER BY Økt_id DESC;";
        int økt_id;
        try {
            PreparedStatement ps = myConnection.prepareStatement(getØkt_idStatement);
            rs = ps.executeQuery();
            if (rs.next()) {
                økt_id = rs.getInt(1);
                return økt_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int getForhold_id(){
        System.out.println("\nEnter the forhold_id");
        int forhold_id = Integer.parseInt(sc.nextLine());
        return forhold_id;
    }

    public int getPrestasjon(){
        System.out.println("\nHow happy are you with your performance (1-100) where 100 is perfect (Required).");
        int prestasjon = Integer.parseInt(sc.nextLine());
        return prestasjon;
    }

    public int getForm(){
        System.out.println("\nEvaluate your physical condition (1-10) where 10 is best (Required).");
        int form = Integer.parseInt(sc.nextLine());
        return form;
    }

    public String getSQLStatement(){
        String sqlStatement = "INSERT INTO Forhold (Forhold_id, Økt_id, Prestasjon, Personlig_form) VALUES (?, ?, ?, ?)";
        return sqlStatement;
    }
}
