/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.Odontologia;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.CallableStatement;
import Modelo.ControladorBD;
import java.sql.ResultSet;
/**
 *
 * @author JOSEF
 */
public class BeanOdontologia {
    
    Odontologia odontologia_a=new Odontologia();
    private ArrayList<Odontologia> arreglo =new  ArrayList<Odontologia>();
    private String parametro;

    public BeanOdontologia() {
    }

    public Odontologia getOdontologia_a() {
        return odontologia_a;
    }

    public void setOdontologia_a(Odontologia odontologia_a) {
        this.odontologia_a = odontologia_a;
    }

    public ArrayList<Odontologia> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Odontologia> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    public boolean DiagodontologiaExamen(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_odontologia_ex" + "(?,?,?,?,?)}");
            st.setString(1,odontologia_a.getDiagpresun_odontologia());
            st.setString(2,odontologia_a.getDiagdef_odontologia());
            st.setString(3,odontologia_a.getIndicacion_odon());
            st.setString(4,odontologia_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            odontologia_a.setCod_odontologia(st.getString(5));
            if(odontologia_a.getCod_odontologia()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }    
        return a;
    }
    
    public boolean DiagodontologiaConsulta(){
    boolean a=false;
    Connection conexion=null;
    try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_atender_odontologia_con" + "(?,?,?,?,?)}");
            st.setString(1,odontologia_a.getDiagpresun_odontologia());
            st.setString(2,odontologia_a.getDiagdef_odontologia());
            st.setString(3,odontologia_a.getIndicacion_odon());
            st.setString(4,odontologia_a.getObj_per().getCod_personal());        
            st.registerOutParameter(5, java.sql.Types.VARCHAR);
            st.execute();
            odontologia_a.setCod_odontologia(st.getString(5));
            if(odontologia_a.getCod_odontologia()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }    
        return a;
    }
    
     public String doRegistrarResultadoOE()
        {
            try
        {
            if (this.DiagodontologiaExamen()){
                Mensaje.guardarMensajeExito( "Registro Paciente: DNI " + this.getOdontologia_a().getCod_odontologia());

            }else {
                Mensaje.manejarError("Registrando Paciente");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
}
