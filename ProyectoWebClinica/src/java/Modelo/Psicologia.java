/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Psicologia {
    
    private String cod_diagpsicologia;
    private String diagpresun_psicologia;
    private String diagdef_psicologia;
    private String indicacion_psico;
    private Personal obj_per=new Personal();

    public Psicologia() {
    }

    public String getCod_psicologia() {
        return cod_diagpsicologia;
    }

    public void setCod_psicologia(String cod_psicologia) {
        this.cod_diagpsicologia = cod_psicologia;
    }

    public String getDiagpresun_psicologia() {
        return diagpresun_psicologia;
    }

    public void setDiagpresun_psicologia(String diagpresun_psicologia) {
        this.diagpresun_psicologia = diagpresun_psicologia;
    }

    public String getDiagdef_psicologia() {
        return diagdef_psicologia;
    }

    public void setDiagdef_psicologia(String diagdef_psicologia) {
        this.diagdef_psicologia = diagdef_psicologia;
    }

    public String getIndicacion_psico() {
        return indicacion_psico;
    }

    public void setIndicacion_psico(String indicacion_psico) {
        this.indicacion_psico = indicacion_psico;
    }

    public Personal getObj_per() {
        return obj_per;
    }

    public void setObj_per(Personal obj_per) {
        this.obj_per = obj_per;
    }
    
    

}
