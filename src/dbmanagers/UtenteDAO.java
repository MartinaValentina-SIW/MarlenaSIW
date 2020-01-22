package dbmanagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {
    static Connection con;
    static PreparedStatement ps;

    public String printAll()
    {
        Utente c = new Utente();
        StringBuilder s = new StringBuilder();
        try {
            UtenteDAO.con = MyConnection.getConnection();
            ps = UtenteDAO.con.prepareStatement("SELECT * FROM Utente AS c");

            //ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                c = new Utente();
                c.setUsername(rs.getString(1));
                c.setEmail(rs.getString(2));
                c.setPassword(rs.getString(3));
                c.setTotMiPiace(rs.getInt(4));
                c.setTipo(rs.getString(5));
                s.append(c.toString());
            }

            System.out.println(c.toString());


        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return s.toString();
    }

    public Utente getUtente(String email, String password)
    {
        Utente c = new Utente();
        try {
            UtenteDAO.con = MyConnection.getConnection();
            ps = UtenteDAO.con.prepareStatement("SELECT * FROM Utente AS c WHERE c.email = ? AND c.password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                c.setUsername(rs.getString(1));
                c.setEmail(rs.getString(2));
                c.setPassword(rs.getString(3));
                c.setTotMiPiace(rs.getInt(4));
                c.setTipo(rs.getString(5));
            }

            System.out.println(c.toString());
            System.out.println(email + " " + password);

        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
        }
        return c;
    }

    public int iscriviUtente(String username, String email, String password)
    {
        Utente c = new Utente();
        try {
            UtenteDAO.con = MyConnection.getConnection();
            ps = UtenteDAO.con.prepareStatement("SELECT * FROM Utente AS c WHERE c.username=?");

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return -1;
            }

            ps = UtenteDAO.con.prepareStatement("INSERT INTO Utente(username,email,password) VALUES (?,?,?)");

            ps.setString(1,username);
            ps.setString(2,email);
            ps.setString(3,password);

            ps.executeUpdate();

        }catch (SQLException | NullPointerException e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
