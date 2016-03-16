package TextProgram.PrintElements;


import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveØvelse {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveØvelse(int økt_id){
        try {
            Statement st = myConnection.createStatement();
            String styrkeStatement = ("SELECT Øvelse_id FROM Styrke WHERE Økt_id = '"+ økt_id + "'");
            String utholdenhetStatement = ("SELECT Øvelse_id FROM Utholdenhetstrening WHERE Økt_id = '"+ økt_id + "'");
            ResultSet rs = st.executeQuery(styrkeStatement);
            if(rs.next()) {
                int øvelse_id = rs.getInt(1);
                String sql = ("SELECT * FROM Øvelse WHERE Øvelse_id = '"+ øvelse_id +"'");
                rs = st.executeQuery(sql);
                if(rs.next()){
                    System.out.print("     Øvelse ID: " + rs.getString(1) + "     ");
                    System.out.print("Navn på øvelse: " + rs.getString(2) + "    ");
                    System.out.print("Beskrivelse av øvelse: " + rs.getString(3) + "    ");
                    System.out.println();
                    System.out.println();
                }
            }
            else{
                rs = st.executeQuery(utholdenhetStatement);
                if (rs.next()){
                    int øvelse_id = rs.getInt(1);
                    String sql = ("SELECT * FROM Øvelse WHERE Øvelse_id = '"+ øvelse_id +"'");
                    rs = st.executeQuery(sql);
                    if(rs.next()) {
                        System.out.print("     Øvelse ID: " + rs.getString(1) + "     ");
                        System.out.print("Navn på øvelse: " + rs.getString(2) + "    ");
                        System.out.print("Beskrivelse av øvelse: " + rs.getString(3) + "    ");
                        System.out.println();
                        System.out.println();
                }
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

