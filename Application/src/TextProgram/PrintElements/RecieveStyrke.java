package TextProgram.PrintElements;


import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveStyrke {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveStyrke(int økt_id){
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Styrke");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                System.out.print("    Belastning: " + rs.getDouble(2) + "    ");
                System.out.print("Repetisjoner: " + rs.getString(3) + "    ");
                System.out.print("Sett: " + rs.getString(4) + "    ");
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
