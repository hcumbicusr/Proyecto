/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Modelo.ControladorBD;
import Modelo.Examen;
import Modelo.Paciente;
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
public class BeanPaciente implements Serializable {
    
    private Paciente paciente_a= new Paciente();
    private ArrayList<Paciente> arreglo =new  ArrayList<Paciente>();
    private String parametro;
    private Paciente selectedPaciente;
    private Examen selectedExamen;
    private Paciente paciente =new Paciente();

    public BeanPaciente() {
    }

    public Paciente getPaciente_a() {
        return paciente_a;
    }

    public void setPaciente_a(Paciente paciente_a) {
        this.paciente_a = paciente_a;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Paciente> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Paciente> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Examen getSelectedExamen() {
        return selectedExamen;
    }

    public void setSelectedExamen(Examen selectedExamen) {
        this.selectedExamen = selectedExamen;
    }

    public Paciente getSelectedPaciente() {
        return selectedPaciente;
    }

    public void setSelectedPaciente(Paciente selectedPaciente) {
        this.selectedPaciente = selectedPaciente;
    }
    
    
    
    public boolean Registrar(){
        boolean a=false;  
        Connection conexion=null;
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st= conexion.prepareCall("{call sp_registrarpaciente" + "(?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1,paciente_a.getDni_paciente());
            st.setString(2,paciente_a.getNombres());
            st.setString(3,paciente_a.getApellidos());
            st.setString(4,paciente_a.getSexo()); 
            st.setString(5,paciente_a.getOcupacion());
            st.setString(6,paciente_a.getProcedencia()); 
            if(paciente_a.getFecha_nacimiento() != null)                 
                st.setDate(7,new java.sql.Date(paciente_a.getFecha_nacimiento().getTime()));                   
             else
                    st.setDate(7,null);   
            st.setString(8,paciente_a.getEstado_civil()); 
            st.setString(9,paciente_a.getDireccion()); 
            st.setString(10,paciente_a.getTelefono());
            st.execute();
            if(paciente_a.getDni_paciente()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
        System.out.println("Error en el metodo por: " + error.getMessage());
        error.printStackTrace();
        }    
        return a;
    }    
    public String reinit() {
		paciente_a = new Paciente();
		
		return null;
	}
    
    public ArrayList<Paciente>getListarAfiliados(){ 
    this.arreglo= null;
    Paciente obj=null;
    Connection conexion = null;
    ResultSet rs = null;
    try{
    conexion = ControladorBD.darConexionBD();
    CallableStatement st = conexion.prepareCall( "{call sp_listar_afiliados()}");
                    rs = st.executeQuery();
    if (rs.next()){
        this.arreglo= new ArrayList<Paciente>();
        do{
        obj =new Paciente();
        obj.getObj_hcl().setCod_historiaclinica(rs.getString("cod_historiaclinica"));
        obj.setDni_paciente(rs.getString("dni_paciente"));
        obj.setNombres(rs.getString("nombres"));
        obj.setApellidos(rs.getString("apellidos"));
        obj.setSexo(rs.getString("sexo"));
        obj.setOcupacion(rs.getString("ocupacion"));
        obj.setTelefono(rs.getString("telefono"));
        obj.setProcedencia(rs.getString("procedencia"));
        obj.setFecha_nascimiento2(rs.getString("fecha_nacimiento2"));
        obj.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
        obj.setEstado_civil(rs.getString("estado_civil"));
        obj.setDireccion(rs.getString("direccion"));
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

    
        public ArrayList<Paciente>getCargarPacientes(){         
            this.arreglo=null;       
            Paciente obj=null;
            Connection conexion = null;
            ResultSet rs = null;
            try{
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listarpacientes()}");    
                rs = st.executeQuery();        
                if (rs.next()){     
                    this.arreglo= new ArrayList<Paciente>();
                do{
                    obj =new Paciente();
                    obj.setDni_paciente(rs.getString("dni_paciente"));
                    obj.getObj_hcl().setCod_historiaclinica(rs.getString("cod_historiaclinica"));
                    obj.setNombres(rs.getString("nombres"));
                    obj.setApellidos(rs.getString("apellidos"));
                    obj.setSexo(rs.getString("sexo"));
                    obj.setOcupacion(rs.getString("ocupacion"));
                    obj.setProcedencia(rs.getString("procedencia"));
                    obj.setFecha_nascimiento2(rs.getString("fecha_nacimiento2"));
                    obj.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                    obj.setEstado_civil(rs.getString("estado_civil"));
                    obj.setDireccion(rs.getString("direccion"));
                    obj.setTelefono(rs.getString("telefono"));
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
        
        
        
        public ArrayList<Paciente> getBuscarPaciente(){
            this.arreglo=null;            
            ResultSet rs=null;
            Paciente obj=null;
            Connection conexion = null;
            try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_buscarpaciente(?)}");
            st.setString(1, this.parametro);
            rs = st.executeQuery();
            if (rs.next()){
                this.arreglo= new ArrayList<Paciente>();
                do{
                obj =new Paciente();
                obj.getObj_hcl().setCod_historiaclinica(rs.getString("cod_historiaclinica"));
                obj.setDni_paciente(rs.getString("dni_paciente"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidos(rs.getString("apellidos"));
                arreglo.add(obj);
               } while (rs.next());
            }  
                 rs.close();
                 st.close();
                 conexion.close(); 
        }catch(Exception error){
                System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
    return arreglo; 
    }
        
        
    public ArrayList<Paciente>getListarHistorias(){ 
        this.arreglo= null;
        Paciente obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarhistoriales()}");
                    rs = st.executeQuery();
            if (rs.next()){
            this.arreglo= new ArrayList<Paciente>();
            do{
            obj =new Paciente();
            obj.getObj_hcl().setCod_historiaclinica(rs.getString("cod_historiaclinica"));
            obj.getObj_hcl().setFecha_emision2(rs.getString("fecha_emision2"));
            obj.getObj_hcl().setFecha_emision(rs.getDate("fecha_emision"));
            obj.setDni_paciente(rs.getString("dni_paciente"));
            obj.setNombres(rs.getString("nombres"));
            obj.setApellidos(rs.getString("apellidos"));
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
    
    
    
      public boolean Actualizar(){
            boolean a=false;
            Connection conexion=null;
            try{
               conexion=ControladorBD.darConexionBD();
               CallableStatement st=conexion.prepareCall("{call sp_actualizarpaciente(?,?,?,?,?,?,?)}");
               conexion.setAutoCommit(false);
               st.setString(1,paciente_a.getNombres());
               st.setString(2,paciente_a.getApellidos());
               st.setString(3,paciente_a.getTelefono());
               st.setString(4,paciente_a.getDireccion());
               if(paciente_a.getFecha_nacimiento() != null)                 
                         st.setDate(5,new java.sql.Date(paciente_a.getFecha_nacimiento().getTime()));                   
                      else
                             st.setDate(5,null);   
               st.setString(6,paciente_a.getDni_paciente());
               st.setString(7,paciente_a.getObj_hcl().getCod_historiaclinica());
               st.execute();          
                 a= true;
                st.close();
                conexion.close();
            }catch(Exception error){
                    System.out.println("Error en el metodo por: " + error.getMessage());
                    error.printStackTrace();
            }
            
            return a;
    }
        
    public void onEdit(RowEditEvent event) {  
        final Paciente paci=(Paciente) event.getObject();     
        this.setPaciente_a(paci); 
        this.Actualizar();
    }  
    
    public void onCancel(RowEditEvent event) {  
        
    }  
    
    public String doActualizarPaciente()
        {
        this.setPaciente_a(selectedPaciente);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Paciente: Codigo " + this.getPaciente_a().getObj_hcl().getCod_historiaclinica());
                       
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
      
        public String doRegistrarPaciente()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Paciente: DNI " + this.getPaciente_a().getDni_paciente());

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
