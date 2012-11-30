/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Medicinag {
    
    private String cod_diagmedicina;
    private String diagpresun_medicina;
    private String diagdef_medicina;
    private String indicacion_medic;
    private Personal obj_per=new Personal();

    public Medicinag() {
    }

    public String getCod_medicina() {
        return cod_diagmedicina;
    }

    public void setCod_medicina(String cod_medicina) {
        this.cod_diagmedicina = cod_medicina;
    }

    public String getDiagpresun_medicina() {
        return diagpresun_medicina;
    }

    public void setDiagpresun_medicina(String diagpresun_medicina) {
        this.diagpresun_medicina = diagpresun_medicina;
    }

    public String getDiagdef_medicina() {
        return diagdef_medicina;
    }

    public void setDiagdef_medicina(String diagdef_medicina) {
        this.diagdef_medicina = diagdef_medicina;
    }

    public String getIndicacion_medic() {
        return indicacion_medic;
    }

    public void setIndicacion_medic(String indicacion_medic) {
        this.indicacion_medic = indicacion_medic;
    }

    public Personal getObj_per() {
        return obj_per;
    }

    public void setObj_per(Personal obj_per) {
        this.obj_per = obj_per;
    }
    
    
    
}
