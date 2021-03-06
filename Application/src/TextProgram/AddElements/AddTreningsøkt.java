package TextProgram.AddElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class AddTreningsøkt {

    private Scanner sc = new Scanner(System.in);

    public AddTreningsøkt(){
        TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
        Connection myConnection = mysql.getConnection();
        System.out.println("\n\nPlease enter all the necessary information. Information that is " +
                "required will have a '(Required)' tag. For items you wish to skip (that are not required)" +
                " press enter.\n");
        try {
            PreparedStatement addØktStatement = myConnection.prepareStatement(getSQLStatement());
            addØktStatement.setString(1, getDate());
            addØktStatement.setString(2, getTime());
            addØktStatement.setInt(3, getVarighet());
            addØktStatement.setString(4, getNotatForTreningen());

            addØktStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSQLStatement(){
        String sqlStatement = "INSERT INTO Treningsøkt (Dato, Tidspunkt, Varighet, Notat_for_treningen) VALUES " + "(?, ? , ?, ?)";
        return sqlStatement;
    }

    public int getVarighet(){
        System.out.println("Enter the duration of your workout (Required).");
        int varighet = Integer.parseInt(sc.nextLine());
        return varighet;
    }

    public String getNotatForTreningen(){
        System.out.println("\nEnter any additional notes for the workout.");
        String notat = sc.nextLine();
        if (notat.length() < 1){
            notat = null;
        }
        return notat;
    }

    public String getDate() {
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());

        return dateNow;
    }

    public String getTime() {
        Calendar currentDate = Calendar.getInstance(); //Get the current time
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm"); //format it as per your requirement
        String timeNow = formatter.format(currentDate.getTime());
        return timeNow;
    }
}
