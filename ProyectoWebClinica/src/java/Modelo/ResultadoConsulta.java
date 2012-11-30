/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class ResultadoConsulta {
    
    private Consulta obj_con=new Consulta();
    private Medicinag obj_med= new Medicinag();
    private Psicologia obj_psi=new Psicologia();
    private Odontologia obj_odo=new Odontologia();

    public ResultadoConsulta() {
    }

    public Consulta getObj_con() {
        return obj_con;
    }

    public void setObj_con(Consulta obj_con) {
        this.obj_con = obj_con;
    }

    public Medicinag getObj_med() {
        return obj_med;
    }

    public void setObj_med(Medicinag obj_med) {
        this.obj_med = obj_med;
    }

    public Psicologia getObj_psi() {
        return obj_psi;
    }

    public void setObj_psi(Psicologia obj_psi) {
        this.obj_psi = obj_psi;
    }

    public Odontologia getObj_odo() {
        return obj_odo;
    }

    public void setObj_odo(Odontologia obj_odo) {
        this.obj_odo = obj_odo;
    }

   
  
}
