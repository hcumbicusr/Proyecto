/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class HistoriaClinica {
    
    private String cod_historiaclinica;
    private Date fecha_emision;
    private String fecha_emision2;

    public HistoriaClinica() {
    }

    public String getFecha_emision2() {
        return fecha_emision2;
    }

    public void setFecha_emision2(String fecha_emision2) {
        this.fecha_emision2 = fecha_emision2;
    }

    public String getCod_historiaclinica() {
        return cod_historiaclinica;
    }

    public void setCod_historiaclinica(String cod_historiaclinica) {
        this.cod_historiaclinica = cod_historiaclinica;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    
    
}
