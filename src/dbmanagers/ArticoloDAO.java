package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticoloDAO {
    static Connection con;
    static PreparedStatement ps;

    public ArrayList<Articolo> getAllArticoli()
    {
        ArrayList<Articolo> articoli = new ArrayList<Articolo>();

        try {
            ArticoloDAO.con = MyConnection.getConnection();
            ps = ArticoloDAO.con.prepareStatement("SELECT * FROM Articolo");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                articoli.add(new Articolo(rs.getInt(1),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getInt(8),rs.getString(2)));
            }
            con.close();
        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }

        return articoli;
    }

    public int aggiungiArticolo(int id, String autore, String titolo, String sottotitolo, String testo)
    {
        Articolo c = new Articolo();
        try {
            ArticoloDAO.con = MyConnection.getConnection();
            ps = ArticoloDAO.con.prepareStatement("SELECT * FROM Articolo AS c WHERE c.id=?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return -1;
            }

            ps = ArticoloDAO.con.prepareStatement("INSERT INTO Articolo(id,autore,titolo,sottotitolo,testo) VALUES (?,?,?,?,?)");

            ps.setInt(1,id);
            ps.setString(2,autore);
            ps.setString(3,titolo);
            ps.setString(4,sottotitolo);
            ps.setString(5,testo);

            ps.executeUpdate();

            con.close();
        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
