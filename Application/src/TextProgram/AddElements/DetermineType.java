package TextProgram.AddElements;

import java.sql.*;
import java.util.Scanner;

/**
 * Styrke eller utholdenhetstrening?
 */
public class DetermineType {

    private Scanner sc = new Scanner(System.in);

    public DetermineType(){
        styrkeOrUtholdenhet();
    }

    public int getØvelseid(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        ResultSet rs;
        String getØvelse_id_statement = "SELECT Øvelse_id FROM Øvelse WHERE Navn = '"+getNavn()+"'";
        try {
            PreparedStatement ps = myConnection.prepareStatement(getØvelse_id_statement);
            rs = ps.executeQuery();
            int øvelse_id;
            if (rs.next()){
                øvelse_id = rs.getInt(1);
                return øvelse_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public String getNavn(){
        System.out.println("\nPlease enter the name of the exercise (Required).");
        String navn = sc.nextLine();
        return navn;
    }

    public void styrkeOrUtholdenhet(){
        if (getØvelseid() > 200){
            AddStyrke styrke = new AddStyrke(getØvelseid());
        }
        else{
            AddUtholdenhet utholdenhet = new AddUtholdenhet(getØvelseid());
        }
    }
}
