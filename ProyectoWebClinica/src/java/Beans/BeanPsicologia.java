/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.Psicologia;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.CallableStatement;
import Modelo.ControladorBD;
/**
 *
 * @author JOSEF
 */
public class BeanPsicologia {
    
    Psicologia psicologia_a= new Psicologia();
    private ArrayList<Psicologia> arreglo =new  ArrayList<Psicologia>();
    private String parametro;

    public BeanPsicologia() {
    }

    public Psicologia getPsicologia_a() {
        return psicologia_a;
    }

    public void setPsicologia_a(Psicologia psicologia_a) {
        this.psicologia_a = psicologia_a;
    }

    public ArrayList<Psicologia> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Psicologia> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    
     public boolean DiagpsicologiaExamen(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_psicologia_ex" + "(?,?,?,?,?)}");
            st.setString(1,psicologia_a.getDiagpresun_psicologia());
            st.setString(2,psicologia_a.getDiagdef_psicologia());
            st.setString(3,psicologia_a.getIndicacion_psico());
            st.setString(4,psicologia_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            psicologia_a.setCod_psicologia(st.getString(5));
            if(psicologia_a.getCod_psicologia()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }    
        return a;
    }
    
    public boolean DiagpsicologiaConsulta(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_psicologia_con" + "(?,?,?,?,?)}");
            st.setString(1,psicologia_a.getDiagpresun_psicologia());
            st.setString(2,psicologia_a.getDiagdef_psicologia());
            st.setString(3,psicologia_a.getIndicacion_psico());
            st.setString(4,psicologia_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            psicologia_a.setCod_psicologia(st.getString(5));
            if(psicologia_a.getCod_psicologia()!= null)
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
