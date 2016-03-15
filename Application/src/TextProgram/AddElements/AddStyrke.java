package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class AddStyrke {

    private Scanner sc = new Scanner(System.in);

    public AddStyrke(int øvelse_id){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        try {
            PreparedStatement addØktStatement = myConnection.prepareStatement(getSQLStatement());
            addØktStatement.setInt(1, øvelse_id);
            addØktStatement.setInt(2, getBelastning());
            addØktStatement.setInt(3, getRepitisjoner());
            addØktStatement.setInt(4, getNumberOfSets());

            addØktStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSQLStatement(){
        String sqlStatement = "INSERT INTO Styrke (Øvelse_id, Belastning, Repitisjoner, Sett) VALUES " + "(?, ? , ?, ?)";
        return sqlStatement;
    }

    public int getBelastning(){
        System.out.println("\nEnter how much weight was used on this exercise (Required).");
        int belastning = Integer.parseInt(sc.nextLine());
        return belastning;
    }

    public int getRepitisjoner(){
        System.out.println("\nEnter how many repititions you did for each set (Required).");
        int reps = Integer.parseInt(sc.nextLine());
        return reps;
    }

    public int getNumberOfSets(){
        System.out.println("\nEnter how many sets you did (Required).");
        int sets = Integer.parseInt(sc.nextLine());
        return sets;
    }


}
