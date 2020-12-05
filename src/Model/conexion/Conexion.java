// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class Conexion {

    private static Connection conexion = null;
    private static String usuario = "root";
    private static String password = "";
    private static String database = "banco";

    private  Conexion(){}

    public static Connection conectar()  {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, usuario, password);
            if (conexion != null) {
                System.out.println("Conexion establecida");
            }

            return conexion;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

        return  null;
    }

}