package TextProgram.PrintElements;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecieveTreningsøkt {

    TextProgram.MYSQL_Connection mysql = new TextProgram.MYSQL_Connection("jdbc:mysql://mysql.stud.ntnu.no/cornelgd_databaser", "cornelgd_dbprosj", "1234");
    Connection myConnection = mysql.getConnection();
    Statement st;

    public RecieveTreningsøkt(String dato){
        int økt_id;
        try {
            Statement st = myConnection.createStatement();
            String sql = ("SELECT * FROM Treningsøkt WHERE Dato = '"+ dato + "' ORDER BY Økt_id DESC");
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()) {
                System.out.print("     Økt ID: " + rs.getString(1) + "     ");
                System.out.print("Dato: " + rs.getString(2) + "    ");
                System.out.print("Tidspunkt: " + rs.getString(3) + "    ");
                System.out.print("Varighet: " + rs.getString(4) + "    ");
                System.out.print("Notater: " + rs.getString(5) + "    ");
                System.out.println();
                System.out.println();
                økt_id = rs.getInt(1);
                RecieveØvelse recieveØvelse = new RecieveØvelse(økt_id);
                RecieveForhold receiveForhold = new RecieveForhold(økt_id);
                String inStatement = ("SELECT * FROM Innendørs WHERE Økt_id = '"+ økt_id + "'");
                String outStatement = ("SELECT * FROM Utendørs WHERE Økt_id = '"+ økt_id + "'");
                String styrkeStatement = ("SELECT * FROM Styrke WHERE Økt_id = '"+ økt_id + "'");
                String utholdenhetStatement = ("SELECT * FROM Utholdenhetstrening WHERE Økt_id = '"+ økt_id + "'");
                String øvelseStatement = ("SELECT Øvelse_id FROM Styrke WHERE Økt_id = '"+ økt_id + "'");
                rs = st.executeQuery(inStatement);
                if (rs.next()){
                    RecieveInnendørs recieveInnendørs = new RecieveInnendørs(økt_id);
                }
                else{
                    RecieveUtendørs recieveUtendørs = new RecieveUtendørs(økt_id);
                }

                rs = st.executeQuery(styrkeStatement);
                if (rs.next()){
                    RecieveStyrke recieveStyrke = new RecieveStyrke(økt_id);
                }
                else{
                    RecieveUtholdenhet recieveUtholdenhet = new RecieveUtholdenhet(økt_id);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
