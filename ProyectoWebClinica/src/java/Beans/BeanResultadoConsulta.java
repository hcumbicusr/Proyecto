/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import Modelo.ResultadoConsulta;
import java.util.ArrayList;
/**
 *
 * @author JOSEF
 */
public class BeanResultadoConsulta {
    
    ResultadoConsulta resulco_a= new ResultadoConsulta();
    private ArrayList<ResultadoConsulta> arreglo =new  ArrayList<ResultadoConsulta>();
    private String parametro;

    public BeanResultadoConsulta() {
    }

    public ResultadoConsulta getResulco_a() {
        return resulco_a;
    }

    public void setResulco_a(ResultadoConsulta resulco_a) {
        this.resulco_a = resulco_a;
    }

    public ArrayList<ResultadoConsulta> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<ResultadoConsulta> arreglo) {
        this.arreglo = arreglo;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

   

}

