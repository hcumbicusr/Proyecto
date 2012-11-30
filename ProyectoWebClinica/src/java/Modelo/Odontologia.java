/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Odontologia {
    
    private String cod_diagodontologia;
    private String diagpresun_odontologia;
    private String diagdef_odontologia;
    private String indicacion_odon;
    private Personal obj_per=new Personal();

    public Odontologia() {
    }

    public String getCod_odontologia() {
        return cod_diagodontologia;
    }

    public void setCod_odontologia(String cod_odontologia) {
        this.cod_diagodontologia = cod_odontologia;
    }

    public String getDiagpresun_odontologia() {
        return diagpresun_odontologia;
    }

    public void setDiagpresun_odontologia(String diagpresun_odontologia) {
        this.diagpresun_odontologia = diagpresun_odontologia;
    }

    public String getDiagdef_odontologia() {
        return diagdef_odontologia;
    }

    public void setDiagdef_odontologia(String diagdef_odontologia) {
        this.diagdef_odontologia = diagdef_odontologia;
    }

    public String getIndicacion_odon() {
        return indicacion_odon;
    }

    public void setIndicacion_odon(String indicacion_odon) {
        this.indicacion_odon = indicacion_odon;
    }

    public Personal getObj_per() {
        return obj_per;
    }

    public void setObj_per(Personal obj_per) {
        this.obj_per = obj_per;
    }
    
    
}
