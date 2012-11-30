package Modelo;

import java.sql.*;

public class ControladorBD {
private static String driverJDBC = "com.mysql.jdbc.Driver";
    private static String ipBD = "localhost";
    private static int puertoTCP = 3306;
    private static String nombreBD = "bd_clinica";
    private static String usuarioBD = "root";
    private static String claveBD = "";

    private static String getURLBD(){
        return "jdbc:mysql://" + ipBD + ":" + puertoTCP + "/" + nombreBD;
    }

    public static Connection darConexionBD(){
        Connection conexion = null;
        try{
            Class.forName(driverJDBC);
            conexion = DriverManager.getConnection(getURLBD(), usuarioBD, claveBD);

        }catch(Exception error) {
            System.out.println("Hay un error por: " + error.getMessage());
            error.printStackTrace();
        }
        return conexion;
    }
    public static void main(String[] argumentos){
        Connection conexion = null;
        try{

            System.out.println("Cadena de Conexion" + ControladorBD.getURLBD());
            conexion = ControladorBD.darConexionBD();
            System.out.println(conexion);
            System.out.println(conexion.getCatalog());
            conexion.close();
        }catch(Exception error){
            System.out.println("Error por: " + error.getMessage());
            error.printStackTrace();
        }
    }
}
