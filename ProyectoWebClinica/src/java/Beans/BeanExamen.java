
package Beans;

import Modelo.*;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BeanExamen implements Serializable{
    Examen examen_a= new Examen();
    private ArrayList<Examen> arreglo =new  ArrayList<Examen>();
    private String parametro;
    private Date parametro2=new Date();
    private int y,m,d;
    private String serie, numero;
    private Examen selectedExamen;

    public BeanExamen() {
    }
    public Examen getSelectedExamen() {
        return selectedExamen;
    }

    public void setSelectedExamen(Examen selectedExamen) {
        this.selectedExamen = selectedExamen;
    }
    
    public int getD() {
        return d;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Examen getExamen_a() {
        return examen_a;
    }

    public void setExamen_a(Examen examen_a) {
        this.examen_a = examen_a;
    }

    public Date getParametro2() {
        return parametro2;
    }

    public void setParametro2(Date parametro2) {
        this.parametro2 = parametro2;
    }

    public ArrayList<Examen> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Examen> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
 
    
     public String reinit() {
		examen_a = new Examen();
		
		return null;
	}
    
    
    //============================================================================
    //----------- crear examen
    public boolean CrearExamen(){
        boolean a=false;  
        Connection conexion=null;
        String cod=this.getSerie()+"-"+this.getNumero();
        try{
        conexion=ControladorBD.darConexionBD();
        CallableStatement st=
        conexion.prepareCall("{call sp_crearexamen" + "(?,?,?,?)}");
            st.setString(1,examen_a.getObj_pac().getDni_paciente());
            st.setString(2,cod);
            st.setDouble(3,examen_a.getObj_bol().getMonto());
            st.registerOutParameter(4, java.sql.Types.VARCHAR);
            st.execute();
            examen_a.setCod_examen(st.getString(4));
            if(examen_a.getCod_examen()!= null)
                a= true;
            st.close();
            conexion.close();
        }catch(Exception error){
        System.out.println("Error en el metodo por: " + error.getMessage());
        error.printStackTrace();
        }    
        return a;
    }  
    //--------busqueda de examenes por fecha---------------
    public ArrayList<Examen> getBuscarExamenFecha(){
            this.arreglo=null;            
            ResultSet rs=null;
            Examen obj=null;
            Connection conexion = null;
           // String fecha=this.getY()+"/"+this.getM()+"/"+this.getD();
            try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarexamen_fecha(?)}");
            st.setDate(1,new java.sql.Date(parametro2.getTime()));  
            rs = st.executeQuery();
            if (rs.next()){
                this.arreglo= new ArrayList<Examen>();
                do{
                obj =new Examen();
                obj.setCod_examen(rs.getString("cod_examen"));
                obj.setEstado(rs.getInt("estado"));
                obj.getObj_bol().setCod_boleta(rs.getString("cod_boleta"));
                obj.setFecha(rs.getDate("fecha"));
                obj.getObj_his().setCod_historiaclinica(rs.getString("cod_historiaclinica"));
                obj.getObj_pac().setNombres(rs.getString("nombres"));
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
    
    //------busqueda de examenes por paciente----
    public ArrayList<Examen> getBuscarExamenPaciente(){
            this.arreglo=null;            
            ResultSet rs=null;
            Examen obj=null;
            Connection conexion = null;
            try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall( "{call sp_listarexamen_paciente(?)}");
            st.setString(1, this.parametro);
            rs = st.executeQuery();
            if (rs.next()){
                this.arreglo= new ArrayList<Examen>();
                do{
                obj =new Examen();
                obj.setCod_examen(rs.getString(1));
                obj.getObj_his().setCod_historiaclinica(rs.getString(2));
                obj.getObj_pac().setDni_paciente(rs.getString(3));
                obj.getObj_pac().setNombres(rs.getString(4));
                obj.getObj_pac().setApellidos(rs.getString(5));
                obj.setFecha(rs.getDate(6));
                obj.getObj_bol().setCod_boleta(rs.getString(7));
                obj.getObj_bol().setMonto(rs.getDouble(8));           
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
    //-------------listar examenes de la fecha de hoy
    public ArrayList<Examen>getListarExamenes(){         
            this.arreglo=null;       
            Examen obj=null;
            Connection conexion = null;
            ResultSet rs = null;
            try{
                conexion = ControladorBD.darConexionBD();
                CallableStatement st = conexion.prepareCall("{call sp_listarexameneshoy()}");    
                rs = st.executeQuery();        
                if (rs.next()){     
                    this.arreglo= new ArrayList<Examen>();
                do{
                    obj =new Examen();
                    obj.setCod_examen(rs.getString(1));
                    obj.getObj_his().setCod_historiaclinica(rs.getString(2));
                    obj.getObj_pac().setNombres(rs.getString(3));
                    obj.getObj_pac().setApellidos(rs.getString(4));
                    
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
    //-------------------

 public String doCrearExamen()
        {
            try
        {
            if (this.CrearExamen()){
                Mensaje.guardarMensajeExito( "Crear Examen: CODIGO EXAMEN  " + this.getExamen_a().getCod_examen());

            }else {
                Mensaje.manejarError("Creando Examen");
            }
        }
        catch( Exception e )
        {
               Mensaje.manejarError(e);
        }
            return null ;
        }
}

