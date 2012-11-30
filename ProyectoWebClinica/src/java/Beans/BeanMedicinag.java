/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.Medicinag;
import java.util.ArrayList;
import java.sql.CallableStatement;
import Modelo.ControladorBD;
import java.sql.Connection;
import javax.servlet.jsp.jstl.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author JOSEF
 */
public class BeanMedicinag {
    Medicinag medicina_a = new Medicinag();
    private ArrayList<Medicinag> arreglo =new  ArrayList<Medicinag>();
    private String parametro;

    public BeanMedicinag() {
    }

    public Medicinag getMedicina_a() {
        return medicina_a;
    }

    public void setMedicina_a(Medicinag medicina_a) {
        this.medicina_a = medicina_a;
    }

    public ArrayList<Medicinag> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Medicinag> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    
    
    public boolean DiagmedicinaExamen(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_medicinag_ex" + "(?,?,?,?,?)}");
            st.setString(1,medicina_a.getDiagpresun_medicina());
            st.setString(2,medicina_a.getDiagdef_medicina());
            st.setString(3,medicina_a.getIndicacion_medic());
            st.setString(4,medicina_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            medicina_a.setCod_medicina(st.getString(5));
            if(medicina_a.getCod_medicina()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }    
        return a;
    }
    
    public boolean DiagmedicinaConsulta(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_medicina_con" + "(?,?,?,?,?)}");
            st.setString(1,medicina_a.getDiagpresun_medicina());
            st.setString(2,medicina_a.getDiagdef_medicina());
            st.setString(3,medicina_a.getIndicacion_medic());
            st.setString(4,medicina_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            medicina_a.setCod_medicina(st.getString(5));
            if(medicina_a.getCod_medicina()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }    
        return a;
    }
}
