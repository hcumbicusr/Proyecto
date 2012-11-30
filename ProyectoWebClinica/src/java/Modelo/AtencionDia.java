/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class AtencionDia {
    
   private int numero;
   private String codigo;
   private int estado;
   private Paciente obj_pac=new Paciente();

    public AtencionDia() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Paciente getObj_pac() {
        return obj_pac;
    }

    public void setObj_pac(Paciente obj_pac) {
        this.obj_pac = obj_pac;
    }

   
   
}
