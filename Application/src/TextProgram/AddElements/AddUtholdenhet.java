package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class AddUtholdenhet {

    private Scanner sc = new Scanner(System.in);

    public AddUtholdenhet(int øvelse_id, int økt_id){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        try {
            PreparedStatement addØktStatement = myConnection.prepareStatement(getSQLStatement());
            addØktStatement.setInt(1, øvelse_id);
            addØktStatement.setDouble(2, getLengde());
            addØktStatement.setInt(3, getVarighet());
            addØktStatement.setInt(4, økt_id);

            addØktStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSQLStatement(){
        String sqlStatement = "INSERT INTO Utholdenhetstrening (Øvelse_id, Lengde, Varighet, Økt_id) VALUES " + "(?, ? , ?, ?)";
        return sqlStatement;
    }

    public int getVarighet(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        ResultSet rs;
        String getVarighetStatement = "SELECT Varighet FROM Treningsøkt ORDER BY Økt_id DESC";
        int varighet;
        try {
            PreparedStatement ps = myConnection.prepareStatement(getVarighetStatement);
            rs = ps.executeQuery();
            if (rs.next()) {
                varighet = rs.getInt(1);
                return varighet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public double getLengde(){
        System.out.println("\nHow many kilometers was your endurance exercise? (Required)");
        double lengde = Double.parseDouble(sc.nextLine());
        return lengde;
    }

    public String getDate() {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;
    }
}
