/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.*;
import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author JOSEF
 */
public class BeanAlumno implements Serializable{
    
    Alumno alumno_a= new Alumno();
    private ArrayList<Alumno> arreglo =new  ArrayList<Alumno>();
    private String parametro;
    private Alumno selectedAlumno;
    private Alumno alumno = new Alumno();
    
    public BeanAlumno() {
    }

    
    public Alumno getAlumno_a() {
        return alumno_a;
    }

    public void setAlumno_a(Alumno alumno_a) {
        this.alumno_a = alumno_a;
    }

    public ArrayList<Alumno> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Alumno> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }
    
    public boolean Actualizar(){
            boolean a=false;
            Connection conexion=null;
            try{
               conexion=ControladorBD.darConexionBD();
               CallableStatement st=conexion.prepareCall("{call sp_actualizaralumno(?,?,?,?,?,?,?)}");
               conexion.setAutoCommit(false);
               st.setString(1,alumno_a.getNombres());
               st.setString(2,alumno_a.getApellidos());
               st.setString(3, alumno_a.getCodigo_univ());
               st.setString(4, alumno_a.getEscuela());
               st.setString(5, alumno_a.getCiclo());
               st.setString(6,alumno_a.getDni_paciente());
               st.setString(7,alumno_a.getObj_paciente().getObj_hcl().getCod_historiaclinica());
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
    
    public String reinit() {
		alumno_a = new Alumno();
		
		return null;
	}
    
 public boolean Registrar(){
        boolean a=false;  
        Connection conexion=null;
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st=
        conexion.prepareCall("{call sp_registrarpacientealumno" + "(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1,alumno_a.getDni_paciente());
            st.setString(2,alumno_a.getNombres());
            st.setString(3,alumno_a.getApellidos());
            st.setString(4,alumno_a.getSexo()); 
            st.setString(5,alumno_a.getProcedencia()); 
            if(alumno_a.getFecha_nacimiento() != null)                 
                st.setDate(6,new java.sql.Date(alumno_a.getFecha_nacimiento().getTime()));                   
             else
                    st.setDate(6,null);   
            st.setString(7,alumno_a.getEstado_civil()); 
            st.setString(8,alumno_a.getDireccion()); 
            st.setString(9,alumno_a.getTelefono());
            st.setString(10,alumno_a.getEscuela());
            st.setInt(11,alumno_a.getAño_ingreso());
            st.setString(12,alumno_a.getCiclo());
            st.setString(13,alumno_a.getCodigo_univ());
            st.execute();
            if(alumno_a.getDni_paciente()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
        System.out.println("Error en el metodo por: " + error.getMessage());
        error.printStackTrace();
        }    
        return a;
    }  
 
 public ArrayList<Alumno> getCargarAlumnos(){         
        if (arreglo.size()==0){         
            Alumno obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall ( "{call sp_listarpacientealumno()}");   
            rs = st.executeQuery();        
            if (rs.next()){        
            do{
                obj=new Alumno(); 
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
                obj.setCodigo_univ(rs.getString("codigo_univ"));
                obj.setEscuela(rs.getString("escuela"));
                obj.setAño_ingreso(rs.getInt("año_ingreso"));
                obj.setCiclo(rs.getString("ciclo"));
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
      }  
    return this.arreglo;
    }
 
 public void onEdit(RowEditEvent event) {  
        final Alumno alum=(Alumno) event.getObject();     
        this.setAlumno_a(alum); 
        this.Actualizar();
    }  
    
    public void onCancel(RowEditEvent event) {  
        
    }  
//----------

 public String doRegistrarAlumno()
        {
            try
        {
            if (this.Registrar()){
                Mensaje.guardarMensajeExito( "Registro Alumno: DNI " + this.getAlumno_a().getDni_paciente());

            }else {
                Mensaje.manejarError("Registrando Alumno");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
 
  public String doActualizarAlumno()
        {
        this.setAlumno_a(selectedAlumno);
            try
        {
            if (this.Actualizar()){
                Mensaje.guardarMensajeExito( "Acualizacion Paciente: Codigo " + this.getAlumno_a().getObj_hcl().getCod_historiaclinica());
                       
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
