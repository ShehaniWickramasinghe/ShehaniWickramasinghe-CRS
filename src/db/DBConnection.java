package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static DBConnection dBConnection;
        private static Connection connection;

        private DBConnection() throws ClassNotFoundException,SQLException{
             Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "shehani@2024");
        }

        public static DBConnection getInstance()throws Exception{
            if (dBConnection==null) {
                dBConnection=new DBConnection();
            }
            return dBConnection;
        }

        public  Connection getConnection(){
            return this.connection;
        }
}
