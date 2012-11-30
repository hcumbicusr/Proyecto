/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.*;
import Utils.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BeanUsuario{
    
    Usuario usuario_a= new Usuario();
    private ArrayList<Usuario> arreglo =new  ArrayList<Usuario>();
    private String parametro;
    private boolean usuarioLogeado;
   private boolean flgPassIguales;
   private String nom_user;
   private String clave_user;

    public BeanUsuario() {
    }

    public Usuario getUsuario_a() {
        return usuario_a;
    }

    public void setUsuario_a(Usuario usuario_a) {
        this.usuario_a = usuario_a;
    }

    public ArrayList<Usuario> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Usuario> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getClave_user() {
        return clave_user;
    }

    public void setClave_user(String clave_user) {
        this.clave_user = clave_user;
    }

    public boolean isFlgPassIguales() {
        return flgPassIguales;
    }

    public void setFlgPassIguales(boolean flgPassIguales) {
        this.flgPassIguales = flgPassIguales;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public boolean isUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(boolean usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    
    //---------------------
    
    //---------- cambiar contraseña
    public boolean ActualizarContraseña(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_actualizar_contraseña_usuario (?,?,?)}");
      st.setString(1,this.nom_user);
      st.setString(2,usuario_a.getClave());  
      st.setString(3,usuario_a.getClave2()); 
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
    //-------- cambiar tipo de usuario
    public boolean ActualizarTipo(){
   boolean a=false;
   Connection conexion=null;
   try{
      conexion=ControladorBD.darConexionBD();
      CallableStatement st=conexion.prepareCall("{call sp_actualizar_tipo_usuario (?,?)}");
      conexion.setAutoCommit(false);
      st.setInt(1,usuario_a.getNum_user());
      //st.setInt(2,usuario_a.getObj_tip().getCod_tipo());  
      st.setInt(2,usuario_a.getObj_tip().getCod_tipo());   
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
    //------- validar acceso al sistema
   public  Usuario validar(String user, String pass){
     ResultSet rs=null; 
     Connection conexion = null;
     Usuario usuario=null;       
        try{               
           conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall
            ( "{call sp_validar_acceso(?,?)}");
            st.setString(1,user);                   
            st.setString(2,pass);
            rs = st.executeQuery();
            
            if(rs.next()){
                usuario = new Usuario();
                usuario.setNombre_usuario(user);
                usuario.setCod_tipo_personal(rs.getInt("cod_tipo_p"));
                usuario.setDescripcion(rs.getString("nombre_p"));
                usuario.setPersonal(rs.getString("personal"));
                usuario.setTipo_user(rs.getInt("cod_tipo"));
                System.out.println("Este es el retorno: "+usuario.getCod_tipo_personal()
                        +" - "+user+" - "+usuario.getPersonal()+" - "+usuario.getDescripcion()
                        +" - "+usuario.getTipo_user());
                rs.close();                
                conexion.close();                
            }
       
        }catch(Exception error){
            System.out.println("Error en el metodo por: " + error.getMessage());
                error.printStackTrace();
        }
        return usuario;
 }
   //--------------------------------------
   public String loginUsuario(){
        String outcome = null;       
        flgPassIguales=false;
        usuario_a = new Usuario();
        try{            
        FacesContext contex = FacesContext.getCurrentInstance();                                        
            if(usuario_a!=null){
                usuario_a=this.validar(this.nom_user, encriptaCadenas.getStringMessageDigest(this.clave_user,encriptaCadenas.MD5));                
                
                if(usuario_a != null){   
                   Mensaje.addMensajeInfo("Usuario logeado correctamente");
                    usuarioLogeado = true; 
                    contex.getExternalContext().getSessionMap().put("usuario",usuario_a);                       
                  contex.getExternalContext().getSessionMap().put("isSesionAlive", usuarioLogeado);                                                                                         
                    outcome=Constantes.PAGE_INGRESO_JSF;                    
               }
               else{
                   Mensaje.addMensajeError("Usuario o Password Incorrectos");
                   this.nom_user="";
                   this.clave_user=""; 
                   outcome=Constantes.PAGE_LOGIN_JSF;  
                    
               }  
            }
            else{
                Mensaje.addMensajeError("Usuario o Password Incorrectos");
                this.nom_user="";
                this.clave_user="";
                outcome=Constantes.PAGE_LOGIN_JSF;  
                
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }        
    return outcome+"?faces-redirect=true";         
    }
   //---------------------------------------
    public void salirSistema(){
        FacesContext contex = FacesContext.getCurrentInstance();  
        this.nom_user="";
        this.clave_user="";
        String outcome =Constantes.PAGE_LOGIN_JSF;
        contex.getExternalContext().getSessionMap().clear();
        contex.getExternalContext().getSessionMap().put("isSesionAlive", false);
        contex.getExternalContext().invalidateSession();
        try {
            contex.getExternalContext().redirect(outcome);
        } catch (IOException ex) {
            System.out.println("Error en el metodo por: " + ex.getMessage());
                ex.printStackTrace();
        }

    }
    
public void validarSesion() {        
        FacesContext contex = FacesContext.getCurrentInstance();
        try {
            if (contex.getExternalContext().getSessionMap().get("isSesionAlive") == null
                    || contex.getExternalContext().getSessionMap().get("isSesionAlive").
                    toString().trim().equals("false")) {
                contex.getExternalContext().redirect(Constantes.PAGE_LOGIN_JSF);
                contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Autenticacion", "El usuario No existe !!"));

            }
        } catch (Exception e) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.PAGE_LOGIN_JSF);
            } catch (Exception ex) {
                System.out.println("Error en el metodo por: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
    }

public String doActualizarContraseña()
        {
            try
        {
            if (this.ActualizarContraseña()){
                Mensaje.guardarMensajeExito( "Acualizacion Contraseña: Usuario: " + this.nom_user);
                       
            }else {
                Mensaje.manejarError("Actualizando Usuario");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
    
}
