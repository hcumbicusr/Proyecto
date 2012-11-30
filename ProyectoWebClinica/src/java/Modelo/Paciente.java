/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Paciente {
  
    protected String dni_paciente;
    private HistoriaClinica obj_hcl=new HistoriaClinica();
    protected String nombres;
    protected String apellidos;
    protected String sexo;
    protected String ocupacion;//se almacenara directamende para ALUMNO
    protected String procedencia;
    protected Date fecha_nacimiento;
    protected String estado_civil;
    protected String fecha_nascimiento2;
    protected String direccion;
    protected String telefono;

    public String getFecha_nascimiento2() {
        return fecha_nascimiento2;
    }

    public void setFecha_nascimiento2(String fecha_nascimiento2) {
        this.fecha_nascimiento2 = fecha_nascimiento2;
    }

    public Paciente() {
    }

    public String getDni_paciente() {
        return dni_paciente;
    }

    public void setDni_paciente(String dni_paciente) {
        this.dni_paciente = dni_paciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public HistoriaClinica getObj_hcl() {
        return obj_hcl;
    }

    public void setObj_hcl(HistoriaClinica obj_hcl) {
        this.obj_hcl = obj_hcl;
    }
    

}
