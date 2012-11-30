/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Consulta {
    
    private String cod_cosulta;
    private Date fecha;
    private String tipo_onsulta;
    private Boleta obj_bol =new Boleta();
    private int estado;
    private HistoriaClinica obj_his=new HistoriaClinica();

    public Consulta() {
    }

    public String getCod_cosulta() {
        return cod_cosulta;
    }

    public void setCod_cosulta(String cod_cosulta) {
        this.cod_cosulta = cod_cosulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo_onsulta() {
        return tipo_onsulta;
    }

    public void setTipo_onsulta(String tipo_onsulta) {
        this.tipo_onsulta = tipo_onsulta;
    }

    public Boleta getObj_bol() {
        return obj_bol;
    }

    public void setObj_bol(Boleta obj_bol) {
        this.obj_bol = obj_bol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public HistoriaClinica getObj_his() {
        return obj_his;
    }

    public void setObj_his(HistoriaClinica obj_his) {
        this.obj_his = obj_his;
    }
    

}
