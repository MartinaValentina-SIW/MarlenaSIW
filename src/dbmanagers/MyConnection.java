package dbmanagers;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;

public class MyConnection implements MyProvider{

    static Connection con = null;

    public static Connection getConnection()
    {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                MyConnection.con = DriverManager.getConnection(connUrl,username,psw);

            } catch (Exception e) {
                e.printStackTrace();
            }
        return MyConnection.con;
    }
}
