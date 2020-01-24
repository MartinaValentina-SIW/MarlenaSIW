package dbmanagers.dao;

import dbmanagers.entities.Articolo;
import dbmanagers.MyConnection;

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
        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }

        return articoli;
    }

    public void aggiungiArticolo(String autore, String titolo, String sottotitolo, String testo)
    {
        Articolo c = new Articolo();
        try {
            ArticoloDAO.con = MyConnection.getConnection();

            ps = ArticoloDAO.con.prepareStatement("INSERT INTO Articolo(autore,titolo,sottotitolo,testo) VALUES (?,?,?,?)");



            ps.setString(1,autore);
            ps.setString(2,titolo);
            ps.setString(3,sottotitolo);
            ps.setString(4,testo);

            ps.executeUpdate();

        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
    }
}
