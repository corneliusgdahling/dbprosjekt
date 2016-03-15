package TextProgram.AddElements;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddØvelse {

    Scanner sc = new Scanner(System.in);

    public AddØvelse(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        try {
            PreparedStatement addØktStatement = myConnection.prepareStatement(getSQLStatement());
            addØktStatement.setInt(1, getØvelse_id());
            addØktStatement.setString(2, getNavn());
            addØktStatement.setString(3, getBeskrivelse());

            addØktStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getSQLStatement(){
        String sqlStatement = "INSERT INTO Øvelse (Øvelse_id, Navn, Beskrivelse) VALUES " + "(?, ? , ?)";
        return sqlStatement;
    }

    public int getØvelse_id(){
        System.out.println("\nPlease enter the exercise ID (Required).");
        int øvelse_id = Integer.parseInt(sc.nextLine());
        return øvelse_id;
    }

    public String getNavn(){
        System.out.println("\nEnter the name of the exercise (Required).");
        String navn = sc.nextLine();
        return navn;
    }

    public String getBeskrivelse(){
        System.out.println("\nWrite a short description of the exercise (Required).");
        String besk = sc.nextLine();
        return besk;
    }
}
