/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Examen {
    
    private String cod_examen;
    private int estado; 
    private Boleta obj_bol=new Boleta();
    private Date fecha;
    private Date fecha_2=new Date();
    private HistoriaClinica obj_his=new HistoriaClinica();
    private Paciente obj_pac=new Paciente();
    private String mes;
    private String año;
    private int cantidad;
    public Examen() {
    }

    public String getCod_examen() {
        return cod_examen;
    }

    public void setCod_examen(String cod_examen) {
        this.cod_examen = cod_examen;
    }

    public Date getFecha_2() {
        return fecha_2;
    }

    public void setFecha_2(Date fecha_2) {
        this.fecha_2 = fecha_2;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boleta getObj_bol() {
        return obj_bol;
    }

    public void setObj_bol(Boleta obj_bol) {
        this.obj_bol = obj_bol;
    }

    public HistoriaClinica getObj_his() {
        return obj_his;
    }

    public void setObj_his(HistoriaClinica obj_his) {
        this.obj_his = obj_his;
    }

    public Paciente getObj_pac() {
        return obj_pac;
    }

    public void setObj_pac(Paciente obj_pac) {
        this.obj_pac = obj_pac;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

   
    
}
