package TextProgram.PrintElements;


import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveUtholdenhet {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveUtholdenhet(int økt_id){
//        System.out.println("Test utholdenhet");
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Utholdenhetstrening");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                System.out.print("Distanse: " + rs.getDouble(2) + "(km)    ");
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
