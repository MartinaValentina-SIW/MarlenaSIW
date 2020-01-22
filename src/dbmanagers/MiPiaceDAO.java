package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MiPiaceDAO {
    static Connection con;
    static PreparedStatement ps;

    public boolean insertOrDeleteMiPiace(String articolo, String utente)
    {
        try {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM MiPiace AS mp WHERE mp.articolo = ? AND mp.utente = ?");

            ps.setString(1,articolo);
            ps.setString(2,utente);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                ps = con.prepareStatement("DELETE FROM MiPiace WHERE articolo = ? AND utente = ?");

                ps.setString(1,articolo);
                ps.setString(2,utente);

                ps.execute();

                return false;
            }
            else
            {
                ps = con.prepareStatement("INSERT INTO MiPiace(articolo,utente) VALUES (?,?)");

                ps.setString(1,articolo);
                ps.setString(2,utente);

                ps.executeUpdate();
                return true;
            }
        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public int getMiPiace(int articolo)
    {
        int n = 0;
        try
        {
            con = MyConnection.getConnection();
            ps = con.prepareStatement("SELECT COUNT(*) FROM MiPiace AS mp WHERE mp.articolo = ?");

            ps.setString(1,""+articolo);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
                n = rs.getInt(1);

        }
        catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return n;
    }
}
