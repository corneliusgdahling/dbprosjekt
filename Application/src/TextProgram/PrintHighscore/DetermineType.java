package TextProgram.PrintHighscore;


import TextProgram.AddElements.AddStyrke;
import TextProgram.AddElements.AddUtholdenhet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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
        System.out.println("\nPlease enter the name of the exercise you wish to know your top results.");
        String navn = sc.nextLine();
        return navn;
    }

    public void styrkeOrUtholdenhet(){
        if (getØvelseid() > 200){
            PrintTopStyrke printTopStyrke = new PrintTopStyrke(getØvelseid());
        }
        else{
            PrintTopUtholdenhet printTopUtholdenhet = new PrintTopUtholdenhet(getØvelseid());
        }
    }
}
