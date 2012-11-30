/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Alumno extends Paciente{
   
    private Paciente obj_paciente=new Paciente();
    private String codigo_univ;
    private String escuela;
    private int año_ingreso;
    private String ciclo;
    
    public Alumno() {
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public int getAño_ingreso() {
        return año_ingreso;
    }

    public void setAño_ingreso(int año_ingreso) {
        this.año_ingreso = año_ingreso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCodigo_univ() {
        return codigo_univ;
    }

    public void setCodigo_univ(String codigo_univ) {
        this.codigo_univ = codigo_univ;
    }

    public Paciente getObj_paciente() {
        return obj_paciente;
    }

    public void setObj_paciente(Paciente obj_paciente) {
        this.obj_paciente = obj_paciente;
    }

}
