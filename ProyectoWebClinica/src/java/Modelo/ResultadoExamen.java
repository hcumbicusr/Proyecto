/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class ResultadoExamen {
    
    private Examen obj_exa = new Examen();
    private String peso;
    private String talla;
    private String presion;
    private Psicologia obj_psi=new Psicologia();
    private Medicinag obj_med= new Medicinag();
    private Odontologia obj_odo=new Odontologia();

    public ResultadoExamen() {
    }

    public Examen getObj_exa() {
        return obj_exa;
    }

    public void setObj_exa(Examen obj_exa) {
        this.obj_exa = obj_exa;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public Psicologia getObj_psi() {
        return obj_psi;
    }

    public void setObj_psi(Psicologia obj_psi) {
        this.obj_psi = obj_psi;
    }

    public Medicinag getObj_med() {
        return obj_med;
    }

    public void setObj_med(Medicinag obj_med) {
        this.obj_med = obj_med;
    }

    public Odontologia getObj_odo() {
        return obj_odo;
    }

    public void setObj_odo(Odontologia obj_odo) {
        this.obj_odo = obj_odo;
    }
    
    
}
