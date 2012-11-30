/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.ControladorBD;
import Modelo.TipoPersonal;
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
public class BeanTipoPersonal implements Serializable{
    TipoPersonal tipopersonal_a= new TipoPersonal();
    private ArrayList<TipoPersonal> arreglo =new  ArrayList<TipoPersonal>();
    private String parametro;  
    private List<TipoPersonal> arrayTipoPersonal   = new ArrayList<TipoPersonal>();

    public BeanTipoPersonal() {
    }

    public TipoPersonal getTipopersonal_a() {
        return tipopersonal_a;
    }

    public void setTipopersonal_a(TipoPersonal tipopersonal_a) {
        this.tipopersonal_a = tipopersonal_a;
    }

    public ArrayList<TipoPersonal> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<TipoPersonal> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    public List<TipoPersonal> getCargarComboTip(){         
    if (this.arrayTipoPersonal.size()==0){         
        TipoPersonal obj=null;
        Connection conexion = null;
        ResultSet rs = null;
        try{
            conexion = ControladorBD.darConexionBD();
            CallableStatement st = conexion.prepareCall ( "{call sp_listartipo_personal()}");    
            rs = st.executeQuery();        
            if (rs.next()){        
                do{
                    obj =new TipoPersonal();
                    obj.setCod_tipo_personal(rs.getInt("cod_tipo_personal"));//codigo
                    obj.setNombre(rs.getString("nombre"));//descripcion        
                    arrayTipoPersonal.add(obj);
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
    return this.arrayTipoPersonal;
    }
    
}
