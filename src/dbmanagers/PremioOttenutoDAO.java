package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PremioOttenutoDAO {
    static Connection con;
    static PreparedStatement ps;

    public boolean ottieniPremio(String utente, int premio)
    {
        if(isOttenuto(utente,premio))
            return false;
        try {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("INSERT INTO PremioOttenuto(utente,premio) VALUES (?,?)");

            ps.setString(1,utente);
            ps.setString(2,""+premio);

            ps.executeUpdate();
            return true;
        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOttenuto(String utente, int premio)
    {
        try
        {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM PremioOttenuto AS p WHERE p.utente = ? AND p.premio = ?");

            ps.setString(1,utente);
            ps.setString(2,""+premio);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
