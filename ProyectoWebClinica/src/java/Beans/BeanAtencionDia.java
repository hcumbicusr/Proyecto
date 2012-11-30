/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.AtencionDia;
import Modelo.ControladorBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author PC01
 */
public class BeanAtencionDia implements Serializable{
 
    private AtencionDia atencion_a= new AtencionDia();
    private ArrayList<AtencionDia> arreglo =new  ArrayList<AtencionDia>();
    private String parametro;
    private AtencionDia selectedAtention;

    public BeanAtencionDia() {
    }

    public ArrayList<AtencionDia> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<AtencionDia> arreglo) {
        this.arreglo = arreglo;
    }

    public AtencionDia getAtencion_a() {
        return atencion_a;
    }

    public void setAtencion_a(AtencionDia atencion_a) {
        this.atencion_a = atencion_a;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public AtencionDia getSelectedAtention() {
        return selectedAtention;
    }

    public void setSelectedAtention(AtencionDia selectedAtention) {
        this.selectedAtention = selectedAtention;
    }
    
    
    
    public ArrayList<AtencionDia>getListarAfiliados(){ 
    this.arreglo= null;
    AtencionDia obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall( "{call sp_listar_pacientes_atender()}");
                    rs = st.executeQuery();
    if (rs.next()){
        this.arreglo= new ArrayList<AtencionDia>();
        do{
        obj =new AtencionDia();
        obj.setNumero(rs.getInt("numero")); 
        obj.setCodigo(rs.getString("codigo"));
        obj.getObj_pac().getObj_hcl().setCod_historiaclinica(rs.getString("cod_historiaclinica")); 
        obj.getObj_pac().setNombres(rs.getString("nombres"));
        arreglo.add(obj);
       } while (rs.next());
    }  
         rs.close();
         st.close();
         conexion.close();

     }catch(Exception error){
        System.out.println("Error en el metodo por: " +
                   error.getMessage());
                error.printStackTrace();
        }    
        
    return this.arreglo;
    } 
    
    
    
     public boolean Atender(){
            boolean a=false;
            Connection conexion=null;
            try{
               conexion=ControladorBD.darConexionBD();
               CallableStatement st=conexion.prepareCall("{call sp_atender_paciente(?)}");
               st.setString(1,this.parametro);
               st.execute();  
               if(parametro!= null)
                a= true;
                st.close();
                conexion.close();
            }catch(Exception error){
                    System.out.println("Error en el metodo por: " + error.getMessage());
                    error.printStackTrace();
            }
            
            return a;
    }
     
    
     
     public String doAtenderPaciente()
        {
        
            try
        {
            if (this.Atender()){
                Mensaje.guardarMensajeExito( "Acualizacion Paciente: Codigo " + this.getAtencion_a().getCodigo());
                       
            }else {
                Mensaje.manejarError("Actualizando Paciente");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
      
}
