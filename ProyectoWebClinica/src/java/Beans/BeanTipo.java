/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.Tipo;
import Modelo.ControladorBD;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JOSEF
 */
public class BeanTipo implements Serializable {
    
    Tipo tipo_a= new Tipo();
    private ArrayList<Tipo> arreglo =new  ArrayList<Tipo>();
    private String parametro;
    private List<Tipo> arrayTipoUser   = new ArrayList<Tipo>();
    
    public BeanTipo() {
    }

    public Tipo getTipo_a() {
        return tipo_a;
    }

    public void setTipo_a(Tipo tipo_a) {
        this.tipo_a = tipo_a;
    }

    public ArrayList<Tipo> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<Tipo> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public List<Tipo> getArrayTipoUser() {
        return arrayTipoUser;
    }

    public void setArrayTipoUser(List<Tipo> arrayTipoUser) {
        this.arrayTipoUser = arrayTipoUser;
    }

     public List<Tipo> getCargarComboTipUser(){         
    if (this.arrayTipoUser.size()==0){         
        Tipo obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall ( "{call sp_listartipo_user()}");    
            rs = st.executeQuery();        
            if (rs.next()){        
                do{
                    obj =new Tipo();
                    obj.setCod_tipo(rs.getInt("cod_tipo"));//codigo
                    obj.setDescripcion(rs.getString("descripcion"));//descripcion        
                    arrayTipoUser.add(obj);
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
    return this.arrayTipoUser;
    }
}
