/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.ControladorBD;
import Modelo.Personal;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.primefaces.event.RowEditEvent;

public class BeanPersonal implements Serializable{
    
    Personal personal_a=new Personal();
    private ArrayList<Personal> arreglo =new  ArrayList<Personal>();
    private String parametro;
    private Personal selectedPersonal;

    public BeanPersonal() {
    }

    public Personal getPersonal_a() {
        return personal_a;
    }

    public void setPersonal_a(Personal personal_a) {
        this.personal_a = personal_a;
    }

    public ArrayList<Personal> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Personal> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Personal getSelectedPersonal() {
        return selectedPersonal;
    }

    public void setSelectedPersonal(Personal selectedPersonal) {
        this.selectedPersonal = selectedPersonal;
    }

  
     public String reinit() {
		personal_a = new Personal();
		
		return null;
	}
    
    
    public boolean RegistrarPersonal(){
        boolean a=false;  
        Connection conexion=null;
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st=  conexion.prepareCall("{call sp_registrarpersonal" + "(?,?,?,?,?,?,?)}");
            st.setString(1,personal_a.getNombres());
            st.setString(2,personal_a.getApellidos());
            st.setString(3,personal_a.getSexo());
            if(personal_a.getFecha_nacimiento() != null)                 
                st.setDate(4,new java.sql.Date(personal_a.getFecha_nacimiento().getTime()));                   
            else
                 st.setDate(4,null);
            st.setInt(5,personal_a.getObj_tpe().getCod_tipo_personal());
            st.setString(6,personal_a.getDni_personal());
            st.setInt(7,personal_a.getObj_use().getNum_user());
            st.registerOutParameter(8, java.sql.Types.VARCHAR);
            st.execute();
            personal_a.setCod_personal(st.getString(8));
            if(personal_a.getCod_personal()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
        System.out.println("Error en el metodo por: " + error.getMessage());
        error.printStackTrace();
        }    
        return a;
    }
   //--- se va a eliminar personal y usuario
    public boolean ActualizarPersonal(){
        boolean a=false;  
        Connection conexion=null;
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st=  conexion.prepareCall("{call sp_eliminar_personal" + "(?)}");
            st.setString(1,personal_a.getCod_personal());            
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
    final Personal per=(Personal) event.getObject();     
    this.setPersonal_a(per);
    this.ActualizarPersonal();
    } 
    
    public void onCancel(RowEditEvent event) {  
        
    }
    
     public ArrayList<Personal> getCargarPersonal(){         
        if (arreglo.size()==0){         
           Personal obj=null;
           Connection conexion = null;
           ResultSet rs = null;
           try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarpersonal()}");    
            rs = st.executeQuery();        
            if (rs.next()){
            do{
                obj =new Personal();
                obj.setCod_personal(rs.getString("cod_personal"));
                obj.setDni_personal(rs.getString("dni_personal"));
                obj.setNombres(rs.getString("nombres"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setSexo(rs.getString("sexo"));
                obj.setFecha_nacimiento2(rs.getString("fecha_nacimiento2"));
                obj.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                obj.getObj_tpe().setNombre(rs.getString("nombre"));
                obj.getObj_use().setNombre_usuario(rs.getString("nombre_usuario"));
                obj.setEstado(rs.getInt("estado"));
                
                arreglo.add(obj);
           } while (rs.next());
         }  
         rs.close();
         st.close();
         conexion.close();

        }catch(Exception error){
        System.out.println("Error en el metodo por: " +error.getMessage());
                error.printStackTrace();
        }    
      }  
    return this.arreglo;
    }
     
     public String doRegistrarPersonal()
        {
            try
        {
            if (this.RegistrarPersonal()){
                Mensaje.guardarMensajeExito( "Registro Personal: CODIGO PERSONAL " + this.getPersonal_a().getCod_personal());

            }else {
                Mensaje.manejarError("Registrando Personal");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
     
     public String doActualizarPersonal()
        {
            try
        {
            if (this.ActualizarPersonal()){
                Mensaje.guardarMensajeExito( "Actualizacion Personal: CODIGO PERSONAL " + this.getPersonal_a().getCod_personal());

            }else {
                Mensaje.manejarError("Actualizando Personal");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
}
